<%-- 
    Document   : customerInfoPage
    Created on : Feb 23, 2014, 7:17:48 PM
    Author     : J-Tron
--%>

<%@page import="java.util.List"%>
<%@page import="model.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.BookOrderService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
        <script src="http://jquery.bassistance.de/validate/jquery.validate.js"></script>
        <script src="http://jquery.bassistance.de/validate/additional-methods.js"></script>
        <script src="jquery.js" type='text/javascript'></script>
        <link rel='stylesheet' type='text/css' href='bookstoreHome.css'>
        <link rel="icon" type="image/png" href="Images/book-favicon.png">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">          
        <script type="text/javascript">
            $().ready(function() {
                $("#addCustomer").validate();
            };
        </script>
        <title>Customer Information</title>
        
    </head>
        <body style="background-image: url(Images/bookstoreBackground.jpg)">
        <div class='center'><img src='Images/bookstoreBanner.png' alt='titleBanner'></div>
        <div class="infoDivs" style="text-align: center; width: 700px; height: 500px; background-color: #ffff66; padding-top:25px;">
            <form id="addCustomer" name="addCustomer" method="POST" action="addCustomer" class="rockwell">
                <fieldset style="text-align:left; border-style:groove; border-width: 8px; border-color: green; width:500px; margin:auto;">
                    <legend><span class="rockwell"><h2>Enter your Information Below</h2></span></legend>
                <div style="text-align: left;">
                First Name: <input id="firstName" type="text" name="firstName" autofocus placeholder="John" title="Your name is required." required size="25"><br>
                Last Name: <input id="lastName" type="text" name="lastName" placeholder="Doe" title="Your Last name is required" required size="25"><br>
                Email Address: <input id="email" type="text" name="email" placeholder="JohnLovesJava@java.net"  title="An email address is required" required size="45"><br>
                Phone Number: <input id="phone" type="text" name="phone" placeholder="262-256-1458" title="A phone number is required" required  size="20"><br>
                Street: <input id="street" type="text" name="street" placeholder="3456 W Main St." title="Street Address is required" required size="50" ><br>
                City: <input id="city" type="text" name="city" placeholder="New Berlin" title="City is required" required size="25" ><br>
                
                State:<select name="state" id="state" required>
                    <option value="AL">AL</option>
                    <option value="AK">AK</option>
                    <option value="AZ">AZ</option>
                    <option value="AR">AR</option>
                    <option value="CA">CA</option>
                    <option value="CO">CO</option>
                    <option value="CT">CT</option>
                    <option value="DE">DE</option>
                    <option value="DC">DC</option>
                    <option value="FL">FL</option>
                    <option value="GA">GA</option>
                    <option value="HI">HI</option>
                    <option value="ID">ID</option>
                    <option value="IL">IL</option>
                    <option value="IN">IN</option>
                    <option value="IA">IA</option>
                    <option value="KS">KS</option>
                    <option value="KY">KY</option>
                    <option value="LA">LA</option>
                    <option value="ME">ME</option>
                    <option value="MD">MD</option>
                    <option value="MA">MA</option>
                    <option value="MI">MI</option>
                    <option value="MN">MN</option>
                    <option value="MS">MS</option>
                    <option value="MO">MO</option>
                    <option value="MT">MT</option>
                    <option value="NE">NE</option>
                    <option value="NV">NV</option>
                    <option value="NH">NH</option>
                    <option value="NJ">NJ</option>
                    <option value="NM">NM</option>
                    <option value="NY">NY</option>
                    <option value="NC">NC</option>
                    <option value="ND">ND</option>
                    <option value="OH">OH</option>
                    <option value="OK">OK</option>
                    <option value="OR">OR</option>
                    <option value="PA">PA</option>
                    <option value="RI">RI</option>
                    <option value="SC">SC</option>
                    <option value="SD">SD</option>
                    <option value="TN">TN</option>
                    <option value="TX">TX</option>
                    <option value="UT">UT</option>
                    <option value="VT">VT</option>
                    <option value="VA">VA</option>
                    <option value="WA">WA</option>
                    <option value="WV">WV</option>
                    <option value="WI" selected>WI</option>
                    <option value="WY">WY</option>
                </select><br>
                
                Zip: <input id="zip" type="text" name="zip" placeholder="53188" size="10" title="Zip is required" required digits><br>
                Credit Card Number: <input id="creditCardNumber" type="text" name="creditCardNumber" placeholder="1256-6521-4785-9568" size="20" title="Credit Card is Required for Billing" required digits><br>
                </div>
                </fieldset><br>
                <input class="button" id="submit" name="submit" type="submit" value="Submit">
            </form>
        </div>
    </body>
</html>
