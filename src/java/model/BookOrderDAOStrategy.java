package model;

import java.util.List;

/**
 *
 * @author J-Tron
 * @version 1.0
 */
public interface BookOrderDAOStrategy {
    public abstract List<Book> getBookList();
    public abstract List<Order> getOrders();
    public abstract List<OrderDetail> getOrderDetails();
    public abstract void addBook(Book book);
    public abstract void updateBook(Book book);
    public abstract void deleteBook(Book book);
}
