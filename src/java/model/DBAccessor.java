package model;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author J-Tron
 * @version 1.0
 */
public interface DBAccessor {
    
    /**
     *
     * @param driverClassName
     * @param url
     * @param username
     * @param password
     * @throws IllegalArgumentException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public abstract void openConnection(String driverClassName, String url, String username, String password) 
	throws IllegalArgumentException, ClassNotFoundException, SQLException;
    
    /**
     *
     * @throws SQLException
     */
    public abstract void closeConnection() throws SQLException;
    
    /**
     *
     * @param tableName
     * @param closeConnection
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public abstract List findAllRecords(String tableName, boolean closeConnection) throws SQLException,
			Exception;
    
    /**
     *
     * @param tableName
     * @param columnNames
     * @param columnValues
     * @param closeConnection
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public abstract boolean insertRecord(String tableName, List columnNames, List columnValues, boolean closeConnection)
            throws SQLException, Exception;
    
    /**
     *
     * @param tableName
     * @param columnNames
     * @param columnValues
     * @param whereField
     * @param whereValue
     * @param closeConnection
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public abstract int updateRecord(String tableName, List columnNames, List columnValues, String whereField, 
            Object whereValue, boolean closeConnection)
            throws SQLException, Exception;
    
    /**
     *
     * @param tableName
     * @param whereField
     * @param whereValue
     * @param closeConnection
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public abstract int deleteRecord(String tableName, String whereField, Object whereValue, boolean closeConnection)
	throws SQLException, Exception;
    
    /**
     *
     * @param sqlStatement
     * @param closeConnection
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public abstract List findRecordsWithSQLString(String sqlStatement, boolean closeConnection) throws SQLException, Exception;
}
