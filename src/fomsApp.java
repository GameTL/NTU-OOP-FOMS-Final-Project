/* 
 * /usr/bin/env /Users/game/Library/Java/JavaVirtualMachines/openjdk-21.0.2/Contents/Home/bin/java -XX:+ShowCodeDetailsInExceptionMessages -cp /Users/game/Library/Application\ Support/Code/User/workspaceStorage/2f5c87283ad91abdee12af6a0051733b/redhat.java/jdt_ws/NTU-OOP-FOMS-Final-Project_ea206817/bin src.fomsApp 
 */

package src;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Set;
import java.util.Map.Entry;

import src.Order.Status;

import java.util.Map;

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

    public static List<Order> orderList;
    private Order currentOrder = new Order("123", false);

    Menu menu = new Menu();
    private Admin onlyAdmin = new Admin("boss", "Boss");
    private PaymentRegistry paymentRegistry = PaymentManager.getPaymentRegistry();
    private static PaymentManager paymentManager = new PaymentManager();
    private static Scanner scanner = new Scanner(System.in);

    public void initializer() {
        List<Order> mockorderList = new ArrayList<>();
        mockorderList.add(new Order("123", true));
        mockorderList.add(new Order("924875", true));
        mockorderList.add(new Order("0000", true));
        branchOP.addOrReplaceBranch("NTU", new Branch("NTU", "North Spine Plaza", 8));
        branchOP.addOrReplaceBranch("JP", new Branch("JP", "Jurong Point", 15));
        branchOP.addOrReplaceBranch("JE", new Branch("JE", "Jurong East", 11));
        // Init for JP
        branchOP.setCurrentBranch("JP");
        branchOP.getCurrentBranch().addManager(new Manager(
                "TomC",
                "Tom Chan",
                Manager.Gender.Male,
                56,
                "JP"));
        branchOP.getCurrentBranch().setOrders(mockorderList);
        branchOP.getCurrentBranch().addStaffMember(new Staff(
                "JustinL",
                "Justin Loh",
                Staff.Gender.Male,
                49,
                "JP"));
        branchOP.getCurrentBranch().setOrders(mockorderList);
        // Init for NTU
        branchOP.setCurrentBranch("NTU");
        branchOP.getCurrentBranch().addStaffMember(new Staff(
                "kumarB",
                "Kumar Blackmore",
                Staff.Gender.Male,
                32,
                "NTU"));
        branchOP.getCurrentBranch().addManager(new Manager(
                "Alexei",
                "Alexei",
                User.Gender.Male,
                25,
                "NTU"));
        branchOP.getCurrentBranch().setOrders(mockorderList);
        // Init for JE
        branchOP.setCurrentBranch("JE");
        branchOP.getCurrentBranch().addStaffMember(new Staff(
                "MaryL",
                "Mary lee",
                Staff.Gender.Female,
                44,
                "JE"));
        branchOP.getCurrentBranch().addManager(new Manager(
                "AlicaA",
                "Alica Ang",
                Manager.Gender.Female,
                27,
                "JE"));
        branchOP.getCurrentBranch().setOrders(mockorderList);

        // for testing
        // for testing
        branchOP.getCurrentBranch().addStaffMember(new Staff(
                "s",
                "Mary lee",
                Staff.Gender.Female,
                44,
                "JE"));
        branchOP.getCurrentBranch().addManager(new Manager(
                "m",
                "Alica Ang",
                Manager.Gender.Female,
                27,
                "JE"));

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
                    (2) Staff

                    (0) back
                    (-1) exit""");
            divider();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    UserBranchSelector();
                    break;
                case 2:
                    clearConsole();
                    staffLogin();
                    break;
                case 0:
                    break;
                case -1:
                    System.out.println("Program terminating ....");
                    System.exit(0);
            }
        } while (choice < 3);
    }

    // >Staff
    public void adminHome() { // Complete level 1
        int choice;
        do {
            divider();
            System.out.println("""
                            Admin Homepage
                    (1) Assign manager
                    (2) Display all staff
                    (3) Edit payment
                    (4) Open/close Branch
                    (5) Promote a Staff
                    (6) Transfer staff to branch

                    (0) back
                    (-1) exit""");
            divider();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    assignManager();
                    break;
                case 2:
                    displayStaff();
                case 3:
                    editPayment();
                case 4:
                    openCloseBranch();
                case 5:
                    promoteStaff();
                case 6:
                    transferStaff();
                case 0:
                    break;
                case -1:
                    System.exit(0);

            }
        } while (choice < 3);
    }
    // Admin

    public void editStaff() { // Complete level 1
        // editing details
        int choice;
        do {
            divider();
            System.out.println("""
                            Admin Homepage
                    (1) Add staff
                    (2) Remove staff
                    (3) Transfer staff

                    (0) back
                    (-1) exit""");
            divider();
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
                    System.out.println("Program terminating ....");
                    System.exit(0);

            }
        } while (choice < 3);
    }
    private void addStaff(){
        //TODO method
    }
    private void removeStaff(){
        //TODO method
    }
    private void editStaffDetails(){
        //TODO method
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

    public void staffHome() {
        // Showing current orders
        Branch selectedBranch = branchOP.getCurrentBranch();
        if (selectedBranch == null) {
            System.out.println("No branch selected. Please select a branch first.");
            return;
        }

        // do {
        divider();
        do {

            Order selectedOrder = branchOP.displayOrdersAndSelect();
            if (selectedOrder != null) {
                // clearConsole();
                System.out.println("(1) Status:      New\n(2) Status:      ReadyForPickup\n(3) Status:      Completed\n(4) Set Takeaway: Takeaway\n(5) Set Takeway:  Dine-In");
                int choice = this.sc.nextInt();
                switch (choice) {
                    case 1:
                        selectedOrder.setStatus(Status.New);
                    case 2:
                        selectedOrder.setStatus(Status.ReadyForPickup);
                    case 3:
                        selectedOrder.setStatus(Status.Completed);
                    case 4:
                        selectedOrder.setTakeaway(true);
                    case 5:
                        selectedOrder.setTakeaway(false);
                }
                clearConsole();
            } else {
                break;
            }
        } while (true);

    }

    // >Admin
    public void assignManager() {

        int choice;
        do {
            String CurrentOrderList = "(1) OrderID2\n(2) OrderID1";
            // String list_branch = "";

            System.out.printf("""
                    -------------------------------
                           Manager Assignment
                    %s

                    (0) back
                    (-1) exit
                    -------------------------------
                    """, CurrentOrderList);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // onlyAdmin.assignManager(); // assignManager is not in Admin so need to create

                    break;
                case 2:
                    //
                case 0:
                    break;
                case -1:
                    System.out.println("Program terminating ....");
                    System.exit(0);

            }
        } while (choice < 3);
    }

    public void paymentGateway(Order order) { //updated by shuya
        if (order == null) {
            System.out.println("Error: No order to process.");
            return;
        }

        System.out.println("Your order total is: $" + String.format("%.2f", order.getTotalCost()));
        displayPaymentMethods();

        System.out.println("Please enter your choice of payment method:");
        int paymentChoice = scanner.nextInt();

        // Check for cancellation option
        if (paymentChoice == -1) {
            System.out.println("Payment cancelled.");
            return;
        }
        // Process payment 
        PaymentManager.makePayment(paymentChoice, order);
        
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
        int choice;
        do {
            String CurrentOrderList = "(1) OrderID2\n(2) OrderID1";
            // String list_branch = "";

            System.out.printf("""
                    -------------------------------
                               All Staff
                    %s
                    (0) back
                    (-1) exit
                    -------------------------------
                    """, CurrentOrderList);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // All of the staff
                    // onlyAdmin.displayStaffList();
                    // displayStaff();

                    break;
                case 0:
                    break;
                case -1:
                    System.out.println("Program terminating ....");
                    System.exit(0);

            }
        } while (choice < 2);
    }

    public void editPayment() { // shuya
        int choice;
        listExistingPaymentMethods(); // Display existing payment methods at the start
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
                    addPaymentMethod();
                    break;
                case 2:
                    removePaymentMethod();
                    break;
                case 0:
                    return; // go back
                case -1:
                    System.out.println("Program terminating...");
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
        System.out.println("Enter payment method ID:");
        int id = sc.nextInt();
        sc.nextLine(); // consume the newline
        System.out.println("Enter payment description:");
        String description = sc.nextLine();
        System.out.println("Enter the class name of the new payment method (e.g., BitCoinPayment):");
        String className = sc.nextLine();

        try {
            Class<?> cls = Class.forName("src." + className); // assumes that the payment classes are in the 'src'
                                                              // package
            Payment newPayment = (Payment) cls.getDeclaredConstructor().newInstance();
            onlyAdmin.managePaymentMethod("add", id, newPayment, description);
            System.out.println("Payment method added: " + description);
        } catch (Exception e) {
            System.out.println("Failed to add payment method. Error: " + e.getMessage());
        }
    }

    private void removePaymentMethod() {
        System.out.println("Enter payment method ID to remove:");
        int id = sc.nextInt();
        sc.nextLine(); // consume the newline
        System.out.println("Removing payment method...");
        onlyAdmin.managePaymentMethod("remove", id, null, "");
    }

    public void openCloseBranch() {
        divider();
        System.out.println("Available branches: ");
        Map<String, Branch> branches = branchOP.getBranchMap();
        for (Map.Entry<String, Branch> entry : branches.entrySet()) {
            String status = entry.getValue().isAvailable() ? "Open" : "Closed";
            System.out.println(entry.getKey() + " - " + status);
        }
        divider();
        System.out.println("Please enter the name of the branch you would like to (open/close).");
        System.out.println("You may type 'exit' to return.");
        String chosenBranch = sc.nextLine();
        if (chosenBranch.equalsIgnoreCase("exit")) {
            return;
        }

        Branch branch = branches.get(chosenBranch);
        if (branch != null) { //
            branch.setAvailable(!branch.isAvailable());
            String newStatus = branch.isAvailable() ? "opened" : "closed";
            System.out.println("Branch " + chosenBranch + " has been " + newStatus + ".");
        } else {
            System.out.println("Branch not found. Please try again.");
        }
    }

    public void promoteStaff() {
        List<Staff> allStaff = new ArrayList<>();
        branchOP.listAndSelectBranch(); // current branch selected

        branchOP.getCurrentBranch().printAndModifyStaffDetails(branchOP.getCurrentBranch().getStaffMembers(), null,
                null);

        // for (Branch branch : branchOP.getAllBranches().values()) {
        // allStaff.addAll(branch.getStaffMembers());
        // }

        // TODO Test code below later
        // if (allStaff.isEmpty()) {
        // System.out.println("There are no staff members available for promotion.");
        // return;
        // }

        // System.out.println("-------------------------------");
        // System.out.println(" Staff Promotion ");
        // for (Staff staff : allStaff) {
        // System.out.println("ID: " + staff.getId() + staff.getName() + " - Currently:
        // " + staff.getRole());
        // }
        // System.out.println("-------------------------------");
        // System.out.println("(0) Back");
        // System.out.println("(-1) Exit");
        // System.out.println("Enter the name of the staff you would like to promote:");

        // int choice = sc.nextInt();
        // sc.nextLine();

        // if (choice == null) {
        // System.out.println("Staff not found. Please check the ID and try again.");
        // return;
        // } else if (choice == 0) {
        // return;
        // } else if (choice == -1) {
        // System.out.println("Program terminating ....");
        // System.exit(0);
        // } else {
        // Branch branch = branchOP.getBranch(selectedStaff.getBranch()); // Assuming
        // getBranch() is a method in BranchOperator
        // if (branch != null) {
        // branch.promoteToManager(selectedStaff); // Ensure this method is implemented
        // System.out.println("Promoted " + selectedStaff.getName() + " to Manager");
        // } else {
        // System.out.println("Branch not found for the selected staff.");
        // }
        // }
    }

    public void transferStaff() {
        int choice;
        do {
            String CurrentOrderList = "(1) OrderID2\n(2) OrderID1";
            // String list_branch = "";
            System.out.printf("""
                    -------------------------------
                             Tranfer Staff
                    %s

                    (0) back
                    (-1) exit
                    -------------------------------
                    """, CurrentOrderList);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    break;
                case 0:
                    break;
                case -1:
                    System.out.println("Program terminating ....");
                    System.exit(0);

            }
        } while (choice < 2);
    }

    // >BranchManager
    public void ManagerHome() { // Complete level 1
        int choice;
        do {
            divider();
            System.out.printf("""
                             Manager Homepage @ %s
                    (1) Show Current Order
                    (2) Display Branch Staff
                    (3) Edit Branch Menu

                    (0) back
                    (-1) exit
                    """, branchOP.getCurrentBranch().getBranchName());
            divider();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    branchOP.getCurrentBranch().printCurrentOrder();
                    break;
                case 2:
                    branchOP.getCurrentBranch().printStaffAndManagers();
                    break;
                case 3:
                    editMenu(); // TODO
                    break;
                case 0:
                    break;
                case -1:
                    System.exit(0);

            }
        } while (choice < 3);
    }

    public void editMenu() {
        int choice;
        do {
            String editOptions = "(1) Add item\n(2) Remove item\n(3) Update item";
            System.out.printf("""
                    -------------------------------
                              Menu Editor
                    %s

                    (0) back
                    (-1) exit
                    -------------------------------
                    \n
                    """, editOptions);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // manager.addItem(menu);
                    break;
                case 2:
                    // manager.removeItem(menu);
                    break;
                case 3:
                    // manager.updateItem(menu);
                case 0:
                    break;
                case -1:
                    System.out.println("Program terminating ....");
                    System.exit(0);

            }
        } while (choice < 3);
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
                    System.out.println(staff.getContactInfo());
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
                    System.out.println("Program terminating ....");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid number.");
            }
        } while (choice != 0 && choice != -1);
    }

    // >User
    public void UserBranchSelector() { // Complete level 2
        // Ask the user to input the chosen branch
        clearConsole();
        divider();
        System.out.println("           OUR FAST FOOD BRANCHES");
        divider();

        branchOP.listAndSelectBranch();
        clearConsole();
        menuList();
        // branchOP.setCurrentBranch(selectedBranch);

        // Collection<Branch> branches = branchOP.getAllBranches(); // TODO change to
        // fit new initializer
        // for (int i = 0; i < branches.size(); i++) {
        // System.out.println(String.format("%20s", "(" + (i + 1) + ") " +
        // branches.get(i).getBranchName()));
        // }
        // System.out.println("=========================================");

        // Scanner sc = new Scanner(System.in);
        // int selection = -1;

        // while (selection < 1 || selection > branches.size()) {
        // System.out.print("Please choose your branch: ");
        // if (sc.hasNextInt()) {
        // selection = sc.nextInt();
        // } else {
        // System.out.println("Invalid input. Please enter a number.");
        // }
        // }

    }

    public void displayStaffCurrentOrder(Order order) { // Complete level 1
        System.out.println("Current Order Details:");
        System.out.println("-------------------------------");
        List<OrderItem> items = order.getItems();
        if (items.isEmpty()) {
            System.out.println("No items in your order.");
        } else {
            for (OrderItem item : items) {
                System.out.printf("Item: %s, Quantity: %d, Price: %.2f\n", item.getMenuItem().getName(),
                        item.getQuantity(), item.getMenuItem().getPrice());
            }
        }
        System.out.println("-------------------------------");
        System.out.println("\nDo you want to confirm this order? (Yes/No)");
        Scanner scanner = new Scanner(System.in);
        String confirmation = scanner.nextLine().trim();

        if ("Yes".equalsIgnoreCase(confirmation)) {
            System.out.println("Order confirmed.");
            // Here you can call any methods to finalize the order processing
        } else {
            System.out.println("Order not confirmed.");
            // Handle order cancellation or modification
        }
    }

    public boolean displayUserCurrentOrder(Order order) { // Complete level 1
        System.out.println("Current Order Details:");
        divider();
        List<OrderItem> items = order.getItems();
        if (items.isEmpty()) {
            System.out.println("No items in your order.");
            return false;
        } else {
            for (OrderItem item : items) {
                System.out.printf("Item: %s, Quantity: %d, Price: %.2f\n", item.getMenuItem().getName(),
                        item.getQuantity(), item.getMenuItem().getPrice());
            }
            System.out.println("Total Cost: $" + order.getTotalCost());
        }
        divider();
        System.out.println("\nDo you want to confirm this order? (Yes/No)");
        Scanner scanner = new Scanner(System.in);
        String confirmation = scanner.nextLine().trim();

        if ("Yes".equalsIgnoreCase(confirmation)) {
            System.out.println("Order confirmed.");
            paymentGateway(currentOrder);
            return true;
        } else {
            System.out.println("Order not confirmed.");
            return false;
        }
    }

    public void menuList() { // Complete level 1
        Branch selectedBranch = branchOP.getCurrentBranch();
        if (selectedBranch == null) { // if no branch is selected
            System.out.println("No branch selected. Please select a branch first.");
            return;
        }

        // Menu menu = selectedBranch.getBranchMenu();
        Menu menu = branchOP.getCurrentBranch().getBranchMenu();
        List<MenuItem> menuItems = menu.getMenuItems();

        if (sc.hasNextLine()) {
            sc.nextLine();
        }
        
        String itemName;
        MenuItem selectedItem;
        int quantity;

        divider();
        System.out.println("              Menu at " + selectedBranch.getBranchName());
        menu.displayMenu(selectedBranch);
        divider();
       
        do{
            System.out.println("Enter the name of the item you wish to order, or type 'Done' to review order:");
            itemName = sc.nextLine().trim();

            if (itemName.equalsIgnoreCase("Done")) {
                if (displayUserCurrentOrder(currentOrder)) {
                    break;  // Exit the loop if the order is confirmed
                }
                divider();
                System.out.println("              Menu at " + selectedBranch.getBranchName());
                menu.displayMenu(selectedBranch);
                divider();
                
                continue; // Continues the loop, prompting the user again
            }
    
            selectedItem = menu.findMenuItemByName(itemName, selectedBranch.getBranchName());
            if (selectedItem == null) {
                System.out.println("Item not found. Please enter a valid item name.");
                continue;
            }
    
            System.out.print("Enter the quantity you want: ");
            while (!sc.hasNextInt()) {
                sc.next(); // Consume incorrect input
                System.out.println("Invalid input. Please enter a number for the quantity.");
            }
            quantity = sc.nextInt();
            sc.nextLine(); // Consume the newline character after the number input
    
            currentOrder.addItem(selectedItem, quantity);
            System.out.println("Added " + quantity + " of " + selectedItem.getName() + " to your order.");
        } while(true);
    }

        
    //displayUserCurrentOrder(currentOrder);

    public static void main(String[] args) {
        fomsApp app = new fomsApp();
        app.userSelector(); // Call the instance method on the object

    }
}
