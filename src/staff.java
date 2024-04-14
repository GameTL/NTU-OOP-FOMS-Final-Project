package src;
import java.security.MessageDigest;

import java.security.NoSuchAlgorithmException;

public class staff {

<<<<<<< Updated upstream
    private final byte[] passHash;

=======
    // Getter and Setter for role
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    // Getter and Setter for branch
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void processOrder(Order order) {
        // Implementation to process the order
        order.setStatus("Ready to pickup");
        System.out.println("Order processed.");
    }

    public void displayNewOrders(List<Order> orders) {
        // Implementation to display new orders according to branch
        for (Order order : orders) {
            if (order.getBranch().equals(branch.getBranchName()) && order.getStatus().equals("New")) {
                System.out.println(order);
            }  
        }
    }
>>>>>>> Stashed changes
    public byte[] getHash(String input) throws NoSuchAlgorithmException {
//        String input = "Hello, world!";

        // get an instance of the SHA-256 message digest algorithm
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // compute the hash of the input string
        byte[] hash = md.digest(input.getBytes());

        // convert the hash to a hexadecimal string
//        StringBuilder hexString = new StringBuilder();
//        for (byte b : hash) {
//            hexString.append(String.format("%02x", b));
//        }
//
//        // print the hash
//        System.out.println(hexString);

        return hash;
    }

    public staff() throws NoSuchAlgorithmException {
        try {
            this.passHash = getHash("password");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


}
