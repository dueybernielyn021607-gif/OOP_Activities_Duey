public class Book {

    // Encapsulation: all attributes are private
    private String title;
    private String author;
    private String isbn;
    private double price;

    // Constructor: sets all four attributes
    public Book(String title, String author, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        setPrice(price);
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public double getPrice() { return price; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Invalid price (" + price + "). Price must not be negative.");
        } else {
            this.price = price;
        }
    }

    // Bonus: lowers the price by a percentage (0 to 100)
    public void applyDiscount(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Invalid discount. Use a value from 0 to 100.");
        } else {
            this.price = this.price - (this.price * percent / 100);
        }
    }

    // Prints all four details (bonus: price formatted as PHP 0.00)
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.printf("Price: PHP %.2f%n", price);
    }
}