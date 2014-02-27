package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import model.BookOrderService;
import model.Customer;
import model.Order;

/**
 *
 * @author J-Tron
 * @version 1.0
 */
@WebServlet(name = "addCustomerController", urlPatterns = {"/addCustomer"})
public class AddNewCustomerController extends HttpServlet {
    private static final String NEW_CUSTOMER_WELCOME_PAGE = "customerWelcomePage.jsp";
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
     * This method retrieves values from the text fields in the customer form. Adds the new customer to the database,
     * and then finds the newly added customer and sets the current session variables to this customer's information.
     * An initial order is created to store order details should they be added, the order is destroyed if an order is canceled.
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
        httpSession = request.getSession(true);
        
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
        
        List<Customer> customers = orderService.getCustomers();
        Customer thisCustomer = customers.get((customers.size() - 1));
        int custID = thisCustomer.getCustomer_id();
        httpSession.setAttribute("session_customer_id", custID);
        String custFirstName = thisCustomer.getFirstName();
        httpSession.setAttribute("session_customer_first_name", custFirstName);
        String custLastName = thisCustomer.getLastName();
        httpSession.setAttribute("session_customer_last_name", custLastName);
        String custEmail = thisCustomer.getEmail();
        httpSession.setAttribute("session_customer_email", custEmail);
        String custPhone = thisCustomer.getPhone();
        httpSession.setAttribute("session_customer_phone", custPhone);
        String custStreet = thisCustomer.getStreet();
        httpSession.setAttribute("session_customer_street", custStreet);
        String custCity = thisCustomer.getCity();
        httpSession.setAttribute("session_customer_city", custCity);
        String custState = thisCustomer.getState();
        httpSession.setAttribute("session_customer_state", custState);
        String custZip = thisCustomer.getZip();
        httpSession.setAttribute("session_customer_zip", custZip);
        String custCreditCardNumber = thisCustomer.getCreditCardNumber();
        httpSession.setAttribute("session_customer_credit_card_number", custCreditCardNumber);
         
        Order initialOrder = new Order();
        initialOrder.setCustomer_id(custID);
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateNow = formatter.format(date);
        initialOrder.setOrderDate(dateNow);
        initialOrder.setTotal(0.0);
        initialOrder.setGrandTotal(0.0);
        initialOrder.setTax(0.0);
        
        orderService.addOrder(initialOrder);
        
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