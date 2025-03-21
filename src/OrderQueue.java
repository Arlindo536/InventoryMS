import java.util.LinkedList;
import java.util.Queue;

public class OrderQueue {
    private Queue<Order> orderQueue;

    public OrderQueue() {
        this.orderQueue = new LinkedList<>();
    }

    public void addOrder(Order order) {
        orderQueue.add(order);
        System.out.println("Order added to queue: " + order.getCustomerName() + " - " + order.getProductName());
        System.out.println("Current queue size: " + orderQueue.size());
    }

    public Order processNextOrder() {
        if (orderQueue.isEmpty()) {
            System.out.println("No orders in queue to process.");
            return null;
        }

        Order nextOrder = orderQueue.poll();
        System.out.println("Processing order for: " + nextOrder.getCustomerName());
        System.out.println("Order details: " + nextOrder);
        System.out.println("Remaining orders in queue: " + orderQueue.size());

        return nextOrder;
    }

    public void displayQueue() {
        if (orderQueue.isEmpty()) {
            System.out.println("No orders in queue.");
            return;
        }

        System.out.println("\n----- Current Order Queue -----");
        for (Order order : orderQueue) {
            System.out.println(order);
        }
        System.out.println("------------------------------\n");
    }

    public int getQueueSize() {
        return orderQueue.size();
    }
}