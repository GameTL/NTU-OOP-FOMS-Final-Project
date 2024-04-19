package src;
import java.util.Scanner;
import java.io.Serializable;

public class PaymentManager implements Serializable{
    private static final long serialVersionUID = 3L;

    private static PaymentRegistry paymentRegistry = new PaymentRegistry();

    static {
        // Registering default payment methods with descriptions
        paymentRegistry.registerPaymentMethod(1, new CreditCardPayment(), "Credit Card");
        paymentRegistry.registerPaymentMethod(2, new DebitCardPayment(), "Debit Card");
        paymentRegistry.registerPaymentMethod(3, new OnlinePayment(), "Online Payment");
    }

    public static PaymentRegistry getPaymentRegistry() {
        return paymentRegistry;
    }

    private static boolean processPayment(Payment payment, Order order, double amount) {
        boolean paymentSuccess = payment.processPayment(amount);
        if (paymentSuccess) {
            payment.displayCompletePayment();
            order.setStatus(Order.Status.New);
            System.out.println("Order ID:      " + order.getOrderId());
            System.out.println("CustomerID ID: " + order.getCustomerId());
            System.out.println("Your Order have been sent to the kitchen\nPRESS 0 THEN ENTER TO CONTINUE");
            // Scanner tempsc = new Scanner(System.in);
            // tempsc.nextInt();
            // tempsc.close();

            return true;
        } else {
            System.out.println("Payment failed.");
            return false;
        }
    }
    
 // Public method to process a payment using a selected method
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
    
    private static double calculate(Order order) {
        double amount = 0;
        for (OrderItem orderEntry : order.getItems()) {
            amount += orderEntry.getQuantity() * orderEntry.getMenuItem().getPrice();
        }
        return amount;
    }
}
