package model;

/**
 *
 * @author J-Tron
 */
public class CustomerOrderDTO implements CustomerOrderDTOStrategy {
    private String lastName;
    private String firstName;
    private int customerID;
    private int orderID;
    private double orderTotal;
    private double orderGrandTotal;

    public CustomerOrderDTO() {
    }

    public CustomerOrderDTO(String lastName, String firstName, int customerID, int orderID, double orderTotal, double orderGrandTotal) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.customerID = customerID;
        this.orderID = orderID;
        this.orderTotal = orderTotal;
        this.orderGrandTotal = orderGrandTotal;
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

    @Override
    public String toString() {
        return "Customer ID: " + customerID + "\n First Name: " + firstName + "\n Last Name: " + lastName 
                + "\n Order ID: " + orderID + "\n Order Total: " + orderTotal + "\n Total With Tax: " + orderGrandTotal;
    }
    
    
}
