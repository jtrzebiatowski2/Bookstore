package model;

/**
 * An example of an 'Entity' class. An entity class is a representation of
 * a database table, where the class name is similar to the table name and 
 * the class properties are similar to the table columns (fields). You would
 * use this to provide structured data to/from database operation code.
 * 
 * @author J-Tron
 * @version 1.0
 */
public class Customer {
    private int customer_id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String creditCardNumber;

    /**
     *
     */
    public Customer() {
    }

    /**
     *
     * @param customer_id
     * @param firstName
     * @param lastName
     * @param email
     * @param phone
     * @param street
     * @param city
     * @param state
     * @param zip
     * @param creditCardNumber
     */
    public Customer(int customer_id, String firstName, String lastName, String email, String phone, String street, String city, String state, String zip, String creditCardNumber) {
        this.customer_id = customer_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.creditCardNumber = creditCardNumber;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @return
     */
    public int getCustomer_id() {
        return customer_id;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @return
     */
    public String getStreet() {
        return street;
    }

    /**
     *
     * @return
     */
    public String getZip() {
        return zip;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @param customer_id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *
     * @param street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     *
     * @param zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     *
     * @return
     */
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     *
     * @param creditCardNumber
     */
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public String toString() {
        return "Customer ID: " + customer_id + "\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nEmail: " + 
                email + "\nPhone Number: " + phone + "\nAddress: " + street + "\n" + city + ", " + state + " " + zip 
                + "\nCredit Card Number: " + creditCardNumber;
    }

    @Override
    public boolean equals(Object obj) {
    if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (this.email != other.email && (this.email == null || !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }    
    

    @Override
    public int hashCode() {
         int hash = 5;
        hash = 53 * hash + (this.email != null ? this.email.hashCode() : 0);
        return hash;
    }
    
    
    
    
    
    
}
