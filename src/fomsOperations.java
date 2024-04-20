package src;

/**
 * Defines the operations available in the Food Order Management System (FOMS).
 * This interface outlines the main functionalities for different types of users including staff, admins, branch managers, and customers.
 */
public interface fomsOperations {

    /**
     * Presents the main user selection interface, allowing users to identify themselves and navigate to their specific functionalities.
     */
    public abstract void userSelector();

    // Staff-related operations //

    /**
     * Displays the home interface for admin users with options for managing the system and user activities.
     */
    public abstract void adminHome();

    /**
     * Handles the login procedure for staff members.
     */
    public abstract void staffLogin();

    /**
     * Displays the home interface for staff users, showing available actions and information relevant to staff.
     */
    public abstract void staffHome();

    /**
     * Displays the current orders assigned to the staff member that are pending completion.
     */
    public abstract void displayStaffCurrentOrder();

    // Admin-specific operations //

    /**
     * Provides functionality for editing staff member details such as roles or personal information.
     */
    public abstract void editStaff();

    /**
     * Displays all staff members, typically for administrative purposes such as management or review.
     */
    public abstract void displayStaff();

    /**
     * Allows admins to edit and configure payment methods and settings.
     */
    public abstract void editPayment();

    /**
     * Provides the ability to open or close branches, adjusting their operational status.
     */
    public abstract void openCloseBranch();

    /**
     * Enables the promotion of staff members to higher roles, such as promoting a staff member to a manager.
     */
    public abstract void promoteStaff();

    // Branch Manager operations //

    /**
     * Displays the home interface for branch managers with managerial functionalities.
     */
    public abstract void ManagerHome();

    /**
     * Provides branch managers with the capability to edit the menu for their branch.
     */
    public abstract void editMenu();

    /**
     * Displays all staff members associated with a specific branch.
     */
    public abstract void displayBranchStaff();

    // Customer-related operations //

    /**
     * Displays the branch selection interface for customers, allowing them to choose which branch's menu to view.
     */
    public abstract void customerBranchSelector();

    /**
     * Processes payments for orders, interfacing with external payment systems as necessary.
     *
     * @param order The order for which payment is being processed.
     * @return true if the payment is processed successfully, false otherwise.
     */
    public abstract boolean paymentGateway(Order order);

    /**
     * Lists the menu items available for order, typically within a customer-facing interface.
     */
    public abstract void menuList();

}
