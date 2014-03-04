<%-- 
    Document   : customerCheckout
    Created on : Feb 25, 2014, 7:20:49 PM
    Author     : J-Tron
--%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page import="model.BookOrderService"%>
<%@page import="model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.OrderDetail"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout</title>
         <link rel='stylesheet' type='text/css' href='bookstoreHome.css'>
         <link rel="icon" type="image/png" href="Images/book-favicon.png">
    </head>
        <body style="background-image: url(Images/bookstoreBackground.jpg)">
        <div class='center'>
            <img src='Images/bookstoreBanner.png' alt='titleBanner'>
        </div>
        <div class="infoDivs" style="text-align: center; width: 600px; height: 700px; background-color: #ffff66; padding-top:25px;">
            <fieldset><legend style="text-align:left;"><h3>Review Your Order</h3></legend>
            <h1>Order Details</h1>
            <table style="border-style: groove; border-color:sandybrown; border-width:3px; margin:auto;">
                <tr>
                    <td style="background-color: #996633; color: #ffff66; padding:3px; margin:auto;">Book Title:</td>
                    <td style="background-color: #996633; color: #ffff66; padding:3px; margin:auto;">Quantity Ordered:</td>
                    <td style="background-color: #996633; color: #ffff66; padding:3px; margin:auto;">Line Item Total:</td>
                </tr>
                <%
                BookOrderService bos = new BookOrderService();
                ArrayList<OrderDetail> orderDetails = (ArrayList<OrderDetail>)request.getAttribute("customerOrderDetails");
                DecimalFormat df = new DecimalFormat("0.00");
                double orderTotal = bos.getOrderTotal((Integer)session.getAttribute("session_order_id"));
                String taxes = df.format(orderTotal * .056);
                double taxesDouble = (Double.parseDouble(taxes));
                double grandTotal = orderTotal + taxesDouble;
                for(OrderDetail od: orderDetails){
                    int bookID = od.getBook_id();
                    Book book = bos.getBookByID(bookID);
                    String title = book.getTitle();
                    int quantity = od.getQuantity();
                    double lineTotal = od.getLineTotal();
                    out.print("<tr style='border-style: groove; border-color:#996633; border-width: 2px;'>");
                    out.print("<td style='background-color:white; color:black; border-style: groove; border-color:#996633; border-width: 2px; '>" + title + "</td>");
                    out.print("<td style='background-color: white; color:black; border-style: groove; border-color:#996633; border-width: 2px;'>" + quantity + "</td>");
                    out.print("<td style='background-color: white; color:black; border-style: groove; border-color:#996633; border-width: 2px;'>" + "$" + lineTotal + "</td>");
                    out.print("</tr>");
                }   
                out.print("<tr style= 'text-align: right; margin-left:0;'>" + "<td></td>" + "<td></td>" + "<td style= 'margin-left:0; text-align: right; font-weight:bolder; font-size: 14px;'>" 
                        + "OrderTotal: " + "<span style='color:#FF0000; font-size: 18px;'> $" + orderTotal + "</span>" + "</td>" + "</tr>");
                out.print("<tr style= 'text-align: right; margin-left:0;'>" + "<td></td>" + "<td></td>" + "<td style= 'margin-left:0; text-align: right; font-weight:bolder; font-size: 14px;'>" 
                        + "Applicable Taxes: " + "<span style='color:#FF0000; font-size: 18px;'> $" + taxes + "</span>" + "</td>" + "</tr>");
                out.print("<tr style= 'text-align: right; margin-left:0;'>" + "<td></td>" + "<td></td>" + "<td style= 'margin-left:0; text-align: right; font-weight:bolder; font-size: 20px;'>" 
                        + "Grand Total: " + "<span style='border: 3px solid red; color:#FF0000; font-size: 26px;'> $" + df.format(grandTotal) + "</span>" + "</td>" + "</tr>");
            %>
                
            </table>
            
            </h2>
            <br>
            <form method='POST' action="receipt">
                    <input class="button" type="submit" value="Checkout">
            </form> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            <form method='POST' action="cancel">
                    <input class="buttonCancel" type="submit" value="Cancel Order">
            </form><br>
            <form method="POST" action="order">
               <input class="button" id="backToBooks" name="backToBooks" type="submit" value="Add More Books">
            </form>
            </fieldset>
            <br>    
    </body>
</html>
