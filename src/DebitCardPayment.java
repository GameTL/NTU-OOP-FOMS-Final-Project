package src;

/**
 * Concrete implementation of the {@link Payment} abstract class for handling debit card payments.
 * This class processes payments made via debit cards and displays appropriate messages to confirm the payment processing.
 * @author Abirami Selvaraj  Created at 12/4/24 Email : @author abiramis2210@gmail.com
 * @version 1.00.00
 */
public class DebitCardPayment extends Payment {
    private static final long serialVersionUID = 15L;

    /**
     * Processes a payment using a debit card for a specified amount.
     * This method simulates the processing of a debit card transaction by outputting the transaction details to the console.
     * 
     * @param amount The amount of money to process for the payment.
     * @return true always, indicating that the payment was processed successfully.
     */
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing debit card payment...");
        System.out.printf("Amount: $%.2f\n", amount);
        return true;
    }

    /**
     * Displays a message to confirm the authorization and completion of the debit card payment.
     * This method provides user feedback indicating that the debit card payment has been authorized and completed.
     */
    @Override
    public void displayCompletePayment() {
        System.out.println("Payment authorized.");
        System.out.println("Payment complete.");
    }
}
