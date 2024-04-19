package src;
import java.util.Scanner;
import java.io.Serializable;

/**
 * Manages payment processing and registration of different payment methods.
 * Utilizes a static initializer to register default payment methods.
 * This class handles the execution of payments and interacts with the PaymentRegistry to retrieve payment methods.
 * @author Abirami Selvaraj  Created at 9/4/24 Email : @author abiramis2210@gmail.com
 * @version 1.00.00
 */
public class PaymentManager implements Serializable {
    private static final long serialVersionUID = 3L;

    private static PaymentRegistry paymentRegistry = new PaymentRegistry();

    // Static initializer to register default payment methods
    static {
        paymentRegistry.registerPaymentMethod(1, new CreditCardPayment(), "Credit Card");
        paymentRegistry.registerPaymentMethod(2, new DebitCardPayment(), "Debit Card");
        paymentRegistry.registerPaymentMethod(3, new OnlinePayment(), "Online Payment");
    }

    /**
     * Retrieves the singleton instance of the PaymentRegistry.
     * @return The single instance of PaymentRegistry used to register and manage payment methods.
     */
    public static PaymentRegistry getPaymentRegistry() {
        return paymentRegistry;
    }

    /**
     * Processes a payment for an order using a specified payment method and amount.
     * If the payment is successful, the order status is set to new, and confirmation is printed.
     * @param payment The payment method to be used.
     * @param order The order for which payment is being processed.
     * @param amount The amount to be paid.
     * @return true if the payment is successfully processed, false otherwise.
     */
    private static boolean processPayment(Payment payment, Order order, double amount) {
        boolean paymentSuccess = payment.processPayment(amount);
        if (paymentSuccess) {
            payment.displayCompletePayment();
            order.setStatus(Order.Status.New);
            System.out.println("Order ID:      " + order.getOrderId());
            System.out.println("CustomerID ID: " + order.getCustomerId());
            System.out.println("Your Order have been sent to the kitchen\nPRESS 0 THEN ENTER TO CONTINUE");
            return true;
        } else {
            System.out.println("Payment failed.");
            return false;
        }
    }
    
    /**
     * Initiates the payment process for an order using a selected payment method option.
     * Validates the payment method and order, calculates the total amount, and processes the payment.
     * @param methodOption The payment method option as registered in the PaymentRegistry.
     * @param order The order for which payment needs to be made.
     * @return true if the payment was successfully made, false otherwise.
     */
    public static boolean makePayment(int methodOption, Order order) {
        if (order == null || methodOption < 0) {
            System.out.println("Error: Invalid payment method or order.");
            return false;
        }

        Payment paymentMethod = getPaymentRegistry().getPaymentMethod(methodOption);
        if (paymentMethod != null) {
            double amount = calculate(order);
            return processPayment(paymentMethod, order, amount);
        } else {
            System.out.println("Invalid payment method choice. Payment canceled.");
            return false;
        }
    }
    
    /**
     * Calculates the total cost of an order by summing up the prices of all items in the order multiplied by their quantities.
     * @param order The order for which the total cost is being calculated.
     * @return The total cost of the order.
     */
    private static double calculate(Order order) {
        double amount = 0;
        for (OrderItem orderEntry : order.getItems()) {
            amount += orderEntry.getQuantity() * orderEntry.getMenuItem().getPrice();
        }
        return amount;
    }
}
