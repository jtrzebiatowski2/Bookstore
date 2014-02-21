package model;

import java.util.List;

/**
 *
 * @author J-Tron
 */
public interface CustomerDAOStrategy {
    public abstract List<Customer> getCustomerList();
}
