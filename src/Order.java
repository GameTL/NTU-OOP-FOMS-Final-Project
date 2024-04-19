package src;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.io.Serializable;

/**
 * Represents an order placed by a customer, including details about the items, total cost, and status of the order.
 * Implements Serializable to facilitate easy storage and retrieval of order data.
 * 
 * @author Shuya Yamazaki  Created at 6/4/24 Email : @author shuya.yamazaki1223@gmail.com
 * @version 1.00.00
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 6L;

    /**
     * Enumerates the various statuses an order can have, ranging from new to cancelled.
     */
    public enum Status {
        New,          // Order has been created but not yet processed
        ReadyForPickup, // Order is processed and ready for pickup
        Completed,    // Order has been completed
        Cancelled     // Order has been cancelled due to customer not picking up
    }

    private Status status;                // Current status of the order
    private String orderId;               // Unique identifier for the order using UUID
    private String customerId;            // ID of the customer who placed the order
    private List<OrderItem> items;        // List of items in the order
    private double totalCost = 0;         // Total cost of the order

    private boolean isTakeaway;           // Flag to indicate if the order is for takeaway

    /**
     * Constructs a new Order for a specified customer with an option for takeaway.
     *
     * @param customerId The ID of the customer who is placing the order.
     * @param isTakeaway Whether the order is for takeaway or not.
     */
    public Order(String customerId, boolean isTakeaway) {
        this.orderId = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.items = new ArrayList<>();
        this.status = Status.New; // Default status
        this.isTakeaway = isTakeaway;
    }

    /**
     * Adds an item with a specified quantity to the order and updates the total cost.
     *
     * @param menuItem The menu item to add to the order.
     * @param quantity The quantity of the menu item.
     */
    public void addItem(MenuItem menuItem, int quantity) {
        this.items.add(new OrderItem(menuItem, quantity));
        totalCost += menuItem.getPrice() * quantity;  // Update total cost
    }

    /**
     * Returns the total cost of the order.
     *
     * @return The total cost.
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * Removes a specified item from the order.
     *
     * @param orderItem The item to remove from the order.
     */
    public void removeItem(OrderItem orderItem) {
        this.items.remove(orderItem);
    }

    /**
     * Returns the unique order ID.
     *
     * @return The unique identifier of the order.
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Returns the ID of the customer who placed the order.
     *
     * @return The customer's ID.
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Returns a copy of the list of items in the order to prevent external modifications.
     *
     * @return A list of order items.
     */
    public List<OrderItem> getItems() {
        return new ArrayList<>(items);
    }

    /**
     * Returns the current status of the order.
     *
     * @return The status of the order.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the status of the order.
     *
     * @param status The new status to set for the order.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Checks if the order is a takeaway.
     *
     * @return true if the order is takeaway, false otherwise.
     */
    public boolean isTakeaway() {
        return isTakeaway;
    }

    /**
     * Sets whether the order should be treated as takeaway.
     *
     * @param isTakeaway true if the order should be takeaway, false otherwise.
     */
    public void setTakeaway(boolean isTakeaway) {
        this.isTakeaway = isTakeaway;
    }

    /**
     * Provides a string representation of the order including order ID, customer ID, status, takeaway flag, and items.
     *
     * @return A string representation of the order.
     */
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
