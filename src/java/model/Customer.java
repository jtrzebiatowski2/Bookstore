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

    public Customer() {
    }

    
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

    public String getCity() {
        return city;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getState() {
        return state;
    }

    public String getStreet() {
        return street;
    }

    public String getZip() {
        return zip;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

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
