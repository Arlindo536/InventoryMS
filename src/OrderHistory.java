import java.util.Stack;

public class OrderHistory {
    private Stack<Order> orderHistory;

    public OrderHistory() {
        this.orderHistory = new Stack<>();
    }

    public void addOrder(Order order) {
        orderHistory.push(order);
        System.out.println("Order saved to history: " + order.getCustomerName() + " - " + order.getProductName());
    }

    public Order undoLastOrder() {
        if (orderHistory.isEmpty()) {
            System.out.println("No orders in history to undo.");
            return null;
        }

        Order lastOrder = orderHistory.pop();
        System.out.println("Undoing last order: " + lastOrder.getCustomerName() + " - " + lastOrder.getProductName());
        return lastOrder;
    }

    public void displayOrderHistory() {
        if (orderHistory.isEmpty()) {
            System.out.println("No orders in history.");
            return;
        }

        System.out.println("\n----- Order History (Most Recent First) -----");
        for (int i = orderHistory.size() - 1; i >= 0; i--) {
            System.out.println(orderHistory.get(i));
        }
        System.out.println("------------------------------------------\n");
    }

    public int getHistorySize() {
        return orderHistory.size();
    }
}