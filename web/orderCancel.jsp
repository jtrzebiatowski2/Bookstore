<%-- 
    Document   : orderCancel
    Created on : Feb 26, 2014, 9:03:27 PM
    Author     : J-Tron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Cancelled</title>
         <link rel='stylesheet' type='text/css' href='bookstoreHome.css'>
         <link rel="icon" type="image/png" href="Images/book-favicon.png">
    </head>
        <body style="background-image: url(Images/bookstoreBackground.jpg)">
        <div class='center'>
            <img src='Images/bookstoreBanner.png' alt='titleBanner'>
        </div>
        <div class="infoDivs" style="text-align: center; width: 500px; height: 600px; background-color: #ffff66; padding-top:25px;">
            <h1>Order has been cancelled!</h1><br>
            <img src='Images/cancelled.png' alt='cancel'>
            <br>
            <form method='POST' action="order">
                    <input class="button" type="submit" value="Book List">
            </form><br>
            <a href="index.html"><button class="button">Home Page</button></a>
    </body>
    
</html>
