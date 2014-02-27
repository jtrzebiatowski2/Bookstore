package model;

import java.util.List;

/**
 *
 * @author J-Tron
 * @version 1.0
 */
public interface BookOrderDAOStrategy {

    /**
     *
     * @return
     */
    public abstract List<Book> getBookList();

    /**
     *
     * @return
     */
    public abstract List<Order> getOrders();

    /**
     *
     * @return
     */
    public abstract List<OrderDetail> getOrderDetails();

    /**
     *
     * @param book
     */
    public abstract void addBook(Book book);

    /**
     *
     * @param book
     */
    public abstract void updateBook(Book book);

    /**
     *
     * @param book
     */
    public abstract void deleteBook(Book book);
}
