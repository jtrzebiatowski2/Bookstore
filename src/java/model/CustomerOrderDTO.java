package model;

import java.util.Date;

/**
 *
 * @author J-Tron
 * @version 1.0
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

    /**
     *
     */
    public CustomerOrderDTO() {
    }

    /**
     *
     * @param lastName
     * @param firstName
     * @param customerID
     * @param orderID
     * @param orderTotal
     * @param orderGrandTotal
     * @param tax
     * @param date
     * @param street
     * @param city
     * @param state
     * @param zip
     * @param creditCardNumber
     */
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

    /**
     *
     * @param customerID
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @param orderGrandTotal
     */
    public void setOrderGrandTotal(double orderGrandTotal) {
        this.orderGrandTotal = orderGrandTotal;
    }

    /**
     *
     * @param orderID
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    /**
     *
     * @param orderTotal
     */
    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @return
     */
    public double getOrderGrandTotal() {
        return orderGrandTotal;
    }

    /**
     *
     * @return
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     *
     * @return
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     *
     * @return
     */
    public double getOrderTotal() {
        return orderTotal;
    }

    /**
     *
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @return
     */
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     *
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @return
     */
    public String getStreet() {
        return street;
    }

    /**
     *
     * @return
     */
    public double getTax() {
        return tax;
    }

    /**
     *
     * @return
     */
    public String getZip() {
        return zip;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @param creditCardNumber
     */
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    /**
     *
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *
     * @param street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     *
     * @param tax
     */
    public void setTax(double tax) {
        this.tax = tax;
    }

    /**
     *
     * @param zip
     */
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
