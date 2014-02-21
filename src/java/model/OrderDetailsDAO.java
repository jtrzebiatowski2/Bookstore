package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author J-Tron
 */
public class OrderDetailsDAO implements OrderDetailsDAOStrategy{
    private final DBAccessor databaseAccessor;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/bookstore";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "tiburon87";
    private static final String ORDER_DETAIL_TABLE_NAME = "order_details";
    
    public OrderDetailsDAO(){
        databaseAccessor = new DB_MySql();
    }
    
        @Override
    public List<OrderDetail> getOrderDetails() throws RuntimeException {
        
        List<OrderDetail> orderDetails = new <OrderDetail>ArrayList();
        
        try{
            databaseAccessor.openConnection(DRIVER, URL, USERNAME, PASSWORD);
            List<Map> orderDetails_list = databaseAccessor.findAllRecords(ORDER_DETAIL_TABLE_NAME, true);
            for(int i = 0; i < orderDetails_list.size(); i++){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder_id((Integer)(orderDetails_list.get(i).get("order_id")));
            orderDetail.setBook_id((Integer)(orderDetails_list.get(i).get("book_id")));
            orderDetail.setQuantity((Integer)(orderDetails_list.get(i).get("quantity")));
            orderDetail.setLineTotal((Double)(orderDetails_list.get(i).get("total")));
            
            orderDetails.add(orderDetail);
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
        
        return orderDetails;
        
    }

}