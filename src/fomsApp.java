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

import src.Order.Status;
import src.User;

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
    private String currentCustomerId;

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
                Manager.Gender.MALE,
                56,
                "JP"));
        branchOP.getCurrentBranch().setOrders(mockorderList);
        branchOP.getCurrentBranch().addStaffMember(new Staff(
                "JustinL",
                "Justin Loh",
                Staff.Gender.MALE,
                49,
                "JP"));
        branchOP.getCurrentBranch().setOrders(mockorderList);
        // Init for NTU
        branchOP.setCurrentBranch("NTU");
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
        branchOP.getCurrentBranch().setOrders(mockorderList);
        // Init for JE
        branchOP.setCurrentBranch("JE");
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
        branchOP.getCurrentBranch().setOrders(mockorderList);

        // for testing
        // for testing
        branchOP.getCurrentBranch().addStaffMember(new Staff(
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
                    Random random = new Random();
                    // Generate a random number between 10000 and 9999
                    String randomID = String.valueOf(10000 + random.nextInt(90000));
                    currentCustomerId = randomID;
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
                    (1) Edit staff
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
                    editStaff();
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
        try{
            gender = User.Gender.valueOf(genderInput.toUpperCase()); // Correctly parsing the enum
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid gender. Please enter Male, Female, or Other.");
            return;
        }
        
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
    
        Staff newStaff = new Staff(chosenID, name, gender, age, branchName); 
        branch.addStaffMember(newStaff);
        System.out.println("New staff added successfully.");
        divider();
        System.out.println("Your current staff list @ " + branch);
        divider();
        displayBranchStaff();
        divider();
    }
    
    private void removeStaff() {
        System.out.print("Enter the branch name: ");
        String branchName = scanner.nextLine().trim();
        Branch branch = branchOP.getBranchMap().get(branchName);
        
        if (branch == null) {
            System.out.println("Branch does not exist.");
            return;
        }
        
        List<Staff> staffList = branch.getStaffMembers();
        if (staffList.isEmpty()) {
            System.out.println("No staff members available to remove.");
            return;
        }

        System.out.println("Select the staff member to remove, or done to cancel:");
        String staffToBeRemoved = scanner.nextLine();
        if (condition) {
            System.out.println("Operation cancelled.");
            return;
        } else {
            if (canChangeStaff(branch, -1)) {
                branch.removeStaffMember(staffToBeRemoved);
                System.out.println("Staff member removed successfully.");
                divider();
                System.out.println("Your current staff list @ " + branch);
                divider();
                displayBranchStaff();
                divider();
            } else {
                System.out.println("Cannot remove staff due to manager-to-staff ratio restrictions.");
            }
        } 
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
                System.out.println(
                        "(1) Status:      New\n(2) Status:      ReadyForPickup\n(3) Status:      Completed\n(4) Set Takeaway: Takeaway\n(5) Set Takeway:  Dine-In");
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
    public void paymentGateway(Order order) { // updated by shuya
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
        System.out.printf("%-10s %-20s %-15s %-15s\n", "ID", "Name", "Role", "Contact Info"); // Adjust headers as
                                                                                              // needed
        for (Staff staff : staffList) {
            System.out.printf("%-10s %-20s %-15s %-15s\n",
                    staff.getId(),
                    staff.getName(),
                    staff.getContactInfo()); // Make sure these methods exist in your Staff class
        }
        divider();
    }

    public void editPayment() {
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
                    branchOP.displayOrdersAndSelect();
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

    public void displayStaffCurrentOrder(Order orderCart) { // Complete level 1
        System.out.println("Current Order Details:");
        divider();
        List<OrderItem> CartMenuItemList = orderCart.getItems();
            int maxNameLength = "Item Name".length();
            int maxQuantityLength = String.valueOf("Quantity").length();
            for (OrderItem item : CartMenuItemList) {
                maxNameLength = Math.max(maxNameLength, item.getMenuItem().getName().length());
                maxQuantityLength = Math.max(maxQuantityLength, String.valueOf(item.getQuantity()).length());
            }
    
            int maxNamePadding = maxNameLength + 4;
            int maxQuantityPadding = maxQuantityLength + 4;
    
            System.out.printf("%-5s %-" + maxNamePadding + "s %-" + maxQuantityPadding + "s%n", "Index", "Name", "Quantity");
            for (OrderItem item : CartMenuItemList) {
                System.out.printf("%-5d %-" + maxNamePadding + "s %-" + maxQuantityPadding + "s%n", 0, item.getMenuItem().getName(), item.getQuantity());
            }
            divider();
            System.out.printf("Total Price: %.2f",orderCart.getTotalCost());
        System.out.println("\nDo you want to confirm this order? (Yes/No)");
        Scanner scanner = new Scanner(System.in);
        String confirmation = scanner.nextLine().trim();

        if ("Yes".equalsIgnoreCase(confirmation)) {
            System.out.println("Order confirmed.");
            branchOP.getCurrentBranch().addOrder(orderCart);
        } else {
            System.out.println("Order not confirmed.");
        }
    }

    public void menuList() {
        Order OrderCart = new Order(null, false);

        OrderCart = branchOP.displayMenuAndSelect(OrderCart);
        divider();
        displayUserCurrentOrder(OrderCart);
        // displayPaymentMethods();
    }

    // displayUserCurrentOrder(currentOrder);

    public static void main(String[] args) {
        fomsApp app = new fomsApp();
        app.userSelector(); // Call the instance method on the object

    }
}
