package model;

import java.util.List;

/**
 *
 * @author J-Tron
 */
public interface OrderDetailsDAOStrategy {
    public abstract List<OrderDetail> getOrderDetails();
}
