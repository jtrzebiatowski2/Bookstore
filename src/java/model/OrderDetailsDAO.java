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
public class OrderDetailsDAO implements OrderDetailsDAOStrategy{
    private final DBAccessor databaseAccessor;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/bookstore";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "tiburon87";
    private static final String ORDER_DETAIL_TABLE_NAME = "order_details";
    private static final String SUM_OF_ORDER_FROM_ORDER_DETAILS = "SELECT sum(total) FROM order_details WHERE order_id = ";
    private static final String ORDER_DETAILS_BY_ORDERID = "SELECT * FROM order_details WHERE order_id = ";
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
    
    @Override
    public void addOrderDetail(OrderDetail orderDetail){
        try {
            databaseAccessor.openConnection(DRIVER, URL, USERNAME, PASSWORD);
            String tableName = ORDER_DETAIL_TABLE_NAME;
            List<String> columnNames =
                new ArrayList<String>();
            columnNames.add("order_id");
            columnNames.add("book_id");
            columnNames.add("quantity");
            columnNames.add("total");
            
            List fieldValues =
                new ArrayList();
            fieldValues.add(orderDetail.getOrder_id());
            fieldValues.add(orderDetail.getBook_id());
            fieldValues.add(orderDetail.getQuantity());
            fieldValues.add(orderDetail.getLineTotal());
            
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
    public double getOrderTotal(int order_id) {
        double total = 0;
      try {
            databaseAccessor.openConnection(DRIVER, URL, USERNAME, PASSWORD);
            List<Map> orderDetails_list = 
                    databaseAccessor.findRecordsWithSQLString(SUM_OF_ORDER_FROM_ORDER_DETAILS 
                            + String.valueOf(order_id), true);
            
            for(int i = 0; i < orderDetails_list.size(); i++){
                total = (Double)orderDetails_list.get(0).get("sum(total)");
            }
            
        }catch (IllegalArgumentException ex) {
            Logger.getLogger(BookOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BookOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      return total;
    }

    @Override
    public List<OrderDetail> getOrderDetails(int order_id) {
        List<OrderDetail> orderDetails = new <OrderDetail>ArrayList();
        try{
            databaseAccessor.openConnection(DRIVER, URL, USERNAME, PASSWORD);
            List<Map> orderDetails_list = 
                    databaseAccessor.findRecordsWithSQLString(ORDER_DETAILS_BY_ORDERID + 
                            String.valueOf(order_id), true);
            for(Map m : orderDetails_list){
                OrderDetail detail = new OrderDetail();
                Integer orderID = (Integer)m.get("order_id");
                detail.setOrder_id(orderID);
                Integer bookID = (Integer)m.get("book_id");
                detail.setBook_id(bookID);
                Integer quantity = (Integer)m.get("quantity");
                detail.setQuantity(quantity);
                double lineTotal = (Double)m.get("total");
                detail.setLineTotal(lineTotal);
                orderDetails.add(detail);
            }
             
        }catch (IllegalArgumentException ex) {
            Logger.getLogger(BookOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BookOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        return orderDetails;
    }
}