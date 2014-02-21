package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author J-Tron
 * @version 1.0
 */
public class DB_MySql implements DBAccessor{
    
    private Connection connection;
    
    public DB_MySql(){
    }
    
    private PreparedStatement constructInsertSQL(Connection connection, String tableName, List columnNames)throws SQLException{
        StringBuilder sqlString = new StringBuilder("Insert into ");
        sqlString.append(tableName).append(" (");
        final Iterator i=columnNames.iterator();
        while(i.hasNext()){
            (sqlString.append( (String)i.next() )).append(", ");
        }
        sqlString = new StringBuilder( (sqlString.toString()).substring( 0,(sqlString.toString()).lastIndexOf(", ") ) + ") VALUES (" );
	for( int j = 0; j < columnNames.size(); j++ ) {
		sqlString.append("?, ");
	}
	final String completeSQL=(sqlString.toString()).substring(0,(sqlString.toString()).lastIndexOf(", ")) + ")";
	return connection.prepareStatement(completeSQL);
    }
    
    private PreparedStatement constructUpdateSQL(Connection connection, String tableName, List columnNames, String whereField)throws SQLException{
        StringBuilder sqlString = new StringBuilder("Update ");
        sqlString.append(tableName).append(" Set ");
        final Iterator i=columnNames.iterator();
        while( i.hasNext() ) {
            (sqlString.append((String)i.next())).append(" = ?, ");
	}
	sqlString = new StringBuilder( (sqlString.toString()).substring( 0,(sqlString.toString()).lastIndexOf(", ") ) );
		((sqlString.append(" WHERE ")).append(whereField)).append(" = ?");
		final String completeSQL=sqlString.toString();
		return connection.prepareStatement(completeSQL);
    }
    
    private PreparedStatement constructDeleteSQL(Connection connection, String tableName, String whereField) throws SQLException{
        StringBuilder sqlString = new StringBuilder("Delete From ");
        sqlString.append(tableName);
        if(whereField != null ) {
		sqlString.append(" WHERE ");
		(sqlString.append( whereField )).append(" = ?");
		}
		final String completeSQL=sqlString.toString();
		return connection.prepareStatement(completeSQL);
    }
   
    @Override
    public void openConnection(String driverClassName, String url, String username, String password) throws IllegalArgumentException, ClassNotFoundException, SQLException {
                String msg = "Please enter a valid URL!";
		if( url == null || url.length() == 0 ) throw new IllegalArgumentException(msg);
		username = (username == null) ? "" : username;
		password = (password == null) ? "" : password;
		Class.forName (driverClassName);
		connection = DriverManager.getConnection(url, username, password);
    }

    @Override
    public void closeConnection() throws SQLException {
        connection.close();
    }

    @Override
    public List findAllRecords(String tableName, boolean closeConnection) throws SQLException, Exception {
        
                Statement sqlStatement = null;
		ResultSet sqlResults = null;
		ResultSetMetaData metaData = null;
		final List listOfRecords = new ArrayList();
		Map record = null;
                String sqlQuery = "Select * From " + tableName + ";";
                
                try{
                    sqlStatement = connection.createStatement();
                    sqlResults = sqlStatement.executeQuery(sqlQuery);
                    metaData = sqlResults.getMetaData();
                    final int numFields = metaData.getColumnCount();
                    
                    while(sqlResults.next()){
                        record = new HashMap();
                        for(int i = 1; i <= numFields; i++){
                            try{
                                record.put(metaData.getColumnName(i), sqlResults.getObject(i));
                            }catch(NullPointerException nullValue){ 
                                //Since Null values are allowed for some fields nothing is done here, they will be handled 
                                //in the creation of the object.
                            }
                        }
                            listOfRecords.add(record);
                        }
                           
                    }catch(SQLException sqle){
                        throw sqle;
                            
                    }catch(Exception e){
                        throw e;
                    }
                finally{
                    try{
                        sqlStatement.close();
				if(closeConnection) connection.close();
                    }catch(SQLException e){
                        throw e;
                    }
                }
                
                return listOfRecords;
    }
    
    @Override
    public boolean insertRecord(String tableName, List columnNames, List columnValues, boolean closeConnection)throws SQLException, Exception{
        PreparedStatement preparedInsertStatement = null;
        int recordsAffected = 0;
        
        try{
            preparedInsertStatement = constructInsertSQL(connection, tableName, columnNames);
            
                Iterator i = columnValues.iterator();
                int count = 1;
                
                while(i.hasNext()){
                    final Object value = i.next();
                    if(value instanceof String){
					preparedInsertStatement.setString( count++,(String)value );
				} else if(value instanceof Integer ){
					preparedInsertStatement.setInt( count++,((Integer)value).intValue() );
				} else if(value instanceof Long ){
					preparedInsertStatement.setLong( count++,((Long)value).longValue() );
				} else if(value instanceof Double ){
					preparedInsertStatement.setDouble( count++,((Double)value).doubleValue() );
				} else if(value instanceof java.sql.Date ){
					preparedInsertStatement.setDate(count++, (java.sql.Date)value);
				} else if(value instanceof Boolean ){
					preparedInsertStatement.setBoolean(count++, ((Boolean)value).booleanValue() );
				} else {
					if(value != null) preparedInsertStatement.setObject(count++, value);
				}
                    }
                recordsAffected = preparedInsertStatement.executeUpdate();
                } catch (SQLException sqle) {
			throw sqle;
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				preparedInsertStatement.close();
				if(closeConnection) connection.close();
			} catch(SQLException e) {
				throw e;
			} 
		} 

		if(recordsAffected == 1){
			return true;
		} else {
			return false;
		}
        
    }
    
    @Override
    public int updateRecord(String tableName, List columnNames, List columnValues, 
            String whereField, Object whereValue, boolean closeConnection)throws SQLException, Exception{
        
        PreparedStatement preparedUpdateStatement = null;
        int recordsAffected = 0;
        
        try{
            preparedUpdateStatement = constructUpdateSQL(connection, tableName, columnNames, whereField);
            final Iterator i=columnValues.iterator();
            int count = 1;
            boolean foundWhereValue = false;
            Object value = null;
            
            while( i.hasNext() || foundWhereValue) {
				if(!foundWhereValue){ value = i.next();}

				if(value instanceof String){
					preparedUpdateStatement.setString( count++,(String)value);
				} else if(value instanceof Integer ){
					preparedUpdateStatement.setInt( count++,((Integer)value).intValue());
				} else if(value instanceof Long ){
					preparedUpdateStatement.setLong( count++,((Long)value).longValue());
				} else if(value instanceof Double ){
					preparedUpdateStatement.setDouble( count++,((Double)value).doubleValue());
				} else if(value instanceof java.sql.Timestamp ){
					preparedUpdateStatement.setTimestamp(count++, (java.sql.Timestamp)value);
				} else if(value instanceof java.sql.Date ){
					preparedUpdateStatement.setDate(count++, (java.sql.Date)value);
				} else if(value instanceof Boolean ){
					preparedUpdateStatement.setBoolean(count++, ((Boolean)value).booleanValue() );
				} else {
					if(value != null) preparedUpdateStatement.setObject(count++, value);
				}
                                if(foundWhereValue){ break;} // only allow loop to continue one time
				if(!i.hasNext() ) {          // continue loop for whereValue
					foundWhereValue = true;
					value = whereValue;
                                    }
				}
            recordsAffected = preparedUpdateStatement.executeUpdate();
            
            } catch (SQLException sqle) {
			throw sqle;
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				preparedUpdateStatement.close();
				if(closeConnection) connection.close();
			} catch(SQLException e) {
				throw e;
			} 
		} 

		return recordsAffected;
    }
    
    @Override
    public int deleteRecord(String tableName, String whereField, Object whereValue, boolean closeConnection)throws SQLException, Exception{
        PreparedStatement preparedDeleteStatement = null;
        int recordsDeleted = 0;
        
        try{
            preparedDeleteStatement = constructDeleteSQL(connection, tableName, whereField);
            
            if(whereField != null){
                if(whereValue instanceof String){
				preparedDeleteStatement.setString( 1,(String)whereValue );
			} else if(whereValue instanceof Integer ){
				preparedDeleteStatement.setInt( 1,((Integer)whereValue).intValue() );
			} else if(whereValue instanceof Long ){
				preparedDeleteStatement.setLong( 1,((Long)whereValue).longValue() );
			} else if(whereValue instanceof Double ){
				preparedDeleteStatement.setDouble( 1,((Double)whereValue).doubleValue() );
			} else if(whereValue instanceof java.sql.Date ){
				preparedDeleteStatement.setDate(1, (java.sql.Date)whereValue );
			} else if(whereValue instanceof Boolean ){
				preparedDeleteStatement.setBoolean(1, ((Boolean)whereValue).booleanValue() );
			} else {
				if(whereValue != null) preparedDeleteStatement.setObject(1, whereValue);
				}
            }
            
            recordsDeleted = preparedDeleteStatement.executeUpdate();
            
            } catch (SQLException sqle) {
			throw sqle;
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				preparedDeleteStatement.close();
				if(closeConnection) connection.close();
			} catch(SQLException e) {
				throw e;
			} // end try
		} // end finally

		return recordsDeleted;
        }
        
 }
    

