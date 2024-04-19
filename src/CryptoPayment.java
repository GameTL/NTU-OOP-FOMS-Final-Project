package src;

/**
 * Concrete implementation of the {@link Payment} abstract class for handling cryptocurrency payments.
 * This class processes payments made via cryptocurrency and displays appropriate messages to confirm the payment processing.
 * @author Shuya Yamazaki  Created at 6/4/24 Email : @author shuya.yamazaki1223@gmail.com
 * @version 1.00.00
 */
public class CryptoPayment extends Payment {
    private static final long serialVersionUID = 14L;

    /**
     * Processes a payment using cryptocurrency for a specified amount.
     * This method simulates the processing of a cryptocurrency transaction by outputting the transaction details to the console.
     * 
     * @param amount The amount of money to process for the payment.
     * @return true always, indicating that the payment was processed successfully.
     */
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing crypto payment...");
        System.out.printf("Amount: $%.2f\n", amount);
        return true;
    }

    /**
     * Displays a message to confirm the authorization and completion of the cryptocurrency payment.
     * This method provides user feedback indicating that the cryptocurrency payment has been authorized and completed.
     */
    @Override
    public void displayCompletePayment() {
        System.out.println("Payment authorized.");
        System.out.println("Payment complete.");
    }
}
