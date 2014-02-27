package model;

/**
 **An example of an 'Entity' class. An entity class is a representation of
 * a database table, where the class name is similar to the table name and 
 * the class properties are similar to the table columns (fields). You would
 * use this to provide structured data to/from database operation code.
 * 
 * @author J-Tron
 * @version 1.0
 */
public class OrderDetail {
    private int order_id;
    private int book_id;
    private int quantity;
    private double lineTotal;

    /**
     *
     */
    public OrderDetail() {
    }

    /**
     *
     * @param order_id
     * @param book_id
     * @param quantity
     * @param lineTotal
     */
    public OrderDetail(int order_id, int book_id, int quantity, double lineTotal) {
        this.order_id = order_id;
        this.book_id = book_id;
        this.quantity = quantity;
        this.lineTotal = lineTotal;
    }

    /**
     *
     * @param quantity
     * @param bookPrice
     * @return
     */
    public double calculateLineItemTotal(double quantity, double bookPrice){
        return quantity * bookPrice;
    }
    
    /**
     *
     * @return
     */
    public int getBook_id() {
        return book_id;
    }

    /**
     *
     * @return
     */
    public double getLineTotal() {
        return lineTotal;
    }

    /**
     *
     * @return
     */
    public int getOrder_id() {
        return order_id;
    }

    /**
     *
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param book_id
     */
    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    /**
     *
     * @param lineTotal
     */
    public void setLineTotal(double lineTotal) {
        this.lineTotal = lineTotal;
    }

    /**
     *
     * @param order_id
     */
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order ID: " + order_id + "\n Book ID: " + book_id + "\n Quantity: " + quantity + "\nLine Total: " + lineTotal;
    }
    
    
}
