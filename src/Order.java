package src;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private String orderId;
    private String customerId;
    private List<OrderItem> items;
    private String status; // For example: "New", "Ready to pickup", "Completed"
    private boolean isTakeaway;

    public Order(String customerId, boolean isTakeaway) {
        this.orderId = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.items = new ArrayList<>();
        this.status = "New"; // Default status
        this.isTakeaway = isTakeaway;
    }

    // Add an item to the order
    public void addItem(MenuItem menuItem, int quantity) {
        this.items.add(new OrderItem(menuItem, quantity));
    }

    // Remove an item from the order
    public void removeItem(OrderItem orderItem) {
        this.items.remove(orderItem);
    }

    // Getters and Setters
    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<OrderItem> getItems() {
        return new ArrayList<>(items); // Return a copy to prevent external modifications
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isTakeaway() {
        return isTakeaway;
    }

    public void setTakeaway(boolean isTakeaway) {
        this.isTakeaway = isTakeaway;
    }

    // Helper method to print order details
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Order ID: %s\nCustomer ID: %s\nStatus: %s\nTakeaway: %s\nItems:\n", orderId, customerId, status, isTakeaway ? "Yes" : "No"));
        for (OrderItem item : items) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }
}
