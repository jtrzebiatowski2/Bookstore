package model;

import java.util.List;

/**
 *
 * @author J-Tron
 */
public interface OrderDetailsDAOStrategy {
    public abstract List<OrderDetail> getOrderDetails();
    public abstract void addOrderDetail(OrderDetail orderDetail);
    public abstract double getOrderTotal(int order_id);
    
}
