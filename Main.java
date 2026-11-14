import java.util.ArrayList;
import java.util.Scanner;
 
public class Main {
 
    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<Book> library = new ArrayList<>();
 
    public static void main(String[] args) {
 
        // The three sample objects from the activity are preloaded
        library.add(new Book("Noli Me Tangere", "Jose Rizal", "ISBN-001", 350.00));
        library.add(new Book("El Filibusterismo", "Jose Rizal", "ISBN-002", 320.00));
        library.add(new EBook("Florante at Laura", "Francisco Balagtas",
                              "ISBN-003", 150.00, "PDF"));
 
        int choice;
        do {
            System.out.println("\n===== LIBRARY BOOK SYSTEM =====");
            System.out.println("1. Add a Book");
            System.out.println("2. Add an E-Book");
            System.out.println("3. Display all books");
            System.out.println("4. Update a book's price");
            System.out.println("5. Apply a discount");
            System.out.println("0. Exit");
            choice = readInt("Enter choice: ");
 
            switch (choice) {
                case 1: addBook(); break;
                case 2: addEBook(); break;
                case 3: displayAll(); break;
                case 4: updatePrice(); break;
                case 5: discountBook(); break;
                case 0: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
 
        sc.close();
    }
 
    // ---------- Menu actions ----------
 
    private static void addBook() {
        String title = readText("Title: ");
        String author = readText("Author: ");
        String isbn = readText("ISBN: ");
        double price = readPrice("Price: ");
        library.add(new Book(title, author, isbn, price));
        System.out.println("Book added.");
    }
 
    private static void addEBook() {
        String title = readText("Title: ");
        String author = readText("Author: ");
        String isbn = readText("ISBN: ");
        double price = readPrice("Price: ");
        String format = readText("File format (PDF/EPUB/MOBI): ");
        library.add(new EBook(title, author, isbn, price, format));
        System.out.println("E-Book added.");
    }
 
    private static void displayAll() {
        System.out.println("\n===== ALL BOOKS =====");
        for (Book b : library) {
            b.displayInfo();   // polymorphism: EBook prints its format too
            System.out.println();
        }
    }
 
    private static void updatePrice() {
        Book b = findByIsbn(readText("ISBN of the book to update: "));
        if (b == null) {
            System.out.println("Book not found.");
            return;
        }
        b.setPrice(readDouble("New price: "));   // setter rejects negatives
        System.out.println("\n===== UPDATED INFORMATION =====");
        System.out.println("Title: " + b.getTitle());
        System.out.printf("Price: PHP %.2f%n", b.getPrice());
    }
 
    private static void discountBook() {
        Book b = findByIsbn(readText("ISBN of the book to discount: "));
        if (b == null) {
            System.out.println("Book not found.");
            return;
        }
        b.applyDiscount(readDouble("Discount percent (0-100): "));
        System.out.println("Title: " + b.getTitle());
        System.out.printf("Price: PHP %.2f%n", b.getPrice());
    }
 
    // ---------- Helpers ----------
 
    private static Book findByIsbn(String isbn) {
        for (Book b : library) {
            if (b.getIsbn().equalsIgnoreCase(isbn)) {
                return b;
            }
        }
        return null;
    }
 
    private static String readText(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }
 
    // Keeps asking until the user types a valid number (no crash on letters)
    private static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }
 
    private static double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
 
    // Keeps asking until the price is not negative
    private static double readPrice(String prompt) {
        double p = readDouble(prompt);
        while (p < 0) {
            System.out.println("Price must not be negative.");
            p = readDouble(prompt);
        }
        return p;
    }
}