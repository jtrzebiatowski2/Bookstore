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
import model.Book;
import model.BookOrderService;
import model.CustomerOrderDTO;
import model.Order;

/**
 *
 * @author J-Tron
 * @version 1.0
 */
@WebServlet(name = "BookOrderServlet", urlPatterns = {"/order"})
public class BookListController extends HttpServlet {
private static final String BOOK_ORDER_PAGE = "/bookOrderPage.jsp";

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * This method simply retrieves the book list from the database and forwards it to the jsp where
     * the books are displayed in a drop down list for user selection.
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
        
        BookOrderService bookService = new BookOrderService();
        
        List<Book> book_list = bookService.getBooks();
        
        request.setAttribute("book_list", book_list);
        
         RequestDispatcher view =
                request.getRequestDispatcher(BOOK_ORDER_PAGE);
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
