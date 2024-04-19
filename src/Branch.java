package src;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * Represents a branch in the system, containing staff, managers, orders, and a specific menu.
 * This class handles the operations related to managing branch-related entities like staff and orders.
 * @author Tracey Heso  Created at 14/3/24 Email : @author tracehheso@gmail.com
 * @version 1.00.00
 */
public class Branch implements Serializable {
    private static final long serialVersionUID = 10L;
    private String branchName;
    private Menu branchMenu;
    private List<Staff> staffMembers;
    private List<Manager> managerMembers;
    private List<Order> Orders;
    private Boolean available;

    /**
     * Constructs a new Branch with a given name, initializes the internal structures for managing staff, managers, and orders.
     *
     * @param branchName The name of the branch.
     * @param location The location of the branch (currently not stored).
     * @param staffQuota The staff quota (currently not stored).
     */
    public Branch(String branchName, String location, Integer staffQuota) {
        this.branchName = branchName;
        this.branchMenu = new Menu();
        this.staffMembers = new ArrayList<>();
        this.managerMembers = new ArrayList<>();
        this.Orders = new ArrayList<>();
        this.available = true;
    }

    /**
     * Adds a staff member to the branch.
     *
     * @param staff The staff member to add.
     */
    public void addStaffMember(Staff staff) {
        if (staff != null) {
            this.staffMembers.add(staff);
        }
    }

    /**
     * Removes a staff member from the branch.
     *
     * @param staff The staff member to remove.
     */
    public void removeStaffMember(Staff staff) {
        if (staff != null) {
            this.staffMembers.remove(staff);
        }
    }

    /**
     * Adds a manager to the branch.
     *
     * @param manager The manager to add.
     */
    public void addManager(Manager manager) {
        if (manager != null) {
            this.managerMembers.add(manager);
        }
    }

    /**
     * Gets a list of staff members in the branch.
     *
     * @return A copy of the list of staff members.
     */
    public List<Staff> getStaffMembers() {
        return new ArrayList<>(staffMembers);
    }

    /**
     * Gets a list of managers in the branch.
     *
     * @return A copy of the list of managers.
     */
    public List<Manager> getManagerMembers() {
        return new ArrayList<>(managerMembers);
    }

    /**
     * Gets the name of the branch.
     *
     * @return The name of the branch.
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * Sets the name of the branch.
     *
     * @param branchName The new name of the branch.
     */
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    /**
     * Gets the number of staff members in the branch.
     *
     * @return The number of staff members.
     */
    public int getNumOfStaff() {
        return staffMembers.size();
    }

    /**
     * Gets the menu associated with the branch.
     *
     * @return The branch menu.
     */
    public Menu getBranchMenu() {
        return branchMenu;
    }

    /**
     * Sets the menu for the branch.
     *
     * @param branchMenu The new menu to set.
     */
    public void setBranchMenu(Menu branchMenu) {
        this.branchMenu = branchMenu;
    }

    /**
     * Gets the list of orders placed at the branch.
     *
     * @return The list of orders.
     */
    public List<Order> getOrders() {
        return this.Orders;
    }

    /**
     * Sets the list of orders for the branch.
     *
     * @param orderList The new list of orders to set.
     */
    public void setOrders(List<Order> orderList) {
        Orders = orderList;
    }

    /**
     * Adds an order to the branch.
     *
     * @param order The order to add.
     */
    public void addOrder(Order order) {
        Orders.add(order);
    }

    /**
     * Checks if the branch is available (e.g., open for business).
     *
     * @return True if available, false otherwise.
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Sets the availability of the branch.
     *
     * @param available True to set the branch as available, false to set it as unavailable.
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Prints a formatted list of all staff and managers at the branch, including their roles, genders, and ages.
     */
    public void printStaffAndManagers() {
        System.out.println("Branch: " + this.branchName);
        System.out.printf("%-20s %-10s %-10s %-5s\n", "Name", "Role", "Gender", "Age");
        for (Staff staff : this.staffMembers) {
            System.out.printf("%-20s %-10s %-10s %-5s\n", staff.getName(), "Staff", staff.getGender().toString(), staff.getAge());
        }
        for (Manager manager : this.managerMembers) {
            System.out.printf("%-20s %-10s %-10s %-5s\n", manager.getName(), "Manager", manager.getGender().toString(), manager.getAge());
        }
    }
}
