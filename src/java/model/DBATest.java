package model;

/**
 *
 * @author J-Tron
 */
public class DBATest {
    public static void main(String[] args) {
        
        BookOrderDAO testDao = new BookOrderDAO();
        
        Book book1 = new Book();
        book1.setBook_id(16);
        book1.setTitle("Killer");
        book1.setPrice(14.99);
        book1.setDescription("Killer is a mesmerizing L.A. noir portrayal of the darkest impulses of human nature carried to shocking extremes.");
        book1.setImage_url("killer.jpg");
        book1.setAuthor("Kellerman, Jonathan");
        
        Book book2 = testDao.getBookList().get(1);
        book2.setPrice(18.99);
        
        testDao.deleteBook(testDao.getBookList().get(1));
        
        testDao.updateBook(book2);
        System.out.print(testDao.getBookList().toString());
        
    }
}
