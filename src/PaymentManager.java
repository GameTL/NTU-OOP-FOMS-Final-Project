package src;
import java.util.Scanner;

public class PaymentManager {
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

//    public static boolean processPayment(Order order) {
//        if (order == null) {
//            System.out.println("Error: Order Not Assigned. Exiting...");
//            return false;
//        }
//
//        double amount = calculate(order);
//        System.out.println("Due Amount: S$ " + String.format("%.2f", amount));
//        displayPaymentMethods();
//
//        Scanner scanner = new Scanner(System.in);
//        int paymentMethodChoice = scanner.nextInt();
//
//        Payment selectedPaymentMethod = paymentRegistry.getPaymentMethod(paymentMethodChoice);
//        if (selectedPaymentMethod != null) {
//            return processPayment(selectedPaymentMethod, order, amount);
//        } else {
//            System.out.println("Invalid payment method choice. Payment canceled.");
//            return false;
//        }
//    }

//    private static void displayPaymentMethods() {
//        System.out.println("Please choose your payment method");
//        System.out.println("=========================================");
//        paymentRegistry.getAllPaymentMethods().forEach(entry -> {
//            System.out.println("(" + entry.getKey() + ") " + entry.getValue().getDescription());
//        });
//        System.out.println("=========================================\nPlease enter your choice:\n Enter -1 to cancel payment.");
//    }

    private static boolean processPayment(Payment payment, Order order, double amount) {
        boolean paymentSuccess = payment.processPayment(amount);
        if (paymentSuccess) {
            payment.displayCompletePayment();
            order.setStatus(Order.Status.New);
            System.out.println("Order ID: " + order.getOrderId());
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
