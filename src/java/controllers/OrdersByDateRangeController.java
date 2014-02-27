package controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BookOrderService;
import model.Order;

/**
 *
 * @author J-Tron
 * @version 1.0
 */
@WebServlet(name = "OrdersByDateRangeController", urlPatterns = {"/getOrders"})
public class OrdersByDateRangeController extends HttpServlet {
    private static final String ORDERS_BY_DATE_PAGE = "ordersByDate.jsp";
   

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

        BookOrderService bos = new BookOrderService();
         
        String date1 = request.getParameter("startDate");
        String date2 = request.getParameter("endDate");
         
        List<Order> ordersList = bos.getOrdersByDateRange(date1, date2);
         
        request.setAttribute("orderList", ordersList);
         
        RequestDispatcher view =
        request.getRequestDispatcher(ORDERS_BY_DATE_PAGE);
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