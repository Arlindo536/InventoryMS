import java.util.Date;

public class Order {
    private String customerName;
    private String productName;
    private int quantity;
    private double totalPrice;
    private Date orderDate;

    public Order(String customerName, String productName, int quantity, double totalPrice) {
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.orderDate = new Date();
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    @Override
    public String toString() {
        return "Order: " + customerName + " | Product: " + productName +
                " | Quantity: " + quantity + " | Total: $" + totalPrice +
                " | Date: " + orderDate;
    }
}