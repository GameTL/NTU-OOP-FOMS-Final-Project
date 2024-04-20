package src;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Set;
import java.util.Map.Entry;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.File;
import src.Order.Status;

/**
 * This Main Class holds global variables used across different classes of our program.
 * It has a main method to run user interactions and mostly interacts with an operator class
 * to store selections made in the program.
 *
 * @author Game Limsila  Created at 26/3/24 Email : @author limsila.limsila@yahoo.com
 * @version 1.00.00
 */
public class fomsApp implements fomsOperations {

    // Declare the Scanner as an instance variable of the class
    /*
     * 1. List of Branch, Admin, CurrentUser
     * 2. Staff, Menu, Order,
     * 3. EditMenu,
     * 
     * init the branch wiht staff, brnachmanger,
     * init with the state of who is using the app.
     * currentUser
     * All branch
     * 
     */
    BranchOperator branchOP = new BranchOperator();
    // Adding branchess

    public int padding = 4;
    private Scanner sc;
    private User currentUser;
    private String currentCustomerId;

    public static List<Order> orderList;

    Menu menu = new Menu();
    private Admin onlyAdmin = new Admin("boss", "Boss", User.Gender.FEMALE, 62, "");
    private PaymentRegistry paymentRegistry = PaymentManager.getPaymentRegistry();
    private static PaymentManager paymentManager = new PaymentManager();
    private transient Scanner scanner = new Scanner(System.in);
    
    /**
     * Restores the transient state of the application after deserialization.
     * This method is automatically called when an object of this class is deserialized,
     * ensuring that the scanner is re-initialized to handle user input after the object is read from the stream.
     *
     * @param ois the {@link ObjectInputStream} from which the object is being read.
     * @throws IOException if an I/O error occurs while reading from the ObjectInputStream.
     * @throws ClassNotFoundException if the class of a serialized object cannot be found.
     */
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject(); // Perform the default deserialization logic
        scanner = new Scanner(System.in); // Re-initialize scanner to handle console input
    }

    /**
     * Saves the current state of the application to a file.
     * This method serializes the main components of the application, such as the branch operator and payment registry,
     * and writes them to "AppState.ser" file. It provides feedback in the console about the success or failure of the operation.
     */
    public void saveState() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("AppState.ser"))) {
            out.writeObject(branchOP);
            out.writeObject(paymentRegistry);
            System.out.println("State saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving state: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Loads the state of the application from a file.
     * This method reads and deserializes the main components of the application from "AppState.ser" file,
     * reestablishing the state of the branch operator and payment registry from the stored data.
     * It provides feedback in the console about the success or failure of the operation.
     */
    public void loadState() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("AppState.ser"))) {
            branchOP = (BranchOperator) in.readObject();
            paymentRegistry = (PaymentRegistry) in.readObject();
            System.out.println("State loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Failed to load state: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Initializes the application with predefined administrative accounts, branch setups, and mock orders.
     * This method sets up three branches each with their respective managers, staff, menu items, and a list of mock orders
     * to simulate a fully operational state at the start of the application.
     * Each branch is configured with:
     *     A unique set of staff members and a manager.
     *     A set of initial menu items.
     * An admin account is also initialized to oversee operations across all branches.
     * This method is typically called at the start of the application to prepare the environment for operation.
     */
    public void initializer() {
        Admin onlyAdmin = new Admin("boss", "Boss", User.Gender.FEMALE, 62, "");
        branchOP.initAdmin(onlyAdmin);
        // Making Mock Orders
        List<Order> mockorderList = new ArrayList<>();
        mockorderList.add(new Order("123", true));
        mockorderList.add(new Order("924875", true));
        mockorderList.add(new Order("0000", true));

        branchOP.addOrReplaceBranch("NTU", new Branch("NTU", "North Spine Plaza", 8));
        branchOP.addOrReplaceBranch("JP", new Branch("JP", "Jurong Point", 15));
        branchOP.addOrReplaceBranch("JE", new Branch("JE", "Jurong East", 11));

        // Initialization for JP branch
        branchOP.setCurrentBranch("JP");
        branchOP.getCurrentBranch().setOrders(mockorderList);
        branchOP.getCurrentBranch().addManager(new Manager(
                "TomC",
                "Tom Chan",
                Manager.Gender.MALE,
                56,
                "JP"));
        branchOP.getCurrentBranch().addStaffMember(new Staff(
                "JustinL",
                "Justin Loh",
                Staff.Gender.MALE,
                49,
                "JP"));
        branchOP.getCurrentBranch().getBranchMenu().addMenuItem(new MenuItem("CAJUN FISH", 5.6, "JP", "Burger"));
        branchOP.getCurrentBranch().getBranchMenu().addMenuItem(new MenuItem("CHICKEN NUGGET", 6.9, "JP", "Side"));

        // Initialization for NTU branch
        branchOP.setCurrentBranch("NTU");
        branchOP.getCurrentBranch().setOrders(mockorderList);
        branchOP.getCurrentBranch().addStaffMember(new Staff(
                "kumarB",
                "Kumar Blackmore",
                Staff.Gender.MALE,
                32,
                "NTU"));
        branchOP.getCurrentBranch().addManager(new Manager(
                "Alexei",
                "Alexei",
                User.Gender.MALE,
                25,
                "NTU"));
        branchOP.getCurrentBranch().getBranchMenu().addMenuItem(new MenuItem("FRIES", 3.2, "NTU", "Side"));
        branchOP.getCurrentBranch().getBranchMenu().addMenuItem(new MenuItem("3PC SET MEAL", 9.9, "NTU", "Set meal"));
        branchOP.getCurrentBranch().getBranchMenu().addMenuItem(new MenuItem("COLE SLAW", 2.7, "NTU", "Side"));
        branchOP.getCurrentBranch().getBranchMenu().addMenuItem(new MenuItem("CHICKEN NUGGET", 6.6, "NTU", "Side"));

        // Initialization for JE branch
        branchOP.setCurrentBranch("JE");
        branchOP.getCurrentBranch().setOrders(mockorderList);
        branchOP.getCurrentBranch().addStaffMember(new Staff(
                "MaryL",
                "Mary lee",
                Staff.Gender.FEMALE,
                44,
                "JE"));
        branchOP.getCurrentBranch().addManager(new Manager(
                "AlicaA",
                "Alica Ang",
                Manager.Gender.FEMALE,
                27,
                "JE"));
        branchOP.getCurrentBranch().getBranchMenu().addMenuItem(new MenuItem("COLE SLAW", 2.7, "JE", "Side"));
        branchOP.getCurrentBranch().getBranchMenu().addMenuItem(new MenuItem("3PC SET MEAL", 10.4, "JE", "Set meal"));
        branchOP.getCurrentBranch().getBranchMenu().addMenuItem(new MenuItem("PEPSI", 2.1, "JE", "Drink"));

    }

    /**
     * Constructs a new {@code fomsApp} instance, initializing the scanner and setting up initial application state.
     * This constructor initializes a new {@code Scanner} to handle console input and calls the {@code initializer} method
     * to set up predefined data for branches, staff, and mock orders.
     */
    public fomsApp() {
        this.sc = new Scanner(System.in);
        initializer();
    }

    /**
     * Clears the console screen to make new information more visible.
     * This method attempts to clear the terminal screen by sending specific control characters
     * that instruct most terminal emulators to clear the screen.
     */
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Prints a divider line in the console to separate sections of output.
     * This method is used throughout the application to enhance readability of console output by
     * adding a consistent visual separator.
     */
    public static void divider() {
        System.out.println("=========================================");
    }

    /**
     * Provides a user interface for selecting the type of user interacting with the system.
     * Users can choose to identify themselves as either a customer or a staff member.
     * Based on their choice, the application will navigate them to the appropriate part of the system
     * to perform tasks specific to their role.
     */
    public void userSelector() { 
        System.out.println(branchOP.getAllStaff());
        System.out.println(branchOP.getBranchMap().values());
        int choice;

        do {
            divider();
            System.out.println("""
                    Are you a customer or a staff?
                    (1) Customer
                    (2) Staff/Manager/Admin

                    (0) back
                    (-1) exit""");
            divider();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Random random = new Random();
                    // Generate a random number between 10000 and 9999
                    String randomID = String.valueOf(10000 + random.nextInt(90000));
                    currentCustomerId = randomID;
                    customerOrderFlow();
                    break;
                case 2:
                    clearConsole();
                    staffLogin();
                    break;
                case 0:
                    break;
                case -1:
                    System.out.println("Saving state and exiting...");
                    // saveState(); // Save the state before exiting
                    System.out.println("Program terminating ....");
                    System.exit(0);
                    break;
            }
        } while (choice < 3);
    }

    // Admin
    /**
     * Provides the administration homepage interface allowing the admin user to manage various aspects of the system.
     * This method presents a menu with several options for the admin user:
     *     Edit staff details
     *     Display all staff
     *     Edit payment methods
     *     Open or close branches
     *     Promote staff members to managers
     *     Change passwords for user accounts
     * Each option leads to a different functionality that allows the admin to manage the system effectively. The user can also exit
     * the menu or log out, at which point the application's state can be saved before termination.
     */
    public void adminHome() { // Complete level 1
        int choice;
    boolean exit = false; 
    do {
        divider();
        System.out.println("""
                            Admin Homepage
                (1) Edit staff
                (2) Display all staff
                (3) Edit payment
                (4) Open/close Branch
                (5) Promote a Staff
                (6) Change password

                (0) back
                (-1) exit""");
        divider();
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                editStaff();
                break;
            case 2:
                displayStaff();
                break;
            case 3:
                editPayment();
                break;
            case 4:
                openCloseBranch();
                break;
            case 5:
                promoteStaff();
                break;
            case 6:
                changeStaffPassword();
                break;
            case 0:
                // Exit loop to go back
                exit = true;
                break;
            case -1:
                System.out.println("Saving state and exiting...");
                // saveState(); // Save the state before exiting
                System.out.println("Program terminating ....");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    } while (!exit);
    }
    
    // Admin
    /**
     * Displays the administration menu for managing staff within the system.
     * This method provides an interface for the admin to add, remove, or edit staff details through a series of menu options.
     * The user navigates through the menu using numeric inputs to select the desired operation:
     *     (1) Add staff - Calls {@code addStaff()} to add a new staff member.
     *     (2) Remove staff - Calls {@code removeStaff()} to remove an existing staff member.
     *     (3) Edit staff details - Calls {@code editStaffDetails()} to modify details of an existing staff member.
     *     (0) Back - Exits the current menu and returns to the previous menu.
     *     (-1) Exit - Terminates the application after saving any changes.
     * Each option is processed through a switch statement, and the method will loop until the user decides to exit by choosing '0' or '-1'.
     */
    public void editStaff() { // Admin page for editing details
        int choice = 0;
        do {
            divider();
            System.out.println("""
                            Admin Homepage
                    (1) Add staff
                    (2) Remove staff
                    (3) Edit staff details

                    (0) back
                    (-1) exit""");
            divider();
            System.out.println("Please enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: // Add staff
                    addStaff();
                    break;
                case 2: // Remove staff
                    removeStaff();
                case 3: // Transfer staff
                    editStaffDetails();
                case 0:
                    break;
                case -1:
                    System.out.println("Saving state and exiting...");
                    // saveState(); // Save the state before exiting
                    System.out.println("Program terminating ....");
                    System.exit(0);
                default:
                    System.out.println("Invald choice. Please choose a valid option.");
            }
        } while (choice != 0);
    }
    /**
     * Evaluates if staff members can be added to or removed from a given branch based on manager-to-staff ratios.
     * This method checks if the proposed change in staff count (either increase or decrease) would keep the branch compliant
     * with predefined staffing ratios.
     *
     * @param branch The branch for which staff changes are being considered.
     * @param delta The net change in the number of staff members (positive for additions, negative for removals).
     * @return {@code true} if the change maintains valid staff-to-manager ratios, {@code false} otherwise.
     */
    private boolean canChangeStaff(Branch branch, int delta) {
        int currentStaffCount = branch.getStaffMembers().size();
        int currentManagerCount = branch.getManagerMembers().size();
        int newStaffCount = currentStaffCount + delta;

        return (newStaffCount <= 4 && currentManagerCount >= 1) ||
                (newStaffCount <= 8 && currentManagerCount >= 2) ||
                (newStaffCount <= 15 && currentManagerCount >= 3) ||
                (currentManagerCount >= (newStaffCount / 5));
    }

    /**
     * Attempts to add a new staff member to a specified branch after validating branch existence and compliance with
     * manager-to-staff ratio rules. It prompts the user for input regarding the new staff's details and, if the
     * addition is valid, adds them to the branch.
     */
    private void addStaff() {
        System.out.print("Enter the branch name: ");
        String branchName = scanner.nextLine();
        Branch branch = branchOP.getBranchMap().get(branchName);

        if (branch == null) {
            System.out.println("Branch does not exist.");
            return;
        }

        // Check if the addition is allowed based on manager-staff ratio rule
        if (!canChangeStaff(branch, 1)) {
            System.out.println("Cannot add staff due to manager-to-staff ratio restrictions.");
            return;
        }

        // Information input for new staff member
        System.out.print("Enter staff name: ");
        String name = scanner.nextLine();

        System.out.print("Enter staff ID: ");
        String chosenID = scanner.nextLine();

        System.out.print("Enter gender (Male/Female/Other): ");
        String genderInput = scanner.nextLine();
        User.Gender gender;
        try {
            gender = User.Gender.valueOf(genderInput.toUpperCase()); // Correctly parsing the enum
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid gender. Please enter Male, Female, or Other.");
            return;
        }

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        Staff newStaff = new Staff(chosenID, name, gender, age, branchName);
        branchOP.getCurrentBranch().addStaffMember(newStaff);
        System.out.println("New staff added successfully.");
        divider();
        System.out.println("Your current staff list @ " + branch.getBranchName());
        divider();

        List<Staff> updatedList = branchOP.getCurrentBranch().getStaffMembers();
        branchOP.printStaffDetails(updatedList, null, null);
        divider();
    }

    /**
     * Provides functionality to remove a staff member from a branch. The method lists all staff members for a given
     * branch and allows the user to select one for removal based on their index. It checks if the branch exists
     * and if there are any staff members to remove.
     */
    private void removeStaff() {
        System.out.print("Enter the branch name: ");
        branchOP.listAndSelectBranch();
        Branch currentBranch = branchOP.getCurrentBranch();

        if (currentBranch == null) {
            System.out.println("Branch does not exist.");
            return;
        }

        List<Staff> initialStaffList = currentBranch.getStaffMembers();
        if (initialStaffList.isEmpty()) {
            System.out.println("No staff members available to remove.");
            return;
        }
        System.out.println("Available Staff Members: ");
        divider();
        branchOP.printStaffDetails(initialStaffList, null, null);
        divider();

        System.out.println("Select the staff member to remove, or type 'done' to cancel.");
        int index = scanner.nextInt();

        if (index > 0 && index <= initialStaffList.size()) {
            Staff staffToBeRemoved = initialStaffList.get(index - 1);
            branchOP.getCurrentBranch().removeStaffMember(staffToBeRemoved);
            System.out.println("Staff member " + staffToBeRemoved.getName() + " removed successfully.");
            divider();
            System.out.println("Updated Staff List");
            divider();
            List<Staff> updatedList = currentBranch.getStaffMembers();
            branchOP.printStaffDetails(updatedList, null, null);
            divider();
        } else if (index == 0) {
            System.out.println("Operation cancelled.");
        } else {
            System.out.println("Invalid index. Please try again.");
        }
    }

    /**
     * Facilitates the filtering and editing of staff details within the system. Users can choose to filter staff
     * by branch and specific attributes such as name, age, gender, or branch. This method allows for dynamic
     * filtering and subsequent modification of staff details based on user input.
     */
    private void editStaffDetails() {
        List<Staff> staffList;
        String filterBranch = null;
        String sortByAttribute = null;
        List<String> filterBranches = new ArrayList<>();

        // Ask if user wants to filter by branch
        System.out.println("Would you like to filter staff by branch? (yes/no):");
        String branchFilterResponse = scanner.nextLine().trim().toLowerCase();

        if ("yes".equals(branchFilterResponse)) {
            System.out.println("Available branches:");
            branchOP.getBranchMap().forEach((name, branch) -> System.out.println(name));
            System.out.print("Enter the branch name to filter by: ");
            filterBranch = scanner.nextLine().trim();
            filterBranches.add(filterBranch);
        }

        // Retrieve staff list based on branch filter
        if (filterBranch != null && branchOP.getBranchMap().containsKey(filterBranch)) {
            staffList = branchOP.getBranchMap().get(filterBranch).getStaffMembers();
            if (staffList.isEmpty()) {
                System.out.println("No staff members available in the selected branch.");
                return;
            }
        } else {
            staffList = branchOP.getAllStaff(); // Get all staff if no branch filter is specified or branch does not
                                          
        }

        // Ask if user would like to filter by attribute
        System.out.println("Would you like to filter staff by specific attributes? (yes/no):");
        String attributeFilterResponse = scanner.nextLine().trim().toLowerCase();

        if ("yes".equals(attributeFilterResponse)) {
            System.out.println("Available attributes to sort by: name, age, gender, branch");
            System.out.print("Enter attribute to sort by: ");
            sortByAttribute = scanner.nextLine().trim();
        }

        // Display and modify staff details using the selected filters
        System.out.println("Displaying staff details...");
        branchOP.printStaffDetails(staffList, filterBranches, sortByAttribute);
        
        System.out.println("Proceeding to modify staff details...");
        branchOP.modifyStaff(staffList);
    }

    /**
     * Manages the login process for staff, managers, and admin users. It prompts for username and password,
     * authenticates against existing staff records, and directs the user to the appropriate home screen based
     * on their role (Manager, Admin, or Staff). If the login credentials do not match, the login process is repeated.
     * The method distinguishes between different types of users and sets up the environment accordingly.
     */
    public void staffLogin() {
        divider();
        System.out.println("""
                          Staff Login
                Username:""");
        String username = sc.next();
        System.out.println("""
                Password:""");
        String password = sc.next();
        currentUser = Staff.loginStaff(branchOP.getAllStaff(), username, password);
        divider();
        if (currentUser != null) {
            if (currentUser instanceof Manager) {
                // Alexei
                Manager currentManager = (Manager) currentUser;
                branchOP.setCurrentBranch(currentManager.getBranch());
                clearConsole();
                System.out.println("Login successful for: " + currentUser.getName() + "(Manager)");
                ManagerHome();
            } else if (currentUser instanceof Admin) {
                // boss
                clearConsole();
                System.out.println("Login successful for: " + currentUser.getName() + "(Admin)");
                adminHome();
            } else if (currentUser instanceof Staff) {
                // kumarB
                Staff currentStaff = (Staff) currentUser;
                branchOP.setCurrentBranch(currentStaff.getBranch());
                clearConsole();
                System.out.println("Login successful for: " + currentUser.getName() + "(Staff)");
                staffHome();
            } else {
                System.out.println("No valid staff type found or login failed");
            }
        } else {
            staffLogin();
        }
    }

    /**
     * Allows staff members to change their password. This method ensures that only staff members can initiate a password
     * change. It requires the user to enter the current password for verification and then input the new password along
     * with a confirmation. If the new password and its confirmation match, and the current password is verified, the
     * password change is processed successfully.
     */
    public void changeStaffPassword() {
        if (currentUser instanceof Staff) {
            Staff staff = (Staff) currentUser;

            System.out.println("Enter your current password:");
            sc.nextLine();
            String oldPassword = sc.nextLine();
            if (!staff.checkPassword(oldPassword)) {
                System.out.println("Password incorrect. Try again.");
                return;
            }

            System.out.println("Enter new password: ");
            String newPassword = sc.nextLine();
            System.out.println("Confirm new password");
            String confirmPassword = sc.nextLine();

            if (newPassword.equals(confirmPassword)) {
                staff.setPassword(newPassword);
                System.out.println("Password changed successfully!");
            } else {
                System.out.println("Passwords do not match. Try again.");
            }
        } else {
            System.out.println("Only staff members can change passwords.");
        }
        clearConsole();
    }

    /**
     * Provides an interactive menu for staff to manage the status of orders within their assigned branch.
     * Staff can view and update order statuses (New, ReadyForPickup, Completed, Cancelled) or toggle the takeaway option.
     * The loop continues until there are no orders to manage or the staff chooses to exit.
     */
    public void displayStaffCurrentOrder() {
        do {

            Order selectedOrder = branchOP.displayOrdersAndSelectForStaff();
            if (selectedOrder != null) {
                // clearConsole();
                System.out.println(
                        "(1) Status:      New\n(2) Status:      ReadyForPickup\n(3) Status:      Completed\n(4) Status:      Cancelled\n(5) Set Takeaway: Takeaway\n(6) Set Takeway:  Dine-In\n\n(0) Back");
                int choice = this.sc.nextInt();
                switch (choice) {
                    case 1:
                        selectedOrder.setStatus(Status.New);
                        break;
                    case 2:
                        selectedOrder.setStatus(Status.ReadyForPickup);
                        break;
                    case 3:
                        selectedOrder.setStatus(Status.Completed);
                        break;
                    case 4:
                        selectedOrder.setStatus(Status.Cancelled);
                        break;
                    case 5:
                        selectedOrder.setTakeaway(true);
                        break;
                    case 6:
                        selectedOrder.setTakeaway(false);
                        break;
                }
                clearConsole();
            } else {
                break;
            }
        } while (true);

    }

    /**
     * Displays the current staff's home page, primarily facilitating order management.
     * This function first ensures that a branch is selected before allowing access to order management.
     */
    public void staffHome() {
        // Showing current orders
        Branch selectedBranch = branchOP.getCurrentBranch();
        if (selectedBranch == null) {
            System.out.println("No branch selected. Please select a branch first.");
            return;
        }

        // do {
        divider();
        displayStaffCurrentOrder();

    }

    // >Admin
    /**
     * Facilitates the payment process for an order.
     * Presents the total amount due, lists available payment methods, and processes the selected payment method.
     * If the user selects to cancel the payment or if an invalid order is passed, the method returns false.
     *
     * @param order The order for which the payment is being processed.
     * @return true if the payment is successfully processed, false if the payment is cancelled or fails.
     */
    public boolean paymentGateway(Order order) { 
        if (order == null) {
            System.out.println("Error: No order to process.");
            return false;
        }

        System.out.println("Your order total is: $" + String.format("%.2f", order.getTotalCost()));
        displayPaymentMethods();

        System.out.println("Please enter your choice of payment method:");
        int paymentChoice = scanner.nextInt();
        clearConsole();

        // Check for cancellation option
        if (paymentChoice == -1) {
            System.out.println("Payment cancelled.");
            return false;
        }
        // Process payment
        return PaymentManager.makePayment(paymentChoice, order);

    }

    /**
     * Displays the available payment methods registered in the payment system.
     * Each payment method is presented with an ID and a description. Users can select a method by entering its ID
     * or cancel the payment process by entering -1.
     */
    private static void displayPaymentMethods() {
        System.out.println("Available Payment Methods:");
        System.out.println("=========================================");
        PaymentManager.getPaymentRegistry().getAllPaymentMethods().forEach(entry -> {
            System.out.println("(" + entry.getKey() + ") " + entry.getValue().getDescription());
        });
        System.out.println("=========================================");
        System.out.println("Enter -1 to cancel payment.");
    }

    /**
     * Displays the list of staff members at the currently selected branch.
     * This method first clears the console, checks if a branch has been selected, and if so, retrieves and lists all staff members.
     * If no branch is selected or if there are no staff members in the selected branch, appropriate messages are displayed.
     */
    public void displayStaff() { 
        clearConsole();
        Branch currentBranch = branchOP.getCurrentBranch();

        if (currentBranch == null) {
            System.out.println("No branch selected. Please select a branch first.");
            return;
        }

        List<Staff> staffList = currentBranch.getStaffMembers();
        if (staffList.isEmpty()) {
            System.out.println("No staff members found in the " + currentBranch.getBranchName() + " branch.");
            return;
        }

        System.out.println("Staff in " + currentBranch.getBranchName() + ":");
        divider();
        System.out.printf("%-10s %-20s\n", "ID", "Name"); // Adjust headers as
                                                                         // needed
        for (Staff staff : staffList) {
            System.out.printf("%-10s %-20s\n",
                    staff.getId(),
                    staff.getName());
        }
        divider();
    }

    /**
     * Provides an interface for editing payment methods. Allows adding or removing payment methods from the system.
     * The method continuously displays options until the user decides to exit. Options include adding a new payment method,
     * removing an existing one, or returning to the previous menu.
     */
    public void editPayment() {
        int choice;

        do {
            System.out.println("----------------------------------------");
            System.out.println("Edit Payment Methods");
            System.out.println("(1) Add Payment Method");
            System.out.println("(2) Remove Payment Method");
            System.out.println("(0) Back");
            System.out.println("(-1) Exit");
            System.out.println("----------------------------------------");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    listExistingPaymentMethods();
                    addPaymentMethod();
                    break;
                case 2:
                    listExistingPaymentMethods();
                    removePaymentMethod();
                    break;
                case 0:
                    return; // go back
                case -1:
                    System.out.println("Saving state and exiting...");
                    // saveState(); // Save the state before exiting
                    System.out.println("Program terminating ....");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);
    }

    /**
     * Lists all existing payment methods available in the payment registry.
     * Displays each payment method's ID and description.
     */
    private void listExistingPaymentMethods() {
        Set<Entry<Integer, PaymentRegistry.PaymentMethod>> methods = paymentRegistry.getAllPaymentMethods();
        if (methods.isEmpty()) {
            System.out.println("No payment methods available.");
        } else {
            System.out.println("Existing Payment Methods:");
            for (Entry<Integer, PaymentRegistry.PaymentMethod> method : methods) {
                System.out.println("ID: " + method.getKey() + ", Description: " + method.getValue().getDescription());
            }
        }
    }

    /**
     * Adds a new payment method to the system based on user input. Requires an ID, a description,
     * and the class name of the payment implementation. The method uses reflection to instantiate
     * the payment class based on its name.
     */
    private void addPaymentMethod() {
        System.out.println("Enter new payment method ID:");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter payment description (e.g., CryptoPayment):");
        String description = sc.nextLine();
        System.out.println("Enter the class name of the new payment method (e.g., CryptoPayment):");
        String className = sc.nextLine();

        try {
            Class<?> cls = Class.forName("src." + className);

            Payment newPayment = (Payment) cls.getDeclaredConstructor().newInstance();
            onlyAdmin.managePaymentMethod("add", id, newPayment, description);
        } catch (Exception e) {
            System.out.println("Failed to add payment method. Error: " + e.getMessage());
        }
    }

    /**
     * Removes a specified payment method from the system using its ID.
     * User must confirm the ID of the payment method they wish to remove.
     */
    private void removePaymentMethod() {
        System.out.println("Enter payment method ID to remove:");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Removing payment method...");
        onlyAdmin.managePaymentMethod("remove", id, null, "");
    }

    /**
     * Provides an interface for opening or closing a branch. 
     * Allows the administrator to toggle the availability of a branch within the system.
     * The method first prompts the user to select a branch, then provides options to either open or close the selected branch.
     * This method ensures that the user can review the current status of the branch before making changes.
     */
    public void openCloseBranch() {
    clearConsole();
    System.out.println("Select the branch to Open or Close");
    branchOP.listAndSelectBranch(); // Assuming this method selects the branch and sets it as current
    int choice;
    boolean exit = false; // Control flag for loop exit

    while (!exit) {
        clearConsole();
        divider();
        System.out.println(branchOP.getCurrentBranch().getBranchName() + "Branch is currently " + (branchOP.getCurrentBranch().isAvailable() ? "OPEN" : "CLOSED"));
        System.out.printf("""
                (1) Open Branch
                (2) Close Branch

                (0) back
                (-1) exit
                """);
        divider();
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                branchOP.getCurrentBranch().setAvailable(true);
                System.out.println("Branch has been closed.");
                openCloseBranch();
                break;
            case 2:
                branchOP.getCurrentBranch().setAvailable(false);
                System.out.println("Branch has been opened.");
                openCloseBranch();
                break;
            case 0:
                exit = true;
                break;
            case -1:
                System.out.println("Saving state and exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }}
        
    }

    /**
     * Facilitates the promotion of a staff member to a managerial position within a selected branch.
     * This method allows the administrator to first select a branch and then choose a staff member from that branch to be promoted.
     * It displays a list of all staff members, allowing the administrator to select one for promotion.
     * Upon selection, the staff member is converted to a manager, and both the staff and manager lists are updated accordingly.
     */
    public void promoteStaff() {
        clearConsole();
        List<Staff> allStaff = new ArrayList<>();
        branchOP.listAndSelectBranch(); // current branch selected
        List<Staff> staffList = branchOP.getCurrentBranch().getStaffMembers();
        int index = 1; // Start index from 1
        for (Staff staff : staffList) {
            System.out.printf("%-5d %-20s %-10s %-10s %-5s\n",
                    index++, // Increment index after printing
                    staff.getName(),
                    "Staff",
                    staff.getGender().toString(),
                    staff.getAge());
        }

        int choice;
        choice = sc.nextInt();
        Staff tempStaff = staffList.get(choice -1);
        Manager newManager = new Manager(tempStaff.getId(), tempStaff.getName(), tempStaff.getGender(), tempStaff.getAge(), tempStaff.getBranch());

        branchOP.getCurrentBranch().removeStaffMember(tempStaff);
        branchOP.getCurrentBranch().addManager(newManager);
        System.out.println("Updated List of Manger in @" + branchOP.getCurrentBranch().getBranchName());
        for (Manager manager : branchOP.getCurrentBranch().getManagerMembers()) {
            System.out.printf("%-20s %-10s %-10s %-5s\n",
                    manager.getName(),
                    "Manager", manager.getGender().toString(),
                    manager.getAge());
        }

    }

    // >BranchManager
    /**
     * Provides the main interface for branch managers within the application.
     * Managers can navigate through various administrative tasks such as viewing and editing current orders,
     * managing staff details, and modifying the branch menu. This method serves as the central hub for all
     * managerial operations, offering choices that lead to specific functionalities for branch management.
     */
    public void ManagerHome() { 
        int choice;
    boolean exit = false; // Control flag for loop exit
    do {
        divider();
        System.out.printf("""
                       Manager Homepage @ %s
                (1) Show and Edit Current Order
                (2) Display Branch Staff
                (3) Edit Branch Menu

                (0) back
                (-1) exit
                """, branchOP.getCurrentBranch().getBranchName());
        divider();
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                clearConsole();
                displayStaffCurrentOrder();
                break;
            case 2:
                clearConsole();
                branchOP.getCurrentBranch().printStaffAndManagers();
                break;
            case 3:
                clearConsole();
                editMenu();
                break;
            case 0:
                // Exit loop to go back
                exit = true;
                break;
            case -1:
                System.out.println("Saving state and exiting...");
                // saveState(); // Save the state before exiting
                System.out.println("Program terminating ....");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    } while (!exit);
    }

    
    /**
     * Provides the menu editing interface for managers of a branch. This method allows managers to add,
     * remove, or update items in the branch's menu. Access is restricted to users with manager privileges.
     * Managers can perform a variety of modifications to ensure the menu reflects current offerings accurately.
     *
     * The method ensures that only authorized managers can make changes to the menu, providing options to
     * add new items, remove existing ones, or update details of menu items such as price or description.
     */
    public void editMenu() {
        int choice;
        if (currentUser instanceof Manager) {
            Branch currentBranch = branchOP.getCurrentBranch();

            do {
                String editOptions = "(1) Add item\n(2) Remove item\n(3) Update item";
                System.out.printf("""
                        -------------------------------
                                Menu Editor for %s
                        %s

                        (0) back
                        (-1) exit
                        -------------------------------
                        \n
                        """, currentBranch.getBranchName(), editOptions);
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        branchOP.addItem(currentBranch.getBranchMenu());
                        break;
                    case 2:
                        branchOP.removeItem(currentBranch.getBranchMenu());
                        break;
                    case 3:
                        branchOP.updateItem(currentBranch.getBranchMenu());
                        break;
                    case 0:
                        break;
                    case -1:
                        System.out.println("Saving state and exiting...");
                        // saveState(); // Save the state before exiting
                        System.out.println("Program terminating ....");
                        System.exit(0);
                        break;

                }
            } while (choice != 0 && choice != -1);
        } else {
            System.out.println("Access Denied: Only managers can edit the menu.");
        }
    }

    /**
     * Displays a list of all staff members within a selected branch. Provides an interface for user interaction where
     * users can view detailed information about each staff member in the branch. Users can navigate back to the previous menu
     * or choose to exit the application from this view.
     */
    public void displayBranchStaff() { // Complete level 1
        Branch selectedBranch = branchOP.getCurrentBranch();
        int choice;
        List<Staff> staffMembers = selectedBranch.getStaffMembers();
        do {
            if (staffMembers.isEmpty()) {
                System.out.println("No staff members in this branch.");
            } else {
                System.out.println("-------------------------------");
                System.out.println("    All staff @ this branch");
                for (Staff staff : staffMembers) {
                    System.out.println(staff); 
                    System.out.println();
                }
                System.out.println("-------------------------------");
                System.out.println("(0) Back");
                System.out.println("(-1) Exit");
            }

            System.out.print("Enter your choice: ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid choice. Please enter a valid option.");
                sc.next();
            }
            choice = sc.nextInt();

            switch (choice) {
                case 0:
                    break;
                case -1:
                    System.out.println("Saving state and exiting...");
                    // saveState(); // Save the state before exiting
                    System.out.println("Program terminating ....");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid number.");
            }
        } while (choice != 0 && choice != -1);
    }

    // >User
    /**
     * Manages the flow for a customer's order interaction. It asks the customer whether they have already placed an order.
     * If they have, it allows them to review and potentially collect their orders by confirming their customer ID.
     * If they have not, it redirects them to the branch selector to place an order. This method ensures that customers can
     * interact with their orders in an organized manner, handling both retrieval of existing orders and the placement of new ones.
     */
    public void customerOrderFlow(){
        System.out.println("Welcome to our Order System!");
        System.out.println("Have you already placed an order? (yes/no):");
        String response = scanner.nextLine().trim().toLowerCase();

        if ("yes".equals(response)) {
            branchOP.listAndSelectBranch(); // Ensure the branch is selected first
    
            System.out.print("Please enter your Customer ID: ");
            String customerId = scanner.nextLine().trim();
    
            List<Order> orders = branchOP.findOrderById(customerId);
    
            if (!orders.isEmpty()) {
                System.out.println("You have the following orders:");
                for (int i = 0; i < orders.size(); i++) {
                    System.out.printf("%d. Order ID: %s, Status: %s\n", i + 1, orders.get(i).getOrderId(), orders.get(i).getStatus());
                }
                System.out.print("Enter the number of the order to collect: ");
                int orderIndex = scanner.nextInt() - 1;
                scanner.nextLine(); // Clear the buffer
    
                if (orderIndex >= 0 && orderIndex < orders.size()) {
                    Order selectedOrder = orders.get(orderIndex);
                    System.out.printf("Your order %s is ready to be collected at %s. Do you want to collect it now? (yes/no): ", selectedOrder.getOrderId(), branchOP.getCurrentBranch().getBranchName());
                    String collect = scanner.nextLine().trim().toLowerCase();
                    if ("yes".equals(collect)) {
                        selectedOrder.setStatus(Order.Status.Completed);
                        System.out.printf("Thank you! Your order status at %s has been updated to Completed.\n", branchOP.getCurrentBranch().getBranchName());
                    } else {
                        System.out.println("You can collect your order later. Thank you!");
                    }
                } else {
                    System.out.println("Invalid order selection.");
                }
            } else {
                System.out.println("No orders found with the Customer ID: " + customerId + " at " + branchOP.getCurrentBranch().getBranchName() + ".");
            }
        } else if ("no".equals(response)) {
            customerBranchSelector();
        } else {
            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
        }
    }

    /**
     * Presents a user interface for customers to select a branch from which they would like to order.
     * Clears the console and displays a list of available branches. Once a branch is selected,
     * the menu list of the selected branch is displayed.
     */
    public void customerBranchSelector() { // Complete level 2
        clearConsole();
        divider();
        System.out.println("           OUR FAST FOOD BRANCHES");
        divider();
        branchOP.listAndSelectBranch();
        clearConsole();
        menuList();

    }

    /**
     * Displays the menu list of the selected branch and allows the customer to create and customize their order.
     * If items are added to the order cart, it prompts the customer for payment.
     * If the payment is successful, the order is added to the branch's list of orders.
     */
    public void menuList() {
        Order OrderCart = new Order(currentCustomerId, false);
        OrderCart = branchOP.displayMenuAndSelect(OrderCart);
        divider();
        clearConsole();
        if (OrderCart.getItems().size() != 0) {
            if (paymentGateway(OrderCart)) {
                branchOP.getCurrentBranch().addOrder(OrderCart);
            }
        }
    }

    /**
     * Main method to start the application. It initializes the application and navigates the user
     * to the appropriate interface based on their role selection.
     *
     * @param args Command line arguments passed to the program.
     */
    public static void main(String[] args) {
        fomsApp app = new fomsApp();
        app.userSelector(); // Call the instance method on the object

    }
};
