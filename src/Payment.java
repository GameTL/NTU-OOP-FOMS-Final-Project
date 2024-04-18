package src;

import java.io.Serializable;

public abstract class Payment implements Serializable {
    private static final long serialVersionUID = 4L;

    public abstract boolean processPayment(double amount);
    public abstract void displayCompletePayment();
}
