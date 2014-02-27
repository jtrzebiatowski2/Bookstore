package model;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author J-Tron
 */
public class OrderDAO implements OrderDAOStrategy {
    private final DBAccessor databaseAccessor;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/bookstore";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "tiburon87";
    private static final String ORDER_TABLE_NAME = "book_order";
    private static final String ORDER_BY_CUSTOMER_ID = "SELECT customer.last_name, customer.first_name, customer.customer_id,"
            + "book_order.order_id, book_order.total, book_order.grand_total, book_order.order_date, customer.street, customer.city, customer.state, customer.zip, customer.credit_card_number, book_order.tax  "
            + "FROM book_order join customer on customer.customer_id = book_order.customer_id "
            + "WHERE customer.customer_id = ";
    private static final String ORDERS_BY_DATE_RANGE_BEGIN = "Select * FROM book_order WHERE order_date BETWEEN ";
    private static final String ORDER_BY_DATE_RANGE_END = " AND ";
    
    /**
     *
     */
    public OrderDAO(){
        databaseAccessor = new DB_MySql();
    }

    /**
     *
     * @return
     * @throws RuntimeException
     */
    @Override
    public List<Order> getOrders() throws RuntimeException {
        SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd");
        List<Order> orders = new <Order>ArrayList();
        
        try{
            databaseAccessor.openConnection(DRIVER, URL, USERNAME, PASSWORD);
            List<Map> order_list = databaseAccessor.findAllRecords(ORDER_TABLE_NAME, true);
            for(int i = 0; i < order_list.size(); i++){
            Order order = new Order();
            order.setOrder_id((Integer)(order_list.get(i).get("order_id")));
            order.setCustomer_id((Integer)(order_list.get(i).get("customer_id")));
            Date date= (Date)order_list.get(i).get("order_date");
            String orderDateS = formatter.format(date);
            order.setOrderDate(orderDateS);
            order.setTax((Double)(order_list.get(i).get("tax")));
            order.setGrandTotal((Double)(order_list.get(i).get("grand_total")));
            
            orders.add(order);
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
        
        return orders;
        
    }
    
    /**
     *
     * @param order
     */
    @Override
    public void addOrder(Order order){
        try {
            databaseAccessor.openConnection(DRIVER, URL, USERNAME, PASSWORD);
            String tableName = ORDER_TABLE_NAME;
            List<String> columnNames =
                new ArrayList<String>();
            columnNames.add("customer_id");
            columnNames.add("order_date");
            columnNames.add("total");
            columnNames.add("tax");
            columnNames.add("grand_total");
            
            List fieldValues =
                new ArrayList();
            fieldValues.add(order.getCustomer_id());
            fieldValues.add(order.getOrderDate());
            fieldValues.add(order.getTotal());
            fieldValues.add(order.getTax());
            fieldValues.add(order.getGrandTotal());
            
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

    /**
     *
     * @param customerID
     * @return
     */
    @Override
    public List<CustomerOrderDTO> getOrderByCustomerID(int customerID) {
            SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd");
            List<Map> joinData = new ArrayList<Map>();
            List<CustomerOrderDTO> values = new ArrayList<CustomerOrderDTO>();
            
        try{
            databaseAccessor.openConnection(DRIVER, URL, USERNAME, PASSWORD);
            joinData = databaseAccessor.findRecordsWithSQLString(ORDER_BY_CUSTOMER_ID + String.valueOf(customerID), true);
            
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        CustomerOrderDTO customerOrderDTO = null;
        
        for (Map m : joinData) {
            customerOrderDTO = new CustomerOrderDTO();
            String lastName = m.get("last_name").toString();
            customerOrderDTO.setLastName(lastName);
            String firstName = m.get("first_name").toString();
            customerOrderDTO.setFirstName(firstName);
            int customer_ID = (Integer)m.get("customer_id");
            customerOrderDTO.setCustomerID(customer_ID);
            int order_ID = (Integer)m.get("order_id");
            customerOrderDTO.setOrderID(order_ID);
            double orderTotal = (Double)m.get("total");
            customerOrderDTO.setOrderTotal(orderTotal);
            double grandTotal = (Double)m.get("grand_total");
            customerOrderDTO.setOrderGrandTotal(grandTotal);
            Date date = (Date)m.get("order_date");
            String orderDateS = formatter.format(date);
            customerOrderDTO.setDate(orderDateS);
            String street = m.get("street").toString();
            customerOrderDTO.setStreet(street);
            String city = m.get("city").toString();
            customerOrderDTO.setCity(city);
            String state = m.get("state").toString();
            customerOrderDTO.setState(state);
            String zip = m.get("zip").toString();
            customerOrderDTO.setZip(zip);
            String creditCardNumber = m.get("credit_card_number").toString();
            customerOrderDTO.setCreditCardNumber(creditCardNumber);
            double tax = (Double)m.get("tax");
            customerOrderDTO.setTax(tax);
            values.add(customerOrderDTO);
        }

        return values;
    }

    /**
     *
     * @param order
     */
    @Override
    public void updateOrder(Order order) {
        try {
            databaseAccessor.openConnection(DRIVER, URL, USERNAME, PASSWORD);
            String tableName = ORDER_TABLE_NAME;
            List<String> columnNames =
                new ArrayList<String>();
            columnNames.add("order_id");
            columnNames.add("customer_id");
            columnNames.add("order_date");
            columnNames.add("total");
            columnNames.add("tax");
            columnNames.add("grand_total");

            List fieldValues =
                new ArrayList();
            fieldValues.add(order.getOrder_id());
            fieldValues.add(order.getCustomer_id());
            fieldValues.add(order.getOrderDate());
            fieldValues.add(order.getTotal());
            fieldValues.add(order.getTax());
            fieldValues.add(order.getGrandTotal());
            
            databaseAccessor.updateRecord(tableName, columnNames, fieldValues, "order_id", order.getOrder_id(), true);
            
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

    /**
     *
     * @param date1
     * @param date2
     * @return
     */
    @Override
    public List<Order> getOrdersByDateRange(String date1, String date2) {
        SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd");
        List<Map> joinData = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        
        try{
            databaseAccessor.openConnection(DRIVER, URL, USERNAME, PASSWORD);
            joinData = databaseAccessor.findRecordsWithSQLString(ORDERS_BY_DATE_RANGE_BEGIN + "'" + date1 + "'" 
                    + ORDER_BY_DATE_RANGE_END + "'" + date2 + "'", true);
             
        }catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
            Order order = null;
            
            for(Map o: joinData){
                order = new Order();
                int orderID = (Integer)o.get("order_id");
                order.setOrder_id(orderID);
                int custmomerID = (Integer)o.get("customer_id");
                order.setCustomer_id(custmomerID);
                double orderTotal = (Double)o.get("total");
                order.setTotal(orderTotal);
                Date orderDate = (Date)o.get("order_date");
                String orderDateS = formatter.format(orderDate);
                order.setOrderDate(orderDateS);
                double tax = (Double)o.get("tax");
                order.setTax(tax);
                double grandTotal = (Double)o.get("grand_total");
                order.setGrandTotal(grandTotal);
                orders.add(order);
            }
            
        return orders;
    }

    /**
     *
     * @param order
     */
    @Override
    public void deleteOrder(Order order) {
         try {
            databaseAccessor.openConnection(DRIVER, URL, USERNAME, PASSWORD);
            
            databaseAccessor.deleteRecord(ORDER_TABLE_NAME, "order_id", order.getOrder_id(), true);
            
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
