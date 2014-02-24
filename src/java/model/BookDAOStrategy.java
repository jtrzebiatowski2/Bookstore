package model;

import java.util.List;

/**
 *
 * @author J-Tron
 * @version 1.0
 */
public interface BookDAOStrategy {
    
    public abstract List<Book> getBookList();
    public abstract void addBook(Book book);
    public abstract void updateBook(Book book);
    public abstract void deleteBook(Book book);
    public abstract List<Book> getBookByID(int bookID);
}
