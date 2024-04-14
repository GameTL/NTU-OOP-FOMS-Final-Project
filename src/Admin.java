import java.util.List;

public class Admin extends User {

    public Admin(String id, String name, String contactInfo) {
        super(id, name, contactInfo);
    }

    // Consolidated method for managing staff accounts (add, edit, remove)
    public void manageStaff(String action, List<Staff> staffList, Staff staff, String newName, String newContactInfo, String newRole, String newBranch) {
        switch (action) {
            case "add":
                staff.setBranch(newBranch); // Set branch when adding new staff
                staffList.add(staff);
                System.out.println("Staff added: " + staff.getName() + " to branch " + newBranch);
                break;
            case "edit":
                staff.setName(newName);
                staff.setContactInfo(newContactInfo);
                staff.setRole(newRole);
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

    // Consolidated method for managing payment methods (add, remove)
    public void managePaymentMethod(String action, List<String> paymentMethods, String method) {
        switch (action) {
            case "add":
                if (!paymentMethods.contains(method)) {
                    paymentMethods.add(method);
                    System.out.println("Payment method added: " + method);
                } else {
                    System.out.println("Payment method already exists.");
                }
                break;
            case "remove":
                if (paymentMethods.remove(method)) {
                    System.out.println("Payment method removed: " + method);
                } else {
                    System.out.println("Payment method not found.");
                }
                break;
            default:
                System.out.println("Invalid action for managePaymentMethod");
        }
    }

    // Consolidated method for managing branches (open, close)
    public void manageBranch(String action, List<Branch> branches, Branch branch) {
        switch (action) {
            case "open":
                branches.add(branch);
                System.out.println("Branch opened: " + branch.getName());
                break;
            case "close":
                branches.remove(branch);
                System.out.println("Branch closed: " + branch.getName());
                break;
            default:
                System.out.println("Invalid action for manageBranch");
        }
    }
    
 // Display staff list with filters: branch, role
    public void displayStaffList(List<Staff> staffList, String branch, String role) {
        staffList.stream()
                .filter(staff -> (branch == null || staff.getBranch().equals(branch)) &&
                        (role == null || staff.getRole().equals(role)))
                .forEach(System.out::println);
    }

    // Promote a staff to Manager
    public void promoteToManager(List<Staff> staffList, Staff staff, List<Manager> managerList, String branch) {
        if (staffList.remove(staff)) {
            Manager newManager = new Manager(staff.getId(), staff.getName(), staff.getContactInfo(), "Manager", branch); // Pass branch to Manager constructor
            managerList.add(newManager);
            System.out.println("Staff promoted to Manager: " + newManager.getName() + " in branch " + branch);
        } else {
            System.out.println("Staff not found.");
        }
    }

    // Transfer a staff or manager among branches
    public void transferStaff(Staff staff, String newBranch) {
        staff.setBranch(newBranch); // Use the setBranch method to update the branch
        System.out.println("Staff/Manager transferred: " + staff.getName() + " to branch " + newBranch);
    }

}