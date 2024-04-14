package src;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private List<Order> orderHistory;

    public Customer(String id, String name, String contactInfo) {
        super(id, name, contactInfo);
        this.orderHistory = new ArrayList<>();
    }

    public void placeOrder(Order order, List<OrderItem> items) {
        for (OrderItem item : items) {
            order.addItem(item.getMenuItem(), item.getQuantity());
        }
        orderHistory.add(order);
        System.out.println("Order placed successfully with " + items.size() + " items.");
    }

    public void checkOrderStatus(String orderId) {
        for (Order order : orderHistory) {
            if (order.getOrderId().equals(orderId)) {
                System.out.println("Order Status: " + order.getStatus());
                return;
            }
        }
        System.out.println("Order not found.");
    }

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
    
    public void collectOrder(String orderId) {
        for (Order order : orderHistory) {
            if (order.getOrderId().equals(orderId)) {
                if ("Ready to pickup".equals(order.getStatus())) {
                    order.setStatus("Completed");
                    System.out.println("Order " + orderId + " collected successfully. Status changed to Completed.");
                } else {
                    System.out.println("Order " + orderId + " is not ready for pickup. Current status: " + order.getStatus());
                }
                return;
            }
        }
        System.out.println("Order with ID " + orderId + " not found in your order history.");
    }

}

