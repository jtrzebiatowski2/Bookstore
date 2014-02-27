package model;

import java.util.Date;

/**
 *An example of an 'Entity' class. An entity class is a representation of
 * a database table, where the class name is similar to the table name and 
 * the class properties are similar to the table columns (fields). You would
 * use this to provide structured data to/from database operation code.
 * 
 * @author J-Tron
 * @version 1.0
 */
public class Order {
    private int order_id;
    private int customer_id;
    private String orderDate;
    private double total;
    private double tax;
    private double grandTotal;

    public Order() {
    }

    public Order(int order_id, int customer_id, String orderDate, double total, double tax, double grandTotal) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.orderDate = orderDate;
        this.total = total;
        this.tax = tax;
        this.grandTotal = grandTotal;
    }
    
    public double calculateWITax(double total){
        return total * .056;
    }
    
    public double calculateGrandTotal(double total, double tax){
        return total + tax;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public int getOrder_id() {
        return order_id;
    }

    public double getTax() {
        return tax;
    }

    public double getTotal() {
        return total;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}


