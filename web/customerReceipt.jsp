<%-- 
    Document   : customerReceipt
    Created on : Feb 26, 2014, 9:49:33 AM
    Author     : J-Tron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Receipt</title>
         <link rel='stylesheet' type='text/css' href='bookstoreHome.css'>
         <link rel="icon" type="image/png" href="Images/book-favicon.png">
    </head>
    <body style="background-image: url(Images/bookstoreBackground.jpg)">
        <div class='center'>
            <img src='Images/bookstoreBanner.png' alt='titleBanner'>
        </div>
        <div class="infoDivs" style="text-align: center; width: 500px; height: 500px; background-color: #ffff66; padding-top:25px;">
            <fieldset><legend>Order Receipt</legend>
                <span style="text-align:left;"><span style="font-weight:bold;">Order ID:</span>${orderID}</span><br>
                <span style="text-align:left;"><span style="font-weight:bold;">Order Date:</span>${orderDate}<span><br>
                        <span><span style="font-weight:bold;">Customer:</span> ${customerFirst} , ${customerLast}</span><br>
                        <span><span style="font-weight:bold;">Order Total:</span> $${orderTotal}</span><br>
                        <span><span style="font-weight:bold;">Tax:</span> $${tax}</span><br>
                            <span><span style="font-weight:bold;">Grand Total:</span> $${grandTotal}</span><br>
                            <fieldset><legend>Shipping Order To</legend>
                                <span style="font-weight:bold;">${customerFirst} ${customerLast}</span><br>
                                <span style="font-weight:bold;">${street}</span><br>
                                <span style="font-weight:bold;">${city}, ${state} ${zip}</span><br>
                            </fieldset>
                                <h2 style="text-align:center;">Your Credit Card # ${creditCardNumber} will be charged <span style="color:red;">$${grandTotal}</span></h2>
                                </fieldset><br>
            <a href="index.html"><button class="button">Home Page</button></a>
        </div>
        </html>
