package controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Book;
import model.BookOrderService;
import model.CustomerOrderDTO;
import model.Order;
import model.OrderDetail;

/**
 *
 * @author J-Tron
 * @version 1.0
 */
@WebServlet(name = "AddBookController", urlPatterns = {"/addBook"})
public class AddBookController extends HttpServlet {
        private static final String ITEM_ADDED_PAGE = "itemAdded.jsp";
        private HttpSession httpSession;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    /**
     * This method retrieves the current user's id and finds if an order exists. If it does it gets the selected
     * book information, creates a book, and then adds the order information as an order detail corresponding
     * to the appropriate customer order. The order detail is added and from that the order totals are all updated.
     * 
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        BookOrderService bos= new BookOrderService();
        
        httpSession = request.getSession(true);
        
        Integer custID = (Integer)(httpSession.getAttribute("session_customer_id"));
        
        List<CustomerOrderDTO> details = bos.getOrderByCustomerID(custID);
        
        if(details.isEmpty()){
        Order initialOrder = new Order();
        initialOrder.setCustomer_id(custID);
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateNow = formatter.format(date);
        initialOrder.setOrderDate(dateNow);
        initialOrder.setTotal(0.0);
        initialOrder.setGrandTotal(0.0);
        initialOrder.setTax(0.0);
        bos.addOrder(initialOrder);  
        }

        Integer bookID = (Integer)(httpSession.getAttribute("session_book_id")) + 2;
        
        Book orderedBook = (Book)bos.getBookByID(bookID);
        
        int bookQuantity = (Integer.valueOf(request.getParameter("bookQuantity")));
        
        OrderDetail orderDetail = new OrderDetail();
        int orderID = (bos.getOrderByCustomerID(custID).get(0).getOrderID());
        
        httpSession.setAttribute("session_order_id", orderID);
        
        orderDetail.setOrder_id(orderID);
        orderDetail.setBook_id(bookID);
        orderDetail.setQuantity(bookQuantity);
        double lineTotal = orderDetail.calculateLineItemTotal(bookQuantity, orderedBook.getPrice());
        orderDetail.setLineTotal(lineTotal);
        bos.addOrderDetail(orderDetail);
        
        List<Order> orderList = bos.getOrders();
        
        Order orderToUpdate = orderList.get(orderList.size() - 1);
        
        orderToUpdate.setTotal(bos.getOrderTotal(orderToUpdate.getOrder_id()));
        double updatedTotal = orderToUpdate.getTotal();
        orderToUpdate.setTax(orderToUpdate.calculateWITax(bos.getOrderTotal(orderToUpdate.getOrder_id())));
        double updatedTax = orderToUpdate.getTax();
        orderToUpdate.setGrandTotal(orderToUpdate.calculateGrandTotal(updatedTotal, updatedTax));
        
        bos.updateOrder(orderToUpdate);
              
        RequestDispatcher view =
                request.getRequestDispatcher(ITEM_ADDED_PAGE);
        view.forward(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
