import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookInventoryTest {

    private BookInventory inventory;
    private Book book1;
    private Book book2;
    private Book book3;

    @BeforeEach
    public void setUp() {
        inventory = new BookInventory();
        book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        book2 = new Book("1984", "George Orwell");
        book3 = new Book("To Kill a Mockingbird", "Harper Lee");

        inventory.add(book1, 5);
        inventory.add(book2, 3);
        inventory.add(book3, 7);
    }

    @Test
    public void testAddBook() {
        Book book4 = new Book("Moby Dick", "Herman Melville");
        inventory.add(book4, 4);
        assertTrue(inventory.contains(book4));
        assertEquals(4, inventory.size());
    }

    @Test
    public void testAddBookInvalidQuantity() {
        Book book4 = new Book("Moby Dick", "Herman Melville");
        inventory.add(book4, 0);
        assertFalse(inventory.contains(book4));
        assertEquals(3, inventory.size());
    }

    @Test
    public void testRemoveBook() {
        inventory.remove(book2);
        assertFalse(inventory.contains(book2));
        assertEquals(2, inventory.size());
    }

    @Test
    public void testRemoveBookNotInInventory() {
        Book book4 = new Book("Moby Dick", "Herman Melville");
        inventory.remove(book4);
        assertEquals(3, inventory.size());
    }

    @Test
    public void testDecrementQuantity() {
        inventory.decrementQuantity(book3, 2);
        inventory.decrementQuantity(book1, 5); // Should remove the book
        assertFalse(inventory.contains(book1));
        assertTrue(inventory.contains(book3));
        assertEquals(5, inventory.size());
    }

    @Test
    public void testDecrementQuantityInvalid() {
        inventory.decrementQuantity(book2, 4); // Exceeds quantity
        assertEquals(3, inventory.size());
        assertTrue(inventory.contains(book2));
    }

    @Test
    public void testSearchByTitle() {
        Book book4 = new Book("The Great Gatsby", "Unknown Author");
        inventory.add(book4, 2);
        inventory.searchByTitle("The Great Gatsby");
    }

    @Test
    public void testSearchByAuthor() {
        inventory.searchByAuthor("Harper Lee");
        inventory.searchByAuthor("Unknown Author"); // Should not find anything
    }

    @Test
    public void testSize() {
        assertEquals(3, inventory.size());
    }

    @Test
    public void testPrintInventory() {
        inventory.printInventory();
    }
}
