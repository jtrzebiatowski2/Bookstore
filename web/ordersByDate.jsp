<%-- 
    Document   : ordersByDate
    Created on : Feb 26, 2014, 11:38:30 AM
    Author     : J-Tron
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Order"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Orders Within Specified Date Range</title>
    </head>
    <body>
        <link rel='stylesheet' type='text/css' href='bookstoreHome.css'>
        <link rel="icon" type="image/png" href="Images/book-favicon.png">
        <body style="background-image: url(Images/bookstoreBackground.jpg)">
        <div class='center'>
            <img src='Images/bookstoreBanner.png' alt='titleBanner'>
        </div>
        <div class="infoDivs" style="text-align: center; width: 800px; height: auto; background-color: #ffff66; padding-top:25px;">
            <fieldset><legend>Orders</legend>
         <table style="border-style: groove; border-color:sandybrown; border-width:3px; margin:auto;">
                <tr>
                    <td style="background-color: #996633; color: #ffff66; padding:3px; margin:auto;">Order ID:</td>
                    <td style="background-color: #996633; color: #ffff66; padding:3px; margin:auto;">Customer ID:</td>
                    <td style="background-color: #996633; color: #ffff66; padding:3px; margin:auto;">Order Date:</td>
                    <td style="background-color: #996633; color: #ffff66; padding:3px; margin:auto;">Order Total:</td>
                    <td style="background-color: #996633; color: #ffff66; padding:3px; margin:auto;">Order Tax:</td>
                    <td style="background-color: #996633; color: #ffff66; padding:3px; margin:auto;">Grand Total:</td>
                </tr>
                
        <%
            List<Order> orderList = (List<Order>)request.getAttribute("orderList");
            DecimalFormat df = new DecimalFormat("0.00");
            double totalCollectedForDateRange = 0;
            for(Order o : orderList){
             int customerID = o.getCustomer_id();
             int orderID = o.getOrder_id();
             double orderTotal = o.getTotal();
             double tax = o.getTax();
             double grandTotal = o.getGrandTotal();
             totalCollectedForDateRange+= grandTotal;
             String orderDate = o.getOrderDate();
             out.print("<tr style='border-style: groove; border-color:#996633; border-width: 2px;'>");
             out.print("<td style='background-color:white; color:black; border-style: groove; border-color:#996633; border-width: 2px; '>" + orderID + "</td>");
             out.print("<td style='background-color: white; color:black; border-style: groove; border-color:#996633; border-width: 2px;'>" + customerID + "</td>");
             out.print("<td style='background-color: white; color:black; border-style: groove; border-color:#996633; border-width: 2px;'>" + orderDate + "</td>");
             out.print("<td style='background-color:white; color:black; border-style: groove; border-color:#996633; border-width: 2px; '>" + "$" + orderTotal + "</td>");
             out.print("<td style='background-color: white; color:black; border-style: groove; border-color:#996633; border-width: 2px;'>" + "$" + tax  + "</td>");
             out.print("<td style='background-color: white; color:black; border-style: groove; border-color:#996633; border-width: 2px;'>" + "$" + grandTotal + "</td>");
             out.print("</tr>");
            };
            out.print("<tr style= 'text-align: right;'>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td style= 'margin-left:0; text-align: right; font-weight:bolder; font-size: 20px;'>" 
                        + "Total for Date Range: " + "<span style='border: 3px solid red; color:#FF0000; font-size: 26px;'> $" + df.format(totalCollectedForDateRange) + "</span>" + "</td>" + "</tr>");
            
            %>
         </fieldset>
        </table><br>
        <a href="index.html"><button class="button">Home Page</button></a>
        <br><br>
         <form method='POST' action="admin">
             <input class="button" type="submit" value="Admin Tools">
         </form>
            
    </body>
</html>
