package src;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer in a system, inheriting properties from the {@link User} class.
 * A customer can place orders, check order statuses, and view their order history.
 * @author Shuya Yamazaki  Created at 6/4/24 Email : @author shuya.yamazaki1223@gmail.com
 * @version 1.00.00
 */
public class Customer extends User {
    private List<Order> orderHistory; // List that holds the history of orders placed by the customer.

    /**
     * Constructs a new customer with the specified ID and name.
     * Initializes an empty list for order history.
     * @param id The unique identifier for the customer.
     * @param name The name of the customer.
     */
    public Customer(String id, String name) {
        super(id, name);
        this.orderHistory = new ArrayList<>();
    }

    /**
     * Places an order by adding items to the order and updating the customer's order history.
     * @param order The order to be placed.
     * @param items The list of items to be added to the order.
     */
    public void placeOrder(Order order, List<OrderItem> items) {
        for (OrderItem item : items) {
            order.addItem(item.getMenuItem(), item.getQuantity());
        }
        orderHistory.add(order);
        System.out.println("Order placed successfully with " + items.size() + " items.");
    }

    /**
     * Checks the status of an order by order ID.
     * If the order is found in the history, it prints the order's status.
     * If not, it notifies the user that the order was not found.
     * @param orderId The ID of the order to check.
     */
    public void checkOrderStatus(String orderId) {
        for (Order order : orderHistory) {
            if (order.getOrderId().equals(orderId)) {
                System.out.println("Order Status: " + order.getStatus());
                return;
            }
        }
        System.out.println("Order not found.");
    }

    /**
     * Displays the order history for the customer.
     * If no orders have been placed, it notifies the user accordingly.
     */
    public void viewOrderHistory() {
        if (orderHistory.isEmpty()) {
            System.out.println("No orders placed yet.");
            return;
        }
        System.out.println("Order History:");
        for (Order order : orderHistory) {
            System.out.println(order);
        }
    }
}
