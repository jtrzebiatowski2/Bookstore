package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
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
import model.Order;
import model.OrderDetail;

/**
 *
 * @author J-Tron
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
        
        Integer bookID = (Integer)(httpSession.getAttribute("session_book_id")) + 2;
        
        Order order = new Order();
        
        order.setOrderDate(Calendar.getInstance().getTime());
        
        order.setCustomer_id(custID);
        
        order.setTotal(0.0);
        
        order.setTax(0.0);
        
        order.setGrandTotal(0.0);
        
        bos.addOrder(order);
        
        OrderDetail orderDetail = new OrderDetail();

        
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
