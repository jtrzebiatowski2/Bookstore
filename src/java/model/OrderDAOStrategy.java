package model;

import java.util.List;

/**
 *
 * @author J-Tron
 */
public interface OrderDAOStrategy {
    public abstract List<Order> getOrders();
}
