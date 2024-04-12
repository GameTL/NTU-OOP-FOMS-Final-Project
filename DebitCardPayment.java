public class DebitCardPayment implements Payment{
    public boolean processPayment(double amount){
        System.out.println("Processing online payment...");
        System.out.println("Amount: $" + amount);
        return true;
    }
    public void displayCompletePayment(){
        System.out.println("Payment authorized.");
        System.out.println("Payment complete.");
    }
}

