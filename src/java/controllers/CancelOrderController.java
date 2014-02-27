package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.BookOrderService;
import model.CustomerOrderDTO;
import model.Order;

/**
 *
 * @author J-Tron
 */
@WebServlet(name = "CancelOrderController", urlPatterns = {"/cancel"})
public class CancelOrderController extends HttpServlet {
    HttpSession session;
    private static final String ORDER_CANCEL_CONFIRMATION_PAGE = "orderCancel.jsp";

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
        session = request.getSession(true);
        
        BookOrderService bos = new BookOrderService();
        Integer customerID = (Integer)session.getAttribute("session_customer_id");
        
        List<CustomerOrderDTO> orderDetails = bos.getOrderByCustomerID(customerID);
        
        CustomerOrderDTO thisOrder = orderDetails.get(0);
        
        Order order = new Order();
        order.setOrder_id(thisOrder.getOrderID());
        order.setCustomer_id(thisOrder.getCustomerID());
        order.setTotal(thisOrder.getOrderTotal());
        order.setOrderDate(thisOrder.getDate());
        order.setTax(thisOrder.getTax());
        order.setGrandTotal(thisOrder.getOrderGrandTotal());
        
        bos.deleteOrder(order);
        
        
        
        RequestDispatcher view =
        request.getRequestDispatcher(ORDER_CANCEL_CONFIRMATION_PAGE);
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
