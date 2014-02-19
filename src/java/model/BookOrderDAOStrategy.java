package model;

import java.util.List;

/**
 *
 * @author J-Tron
 * @version 1.0
 */
public interface BookOrderDAOStrategy {
    List<Book> getBookList();
    List<Customer> getCustomerList();
    List<Order> getOrders();
    List<OrderDetail> getOrderDetails();
}
