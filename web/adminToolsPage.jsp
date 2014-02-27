<%-- 
    Document   : adminToolsPage
    Created on : Feb 25, 2014, 5:12:51 PM
    Author     : J-Tron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
        <script src="http://jquery.bassistance.de/validate/jquery.validate.js"></script>
        <script src="http://jquery.bassistance.de/validate/additional-methods.js"></script>
        <script src="jquery.js" type='text/javascript'></script>
        <script src="validate.js" type='text/javascript'></script>
        <script>
            $().ready(function() {
                $("#addCustomer").validate();
            };
        </script>
        <link rel='stylesheet' type='text/css' href='bookstoreHome.css'>
        <link rel="icon" type="image/png" href="Images/book-favicon.png">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Tools</title>
    </head>
    <body style="background-image: url(Images/bookstoreBackground.jpg)">
        <div class='center'><img src='Images/bookstoreBanner.png' alt='titleBanner'></div>
        <div class="infoDivs" style="text-align: center; width: 700px; height: 550px; background-color: #ffff66; padding-top:25px;">
            <form id="addBook" name="addBook" method="POST" action="adminAddBook">
                <fieldset style="text-align:left; border-style:groove; border-width: 8px; border-color: green; width:500px; margin:auto;">
                    <legend><span class="rockwell"><h2>Enter New Book Information</h2></span></legend>
                <div style="text-align:left">
                    Book Title: <input type="text" name="bookTitle" autofocus placeholder="The Great Gatsby" title="Book Title Required" required size="30"><br>
                    Price: <input type="text" name="bookPrice" placeholder="16.99" title="Price is Required" required size="12"><br>
                    Description: <textarea name="bookDescription" placeholder="This enchanting tale of a young rich man ends in catastrophic drama. Full of wild parties, booze, and a lavish lifestlye." title="Description Required" required cols="50" rows="3" >
                    </textarea><br>
                    Author: <input type="text" name="bookAuthor" placeholder="Fitzgerald, Scott [Last, First] format" size="50"><br>
                    Image URL: <input type="text" name="bookImageURL" placeholder="theGreatGatsby.jpg" title="Image Path Required" required size="40"><br>
                </div><br>
                    <div style="text-align: center">
                     <input class="button" id="submit" name="submit" type="submit" value="Add Book">
                    </div>
                </fieldset>
                <br>
            </form><br>
            <form id="ordersByDate" name="ordersByDate" method="POST" action="getOrders">
                <fieldset style="text-align:left; border-style:groove; border-width: 8px; border-color: green; width:500px; margin:auto;">
                     <legend style="text-align:left;"><span class="rockwell"><h2>Enter Date Range to get Orders</h2></span></legend>
                     <div style="text-align:left">
                         Start Date: <input type="date" id="startDate" name="startDate" placeholder="Enter Begin Date">
                         End Date: <input type="date" id="endDate" name="endDate" placeholder="Enter End Date">
                     </div><br>
                     <div style="text-align:center;">
                     <input class="button" id="getOrders" name="getOrders" type="submit" value="Get Orders">
                     </div>
            </form>      
        </div>    
</html>
