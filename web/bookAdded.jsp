<%-- 
    Document   : bookAdded
    Created on : Feb 25, 2014, 5:44:09 PM
    Author     : J-Tron
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Added Successfully</title>
         <link rel='stylesheet' type='text/css' href='bookstoreHome.css'>
         <link rel="icon" type="image/png" href="Images/book-favicon.png">
    </head>
        <body style="background-image: url(Images/bookstoreBackground.jpg)">
        <div class='center'>
            <img src='Images/bookstoreBanner.png' alt='titleBanner'>
        </div>
        <div class="infoDivs" style="text-align: center; width: 500px; height: 500px; background-color: #ffff66; padding-top:25px;">
            <h1>Book has been added!</h1><br>
            <img src='Images/checkmark.png' alt='checkmark'>
            <br>
            <form method='POST' action="admin">
                    <input class="button" type="submit" value="Add Another Book">
            </form><br>
            <a href="index.html"><button class="button">Home Page</button></a>
    </body>
</html>
