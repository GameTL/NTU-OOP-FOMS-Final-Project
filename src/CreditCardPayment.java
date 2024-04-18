package src;

public class CreditCardPayment extends Payment {
    private static final long serialVersionUID = 13L;

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing credit card payment...");
        System.out.printf("Amount: $%.2f\n", amount);
        return true;
    }

    @Override
    public void displayCompletePayment() {
        System.out.println("Payment authorized.");
        System.out.println("Payment complete.");
    }
}

