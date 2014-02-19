package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author J-Tron
 * @version 1.0
 */
public class BookOrderDAO implements BookOrderDAOStrategy{
    private final DBAccessor databaseAccessor;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/bookstore";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "tiburon87";
    private static final String BOOK_TABLE_NAME = "book";
    private static final String CUSTOMER_TABLE_NAME = "customer";
    private static final String ORDER_TABLE_NAME = "order";
    private static final String ORDER_DETAIL_TABLE_NAME = "order_details";
    
    public BookOrderDAO(){
        databaseAccessor = new DB_MySql();
    }

    @Override
    public List<Book> getBookList() throws RuntimeException {
        
        List<Book> books = new <Book>ArrayList();
        
        try{
            databaseAccessor.openConnection(DRIVER, URL, USERNAME, PASSWORD);
            List<Map> book_list = databaseAccessor.findAllRecords(BOOK_TABLE_NAME, true);
            for(int i = 0; i < book_list.size(); i++){
            Book book = new Book();
            book.setBook_id((Integer)(book_list.get(i).get("book_id")));
            book.setTitle((String)(book_list.get(i).get("title")));
            book.setDescription((String)(book_list.get(i).get("description")));
            book.setPrice((Double)(book_list.get(i).get("price")));
            books.add(book);
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
        
        return books;
        
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
