package src;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.io.Serializable;

/**
 * Manages the registration and unregistration of different payment methods in the system.
 * This class stores payment methods using a unique integer identifier and provides methods
 * to add, remove, and retrieve payment methods.
 * @author Shuya Yamazaki  Created at 6/4/24 Email : @author shuya.yamazaki1223@gmail.com
 * @version 1.00.00
 */
public class PaymentRegistry implements Serializable {
    private static final long serialVersionUID = 2L;

    private Map<Integer, PaymentMethod> paymentMethods = new LinkedHashMap<>();

    /**
     * Registers a payment method with an associated option number and description.
     * If a payment method already exists with the same option number, it will be replaced.
     *
     * @param methodOption The option number to register the payment method under.
     * @param paymentProcessor The payment processor to handle payments of this method.
     * @param description A description of the payment method.
     */
    public void registerPaymentMethod(int methodOption, Payment paymentProcessor, String description) {
        paymentMethods.put(methodOption, new PaymentMethod(paymentProcessor, description));
    }

    /**
     * Unregisters a payment method associated with the given option number.
     *
     * @param methodOption The option number of the payment method to unregister.
     */
    public void unregisterPaymentMethod(int methodOption) {
        paymentMethods.remove(methodOption);
    }

    /**
     * Retrieves the payment processor associated with a given option number.
     * 
     * @param methodOption The option number of the payment method to retrieve.
     * @return The payment processor if available, null if no method is registered under that option number.
     */
    public Payment getPaymentMethod(int methodOption) {
        PaymentMethod method = paymentMethods.get(methodOption);
        return (method != null) ? method.getPayment() : null;
    }

    /**
     * Returns a set of all registered payment methods along with their option numbers.
     * 
     * @return A set of entries, each representing a payment method along with its option number.
     */
    public Set<Map.Entry<Integer, PaymentMethod>> getAllPaymentMethods() {
        return paymentMethods.entrySet();
    }

    /**
     * Represents a payment method within the registry, including the payment processor and its description.
     */
    public static class PaymentMethod {
        private Payment payment;
        private String description;

        /**
         * Constructs a new PaymentMethod with a specified payment processor and description.
         * 
         * @param payment The payment processor associated with this method.
         * @param description The description of the payment method.
         */
        public PaymentMethod(Payment payment, String description) {
            this.payment = payment;
            this.description = description;
        }

        /**
         * Returns the payment processor of this payment method.
         * 
         * @return The payment processor.
         */
        public Payment getPayment() {
            return payment;
        }

        /**
         * Returns the description of this payment method.
         * 
         * @return The description of the payment method.
         */
        public String getDescription() {
            return description;
        }
    }
}
