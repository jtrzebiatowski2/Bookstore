package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author J-Tron
 */
public interface OrderDAOStrategy {
    public abstract List<Order> getOrders();
    public abstract void addOrder(Order order);
    public abstract List<CustomerOrderDTO> getOrderByCustomerID(int customerID);
    public abstract void updateOrder(Order order);
    public abstract List<Order> getOrdersByDateRange(String date1, String date2);
    
}
