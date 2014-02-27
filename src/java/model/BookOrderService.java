package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author J-Tron
 * @version 1.0
 */
public class BookOrderService {
    private final BookDAOStrategy bookDAOStrategy;
    private final CustomerDAOStrategy customerDAOStrategy;
    private final OrderDAOStrategy orderDAOStrategy;
    private final OrderDetailsDAOStrategy orderDetailsStrategy;

    /**
     *
     */
    public BookOrderService() {
        bookDAOStrategy = new BookOrderDAO();
        customerDAOStrategy = new CustomerDAO();
        orderDAOStrategy = new OrderDAO();
        orderDetailsStrategy = new OrderDetailsDAO();
    }
    
    /**
     *
     * @return
     */
    public List<Book> getBooks(){
        return bookDAOStrategy.getBookList();
    }
    
    /**
     *
     * @param book
     */
    public void addBook(Book book){
        bookDAOStrategy.addBook(book);
    }
    
    /**
     *
     * @param book
     */
    public void deleteBook(Book book){
        bookDAOStrategy.deleteBook(book);
    }
    
    /**
     *
     * @param book
     */
    public void updateBook(Book book){
        bookDAOStrategy.updateBook(book);
    }
    
    /**
     *
     * @return
     */
    public List<Customer> getCustomers(){
        return customerDAOStrategy.getCustomerList();
    }
    
    /**
     *
     * @param customer
     */
    public void addCustomer(Customer customer){
    customerDAOStrategy.addCustomer(customer);
    }
    
    /**
     *
     * @param customer
     */
    public void updateCustomer(Customer customer){
        customerDAOStrategy.updateCustomer(customer);
    }
    
    /**
     *
     * @param customer
     */
    public void deleteCustomer(Customer customer){
        customerDAOStrategy.deleteCustomer(customer);
    }
    
    /**
     *
     * @return
     */
    public List<Order> getOrders(){
        return orderDAOStrategy.getOrders();
    }
    
    /**
     *
     * @param order
     */
    public void addOrder(Order order){
        orderDAOStrategy.addOrder(order);
    }
    
    /**
     *
     * @param customerID
     * @return
     */
    public List<CustomerOrderDTO> getOrderByCustomerID(int customerID){
        return orderDAOStrategy.getOrderByCustomerID(customerID);
    }
    
    /**
     *
     * @return
     */
    public List<OrderDetail> getOrderDetail(){
        return orderDetailsStrategy.getOrderDetails();
    }
    
    /**
     *
     * @param orderDetail
     */
    public void addOrderDetail(OrderDetail orderDetail){
        orderDetailsStrategy.addOrderDetail(orderDetail);
    }
    
    /**
     *
     * @param bookID
     * @return
     */
    public Book getBookByID(int bookID){
        return bookDAOStrategy.getBookByID(bookID);
    }
    
    /**
     *
     * @param order
     */
    public void updateOrder(Order order){
        orderDAOStrategy.updateOrder(order);
    }

    /**
     *
     * @param order_id
     * @return
     */
    public double getOrderTotal(int order_id){
        return orderDetailsStrategy.getOrderTotal(order_id);
    }
    
    /**
     *
     * @param order_id
     * @return
     */
    public List<OrderDetail> getOrderDetailsByOrderID(int order_id){
        return orderDetailsStrategy.getOrderDetails(order_id);
    }
    
    /**
     *
     * @param date1
     * @param date2
     * @return
     */
    public List<Order> getOrdersByDateRange(String date1, String date2){
        return orderDAOStrategy.getOrdersByDateRange(date1, date2);
    }
    
    /**
     *
     * @param order
     */
    public void deleteOrder(Order order){
        orderDAOStrategy.deleteOrder(order);
    }
    
}
