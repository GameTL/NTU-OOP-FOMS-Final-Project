package src;

import java.util.Scanner;
import java.util.List;

/**
 * Represents a staff member in a system. Extends the {@link User} class.
 * Each staff member has specific attributes such as branch, gender, age, and a password for system access.
 * 
 * @author Game Limsila  Created at 26/3/24 Email : @author limsila.limsila@yahoo.com
 * @version 1.00.00
 */
public class Staff extends User {
    private static final long serialVersionUID = 11L;

    private String branch;
    private Gender gender;
    private Integer age;
    private String password;
    private Scanner sc = new Scanner(System.in);

    /**
     * Constructs a new staff member with specified details.
     * @param id The unique identifier for the staff member.
     * @param name The name of the staff member.
     * @param gender The gender of the staff member.
     * @param age The age of the staff member.
     * @param branch The branch the staff member is associated with.
     */
    public Staff(String id, String name, Gender gender, Integer age, String branch) {
        super(id, name);
        this.branch = branch;
        this.gender = gender;
        this.age = age;
        this.password = "password";
    }

    /**
     * Gets the branch of the staff member.
     * @return The branch this staff member is associated with.
     */
    public String getBranch() {
        return branch;
    }

    /**
     * Sets the branch of the staff member.
     * @param branch The new branch for this staff member.
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * Gets the gender of the staff member.
     * @return The gender of the staff member.
     */
    public Gender getGender() {
        return this.gender;
    }

    /**
     * Sets the gender of the staff member.
     * @param gender The new gender of this staff member.
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Gets the age of the staff member.
     * @return The age of the staff member.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the staff member.
     * @param age The new age of this staff member.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Processes an order and sets its status to Ready For Pickup.
     * @param order The order to be processed.
     */
    public void processOrder(Order order) {
        order.setStatus(Order.Status.ReadyForPickup);
        System.out.println("Order processed.");
    }

    /**
     * Changes the password of the staff member.
     * @param newPassword The new password for this staff member.
     */
    public void setPassword(String newPassword){
        this.password = newPassword;
    }

    /**
     * Checks if the provided password matches the staff member's password.
     * @param inputPassword The password to check.
     * @return true if the password matches, false otherwise.
     */
    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    /**
     * Attempts to login a staff member from a list based on user ID and password.
     * @param staffList The list of staff members.
     * @param userId The user ID of the staff member trying to log in.
     * @param inputPassword The password provided for login.
     * @return The logged-in staff member if credentials match, null otherwise.
     */
    public static User loginStaff(List<Staff> staffList, String userId, String inputPassword) {
        for (Staff staff : staffList) {
            if (staff.getId().equals(userId) && staff.checkPassword(inputPassword)) {
                return staff;  // Login successful
            }
        }
        System.out.println("Login failed");
        return null; // Login failed, no matching credentials
    }
}
