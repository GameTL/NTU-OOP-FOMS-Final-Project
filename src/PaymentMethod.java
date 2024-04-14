package src;

import java.util.List;
import java.util.Scanner;

public class PaymentMethod {
	private static List<String> paymentMethodsList;
	
    public enum PaymentMethod {CREDIT_CARD,CASH,PAYPAL,PAYNOW}

    /*
    * Returns 1 if payment successful.
    *
    *
    * */
    public static boolean processPayment(Order OrderItem) {
        Scanner sc = new Scanner(System.in);
        if(OrderItem == null){
            System.out.println("Error: Order Not Assigned. Exiting...");
        }

        double amount = calculate(OrderItem);
        System.out.println("Due Amount: S$ "+String.format("%.2f",amount));
        System.out.println("All possible payment method are:");
        for (int i = 0; i < PaymentMethod.values().length; i++) {
            System.out.println((i+1)+" ："+PaymentMethod.values()[i]);
        }
        System.out.println("-----------------------------------\nPlease enter your choice:\n Enter -1 to cancel payment.");
        switch (sc.nextInt()){
            default:
                return false;
            case 1:
                System.out.println("Payment Through Credit Card...Authorizing...Completed");
                break;
            case 2:
                System.out.println("Cash Payment.Please Proceed to Counter for Payment.");
                break;
            case 3:
                System.out.println("Payment Through Paypal...Please login in...Completed");
                break;
            case 4:
                System.out.println("Payment Through Paynow...Please scan the QR Code...Completed");
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
