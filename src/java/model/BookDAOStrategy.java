package model;

import java.util.List;

/**
 *
 * @author J-Tron
 * @version 1.0
 */
public interface BookDAOStrategy {
    
    /**
     *
     * @return
     */
    public abstract List<Book> getBookList();

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

    /**
     *
     * @param bookID
     * @return
     */
    public abstract Book getBookByID(int bookID);
}
