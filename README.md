# 📘 Inventory Management System ✏️

## Project Overview

The Inventory Management System is a Java-based application designed for small businesses to efficiently handle products, process customer orders, and maintain stock levels. The system demonstrates the implementation of fundamental data structures and algorithms.

## Features

- **Product Management**: Add, update, remove, and view product details
- **Order Processing**: Place customer orders and process them in FIFO order
- **Undo Functionality**: Reverse mistakenly placed orders
- **Search Capabilities**: Find products quickly using binary search
- **Sorting Options**: Sort products by price using merge sort
- **Inventory Valuation**: Calculate total inventory value recursively

## 📁Data Structures

This project implements the following data structures:

- **Linked List**: Used to store and manage the product inventory
- **Queue**: Processes customer orders in the order received (FIFO)
- **Stack**: Tracks previous orders to enable undo operations

## 📐Algorithms

The system implements several key algorithms:

- **Binary Search**: For efficient product lookups by name
- **Merge Sort**: For sorting products by price
- **Recursion**: For calculating the total inventory value

## 📝Classes

1. **Product**: Represents a product with name, price, and quantity
2. **InventoryNode**: Node in the linked list storing product information
3. **InventoryList**: Linked list implementation for managing products
4. **Order**: Represents a customer order with details
5. **OrderQueue**: Queue implementation for processing orders
6. **OrderHistory**: Stack implementation for tracking orders
7. **InventorySearchSort**: Contains search and sort algorithms
8. **InventorySystem**: Main controller class that ties everything together
9. **Main**: Contains the main method and demonstration code

## Implementation Details

### Linked List Implementation
The inventory is managed using a custom linked list implementation. Each node in the list contains a product and a reference to the next node.

### Queue Implementation
Customer orders are processed using a queue to ensure they are handled in the order they were received (First-In-First-Out).

### Stack Implementation
The system uses a stack to keep track of order history, allowing for easy undo
