# Development of Java Inventory Management System: A Comprehensive Summary
## Product.java

What was done: Created a simple class to represent inventory items with name, price, and quantity attributes.
Why: This forms the foundation of the inventory system, defining what information we need to track for each product. The class includes getters, setters, and a toString() method to provide encapsulation and proper data display.

## InventoryNode.java

What was done: Implemented a node class containing a Product object and a reference to the next node.
Why: This class serves as the building block for a linked list data structure. Using nodes allows for dynamic memory allocation and efficient insertion/deletion operations in the inventory list without requiring array resizing.

## InventoryList.java

What was done: Built a linked list implementation to store and manage product inventory using InventoryNode objects.
Why: A linked list provides flexibility for a constantly changing inventory. The class includes methods for:

Adding products (appending to the end of the list)
Removing products by name (maintaining list integrity)
Finding products by name (traversing the list)
Updating product quantities and prices
Calculating total inventory value using recursion
Converting the inventory to arrays or lists for different operational needs



## Order.java

What was done: Created a class representing customer orders with customer name, product name, quantity, total price, and order date.
Why: This class encapsulates all necessary information about an order. The order date is automatically captured at creation time, and the class provides a clear toString() method for displaying order information.

## OrderQueue.java

What was done: Implemented a queue for pending orders using Java's LinkedList.
Why: A queue enforces First-In-First-Out (FIFO) processing of orders, ensuring fairness in order fulfillment. This simulates a real-world order processing system where orders are handled in the sequence they arrive. Methods include:

Adding new orders to the queue
Processing (removing) the next order in sequence
Displaying all pending orders



## OrderHistory.java

What was done: Created a class using Java's Stack to maintain a history of all orders.
Why: A stack data structure (Last-In-First-Out) is ideal for tracking historical actions with the ability to undo the most recent ones. The most recent order is always at the top of the stack, making it easy to:

Add new orders to history
Undo (pop) the last order placed
Display the complete order history



 ## InventorySearchSort.java

What was done: Developed utility methods for searching and sorting products.
Why: These algorithms provide efficient ways to find and organize inventory data:

Binary search implementation for quickly finding products by name (requires sorted data)
Merge sort algorithm for sorting products by price (provides stable, efficient O(n log n) sorting)
Comparator-based sorting for arranging products by quantity



## InventorySystem.java

What was done: Created the central controller class that integrates all components of the system.
Why: This class serves as a facade, providing a simplified interface to the complex underlying system. It:

Manages instances of InventoryList, OrderQueue, and OrderHistory
Provides methods for all core business operations
Implements inventory file loading functionality
Handles the business logic for placing orders (checking stock, updating inventory)
Enables searching, sorting, and reporting on inventory



## Main.java

What was done: Implemented the application entry point with demonstration and full system modes.
Why: This class showcases how the inventory system works and provides a functional interface for users. It:

Creates a menu to choose between demonstration and full system modes
Provides sample data for demonstration purposes
Shows the sequence of operations in a typical workflow
Demonstrates file loading capabilities
Includes examples of all major system functionality


