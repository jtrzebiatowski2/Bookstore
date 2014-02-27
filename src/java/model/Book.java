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
    private String author;

    /**
     *
     */
    public Book() {
    }

    /**
     *
     * @param book_id
     * @param title
     * @param description
     * @param price
     * @param image_url
     * @param author
     */
    public Book(int book_id, String title, String description, double price, String image_url, String author) {
        this.book_id = book_id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.image_url = image_url;
        this.author = author;
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
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @param image_url
     */
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    /**
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
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
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return
     */
    public String getImage_url() {
        return image_url;
    }

    /**
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
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
        return "Book ID: " + book_id + "\nBook Title: " + title + "\nDescription: " + description + "\nPrice: " + price + "\nAuthor: "
                + author + "\n";
    }
    
    
    
}
