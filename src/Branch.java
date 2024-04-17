package src;

import java.util.ArrayList;
import java.util.List;

public class Branch{
    private String branchName;
    private int numOfStaff;
    private Menu branchMenu;
    private List<BranchManager> branchManagerMembers;
    private List<Staff> staffMembers;
    private Boolean available;

    public Branch(String branchName){
        this.branchName = branchName;
        this.branchMenu = new Menu();
        this.staffMembers = new ArrayList<>();
        this.branchManagerMembers = new ArrayList<>();
        this.available = true;
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

    public Menu getBranchMenu() {
        return branchMenu;
    }

    public void setBranchMenu(Menu branchMenu) {
        this.branchMenu = branchMenu;
    }

    public List<Staff> getStaffMembers() {
        return staffMembers;
    }

    public void setStaffMembers(List<Staff> staffMembers) {
        this.staffMembers = staffMembers;
    }

    public List<BranchManager> getbranchManagerMembers() {
        return branchManagerMembers;
    }

    public void setBranchManagerMembers(List<BranchManager> branchManagerMembers) {
        this.branchManagerMembers = branchManagerMembers;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    public void displayCurrentOrder() {
        this.branchMenu.displayMenu(this);
    }

    // public void displayCurrentOrder(Menu menu) {
    //     menu.displayMenu(this);
    // }
}