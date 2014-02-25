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
    </head>
    <body style="background-image: url(Images/bookstoreBackground.jpg)">
        <div class='center'><img src='Images/bookstoreBanner.png' alt='titleBanner'></div>
        <div class="infoDivs" style="text-align: center; width: 500px; height: 800px; background-color: #ffff66; padding-top:25px;">

                <select name='selectItem'>
                        ${"<option value='"}${selectedBook}${"'>"}${selectedBookTitle}${"</option>"}                   
                </select>                    
                 <p>
                    <strong>Book Title:</strong><br>${bookTitle}<br><strong>Author:</strong><br>${bookAuthor} <br> <strong>Synopsis:</strong><br>${bookDescription}<br>
                    <strong>Price:</strong><br>$${bookPrice}<br>
                     <img src="Images/${imageURL}" style="border-style: groove; border-color:saddlebrown; border-width: 6px;">
                 </p>
                 <form method="POST" action="addBook">
                     Quantity to add:<input id="bookQuantity" name="bookQuantity" type="text" placeholder="QTY" size="1"><br>
                     <input class="button" id="addBook" name="addBook" type="submit" value="Add to Order">
                 </form>
                 <br>
                  <form method="POST" action="order">
                     <input class="button" id="backToBooks" name="backToBooks" type="submit" value="Back to Books">
                 </form>
        </div>
                        <%
                         int bookID = (Integer)(request.getAttribute("selectedBook"));
                         session.setAttribute("session_book_id", bookID);
                         %>
    </body>
</html>
