package src;

public class CryptoPayment extends Payment {
    private static final long serialVersionUID = 14L;

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing crypto payment...");
        System.out.printf("Amount: $%.2f\n", amount);
        return true;
    }

    @Override
    public void displayCompletePayment() {
        System.out.println("Payment authorized.");
        System.out.println("Payment complete.");
    }
}

