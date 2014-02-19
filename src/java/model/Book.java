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
public class Book {
    private int book_id;
    private String title;
    private String description;
    private double price;
    private String image_url;

    public Book() {
    }

    public Book(int book_id, String title, String description, double price, String image_url) {
        this.book_id = book_id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.image_url = image_url;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBook_id() {
        return book_id;
    }

    public String getDescription() {
        return description;
    }

    public String getImage_url() {
        return image_url;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }
    
      @Override
       public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if(this.title != other.title && (this.title == null || !this.title.equals(other.title))){
        return false;
    }
       return true;
}

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.title != null ? this.title.hashCode() : 0);
        return hash;
    }
    
    @Override
    public String toString() {
        return "Book ID: " + book_id + "\nBook Title: " + title + "\nDescription: " + description + "\nPrice: " + price;
    }
    
    
    
}
