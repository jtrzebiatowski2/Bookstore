package model;

import java.util.Date;

/**
 *
 * @author J-Tron
 */
public class CustomerOrderDTO{
    private String lastName;
    private String firstName;
    private int customerID;
    private int orderID;
    private double orderTotal;
    private double orderGrandTotal;
    private double tax;
    private String date;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String creditCardNumber;

    public CustomerOrderDTO() {
    }

    public CustomerOrderDTO(String lastName, String firstName, int customerID, int orderID, double orderTotal, double orderGrandTotal, 
            double tax, String date, String street, String city, String state, String zip, String creditCardNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.customerID = customerID;
        this.orderID = orderID;
        this.orderTotal = orderTotal;
        this.orderGrandTotal = orderGrandTotal;
        this.tax = tax;
        this.date = date;
        this.street =street;
        this.city = city;
        this.state = state;
        this.zip=zip;
        this.creditCardNumber = creditCardNumber;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setOrderGrandTotal(double orderGrandTotal) {
        this.orderGrandTotal = orderGrandTotal;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getOrderGrandTotal() {
        return orderGrandTotal;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getOrderID() {
        return orderID;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getState() {
        return state;
    }

    public String getStreet() {
        return street;
    }

    public double getTax() {
        return tax;
    }

    public String getZip() {
        return zip;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerID + "Order Date: " + date + "\n First Name: " + firstName + "\n Last Name: " + lastName 
                + "\n Order ID: " + orderID + "\n Order Total: " + orderTotal + "\n Total With Tax: " + orderGrandTotal 
                + "\nAddress: " + street + "\n" + city + ", " + state + " " + zip + "\nCredit Card Number: " + creditCardNumber;
    }
    
    
}
