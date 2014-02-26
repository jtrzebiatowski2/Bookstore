<%-- 
    Document   : adminToolsPage
    Created on : Feb 25, 2014, 5:12:51 PM
    Author     : J-Tron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Tools</title>
        <link rel='stylesheet' type='text/css' href='bookstoreHome.css'>
        <link rel="icon" type="image/png" href="Images/book-favicon.png">
    </head>
    <body style="background-image: url(Images/bookstoreBackground.jpg)">
        <div class='center'><img src='Images/bookstoreBanner.png' alt='titleBanner'></div>
        <div class="infoDivs" style="text-align: center; width: 500px; height: 500px; background-color: #ffff66; padding-top:25px;">
            <form id="addBook" name="addBook" method="POST" action="adminAddBook">
                <fieldset style="text-align:left">
                    <legend><span class="rockwell"><h2>Enter New Book Information</h2></span></legend>
                <div style="text-align:left">
                    Book Title: <input type="text" name="bookTitle" autofocus placeholder="Enter book title" size="30"><br>
                    Price: <input type="text" name="bookPrice" placeholder="Enter book price" size="12"><br>
                    Description: <textarea name="bookDescription" placeholder="Enter synopsis" cols="50" rows="3" >
                    </textarea><br>
                    Author: <input type="text" name="bookAuthor" placeholder="Enter author [last, first]" size="50"><br>
                    Image URL: <input type="text" name="bookImageURL" placeholder="Enter image path" size="40"><br>
                </div>
                </fieldset>
                <br>
                <input class="button" id="submit" name="submit" type="submit" value="Add Book">
            </form>
        
        
        </div>    
</html>
