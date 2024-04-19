package src;

public class OnlinePayment extends Payment {
    private static final long serialVersionUID = 16L;

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing online payment...");
        System.out.printf("Amount: $%.2f\n", amount);
        return true;
    }

    @Override
    public void displayCompletePayment() {
        System.out.println("Payment authorized.");
        System.out.println("Payment complete.");
    }
}
