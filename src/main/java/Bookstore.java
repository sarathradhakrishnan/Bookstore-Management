

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bookstore {
    private List<Book> inventory;

    public Bookstore() {
        this.inventory = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        inventory.add(book);
        System.out.println("Book added to inventory.");
    }

    public void updateBook(int bookId, String title, String author, double price, int quantity) {
        for (Book book : inventory) {
            if (book.getBookId() == bookId) {
                book.setTitle(title);
                book.setAuthor(author);
                book.setPrice(price);
                book.setQuantity(quantity);
                System.out.println("Book information updated.");
                return;
            }
        }
        System.out.println("Book not found. Update failed.");
    }

    public Book searchBookById(int bookId) {
        for (Book book : inventory) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        System.out.println("Book not found.");
        return null;
    }

    public void displayBookDetails(int bookId) {
        Book book = searchBookById(bookId);
        if (book != null) {
            System.out.println("Book Details:");
            System.out.println(book.toString());
        }
    }

    public void removeBook(int bookId) {
        Iterator<Book> iterator = inventory.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getBookId() == bookId) {
                iterator.remove();
                System.out.println("Book removed from inventory.");
                return;
            }
        }
        System.out.println("Book not found. Removal failed.");
    }

    public void listAllBooks() {
        System.out.println("Inventory List:");
        for (Book book : inventory) {
            System.out.println(book.toString());
        }
    }
}
