package src;

import java.io.Serializable;

/**
 * Abstract class that defines the structure and necessary actions for different payment methods within the system.
 * This class provides a framework for processing payments and displaying payment completions, which must be implemented by all subclasses.
 * It implements Serializable to enable its subclasses to be serialized for storage or communication purposes.
 * @author Abirami Selvaraj  Created at 9/4/24 Email : @author abiramis2210@gmail.com
 * @version 1.00.00
 */
public abstract class Payment implements Serializable {
    private static final long serialVersionUID = 4L;

    /**
     * Processes a payment for a specified amount. This method is to be implemented by all subclasses to handle
     * the specific details of the payment process depending on the payment type.
     * 
     * @param amount The amount of money to process for the payment.
     * @return true if the payment is processed successfully, false otherwise.
     */
    public abstract boolean processPayment(double amount);

    /**
     * Displays a confirmation message or receipt upon the successful completion of a payment.
     * This method is to be implemented by all subclasses to provide user feedback after processing a payment.
     */
    public abstract void displayCompletePayment();
}
