package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author J-Tron
 */
public class CustomerDAO implements CustomerDAOStrategy {
    
    private final DBAccessor databaseAccessor;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/bookstore";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "tiburon87";
    private static final String CUSTOMER_TABLE_NAME = "customer";
    
    public CustomerDAO(){
        databaseAccessor = new DB_MySql();
    }
     @Override
    public List<Customer> getCustomerList() throws RuntimeException {
        
        List<Customer> customers = new <Customer>ArrayList();
        
        try{
            databaseAccessor.openConnection(DRIVER, URL, USERNAME, PASSWORD);
            List<Map> customer_list = databaseAccessor.findAllRecords(CUSTOMER_TABLE_NAME, true);
            for(int i = 0; i < customer_list.size(); i++){
            Customer customer = new Customer();
            customer.setCustomer_id((Integer)(customer_list.get(i).get("customer_id")));
            customer.setFirstName((String)(customer_list.get(i).get("first_name")));
            customer.setLastName((String)(customer_list.get(i).get("last_name")));
            customer.setEmail((String)(customer_list.get(i).get("email")));
            customer.setPhone((String)(customer_list.get(i).get("phone")));
            customer.setStreet((String)(customer_list.get(i).get("street")));
            customer.setCity((String)(customer_list.get(i).get("city")));
            customer.setState((String)(customer_list.get(i).get("state")));
            customer.setZip((String)(customer_list.get(i).get("zip")));
            customer.setCreditCardNumber((String)(customer_list.get(i).get("credit_card_number")));
            
            customers.add(customer);
        }
            
        }catch (IllegalArgumentException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch(Exception ex) {
             throw new RuntimeException(ex.getMessage(), ex);
        }
        
        return customers;
        
    }

     @Override
    public void addCustomer(Customer customer){
        try {
            databaseAccessor.openConnection(DRIVER, URL, USERNAME, PASSWORD);
            String tableName = CUSTOMER_TABLE_NAME;
            List<String> columnNames =
                new ArrayList<String>();
            columnNames.add("first_name");
            columnNames.add("last_name");
            columnNames.add("email");
            columnNames.add("phone");
            columnNames.add("street");
            columnNames.add("city");
            columnNames.add("state");
            columnNames.add("zip");
            columnNames.add("credit_card_number");
            
            List fieldValues =
                new ArrayList();
            fieldValues.add(customer.getFirstName());
            fieldValues.add(customer.getLastName());
            fieldValues.add(customer.getEmail());
            fieldValues.add(customer.getPhone());
            fieldValues.add(customer.getStreet());
            fieldValues.add(customer.getCity());
            fieldValues.add(customer.getState());
            fieldValues.add(customer.getZip());
            fieldValues.add(customer.getCreditCardNumber());
            
            databaseAccessor.insertRecord(tableName, columnNames, fieldValues, true);
            
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BookOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BookOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void updateCustomer(Customer customer){
        try {
            databaseAccessor.openConnection(DRIVER, URL, USERNAME, PASSWORD);
            String tableName = CUSTOMER_TABLE_NAME;
            List<String> columnNames =
                new ArrayList<String>();
            columnNames.add("customer_id");
            columnNames.add("first_name");
            columnNames.add("last_name");
            columnNames.add("email");
            columnNames.add("phone");
            columnNames.add("street");
            columnNames.add("city");
            columnNames.add("state");
            columnNames.add("zip");
            columnNames.add("credit_card_number");
            
            List fieldValues =
                new ArrayList();
            fieldValues.add(customer.getCustomer_id());
            fieldValues.add(customer.getFirstName());
            fieldValues.add(customer.getLastName());
            fieldValues.add(customer.getEmail());
            fieldValues.add(customer.getPhone());
            fieldValues.add(customer.getStreet());
            fieldValues.add(customer.getCity());
            fieldValues.add(customer.getState());
            fieldValues.add(customer.getZip());
            fieldValues.add(customer.getCreditCardNumber());
            
            databaseAccessor.updateRecord(tableName, columnNames, fieldValues, "customer_id", customer.getCustomer_id(), true);
            
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BookOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BookOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void deleteCustomer(Customer customer){
        try {
            databaseAccessor.openConnection(DRIVER, URL, USERNAME, PASSWORD);
            
            databaseAccessor.deleteRecord(CUSTOMER_TABLE_NAME, "customer_id", customer.getCustomer_id(), true);
            
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BookOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BookOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
