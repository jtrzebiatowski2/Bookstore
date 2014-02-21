package model;

/**
 *
 * @author J-Tron
 */
public class DBATest {
    public static void main(String[] args) {
        
        BookOrderDAO testDao = new BookOrderDAO();
        System.out.print(testDao.getBookList().toString());
        
        
    }
}
