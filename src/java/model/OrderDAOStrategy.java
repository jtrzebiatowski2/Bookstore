package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author J-Tron
 * @version 1.0
 */
public interface OrderDAOStrategy {

    /**
     *
     * @return
     */
    public abstract List<Order> getOrders();

    /**
     *
     * @param order
     */
    public abstract void addOrder(Order order);

    /**
     *
     * @param customerID
     * @return
     */
    public abstract List<CustomerOrderDTO> getOrderByCustomerID(int customerID);

    /**
     *
     * @param order
     */
    public abstract void updateOrder(Order order);

    /**
     *
     * @param date1
     * @param date2
     * @return
     */
    public abstract List<Order> getOrdersByDateRange(String date1, String date2);

    /**
     *
     * @param order
     */
    public abstract void deleteOrder(Order order);
    
}
