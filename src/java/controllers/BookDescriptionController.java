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
import model.Book;
import model.BookOrderService;

/**
 *
 * @author J-Tron
 */
@WebServlet(name = "BookDescriptionController", urlPatterns = {"/description"})
public class BookDescriptionController extends HttpServlet {
private static final String BOOK_ORDER_PAGE = "/bookOrderPage.jsp";
   

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
        
        BookOrderService bookOrderService = new BookOrderService();
        
        List<Book> books = bookOrderService.getBooks();
        
        int bookID = Integer.parseInt(request.getParameter("bookList"));
        
        String bookTitle = books.get(bookID).getTitle();
        
        request.setAttribute("bookTitle", bookTitle);
        
        String bookAuthor = books.get(bookID).getAuthor();
        
        request.setAttribute("bookAuthor", bookAuthor);
        
        String bookDescription = books.get(bookID).getDescription();
        
        request.setAttribute("bookDescription", bookDescription);
        
        double bookPrice = (Double)books.get(bookID).getPrice();
        
        request.setAttribute("bookPrice", bookPrice);
        
        int selectedBook = bookID;
        
        String selectedBookTitle = books.get(selectedBook).getTitle();
        
        request.setAttribute("selectedBook", selectedBook);
        
        request.setAttribute("selectedBookTitle", selectedBookTitle);
        
        
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
