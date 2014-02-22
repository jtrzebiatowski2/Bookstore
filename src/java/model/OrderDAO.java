package model;

import java.sql.SQLException;
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
    
    public OrderDAO(){
        databaseAccessor = new DB_MySql();
    }
    
     @Override
    public List<Order> getOrders() throws RuntimeException {
        
        List<Order> orders = new <Order>ArrayList();
        
        try{
            databaseAccessor.openConnection(DRIVER, URL, USERNAME, PASSWORD);
            List<Map> order_list = databaseAccessor.findAllRecords(ORDER_TABLE_NAME, true);
            for(int i = 0; i < order_list.size(); i++){
            Order order = new Order();
            order.setOrder_id((Integer)(order_list.get(i).get("order_id")));
            order.setCustomer_id((Integer)(order_list.get(i).get("customer_id")));
            order.setOrderDate((Date)(order_list.get(i).get("order_date")));
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
}
