package src;
import java.util.Scanner;

public class PaymentManager {
    public static boolean processPayment(Order OrderItem) {
        Scanner sc = new Scanner(System.in);
        if(OrderItem == null){
            System.out.println("Error: Order Not Assigned. Exiting...");
        }

        double amount = calculate(OrderItem);
        System.out.println("Due Amount: S$ "+String.format("%.2f",amount));
        System.out.println("Please choose your payment method");
        System.out.println("=========================================");
        System.out.println("(1) Credit Card");
        System.out.println("(2) Debit Card");
        System.out.println("(3) Online Payment");
        System.out.println("=========================================\nPlease enter your choice:\n Enter -1 to cancel payment.");
        switch (sc.nextInt()){
            default:
                return false;
            case 1:
                Payment creditCardPayment = new CreditCardPayment();
                boolean cPaymentSuccess = creditCardPayment.processPayment(amount);
                if (cPaymentSuccess) {
                    creditCardPayment.displayCompletePayment();
                    return true;
                } else {
                    System.out.println("Payment failed.");
                    return false;
                }
                break;
            case 2:
                Payment debitCardPayment = new DebitCardPayment();
                boolean dPaymentSuccess = debitCardPayment.processPayment(amount);
                if (dPaymentSuccess) {
                    debitCardPayment.displayCompletePayment();
                    return true;
                } else {
                    System.out.println("Payment failed.");
                    return false;
                }
                break;
            case 3:
                Payment onlinePayment = new OnlinePayment();
                boolean oPaymentSuccess = onlinePayment.processPayment(amount);
                if (oPaymentSuccess) {
                    onlinePayment.displayCompletePayment();
                    return true;
                } else {
                    System.out.println("Payment failed.");
                    return false;
                }
                break;
        }
        OrderItem.setStatus(OrderStatus.PREPARING);
        return true;
    }
    
    public List<String> getPaymentMethod(){
        return paymentMethodsList;
    }
    
    private static double calculate(Order OrderItem){
        double amount = 0;
        for(OrderEntry oe : OrderItem.getMenuItem()){
            amount += oe.getQuantity() * oe.getFood().getPrice();
        }
        return amount;
    }
} 

