package model;

import java.util.List;

/**
 *
 * @author J-Tron
 */
public interface CustomerDAOStrategy {
    public abstract List<Customer> getCustomerList();
    public abstract void addCustomer(Customer customer);
    public abstract void updateCustomer(Customer customer);
    public abstract void deleteCustomer(Customer customer);
}
