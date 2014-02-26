package model;

import java.util.List;

/**
 *
 * @author J-Tron
 */
public class BookOrderService {
    private final BookDAOStrategy bookDAOStrategy;
    private final CustomerDAOStrategy customerDAOStrategy;
    private final OrderDAOStrategy orderDAOStrategy;
    private final OrderDetailsDAOStrategy orderDetailsStrategy;

    public BookOrderService() {
        bookDAOStrategy = new BookOrderDAO();
        customerDAOStrategy = new CustomerDAO();
        orderDAOStrategy = new OrderDAO();
        orderDetailsStrategy = new OrderDetailsDAO();
    }
    
    public List<Book> getBooks(){
        return bookDAOStrategy.getBookList();
    }
    
    public void addBook(Book book){
        bookDAOStrategy.addBook(book);
    }
    
    public void deleteBook(Book book){
        bookDAOStrategy.deleteBook(book);
    }
    
    public void updateBook(Book book){
        bookDAOStrategy.updateBook(book);
    }
    
    public List<Customer> getCustomers(){
        return customerDAOStrategy.getCustomerList();
    }
    
    public void addCustomer(Customer customer){
    customerDAOStrategy.addCustomer(customer);
    }
    
    public void updateCustomer(Customer customer){
        customerDAOStrategy.updateCustomer(customer);
    }
    
    public void deleteCustomer(Customer customer){
        customerDAOStrategy.deleteCustomer(customer);
    }
    
    public List<Order> getOrders(){
        return orderDAOStrategy.getOrders();
    }
    
    public void addOrder(Order order){
        orderDAOStrategy.addOrder(order);
    }
    
    public List<CustomerOrderDTO> getOrderByCustomerID(int customerID){
        return orderDAOStrategy.getOrderByCustomerID(customerID);
    }
    
    public List<OrderDetail> getOrderDetail(){
        return orderDetailsStrategy.getOrderDetails();
    }
    
    public void addOrderDetail(OrderDetail orderDetail){
        orderDetailsStrategy.addOrderDetail(orderDetail);
    }
    
    public Book getBookByID(int bookID){
        return bookDAOStrategy.getBookByID(bookID);
    }
    
    public void updateOrder(Order order){
        orderDAOStrategy.updateOrder(order);
    }
    public double getOrderTotal(int order_id){
        return orderDetailsStrategy.getOrderTotal(order_id);
    }
    
    public List<OrderDetail> getOrderDetailsByOrderID(int order_id){
        return orderDetailsStrategy.getOrderDetails(order_id);
    }
    
}
