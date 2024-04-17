/* 
 * /usr/bin/env /Users/game/Library/Java/JavaVirtualMachines/openjdk-21.0.2/Contents/Home/bin/java -XX:+ShowCodeDetailsInExceptionMessages -cp /Users/game/Library/Application\ Support/Code/User/workspaceStorage/2f5c87283ad91abdee12af6a0051733b/redhat.java/jdt_ws/NTU-OOP-FOMS-Final-Project_ea206817/bin src.fomsApp 
 */

package src;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

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
    // Adding branches
    private String currentBranchName;
    private String currentUser;

    private Scanner sc;
    private String CurrentStaffType;

    public static List<Order> orderList;
    private Order currentOrder = new Order("123", false);

    Menu menu = new Menu();
    private Admin onlyAdmin = new Admin("boss", "Boss");

    public void initializer() {
        branchOP.addOrReplaceBranch("NTU", new Branch("NTU", "North Spine Plaza", 8));
        branchOP.addOrReplaceBranch("JP", new Branch("JP", "Jurong Point", 15));
        branchOP.addOrReplaceBranch("JE", new Branch("JE", "Jurong East", 11));
        branchOP.setCurrentBranch("JP");
        branchOP.getCurrentBranch().addManager(new Manager(
                "TomC",
                "Tom Chan",
                Manager.Gender.Male,
                56,
                "JP"));
        branchOP.getCurrentBranch().addStaffMember(new Staff(
                "JustinL",
                "Justin Loh",
                Staff.Gender.Male,
                49,
                "JP"));

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
            choice = sc.nextInt();
            divider();
            switch (choice) {
                case 1:
                    UserBranchSelector();
                    break;
                case 2:
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
                    // TODO
                    break;
                case 2: // Remove staff
                    // TODO
                case 3: // Transfer staff
                    // TODO
                case 0:
                    break;
                case -1:
                    System.out.println("Program terminating ....");
                    System.exit(0);

            }
        } while (choice < 3);
    }

    public void staffLogin() {
        divider();
        System.out.println("""
                          Staff Login
                Username:""");
        String username = sc.next();
        System.out.println("Entered username: " + username);
        System.out.println("""
                Password:""");
        String password = sc.next();
        System.out.println("Entered password: " + password);
        System.out.println("\nACCESS GRANTED!!");
        divider();

        /*
         * Username 1234
         * Password 1234
         */

        // if staff then go to staff home

        // String CurrentStaffType = "admin";
        // String CurrentStaffType = "staff";
        String CurrentStaffType = "branchmanager";
        switch (CurrentStaffType) {
            case "admin":
                adminHome();
                break;
            case "staff":
                staffHome();
                break;
            // TODO
            case "branchmanager":
                branchManagerHome();

                break;
            // TODO

        }
    }

    public void staffHome() {
        // Showing current orders
        Branch selectedBranch = branchOP.getCurrentBranch();
        if (selectedBranch == null) {
            System.out.println("No branch selected. Please select a branch first.");
            return;
        }

        int choice;
        do {
            divider();
            System.out.println("        Current orders         ");
            List<Order> currentOrders = new ArrayList<>();
            int index = 1;

            for (Order order : orderList) {
                if (order.getStatus().equals("New") && order.getCustomerId().equals(selectedBranch.getBranchName())) {
                    System.out.println(order.getOrderId());
                    currentOrders.add(order);
                    index++;
                }
            }
            if (currentOrders.isEmpty()) {
                System.out.println("No current orders available.");
                break; // loop is broken if there are no orders
            }
            divider();
            System.out.println("(0) Back");
            System.out.println("(-1) Exit");
            choice = sc.nextInt();
            sc.nextLine();
            if (choice > 0 && choice <= currentOrders.size()) {
                Order selectedOrder = currentOrders.get(choice - 1);
                selectedOrder.setStatus(Order.Status.ReadyForPickup);
                System.out.println("Order ID: " + selectedOrder.getOrderId() + " is now ready to pick up.");
            } else if (choice == 0) {
                break; // Go back to the previous menu
            } else if (choice == -1) {
                System.out.println("Program terminating...");
                System.exit(0);
            } else {
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0 && choice != -1);
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

    public void cardPaymentGateway() { // Complete level 1
        int choice;
        do {
            String CurrentOrderList = "(1) OrderID2\n(2) OrderID1";
            // String list_branch = "";

            System.out.printf("""
                    -------------------------------
                            Payment Type
                    %s

                    (0) back
                    (-1) exit
                    -------------------------------
                    """, CurrentOrderList);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // TODO
                    break;
                case 2:
                    // TODO
                case 0:
                    break;
                case -1:
                    System.out.println("Program terminating ....");
                    System.exit(0);

            }
        } while (choice < 3);
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

    public void editPayment() { //shuya
        int choice;
        do {
            String CurrentOrderList = "(1) OrderID2\n(2) OrderID1";
            // String list_branch = "";

            System.out.printf("""
                    -------------------------------
                              Edit Payment
                    %s

                    (0) back
                    (-1) exit
                    -------------------------------
                    """, CurrentOrderList);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // TODO
                    break;
                case 2:
                    // TODO
                case 0:
                    break;
                case -1:
                    System.out.println("Program terminating ....");
                    System.exit(0);

            }
        } while (choice < 3);
    }

    public void openCloseBranch() { //tracey
        int choice;
        do {
            String header = "(1) OrderID2\n(2) OrderID1";
            // String list_branch = "";

            System.out.printf("""
                    -------------------------------
                           Open/Close Branch
                    %s

                    (0) back
                    (-1) exit
                    \n
                    """, header);
            choice = sc.nextInt();
            switch (choice) {
                case 1:

                    break;
                case 2:
                    // TODO
                case 0:
                    break;
                case -1:
                    System.out.println("Program terminating ....");
                    System.exit(0);

            }
        } while (choice < 3);
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
    public void branchManagerHome() { // Complete level 1
        int choice;
        do {
            divider();
            System.out.printf("""
                            Branch Manager Homepage
                    (1) Show Current Order
                    (2) Display Branch Staff
                    (3) Edit Branch Menu

                    (0) back
                    (-1) exit
                    """);
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

    public void displayUserCurrentOrder(Order order) { // Complete level 1
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

    public void menuList() { // Complete level 1
        Branch selectedBranch = branchOP.getCurrentBranch();
        if (selectedBranch == null) { // if no branch is selected
            System.out.println("No branch selected. Please select a branch first.");
            return;
        }

        // Menu menu = selectedBranch.getBranchMenu();
        Menu menu = branchOP.getCurrentBranch().getBranchMenu();
        List<MenuItem> menuItems = menu.getMenuItems();

        divider();
        System.out.println("              Menu at " + selectedBranch.getBranchName());
        menu.displayMenu(selectedBranch);
        divider();

        String itemName;
        MenuItem selectedItem;
        int quantity;

        while (true) {
            System.out.println("Enter the name of the item you wish to order.");
            itemName = sc.nextLine().trim();

            if (itemName.equalsIgnoreCase("exit")) {
                break;
            }

            selectedItem = menu.findMenuItemByName(itemName);
            if (selectedItem == null) {
                System.out.println("Item not found. Please enter a valid item name.");
                continue;
            }

            System.out.print("Enter the quantity you want: ");
            while (!sc.hasNextInt()) {
                sc.next(); // Consume the incorrect input
                System.out.println("Invalid input. Please enter a number for the quantity.");
            }
            quantity = sc.nextInt();
            sc.nextLine();

            currentOrder.addItem(selectedItem, quantity); // Add the item and quantity to the order
            System.out.println("Added " + quantity + " of " + selectedItem.getName() + " to your order.");
        }
        displayUserCurrentOrder(currentOrder);
    }

    public static void main(String[] args) {
        fomsApp app = new fomsApp();
        app.userSelector(); // Call the instance method on the object

    }
}
