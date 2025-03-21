import java.util.ArrayList;
import java.util.List;

public class InventoryList {
    private InventoryNode head;
    private int size;

    public InventoryList() {
        this.head = null;
        this.size = 0;
    }

    public void addProduct(Product product) {
        InventoryNode newNode = new InventoryNode(product);

        if (head == null) {
            head = newNode;
        } else {
            InventoryNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
        System.out.println("Added product: " + product.getName());
    }

    public boolean removeProduct(String productName) {
        if (head == null) {
            System.out.println("Inventory is empty");
            return false;
        }

        if (head.getProduct().getName().equalsIgnoreCase(productName)) {
            head = head.getNext();
            size--;
            System.out.println("Removed product: " + productName);
            return true;
        }

        InventoryNode current = head;
        while (current.getNext() != null) {
            if (current.getNext().getProduct().getName().equalsIgnoreCase(productName)) {
                current.setNext(current.getNext().getNext());
                size--;
                System.out.println("Removed product: " + productName);
                return true;
            }
            current = current.getNext();
        }

        System.out.println("Product not found: " + productName);
        return false;
    }

    public Product findProduct(String productName) {
        InventoryNode current = head;
        while (current != null) {
            if (current.getProduct().getName().equalsIgnoreCase(productName)) {
                return current.getProduct();
            }
            current = current.getNext();
        }
        return null;
    }

    public void updateProductQuantity(String productName, int newQuantity) {
        Product product = findProduct(productName);
        if (product != null) {
            product.setQuantity(newQuantity);
            System.out.println("Updated quantity for " + productName + " to " + newQuantity);
        } else {
            System.out.println("Product not found: " + productName);
        }
    }

    public void updateProductPrice(String productName, double newPrice) {
        Product product = findProduct(productName);
        if (product != null) {
            product.setPrice(newPrice);
            System.out.println("Updated price for " + productName + " to $" + newPrice);
        } else {
            System.out.println("Product not found: " + productName);
        }
    }

    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty");
            return;
        }

        System.out.println("\n----- Current Inventory -----");
        InventoryNode current = head;
        while (current != null) {
            System.out.println(current.getProduct());
            current = current.getNext();
        }
        System.out.println("----------------------------\n");
    }

    public double calculateTotalValue() {
        if (head == null) {
            return 0;
        }
        return calculateNodeValue(head);
    }

    private double calculateNodeValue(InventoryNode node) {
        if (node == null) {
            return 0;
        }
        double currentValue = node.getProduct().getPrice() * node.getProduct().getQuantity();
        return currentValue + calculateNodeValue(node.getNext());
    }

    public Product[] getProductsArray() {
        Product[] products = new Product[size];
        InventoryNode current = head;
        int index = 0;

        while (current != null) {
            products[index++] = current.getProduct();
            current = current.getNext();
        }

        return products;
    }

    public List<Product> getProductsList() {
        List<Product> productList = new ArrayList<>();
        InventoryNode current = head;

        while (current != null) {
            productList.add(current.getProduct());
            current = current.getNext();
        }

        return productList;
    }
}