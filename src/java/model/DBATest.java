package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author J-Tron
 */
public class DBATest {
    public static void main(String[] args) throws ParseException {
        
//        BookOrderDAO testDao = new BookOrderDAO();
//        
//        Book book1 = new Book();
//        book1.setBook_id(16);
//        book1.setTitle("Killer");
//        book1.setPrice(14.99);
//        book1.setDescription("Killer is a mesmerizing L.A. noir portrayal of the darkest impulses of human nature carried to shocking extremes.");
//        book1.setImage_url("killer.jpg");
//        book1.setAuthor("Kellerman, Jonathan");
//        
//        Book book2 = testDao.getBookList().get(1);
//        book2.setPrice(18.99);
//        
//        testDao.deleteBook(testDao.getBookList().get(1));
//        
//        testDao.updateBook(book2);
//        System.out.print(testDao.getBookList().toString());
        
//        CustomerDAO testDao2 = new CustomerDAO();
        
//        Customer customer1 = new Customer();
//        customer1.setFirstName("Justin");
//        customer1.setLastName("Trzebiatowski");
//        customer1.setEmail("jtrzebiatowski2@my.wctc.edu");
//        customer1.setStreet("2004 Oakdale Dr. #49");
//        customer1.setCity("Waukesha");
//        customer1.setState("WI");
//        customer1.setZip("53189");
//        customer1.setPhone("262-259-7845");
//        customer1.setCreditCardNumber("4451236585961245");
//        
//        testDao2.addCustomer(customer1);
        
//       Customer customer2;
//       customer2 = testDao2.getCustomerList().get(0);
//       customer2.setPhone("4142564785");
//       
//       testDao2.updateCustomer(customer2);
        
//        OrderDAO testDao3 = new OrderDAO();
        
//        Order order1 = new Order();
//        order1.setCustomer_id(1);
//        order1.setOrderDate(Calendar.getInstance().getTime());
//        order1.setTotal(140.45);
//        order1.setTax(order1.calculateWITax(order1.getTotal()));
//        order1.setGrandTotal(order1.calculateGrandTotal(order1.getTotal(), order1.getTax()));
//        
//        testDao3.addOrder(order1);
        
//        OrderDetailsDAO testDao4 = new OrderDetailsDAO();
//        OrderDetail orderDetail1 = new OrderDetail();
//        orderDetail1.setOrder_id(1);
//        orderDetail1.setBook_id(6);
//        orderDetail1.setQuantity(8);
//        orderDetail1.setLineTotal(orderDetail1.calculateLineItemTotal(orderDetail1.getQuantity(), 25.00));
//        
//        testDao4.addOrderDetail(orderDetail1);
        
//        System.out.print(testDao3.getOrderByCustomerID(1).toString());
        
       BookOrderService bos = new BookOrderService();
//        
//        System.out.print(bos.getBooks().toString());
        
//        System.out.print((bos.getBookByID(17)).toString());
       
//        System.out.print((bos.getOrderTotal(14)));
        
//       List<OrderDetail> orders = bos.getOrderDetailsByOrderID(24);
        
//       System.out.print(orders.toString());
//            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            String date1 = ("2014-02-20");
//            String date2 = ("2014-02-27");
//            
//            Date convertedDate1 = (Date)formatter.parse(date1);
//            Date convertedDate2= (Date)formatter.parse(date2);
//            
//         
//         List<Order> orders = bos.getOrdersByDateRange(convertedDate1, convertedDate2);
//         
//         for(Order o: orders){
//             System.out.print(o.getCustomer_id() + "\n");
//         }
      
    }
}
