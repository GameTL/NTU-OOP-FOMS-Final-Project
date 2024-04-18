package src;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Branch implements Serializable{
    private static final long serialVersionUID = 10L;
    private String branchName;
    // private int numOfStaff;
    private Menu branchMenu;
    // private List<BranchManager> branchManagerMembers;
    private List<Staff> staffMembers;
    private List<Manager> managerMembers;
    private List<Order> Orders;
    private Boolean available;

    public Branch(String branchName, String location, Integer staffQuota){
        this.branchName = branchName;
        this.branchMenu = new Menu();
        this.staffMembers = new ArrayList<>();
        this.managerMembers = new ArrayList<>(); // Initialize manager lists
        this.Orders = new ArrayList<>();
        this.available = true;

        // Orders.add(new Order("00000", true));
        // Orders.get(0).setStatus(Order.Status.Completed);
    }
    public void addStaffMember(Staff staff) {
        if (staff != null) {
            this.staffMembers.add(staff);
        }
    }
    public void removeStaffMember(Staff staff){
        if (staff != null){
            this.staffMembers.remove(staff);
        }
    }
    public void addManager(Manager manager) {
        if (manager != null) {
            this.managerMembers.add(manager);
        }
    }
    // Get List of staff
    public List<Staff> getStaffMembers() {
        return new ArrayList<>(staffMembers); // Return a copy of the staff list
    }
    
    public List<Manager> getManagerMembers() {
        return new ArrayList<>(managerMembers); // Return a copy of the manager list
    }
    
    public String getBranchName() {
        return branchName;
    }
    
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
    
    public int getNumOfStaff() {
        return staffMembers.size();
    }
    
    public Menu getBranchMenu() {
        return branchMenu;
    }
    
    public void setBranchMenu(Menu branchMenu) {
        this.branchMenu = branchMenu;
    }
    
    public void setStaffMembers(List<Staff> staffMembers) {
        this.staffMembers = staffMembers;
    }
    // Orders
    public List<Order> getOrders() {
        return this.Orders; // DON'T RETURN A COPY DUHHHH
    }
    public void setOrders(List<Order> orderList) {
        Orders = orderList;
    }
    public void addOrder(Order order) {
        Orders.add(order);
    }
    public boolean isAvailable() {
        return available;
    }
    
    public void setAvailable(boolean available) {
        this.available = available;
    }
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