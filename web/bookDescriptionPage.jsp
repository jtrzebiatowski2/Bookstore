<%-- 
    Document   : bookDescriptionPage
    Created on : Feb 23, 2014, 6:00:32 PM
    Author     : J-Tron
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Book"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Books</title>
         <link rel='stylesheet' type='text/css' href='bookstoreHome.css'>
         <link rel="icon" type="image/png" href="Images/book-favicon.png">
         <script type="text/javascript">
         </script>
    </head>
    <body style="background-image: url(Images/bookstoreBackground.jpg)">
        <div class='center'><img src='Images/bookstoreBanner.png' alt='titleBanner'></div>
        <div class="infoDivs" style="text-align: center; width: 700px; height: 1000px; background-color: #ffff66; padding-top:25px;">

                <select name='selectItem'>
                        ${"<option value='"}${selectedBook}${"'>"}${selectedBookTitle}${"</option>"}                   
                </select>              
                <fieldset style= "border-style:groove; border-width: 8px; border-color: green; width:600px; margin:auto;">
                    <legend style="text-align:left"><h3>Book Details</h3></legend>
                 <p>
                    <strong>Book Title:</strong><br>${bookTitle}<br><strong>Author:</strong><br>${bookAuthor} <br> <strong>Synopsis:</strong><br>${bookDescription}<br>
                    <strong>Price:</strong><br>$${bookPrice}<br>
                     <img src="Images/${imageURL}" style="border-style: groove; border-color:saddlebrown; border-width: 6px;">
                 </p>
                </fieldset>
                 <form id="addBook" name="addBook" method="POST" action="addBook">
                     <fieldset  style="border-style:groove; border-width: 8px; border-color: green; width:600px; margin:auto;">
                         <legend style="text-align:left;"><h3>Add Book(s) to Cart</h3></legend>
                     <span style="font-size:large; font-weight: bold;">Quantity to add:<input id="bookQuantity" name="bookQuantity" type="text" value="1" placeholder="QTY" size="1"></span><br>
                     <input class="button" id="addBook" name="addBook" type="submit" value="Add to Cart">
                     </fieldset>
                 </form>
                 <br>
                  <form method="POST" action="order">
                      <fieldset style="border-style:groove; border-width: 8px; border-color: green; width:600px; margin:auto;">
                          <legend style="text-align:left"><h3>View more Books</h3></legend>
                     <input class="button" id="backToBooks" name="backToBooks" type="submit" value="Book List">
                      </fieldset>
                 </form>
        </div>
                        <%
                         int bookID = (Integer)(request.getAttribute("selectedBook"));
                         session.setAttribute("session_book_id", bookID);
                         %>
    </body>
</html>
