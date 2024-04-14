import java.util.List;

public class Staff extends User {
    protected String role;
    protected String branch; 

    public Staff(String id, String name, String contactInfo, String role, String branch) {
        super(id, name, contactInfo);
        this.role = role;
        this.branch = branch; 
    }

    // Getter and Setter for role
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    // Getter and Setter for branch
    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }

    public void processOrder(Order order) {
        // Implementation to process the order
        order.setStatus("Ready to pickup");
        System.out.println("Order processed.");
    }

    public void displayNewOrders(List<Order> orders) {
        // Implementation to display new orders
        for (Order order : orders) {
            if (order.getStatus().equals("New")) {
                System.out.println(order);
            }
        }
    }
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
}
