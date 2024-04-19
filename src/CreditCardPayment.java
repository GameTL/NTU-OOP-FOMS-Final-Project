package src;

/**
 * Concrete implementation of the {@link Payment} abstract class for handling credit card payments.
 * This class processes payments made via credit card and displays appropriate messages to confirm the payment processing.
 * @author Abirami Selvaraj  Created at 12/4/24 Email : @author abiramis2210@gmail.com
 * @version 1.00.00
 */
public class CreditCardPayment extends Payment {
    private static final long serialVersionUID = 13L;

    /**
     * Processes a payment using a credit card for a specified amount.
     * This method simulates the processing of a credit card transaction by outputting the transaction details to the console.
     * 
     * @param amount The amount of money to process for the payment.
     * @return true always, indicating that the payment was processed successfully.
     */
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing credit card payment...");
        System.out.printf("Amount: $%.2f\n", amount);
        return true;
    }

    /**
     * Displays a message to confirm the authorization and completion of the credit card payment.
     * This method provides user feedback indicating that the credit card payment has been authorized and completed.
     */
    @Override
    public void displayCompletePayment() {
        System.out.println("Payment authorized.");
        System.out.println("Payment complete.");
    }
}
