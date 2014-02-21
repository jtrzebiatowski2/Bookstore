package model;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author J-Tron
 * @version 1.0
 */
public interface DBAccessor {
    
    public abstract void openConnection(String driverClassName, String url, String username, String password) 
	throws IllegalArgumentException, ClassNotFoundException, SQLException;
    
    public abstract void closeConnection() throws SQLException;
    
    public abstract List findAllRecords(String tableName, boolean closeConnection) throws SQLException,
			Exception;
    
    public abstract boolean insertRecord(String tableName, List columnNames, List columnValues, boolean closeConnection)
            throws SQLException, Exception;
    
    public abstract int updateRecord(String tableName, List columnNames, List columnValues, String whereField, 
            Object whereValue, boolean closeConnection)
            throws SQLException, Exception;
    
    public abstract int deleteRecord(String tableName, String whereField, Object whereValue, boolean closeConnection)
	throws SQLException, Exception;
}
