package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author J-Tron
 * @version 1.0
 */
public class BookOrderDAO implements BookDAOStrategy{
    private final DBAccessor databaseAccessor;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/bookstore";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "tiburon87";
    private static final String BOOK_TABLE_NAME = "book";
    private static final String BOOK_BY_ID = "SELECT book_id,title, price, description, image, author"
            + " FROM book WHERE book_id = ";
    
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
            book.setAuthor((String)(book_list.get(i).get("author")));
            book.setImage_url((String)(book_list.get(i).get("image")));
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
    public void addBook(Book book){
        try {
            databaseAccessor.openConnection(DRIVER, URL, USERNAME, PASSWORD);
            String tableName = BOOK_TABLE_NAME;
            List<String> columnNames =
                new ArrayList<String>();
            columnNames.add("title");
            columnNames.add("price");
            columnNames.add("description");
            columnNames.add("image");
            columnNames.add("author");

            List fieldValues =
                new ArrayList();
            fieldValues.add(book.getTitle());
            fieldValues.add(book.getPrice());
            fieldValues.add(book.getDescription());
            fieldValues.add(book.getImage_url());
            fieldValues.add(book.getAuthor());
            
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
    public void updateBook(Book book){
        try {
            databaseAccessor.openConnection(DRIVER, URL, USERNAME, PASSWORD);
            String tableName = BOOK_TABLE_NAME;
            List<String> columnNames =
                new ArrayList<String>();
            columnNames.add("book_id");
            columnNames.add("title");
            columnNames.add("price");
            columnNames.add("description");
            columnNames.add("image");
            columnNames.add("author");

            List fieldValues =
                new ArrayList();
            fieldValues.add(book.getBook_id());
            fieldValues.add(book.getTitle());
            fieldValues.add(book.getPrice());
            fieldValues.add(book.getDescription());
            fieldValues.add(book.getImage_url());
            fieldValues.add(book.getAuthor());
            
            databaseAccessor.updateRecord(tableName, columnNames, fieldValues, "book_id", book.getBook_id(), true);
            
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
    public void deleteBook(Book book){
        try {
            databaseAccessor.openConnection(DRIVER, URL, USERNAME, PASSWORD);
            
            databaseAccessor.deleteRecord(BOOK_TABLE_NAME, "book_id", book.getBook_id(), true);
            
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
    public Book getBookByID(int bookID) {
        List<Map> data = new ArrayList<Map>();
        Book book = new Book();
        
        try{
            databaseAccessor.openConnection(DRIVER, URL, USERNAME, PASSWORD);
            data = databaseAccessor.findRecordsWithSQLString(BOOK_BY_ID + String.valueOf(bookID), true);
            
        }catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         for(Map m : data){
             book = new Book();
             book.setBook_id(bookID);
             String title = m.get("title").toString();
             book.setTitle(title);
             Double price = (Double)m.get("price");
             book.setPrice(price);
             String description = m.get("description").toString();
             book.setDescription(description);
             String image = m.get("image").toString();
             book.setImage_url(image);
             String author = m.get("author").toString();
             book.setAuthor(author);
             
         }
        return book;
    }
    
}
