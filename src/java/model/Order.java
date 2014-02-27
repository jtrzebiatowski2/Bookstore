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

    /**
     *
     */
    public Order() {
    }

    /**
     *
     * @param order_id
     * @param customer_id
     * @param orderDate
     * @param total
     * @param tax
     * @param grandTotal
     */
    public Order(int order_id, int customer_id, String orderDate, double total, double tax, double grandTotal) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.orderDate = orderDate;
        this.total = total;
        this.tax = tax;
        this.grandTotal = grandTotal;
    }
    
    /**
     *
     * @param total
     * @return
     */
    public double calculateWITax(double total){
        return total * .056;
    }
    
    /**
     *
     * @param total
     * @param tax
     * @return
     */
    public double calculateGrandTotal(double total, double tax){
        return total + tax;
    }

    /**
     *
     * @return
     */
    public int getCustomer_id() {
        return customer_id;
    }

    /**
     *
     * @return
     */
    public double getGrandTotal() {
        return grandTotal;
    }

    /**
     *
     * @return
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     *
     * @return
     */
    public int getOrder_id() {
        return order_id;
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
    public double getTotal() {
        return total;
    }

    /**
     *
     * @param customer_id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    /**
     *
     * @param grandTotal
     */
    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    /**
     *
     * @param orderDate
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    /**
     *
     * @param order_id
     */
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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
     * @param total
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
    
}


