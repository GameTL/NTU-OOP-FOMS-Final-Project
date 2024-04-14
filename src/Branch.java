package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Branch{
    private String branchName;
    private int numOfStaff;
    private List<MenuItem> branchMenu;
    private List<staff> staffMembers;
    private Boolean available;

    public Branch(String branchName){
        this.branchName = branchName;
        this.branchMenu = new ArrayList<>();
        this.staffMembers = new ArrayList<>();
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

    public List<MenuItem> getBranchMenu() {
        return branchMenu;
    }

    public void setBranchMenu(List<MenuItem> branchMenu) {
        this.branchMenu = branchMenu;
    }

    public List<staff> getStaffMembers() {
        return staffMembers;
    }

    public void setStaffMembers(List<staff> staffMembers) {
        this.staffMembers = staffMembers;
    }

    public List<Manager> getManagers() {
        return managers;
    }

    public void setManagers(List<Manager> managers) {
        this.managers = managers;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    public void manageStaff() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                    -------------------------------
                    Staff Management
                    (1) Add staff member
                    (2) Remove staff member

                    (0) back
                    (-1) exit
                    -------------------------------""");
        int manageChoice = sc.nextInt();
        switch (manageChoice) {
            case 1:
                addStaff();
                break;
            case 2:
                removeStaff();
                break;
            case 0:
                break;
            case -1:
                System.out.println("Program terminating ....");
                System.exit(0);
        }
    }

    public void displayBranchMenu(Menu menu) {
        menu.displayMenu(this);
    }
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

