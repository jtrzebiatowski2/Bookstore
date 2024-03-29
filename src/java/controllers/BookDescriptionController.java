package controllers;

import java.io.IOException;
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
 * @version 1.0
 */
@WebServlet(name = "BookDescriptionController", urlPatterns = {"/description"})
public class BookDescriptionController extends HttpServlet {
private static final String BOOK_DESCRIPTION_PAGE = "/bookDescriptionPage.jsp";
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * This method get the list of books from the database, sets request attributes of the book's properties for use
     * in the jsp display page to be used accordingly there.
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
        
        BookOrderService bookOrderService = new BookOrderService();
        
        List<Book> books = bookOrderService.getBooks();
        
        request.setAttribute("book_list", books);
        
        int bookID = Integer.parseInt(request.getParameter("bookList")) - 2;
        
        String bookTitle = books.get(bookID).getTitle();
        
        request.setAttribute("bookTitle", bookTitle);
        
        String bookAuthor = books.get(bookID).getAuthor();
        
        request.setAttribute("bookAuthor", bookAuthor);
        
        String bookDescription = books.get(bookID).getDescription();
        
        request.setAttribute("bookDescription", bookDescription);
        
        double bookPrice = (Double)books.get(bookID).getPrice();
        
        request.setAttribute("bookPrice", bookPrice);
        
        String imageURL = books.get(bookID).getImage_url();
        
        request.setAttribute("imageURL", imageURL);
        
        int selectedBook = bookID;
        
        String selectedBookTitle = books.get(selectedBook).getTitle();
        
        request.setAttribute("selectedBook", selectedBook);
        
        request.setAttribute("selectedBookTitle", selectedBookTitle);
        
        RequestDispatcher view =
                request.getRequestDispatcher(BOOK_DESCRIPTION_PAGE);
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
