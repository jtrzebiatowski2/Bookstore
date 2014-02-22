package model;

import java.util.List;

/**
 *
 * @author J-Tron
 */
public interface OrderDAOStrategy {
    public abstract List<Order> getOrders();
    public abstract void addOrder(Order order);
    public abstract List<CustomerOrderDTO> getOrderByCustomerID(String customerID);
    
}
