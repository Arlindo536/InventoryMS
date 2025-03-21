import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create the inventory system
        InventorySystem system = new InventorySystem();

        // Add initial products
        system.addProduct("Laptop", 999.99, 10);
        system.addProduct("Smartphone", 699.99, 15);
        system.addProduct("Headphones", 149.99, 25);
        system.addProduct("Tablet", 499.99, 8);
        system.addProduct("Mouse", 29.99, 30);

        // Display initial inventory
        system.displayInventory();

        // Calculate and display total inventory value
        double totalValue = system.calculateTotalInventoryValue();
        System.out.println("Total inventory value: $" + totalValue);

        // Place some orders
        system.placeOrder("John Doe", "Laptop", 2);
        system.placeOrder("Jane Smith", "Smartphone", 3);
        system.placeOrder("Bob Johnson", "Headphones", 5);

        // Display the updated inventory
        system.displayInventory();

        // Display the order queue
        system.displayOrderQueue();

        // Process the next order in the queue
        system.processNextOrder();

        // Display the updated order queue
        system.displayOrderQueue();

        // Display order history
        system.displayOrderHistory();

        // Undo the last order
        system.undoLastOrder();

        // Display the updated inventory and order history
        system.displayInventory();
        system.displayOrderHistory();

        // Search for a product
        Product product = system.searchProduct("Tablet");
        if (product != null) {
            System.out.println("Product found: " + product);
        } else {
            System.out.println("Product not found");
        }

        // Binary search for a product
        Product binarySearchResult = system.binarySearchProduct("Mouse");
        if (binarySearchResult != null) {
            System.out.println("Binary search found: " + binarySearchResult);
        } else {
            System.out.println("Binary search: Product not found");
        }

        // Sort products by price
        List<Product> sortedProducts = system.sortProductsByPrice();
        System.out.println("\n----- Products Sorted by Price -----");
        for (Product p : sortedProducts) {
            System.out.println(p);
        }
        System.out.println("----------------------------------\n");

        // Update a product
        system.updateProductPrice("Headphones", 129.99);
        system.updateProductQuantity("Mouse", 50);

        // Display final inventory
        system.displayInventory();

        // Calculate and display final inventory value
        totalValue = system.calculateTotalInventoryValue();
        System.out.println("Final inventory value: $" + totalValue);
    }
}