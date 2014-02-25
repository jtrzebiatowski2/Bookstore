package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BookOrderService;
import model.Customer;

/**
 *
 * @author J-Tron
 */
@WebServlet(name = "addCustomerController", urlPatterns = {"/addCustomer"})
public class AddCustomerController extends HttpServlet {
    private static final String NEW_CUSTOMER_WELCOME_PAGE = "customerWelcomePage.jsp";

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
        
        Customer newCustomer = new Customer();
        
        BookOrderService orderService = new BookOrderService();
        
        String firstName = request.getParameter("firstName");
        newCustomer.setFirstName(firstName);
        
        String lastName = request.getParameter("lastName");
        newCustomer.setLastName(lastName);
        
        String email = request.getParameter("email");
        newCustomer.setEmail(email);
        
        String phone = request.getParameter("phone");
        newCustomer.setPhone(phone);
        
        String street = request.getParameter("street");
        newCustomer.setStreet(street);
        
        String city = request.getParameter("city");
        newCustomer.setCity(city);
        
        String state = request.getParameter("state");
        newCustomer.setState(state);
        
        String zip = request.getParameter("zip");
        newCustomer.setZip(zip);
        
        String creditCardNumber = request.getParameter("creditCardNumber");
        newCustomer.setCreditCardNumber(creditCardNumber);
        
        orderService.addCustomer(newCustomer);
        
          RequestDispatcher view =
            request.getRequestDispatcher(NEW_CUSTOMER_WELCOME_PAGE);
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
