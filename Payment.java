package src;
public interface Payment {
	boolean processPayment(double amount);
    void displayCompletePayment();
}