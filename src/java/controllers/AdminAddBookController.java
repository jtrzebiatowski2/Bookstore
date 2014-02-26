package controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AdminAddBookController", urlPatterns = {"/adminAddBook"})
public class AdminAddBookController extends HttpServlet {
private static final String ADDED_BOOK_PAGE = "bookAdded.jsp";

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
        
        Book addedBook = new Book();
        
        BookOrderService bos= new BookOrderService();
        
        String bookTitle = request.getParameter("bookTitle");
        addedBook.setTitle(bookTitle);
        
        double bookPrice = (Double.valueOf(request.getParameter("bookPrice")));
        addedBook.setPrice(bookPrice);
        
        String bookDescription = request.getParameter("bookDescription");
        addedBook.setDescription(bookDescription);
    
        String bookAuthor = request.getParameter("bookAuthor");
        addedBook.setAuthor(bookAuthor);
    
        String bookImageURL = request.getParameter("bookImageURL");
        addedBook.setImage_url(bookImageURL);
        
        bos.addBook(addedBook);
        
        RequestDispatcher view =
        request.getRequestDispatcher(ADDED_BOOK_PAGE);
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
