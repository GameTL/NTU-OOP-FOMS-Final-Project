/* 
* /usr/bin/env /Users/game/Library/Java/JavaVirtualMachines/openjdk-21.0.2/Contents/Home/bin/java -XX:+ShowCodeDetailsInExceptionMessages -cp /Users/game/Library/Application\ Support/Code/User/workspaceStorage/2f5c87283ad91abdee12af6a0051733b/redhat.java/jdt_ws/NTU-OOP-FOMS-Final-Project_ea206817/bin src.fomsApp 
*/

package src;

import java.util.Random;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Set;
import java.util.Map.Entry;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

import src.Order.Status;
// import src.User.Gender;

// import java.util.Map;

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
    // private Order currentOrder = new Order("123", false);

    Menu menu = new Menu();
    private Admin onlyAdmin = new Admin("boss", "Boss", User.Gender.FEMALE, 62, "");
    private PaymentRegistry paymentRegistry = PaymentManager.getPaymentRegistry();
    private static PaymentManager paymentManager = new PaymentManager();
    private static Scanner scanner = new Scanner(System.in);

    public void saveState() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("AppState.ser"))) {
            out.writeObject(branchOP); // First serialize BranchOperator
            out.writeObject(paymentRegistry); // Then serialize PaymentRegistry
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadState() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("AppState.ser"))) {
            branchOP = (BranchOperator) in.readObject(); // First deserialize BranchOperator
            paymentRegistry = (PaymentRegistry) in.readObject(); // Then deserialize PaymentRegistry
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // TO DO Repalce current initializer with the new one & rename current init as
    // setupNewBranches
    // TO DO activate saveState() when exiting for all case -1

    // public void initializer() {
    // File f = new File("AppState.ser");
    // if (f.exists() && !f.isDirectory()) {
    // loadState(); // Load the saved state if it exists
    // } else {
    // setupNewBranches(); // rename current initializer as setupNewBranches()
    // }
    // }

    public void initializer() { // TO DO rename to setupNewBranches()
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

        // for testing
        // for testing
        /*branchOP.getCurrentBranch().addStaffMember(new Staff(
                "s",
                "Mary lee",
                Staff.Gender.FEMALE,
                44,
                "JE"));
        branchOP.getCurrentBranch().addManager(new Manager(
                "m",
                "Alica Ang",
                Manager.Gender.FEMALE,
                27,
                "JE"));*/

    }
    // private //List of Branch

    // Constructor
    public fomsApp() {
        // Initialize the Scanner with System.in as its input stream
        this.sc = new Scanner(System.in);
        initializer();
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void divider() {
        System.out.println("=========================================");
    }

    // Main
    public void userSelector() { // Complete level 2
        int choice;

        clearConsole();
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

    // >Staff
    public void adminHome() { // Complete level 1
        int choice;
    boolean exit = false; // Control flag for loop exit
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

    private boolean canChangeStaff(Branch branch, int delta) {
        int currentStaffCount = branch.getStaffMembers().size();
        int currentManagerCount = branch.getManagerMembers().size();
        int newStaffCount = currentStaffCount + delta;

        return (newStaffCount <= 4 && currentManagerCount >= 1) ||
                (newStaffCount <= 8 && currentManagerCount >= 2) ||
                (newStaffCount <= 15 && currentManagerCount >= 3) ||
                (currentManagerCount >= (newStaffCount / 5));
    }

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
                                                // exist
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

    public void staffLogin() {
        divider();
        System.out.println("""
                          Staff Login
                Username:""");
        String username = sc.next();
        // System.out.println("Entered username: " + username);
        System.out.println("""
                Password:""");
        String password = sc.next();
        // System.out.println("Entered password: " + password);
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

    // change password and save
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
                    case 2:
                        selectedOrder.setStatus(Status.ReadyForPickup);
                    case 3:
                        selectedOrder.setStatus(Status.Completed);
                    case 4:
                        selectedOrder.setStatus(Status.Cancelled);
                    case 5:
                        selectedOrder.setTakeaway(true);
                    case 6:
                        selectedOrder.setTakeaway(false);
                }
                clearConsole();
            } else {
                break;
            }
        } while (true);

    }

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
    public boolean paymentGateway(Order order) { // updated by shuya
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

    private static void displayPaymentMethods() {
        System.out.println("Available Payment Methods:");
        System.out.println("=========================================");
        PaymentManager.getPaymentRegistry().getAllPaymentMethods().forEach(entry -> {
            System.out.println("(" + entry.getKey() + ") " + entry.getValue().getDescription());
        });
        System.out.println("=========================================");
        System.out.println("Enter -1 to cancel payment.");
    }

    public void displayStaff() { // Complete level 1
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
        System.out.printf("%-10s %-20s %-15s \n", "ID", "Name", "Role"); // Adjust headers as
                                                                         // needed
        for (Staff staff : staffList) {
            System.out.printf("%-10s %-20s %-15s \n",
                    staff.getId(),
                    staff.getName()); // Make sure these methods exist in your Staff class
        }
        divider();
    }

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

    private void removePaymentMethod() {
        System.out.println("Enter payment method ID to remove:");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Removing payment method...");
        onlyAdmin.managePaymentMethod("remove", id, null, "");
    }

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
        // System.out.println(branchOP.getCurrentBranch().getManagerMembers());
        for (Manager manager : branchOP.getCurrentBranch().getManagerMembers()) {
            System.out.printf("%-20s %-10s %-10s %-5s\n",
                    manager.getName(),
                    "Manager", manager.getGender().toString(),
                    manager.getAge());
        }

    }

    // >BranchManager
    public void ManagerHome() { // Complete level 1
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

    

    public void editMenu() {
        int choice;
        if (currentUser instanceof Manager) {
            // Manager manager = (Manager) currentUser;
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

    public void displayBranchStaff() { // Complete level 1
        Branch selectedBranch = ApplicationState.getCurrentBranch();
        int choice;
        List<Staff> staffMembers = selectedBranch.getStaffMembers();
        do {
            if (staffMembers.isEmpty()) {
                System.out.println("No staff members in this branch.");
            } else {
                System.out.println("-------------------------------");
                System.out.println("    All staff @ this branch");
                for (Staff staff : staffMembers) {
                    System.out.println(staff); // TODO ? do we have a method for this
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

    public void customerBranchSelector() { // Complete level 2
        clearConsole();
        divider();
        System.out.println("           OUR FAST FOOD BRANCHES");
        divider();
        branchOP.listAndSelectBranch();
        clearConsole();
        menuList();

    }

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
        // * Debug
        // System.out.println("i'm here ");
        // System.out.println(branchOP.getCurrentBranch().getOrders());

    }

    public static void main(String[] args) {
        fomsApp app = new fomsApp();
        app.userSelector(); // Call the instance method on the object

    }
};
// cd/ Users/game/GitHub-School/NTU-OOP-FOMS-Final-Project ;
// /usr/bin/env/Users/game/Library/Java/JavaVirtualMachines/openjdk-21.0.2/Contents/Home/bin/java-XX:+ShowCodeDetailsInExceptionMessages
// -cp
// /Users/game/Library/Application\Support/Code/User/workspaceStorage/2f5c87283ad91abdee12af6a0051733b/redhat.java/jdt_ws/NTU-OOP-FOMS-Final-Project_ea206817/binsrc.fomsApp