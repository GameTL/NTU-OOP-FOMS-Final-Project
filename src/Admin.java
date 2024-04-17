package src;

import java.util.List;

public class Admin extends User {
    private String password;

    // private PaymentRegistry paymentRegistry;
    // // private BranchManager branchManager;

    public Admin(String id, String name) {
        super(id, name);
        // this.paymentRegistry = paymentRegistry; //TODO
    }

    // Method for managing staff accounts (add, edit, remove)
    public void manageStaff(String action, List<Staff> staffList, Staff staff, String newName, String newRole,
            String newBranch) {
        switch (action) {
            case "add":
                staff.setBranch(newBranch); // Set branch when adding new staff
                staffList.add(staff);
                System.out.println("Staff added: " + staff.getName() + " to branch " + newBranch);
                break;
            case "edit":
                staff.setName(newName);
                // staff.setRole(newRole);
                staff.setBranch(newBranch);
                System.out.println("Staff edited: " + staff.getName() + " in branch " + newBranch);
                break;
            case "remove":
                staffList.remove(staff);
                System.out.println("Staff removed: " + staff.getName());
                break;
            default:
                System.out.println("Invalid action for manageStaff");
        }
    }

    // Method for managing payment methods (add, remove)
    public void managePaymentMethod(String action, int methodOption, Payment payment, String description) {
        PaymentRegistry paymentRegistry = PaymentManager.getPaymentRegistry();
        switch (action) {
            case "add":
                if (paymentRegistry.getPaymentMethod(methodOption) == null) {
                    paymentRegistry.registerPaymentMethod(methodOption, payment, description);
                    System.out.println("Payment method added: " + description);
                } else {
                    System.out.println("Payment method already exists.");
                }
                break;
            case "remove":
                if (paymentRegistry.getPaymentMethod(methodOption) != null) {
                    paymentRegistry.unregisterPaymentMethod(methodOption);
                    System.out.println("Payment method removed: " + description);
                } else {
                    System.out.println("Payment method not found.");
                }
                break;
            default:
                System.out.println("Invalid action for managePaymentMethod");
        }
    }

    // Method for managing branches (open, close)
    public void manageBranch(String action, Branch branch, BranchOperator branchOP) {
        switch (action) {
            case "open":
                // BranchOperator.(branch.getBranchName(),branch);
                branchOP.addOrReplaceBranch(branch.getBranchName(), branch);
                System.out.println("Branch opened: " + branch.getBranchName());
                break;
            case "close":
                branchOP.removeBranch(branch.getBranchName());
                System.out.println("Branch closed: " + branch.getBranchName());
                break;
            default:
                System.out.println("Invalid action for manageBranch");
        }
    }

    // Display staff list with filters: branch, role, gender, age
    // public void displayStaffList(List<Staff> staffList, String branch, String role, String gender, Integer age) {
    //     StaffPrinter.displayStaffList(staffList, branch, role, gender, age);
    // }
    
    // Promote a staff to Manager
    public void promoteToManager(List<Staff> staffList, Staff staff, List<Manager> managerList, String branchName) {
        if (staffList.remove(staff)) {
            // String id, String name, Gender gender, Integer age, String branch
            Manager newManager = new Manager(staff.getId(), staff.getName(), staff.getGender(), staff.getAge(),
                    branchName);
            managerList.add(newManager);
            System.out.println("Staff promoted to Manager: " + newManager.getName() + " in branch " + branchName);
        } else {
            System.out.println("Staff not found.");
        }
    }

    // Transfer a staff or manager among branches
    public void transferStaff(Staff staff, String newBranch) {
        staff.setBranch(newBranch);
        System.out.println("Staff/Manager transferred: " + staff.getName() + " to branch " + newBranch);
    }

}
