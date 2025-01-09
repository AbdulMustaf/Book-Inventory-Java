# Book Inventory Management

## Overview
This repository contains a Java-based Book Inventory Management System. The project provides functionality to manage books in an inventory, including adding, removing, searching, and decrementing book quantities. The inventory uses a `HashMap` for efficient tracking.

---

## Files in the Repository
- **`Book.java`**: Represents the `Book` class, which encapsulates the title and author.
- **`BookInventory.java`**: Implements the inventory management system with features like adding, removing, and searching books.
- **`BookInventoryTest.java`**: JUnit test cases to verify the functionality of the inventory management system.
- **`README.md`**: Documentation of the project.

---

## Features

1. **Core Functionalities**:
   - Add books to the inventory with a specified quantity.
   - Remove books from the inventory.
   - Decrement the quantity of a book without removing it entirely.
   - Verify if a specific book exists in the inventory.
   - Retrieve the total number of distinct books in the inventory.

2. **Search Features**:
   - Search for books by their title.
   - Search for books by their author.

3. **Utility Functions**:
   - Print all books in the inventory along with their quantities.

---

## How to Run

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/book-inventory-management.git
   cd book-inventory-management
