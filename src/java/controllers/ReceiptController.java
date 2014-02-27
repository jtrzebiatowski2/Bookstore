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
import model.CustomerOrderDTO;

/**
 *
 * @author J-Tron
 * @version 1.0
 */
@WebServlet(name = "receiptController", urlPatterns = {"/receipt"})
public class ReceiptController extends HttpServlet {
    private static final String CUSTOMER_RECEIPT_PAGE = "customerReceipt.jsp";
    HttpSession session;
     
     

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
        
        List<CustomerOrderDTO> thisOrder = bos.getOrderByCustomerID((Integer)session.getAttribute("session_customer_id"));
        
        CustomerOrderDTO customerOrder = thisOrder.get(0);
        String customerFirst = customerOrder.getFirstName();
        request.setAttribute("customerFirst", customerFirst);
        
        String customerLast = customerOrder.getLastName();
        request.setAttribute("customerLast", customerLast);
        
        String orderDate = customerOrder.getDate();
        request.setAttribute("orderDate", orderDate);
        
        int orderID = customerOrder.getOrderID();
        request.setAttribute("orderID", orderID);
        
        double orderTotal = customerOrder.getOrderTotal();
        request.setAttribute("orderTotal", orderTotal);
        
        double grandTotal = customerOrder.getOrderGrandTotal();
        request.setAttribute("grandTotal", grandTotal);
        
        double tax = customerOrder.getTax();
        request.setAttribute("tax", tax);
        
        String street = customerOrder.getStreet();
        request.setAttribute("street", street);
        
        String city = customerOrder.getCity();
        request.setAttribute("city", city);
        
        String state = customerOrder.getState();
        request.setAttribute("state", state);
        
        String creditCardNumber = customerOrder.getCreditCardNumber();
        request.setAttribute("creditCardNumber",creditCardNumber);
        
        String zip = customerOrder.getZip();
        request.setAttribute("zip", zip);
        
        RequestDispatcher view =
            request.getRequestDispatcher(CUSTOMER_RECEIPT_PAGE);
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
