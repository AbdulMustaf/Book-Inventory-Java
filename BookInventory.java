import java.util.*;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    @Override
    public String toString() {
        return "Book{" + "title='" + title + '\'' + ", author='" + author + '\'' + '}';
    }
}

interface BookInventoryInterface {
    void add(Book book, int quantity);

    void remove(Book book);

    boolean contains(Book book);

    int size();
}

public class BookInventory implements BookInventoryInterface {
    private Map<Book, Integer> inventory;

    public BookInventory() {
        inventory = new HashMap<>();
    }

    @Override
    public void add(Book book, int quantity) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity. Quantity must be positive.");
            return;
        }

        inventory.put(book, inventory.getOrDefault(book, 0) + quantity);
        System.out.println("Added book: " + book + " with quantity: " + quantity);
    }

    @Override
    public void remove(Book book) {
        if (inventory.containsKey(book)) {
            inventory.remove(book);
            System.out.println("Removed book: " + book);
        } else {
            System.out.println("Book not found in inventory: " + book);
        }
    }

    public void decrementQuantity(Book book, int quantity) {
        if (!inventory.containsKey(book)) {
            System.out.println("Book not found in inventory: " + book);
            return;
        }

        int currentQuantity = inventory.get(book);
        if (quantity <= 0 || quantity > currentQuantity) {
            System.out.println("Invalid quantity to decrement.");
            return;
        }

        if (currentQuantity == quantity) {
            inventory.remove(book);
            System.out.println("Removed book: " + book);
        } else {
            inventory.put(book, currentQuantity - quantity);
            System.out.println("Decremented quantity for book: " + book + " by " + quantity);
        }
    }

    @Override
    public boolean contains(Book book) {
        boolean exists = inventory.containsKey(book);
        System.out.println("Book " + book + " exists: " + exists);
        return exists;
    }

    @Override
    public int size() {
        System.out.println("Inventory size: " + inventory.size());
        return inventory.size();
    }

    public void printInventory() {
        System.out.println("\nInventory contents:");
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            inventory.forEach((book, quantity) -> 
                System.out.println(book + " - Quantity: " + quantity)
            );
        }
    }

    public void searchByTitle(String title) {
        System.out.println("\nSearching for books with title: " + title);
        inventory.keySet().stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .forEach(System.out::println);
    }

    public void searchByAuthor(String author) {
        System.out.println("\nSearching for books by author: " + author);
        inventory.keySet().stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        BookInventory inventory = new BookInventory();

        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("1984", "George Orwell");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee");

        inventory.add(book1, 5);
        inventory.add(book2, 3);
        inventory.add(book3, 7);

        inventory.contains(book1);
        inventory.contains(new Book("Moby Dick", "Herman Melville"));

        inventory.size();
        inventory.printInventory();

        inventory.remove(book2);
        inventory.decrementQuantity(book3, 2);

        inventory.printInventory();

        inventory.searchByTitle("The Great Gatsby");
        inventory.searchByAuthor("Harper Lee");
    }
}
