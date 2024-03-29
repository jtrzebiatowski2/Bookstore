package controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.BookOrderService;
import model.OrderDetail;

/**
 *
 * @author J-Tron
 * @version 1.0
 */
@WebServlet(name = "checkoutController", urlPatterns = {"/checkout"})
public class CustomerCheckoutController extends HttpServlet {
    private static final String CUSTOMER_CHECKOUT_PAGE = "customerCheckout.jsp";
    private HttpSession session;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * This method retrieves the list of order details based upon the current user's customer id. It locates the order,
     * uses that to get the order details and sends a list of this info to the jsp page for proper display.
     * 
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
        
        session = request.getSession(true);
        
        BookOrderService bos = new BookOrderService();
        
        List<OrderDetail> orderDetails = bos.getOrderDetailsByOrderID(
                Integer.valueOf(session.getAttribute("session_order_id").toString()));
        
        request.setAttribute("customerOrderDetails", orderDetails);
        
        RequestDispatcher view =
            request.getRequestDispatcher(CUSTOMER_CHECKOUT_PAGE);
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
