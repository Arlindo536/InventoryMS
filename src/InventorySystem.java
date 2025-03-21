import java.util.List;

public class InventorySystem {
    private InventoryList inventory;
    private OrderQueue orderQueue;
    private OrderHistory orderHistory;

    public InventorySystem() {
        this.inventory = new InventoryList();
        this.orderQueue = new OrderQueue();
        this.orderHistory = new OrderHistory();
    }

    public void addProduct(String name, double price, int quantity) {
        Product product = new Product(name, price, quantity);
        inventory.addProduct(product);
    }

    public boolean removeProduct(String name) {
        return inventory.removeProduct(name);
    }

    public void updateProductQuantity(String name, int newQuantity) {
        inventory.updateProductQuantity(name, newQuantity);
    }

    public void updateProductPrice(String name, double newPrice) {
        inventory.updateProductPrice(name, newPrice);
    }

    public void placeOrder(String customerName, String productName, int quantity) {
        Product product = inventory.findProduct(productName);

        if (product == null) {
            System.out.println("Product not found: " + productName);
            return;
        }

        if (product.getQuantity() < quantity) {
            System.out.println("Insufficient stock. Available: " + product.getQuantity());
            return;
        }

        double totalPrice = product.getPrice() * quantity;
        Order order = new Order(customerName, productName, quantity, totalPrice);

        // Update inventory
        product.setQuantity(product.getQuantity() - quantity);

        // Add to queue and history
        orderQueue.addOrder(order);
        orderHistory.addOrder(order);

        System.out.println("Order placed successfully for " + customerName);
    }

    public void processNextOrder() {
        Order order = orderQueue.processNextOrder();
        if (order != null) {
            System.out.println("Order processed successfully");
        }
    }

    public void undoLastOrder() {
        Order lastOrder = orderHistory.undoLastOrder();

        if (lastOrder != null) {
            // Restore inventory
            Product product = inventory.findProduct(lastOrder.getProductName());
            if (product != null) {
                product.setQuantity(product.getQuantity() + lastOrder.getQuantity());
                System.out.println("Inventory restored for: " + lastOrder.getProductName());
            }
            System.out.println("Order undone successfully");
        }
    }

    public Product searchProduct(String name) {
        return inventory.findProduct(name);
    }

    public Product binarySearchProduct(String name) {
        Product[] products = inventory.getProductsArray();
        return InventorySearchSort.binarySearchByName(products, name);
    }

    public List<Product> sortProductsByPrice() {
        List<Product> products = inventory.getProductsList();
        return InventorySearchSort.sortByPrice(products);
    }

    public double calculateTotalInventoryValue() {
        return inventory.calculateTotalValue();
    }

    public void displayInventory() {
        inventory.displayInventory();
    }

    public void displayOrderQueue() {
        orderQueue.displayQueue();
    }

    public void displayOrderHistory() {
        orderHistory.displayOrderHistory();
    }
}