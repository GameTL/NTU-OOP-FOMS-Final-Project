package src;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    public enum Status {
        New,
        ReadyForPickup,
        Completed
    }

    private Status status;
    private String orderId;
    private String customerId;
    private List<OrderItem> items;
    private double totalCost = 0;

    private boolean isTakeaway;

    public Order(String customerId, boolean isTakeaway) {
        this.orderId = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.items = new ArrayList<>();
        this.status = status.New; // Default status
        this.isTakeaway = isTakeaway;
    }

    // Add an item to the order
    public void addItem(MenuItem menuItem, int quantity) {
        this.items.add(new OrderItem(menuItem, quantity));
        totalCost += menuItem.getPrice() * quantity;  // Update total cost
    }

    public double getTotalCost(){
        return totalCost;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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
        sb.append(String.format("Order ID: %s\nCustomer ID: %s\nStatus: %s\nTakeaway: %s\nItems:\n", orderId,
                customerId, status, isTakeaway ? "Yes" : "No"));
        for (OrderItem item : items) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }
}
