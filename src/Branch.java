package src;

import java.util.ArrayList;
import java.util.List;

public class Branch{
    private String branchName;
    private int numOfStaff;
    private List<Menu> branchMenu;
    private List<staff> staffMembers;
    private List<Manager> managers;
    private Boolean availibility;

    public Branch(String branchName, int numOfStaff){
        this.branchName = branchName;
        this.numOfStaff = numOfStaff;
        this.branchMenu = new ArrayList<>();
        this.staffMembers = new ArrayList<>();
        this.managers = new ArrayList<>();
        this.availibility = true;
    }
    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public int getNumOfStaff() {
        return numOfStaff;
    }

    public void setNumOfStaff(int numOfStaff) {
        this.numOfStaff = numOfStaff;
    }

    public List<FoodItem> getBranchMenu() {
        return branchMenu;
    }

    public void setBranchMenu(List<FoodItem> branchMenu) {
        this.branchMenu = branchMenu;
    }

    public List<Staff> getStaffMembers() {
        return staffMembers;
    }

    public void setStaffMembers(List<Staff> staffMembers) {
        this.staffMembers = staffMembers;
    }

    public List<Manager> getManagers() {
        return managers;
    }

    public void setManagers(List<Manager> managers) {
        this.managers = managers;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
    public void manageStaff() {
        // TO DO: have options (1) Add staff (2) Kick Staff 
    }

    public void displayMenu(Menu menu) {
        // TO DO: ask for branch
    }
}
//Branch to initialize the menu and staff 
