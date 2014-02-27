package model;

import java.util.List;

/**
 *
 * @author J-Tron
 * @version 1.0
 */
public interface CustomerDAOStrategy {

    /**
     *
     * @return
     */
    public abstract List<Customer> getCustomerList();

    /**
     *
     * @param customer
     */
    public abstract void addCustomer(Customer customer);

    /**
     *
     * @param customer
     */
    public abstract void updateCustomer(Customer customer);

    /**
     *
     * @param customer
     */
    public abstract void deleteCustomer(Customer customer);
}
