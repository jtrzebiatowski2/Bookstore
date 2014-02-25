<%-- 
    Document   : itemAdded
    Created on : Feb 23, 2014, 11:50:36 PM
    Author     : J-Tron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Updated</title>
         <link rel='stylesheet' type='text/css' href='bookstoreHome.css'>
    </head>
    <body style="background-image: url(Images/bookstoreBackground.jpg)">
        <div class='center'><img src='Images/bookstoreBanner.png' alt='titleBanner'></div>
        <div class="infoDivs" style="text-align: center; width: 500px; height: 500px; background-color: #ffff66; padding-top:25px;">
            <h2>Item(s) were successfully added to your order</h2>
            <a href="index.html"><button class="button">Home Page</button></a><br>
            <form method="POST" action="order">
               <input class="button" id="backToBooks" name="backToBooks" type="submit" value="Back to Books">
            </form>
        </div>
</html>
