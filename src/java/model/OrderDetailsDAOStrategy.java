package model;

import java.util.List;

/**
 *
 * @author J-Tron
 * @version 1.0
 */
public interface OrderDetailsDAOStrategy {

    /**
     *
     * @return
     */
    public abstract List<OrderDetail> getOrderDetails();

    /**
     *
     * @param orderDetail
     */
    public abstract void addOrderDetail(OrderDetail orderDetail);

    /**
     *
     * @param order_id
     * @return
     */
    public abstract double getOrderTotal(int order_id);

    /**
     *
     * @param order_id
     * @return
     */
    public abstract List<OrderDetail> getOrderDetails(int order_id);
    
}
