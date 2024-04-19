package src;

import java.util.List;

/**
 * Represents an administrator with extended privileges to manage staff, payment methods, and branches.
 * Inherits properties and behaviors from the Staff class.
 * @author Shuya Yamazaki  Created at 6/4/24 Email : @author shuya.yamazaki1223@gmail.com
 * @version 1.00.00
 */
public class Admin extends Staff {

    /**
     * Constructs an Admin with initial settings.
     * @param id The unique identifier for the administrator.
     * @param name The name of the administrator.
     * @param gender The gender of the administrator.
     * @param age The age of the administrator.
     * @param branch The branch the administrator is associated with.
     */
    public Admin(String id, String name, Gender gender, Integer age, String branch) {
        super(id, name, gender, age, branch);
        setPassword("password");
    }

    /**
     * Manages staff accounts by adding, editing, or removing staff members based on the specified action.
     * @param action The management action to perform ("add", "edit", "remove").
     * @param staffList The list of all staff members.
     * @param staff The staff member to manage.
     * @param newName The new name of the staff (used in edit).
     * @param newBranch The new branch for the staff member.
     */
    public void manageStaff(String action, List<Staff> staffList, Staff staff, String newName, String newBranch) {
        switch (action) {
            case "add":
                staff.setBranch(newBranch); // Set branch when adding new staff
                staffList.add(staff);
                System.out.println("Staff added: " + staff.getName() + " to branch " + newBranch);
                break;
            case "edit":
                staff.setName(newName);
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

    /**
     * Manages payment methods by adding or removing them based on the specified action.
     * @param action The management action to perform ("add", "remove").
     * @param methodOption The option number associated with the payment method.
     * @param payment The payment method to manage.
     * @param description A description of the payment method.
     */
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

    /**
     * Manages branches by opening or closing them based on the specified action.
     * @param action The management action to perform ("open", "close").
     * @param branch The branch to manage.
     * @param branchOP The branch operator to handle branch management tasks.
     */
    public void manageBranch(String action, Branch branch, BranchOperator branchOP) {
        switch (action) {
            case "open":
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

    /**
     * Promotes a staff member to a manager position in a specified branch.
     * @param staffList The list of all staff members.
     * @param staff The staff member to promote.
     * @param managerList The list where the new manager will be added.
     * @param branchName The branch where the staff member will be promoted.
     */
    public void promoteToManager(List<Staff> staffList, Staff staff, List<Manager> managerList, String branchName) {
        if (staffList.remove(staff)) {
            Manager newManager = new Manager(staff.getId(), staff.getName(), staff.getGender(), staff.getAge(), branchName);
            managerList.add(newManager);
            System.out.println("Staff promoted to Manager: " + newManager.getName() + " in branch " + branchName);
        } else {
            System.out.println("Staff not found.");
        }
    }

    /**
     * Transfers a staff or manager to a new branch.
     * @param staff The staff member to transfer.
     * @param newBranch The new branch to which the staff member will be transferred.
     */
    public void transferStaff(Staff staff, String newBranch) {
        staff.setBranch(newBranch);
        System.out.println("Staff/Manager transferred: " + staff.getName() + " to branch " + newBranch);
    }

}
