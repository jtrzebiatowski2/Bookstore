<%-- 
    Document   : bookOrderPage
    Created on : Feb 21, 2014, 10:59:08 PM
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
        <div class="infoDivs" style="background-color: #ffff66; height: 350px; width:600px; text-align: center;">
            
            <form method="POST" action="description" class='center'>
                <h2 class='rockwell'>Book List</h2>
                
                <select name='bookList'>
                     <%
                    ArrayList<Book> books = (ArrayList<Book>)request.getAttribute("book_list");
                    for(Book book : books){
                        out.print("<option value='" + book.getBook_id() + "'>" + book.getTitle() + "</option>");
                    }
                    
                    %>
                </select>
                <br><br>
                <input class="button" id="descriptionSubmit" name="descriptionSubmit" type="submit" value="Get Description">
                
            </form>      
                <br>
                <a href="index.html"><button class="button">Home Page</button></a>
        </div>
        <h1></h1>
    </body>
</html>
