<%-- 
    Document   : customerInfoPage
    Created on : Feb 23, 2014, 7:17:48 PM
    Author     : J-Tron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Information</title>
        <link rel='stylesheet' type='text/css' href='bookstoreHome.css'>
    </head>
        <body style="background-image: url(Images/bookstoreBackground.jpg)">
        <div class='center'><img src='Images/bookstoreBanner.png' alt='titleBanner'></div>
        <div class="infoDivs" style="text-align: center; width: 500px; height: 500px; background-color: #ffff66; padding-top:25px;">
            <form id="addCustomer" name="addCustomer" method="POST" action="addCustomer" class="rockwell">
                <fieldset>
                    <legend><span class="rockwell">Enter your Information Below</span></legend>
                <div style="text-align: center;">
                First Name: <input id="firstName" type="text" name="firstName" autofocus placeholder="Enter First Name" class="required"><br>
                Last Name: <input id="lastName" type="text" name="lastName" placeholder="Enter Last Name" class="required"><br>
                Email Address: <input id="email" type="text" name="email" placeholder="Enter E-Mail" class="email"><br>
                Phone Number: <input id="phone" type="text" name="phone" placeholder="Enter Phone Number" class="required digits"><br>
                Street: <input id="street" type="text" name="street" placeholder="Enter Street" class="required"><br>
                City: <input id="city" type="text" name="city" placeholder="Enter City" class="required"><br>
                
                State:<select name="state" id="state" class="required">
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
                    <option value="WI">WI</option>
                    <option value="WY">WY</option>
                </select><br>
                
                Zip: <input id="zip" type="text" name="zip" placeholder="Enter Zip" class="required digits"><br>
                Credit Card Number: <input id="creditCardNumber" type="text" name="creditCardNumber" placeholder="Enter Credit Card Number" class="creditcard"><br>
                </div>
                </fieldset>
                <input class="button" id="submit" name="submit" type="submit" value="Submit">
            </form>
        
        </div>
    </body>
</html>
