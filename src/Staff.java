package src;

import java.util.Scanner;
import java.util.List;
public class Staff extends User {

    // private String role;
    private String branch;
    private Gender gender;
    private Role role;
    private Integer age;
    private String password;

    Scanner sc = new Scanner(System.in);

    public Staff(String id, String name, Gender gender, Integer age, String branch) {
        super(id, name);
        // this.role = role;
        this.branch = branch;
        this.gender = gender;
        this.age = age;
        this.password = "1";
    }

    // Getter and Setter for role
    // public String getRole() {
    // return role;
    // }
    // public void setRole(String role) {
    // this.role = role;
    // }

    // Getter and Setter for branch
    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    // Getter and Setter for gender
    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    // Getter and Setter for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void processOrder(Order order) {
        // Implementation to process the order
        order.setStatus(Order.Status.ReadyForPickup);
        System.out.println("Order processed.");
    }

    public void viewOrderDetails() {
        System.out.println("Enter OrderID to view order: ");
        int orderID = sc.nextInt();
    }

    // password check method
    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    // Method to handle login based on user ID and password
    public static User loginStaff(List<Staff> staffList, String userId, String inputPassword) {
        for (Staff staff : staffList) {
            if (staff.getId().equals(userId) && staff.checkPassword(inputPassword)) {
                return staff;  // Login successful
            }
        }
        System.out.println("Login failed");
        return null; // Login failed, no matching credentials
    }



    // public byte[] getHash(String input) throws NoSuchAlgorithmException {
    // // String input = "Hello, world!";

    // // get an instance of the SHA-256 messsage digest algorithm
    // MessageDigest md = MessageDigest.getInstance("SHA-256");

    // // compute the hash of the input string
    // byte[] hash = md.digest(input.getBytes());

    // // convert the hash to a hexadecimal string
    // // StringBuilder hexString = new StringBuilder();
    // // for (byte b : hash) {
    // // hexString.append(String.format("%02x", b));
    // // }
    // //
    // // // print the hash
    // // System.out.println(hexString);

    // }
    // // }
    // //
    // // // print the hash
    // // System.out.println(hexString);

    // return hash;
    // }

    public String getContactInfo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getContactInfo'");
    }
}
