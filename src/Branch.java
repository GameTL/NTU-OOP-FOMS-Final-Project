package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public static void main(String[] args) {
        // Create an instance of Menu
        Menu menu = new Menu();
        BranchManager branchManager = new BranchManager();

        // Ask the user to input the chosen branch
        Scanner scanner = new Scanner(System.in);
        System.out.println("         OUR FAST FOOD BRANCHES");
        System.out.println("=========================================");

        List<Branch> branches = branchManager.getBranches();
        for (int i = 0; i < branches.size(); i++) {
            String branchName = branches.get(i).getBranchName();
            System.out.println(String.format("%20s", "(" + (i + 1) + ") " + branchName));
        }
        System.out.println("=========================================");
        int selection = -1;
        while (selection < 1 || selection > branches.size()) {
            System.out.print("Please choose your branch: ");
            if (scanner.hasNextInt()) {
                selection = scanner.nextInt();
                scanner.nextLine();  // Consume newline character
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();  // Clear the invalid input
            }
    }

        Branch selectedBranch = branches.get(selection - 1);
        menu.displayMenu(selectedBranch);
    }
}

