package src;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.io.Serializable;

public class PaymentRegistry implements Serializable{
    private static final long serialVersionUID = 2L;
    
    private Map<Integer, PaymentMethod> paymentMethods = new LinkedHashMap<>();

    public void registerPaymentMethod(int methodOption, Payment paymentProcessor, String description) {
        paymentMethods.put(methodOption, new PaymentMethod(paymentProcessor, description));
    }

    public void unregisterPaymentMethod(int methodOption) {
        paymentMethods.remove(methodOption);
    }

    public Payment getPaymentMethod(int methodOption) {
        PaymentMethod method = paymentMethods.get(methodOption);
        return (method != null) ? method.getPayment() : null;
    }

    public Set<Map.Entry<Integer, PaymentMethod>> getAllPaymentMethods() {
        return paymentMethods.entrySet();
    }

    public static class PaymentMethod {
        private Payment payment;
        private String description;

        public PaymentMethod(Payment payment, String description) {
            this.payment = payment;
            this.description = description;
        }

        public Payment getPayment() {
            return payment;
        }

        public String getDescription() {
            return description;
        }
    }
}
