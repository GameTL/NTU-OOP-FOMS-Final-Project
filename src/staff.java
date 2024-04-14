package src;

import java.util.List;
import java.util.Scanner;

public class Staff extends User {
    protected String role;
    protected String branch; 

    public Staff(String id, String name, String contactInfo, String role, String branch) {
        super(id, name, contactInfo);
        this.role = role;
        this.branch = branch; 
    }

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

    private Order getOrderById(int orderID, Branch branch){
        for (Order order : orders) {
            if (order.getOrderId().equals(orderID) && order.getBranch().equals(branch.getBranchName())) {
                return order;
            }
        }
        return null;
    }

    public void displayNewOrders(Branch branch) {
        for (Order order : orders) {
            if (order.getBranch().equals(branch.getBranchName()) && order.getStatus().equals("New")){
                System.out.println(order.getOrderId);
            }
        }
    }
    public void viewOrderDetails(Branch branch){
        displayNewOrders(branch);   
        System.out.println("Please enter OrderID to view order: ");
        int orderID = scanner.nextInt();
        Order customerOrder = getOrderById(orderID, branch); //getting the customer's order
        if (customerOrder == null){
            System.out.print("Order does not exist.");
            return;
        }
    }
//     public byte[] getHash(String input) throws NoSuchAlgorithmException {
// //        String input = "Hello, world!";

//         // get an instance of the SHA-256 message digest algorithm
//         MessageDigest md = MessageDigest.getInstance("SHA-256");

//         // compute the hash of the input string
//         byte[] hash = md.digest(input.getBytes());

//         // convert the hash to a hexadecimal string
// //        StringBuilder hexString = new StringBuilder();
// //        for (byte b : hash) {
// //            hexString.append(String.format("%02x", b));
// //        }
// //
// //        // print the hash
// //        System.out.println(hexString);

//         return hash;
//     }
}
