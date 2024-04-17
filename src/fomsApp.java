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
    private String currentBranchName;
    private String currentUser;

    private Scanner sc;
    private String CurrentStaffType;

    public static List<Order> orderList;
    public static List<Branch> branchList = new ArrayList<>();

    Menu menu = new Menu();

    public static void initializer() {
        // Initialize branch
        branchList.add(new Branch("NTU"));
        branchList.add(new Branch("JP"));
        branchList.add(new Branch("JE"));
        
        // Initizalize order
        

        //Initialize orders made to branch
    }
    // private //List of Branch

    // Constructor
    public fomsApp() {
        // Initialize the Scanner with System.in as its input stream
        this.sc = new Scanner(System.in);
    }

    // Main
    public void userSelector() { // Complete level 2
        int choice;
        do {
            System.out.println("""
                    -------------------------------
                    Are you a customer or a staff?
                    (1) Customer
                    (2) Staff

                    (0) back
                    (-1) exit
                    -------------------------------""");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    branchSelector();
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
            String AdminChoices = String.format("""
                    %23s
                    (1) Assign manager
                    (2) Display all staff
                    (3) Edit payment
                    (4) Open/close Branch
                    (5) Promote a Staff
                    (6) Transfer staff to branch
                    """, "Admin HomePage");
            System.out.printf("""
                    -------------------------------
                            Admin Homepage
                    %s

                    (0) back
                    (-1) exit
                    -------------------------------
                    """, AdminChoices);
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
        int choice;
        do {
            String CurrentOrderList = "(1) OrderID2\n(2) OrderID1";
            // String list_branch = "";

            System.out.printf("""

                    -------------------------------
                           Edit Staff Account
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

    public void staffLogin() { // Complete level 2

        System.out.println("""

                -------------------------------
                          Staff Login
                Username:""");
        String username = sc.next();
        System.out.println("Entered username: " + username);
        System.out.println("""
                Password:""");
        String password = sc.next();
        System.out.println("Entered password: " + password);
        System.out.println("\nACCESS GRANTED!!");
        System.err.println("-------------------------------");

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

    public void staffHome() { // Complete level 1
        // Show all the order that's the staff suppose to be doing
        int choice;
        do {
            String CurrentOrderList = "1. 000011\n1. 000012 ";
            // String list_branch = "";

            System.out.printf("""

                    -------------------------------
                             Staff HomePage

                    Current Order
                    %s

                    (1) Update Order

                    (0) back
                    (-1) exit
                    -------------------------------
                    """, CurrentOrderList);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // update order status
                    break;
                case 0:
                    break;
                case -1:
                    System.out.println("Program terminating ....");
                    System.exit(0);

            }
        } while (choice < 3);
    }

    // >Admin
    public void assignManager() { // Complete level 1
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
        // As an Admin this function will display all 
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

    public void editPayment() { // Complete level 1
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

    public void openCloseBranch() { // Complete level 1
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

    public void promoteStaff() { // Complete level 1
        int choice;
        do {
            String CurrentOrderList = "(1) OrderID2\n(2) OrderID1";
            // String list_branch = "";

            System.out.printf("""
                    -------------------------------
                            Staff Promotion
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

    public void transferStaff() { // Complete level 1
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

    // >BranchManager
    public void branchManagerHome() { // Complete level 1
        int choice;
        do {
            String BranchManagerChoices = """
                    
                (1) Show Current Order
                (2) Display Branch Staff
                (3) Edit Branch Menu
                    """;
            System.out.printf("""
                    -------------------------------
                         Branch Manager Homepage
                    %s

                    (0) back
                    (-1) exit
                    -------------------------------
                    """, BranchManagerChoices);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    displayCurrentOrder();
                    break;
                case 2:
                    displayBranchStaff();
                    break;
                case 3:
                    editMenu();
                    break;
                case 0:
                    break;
                case -1:
                    System.exit(0);

            }
        } while (choice < 3);
    }

    public void editMenu() {
        Manager manager = new Manager();
        int choice;
        do {
            String CurrentOrderList = """
                    
                (1) Add menu item
                (2) Remove menu item
                (3) Update menu item
                    """;
            System.out.printf("""
                    -------------------------------
                              Menu Editor
                    %s

                    (0) back
                    (-1) exit
                    -------------------------------
                    \n
                    """, CurrentOrderList);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    manager.addItem(menu);
                    break;
                case 2:
                    manager.removeItem(menu);
                case 3:
                    manager.updateItem(menu);
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
            if (staffMembers.isEmpty()){
                System.out.println("No staff members in this branch.");
            } else {
                System.out.println("-------------------------------");
                System.out.println("    All staff @ this branch");
                for (Staff staff : staffMembers) {
                    System.out.println("Name: " + staff.getName() + ", Role: " + staff.getRole() + ", Contact: " + staff.getContactInfo());
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
    public void branchSelector() { // Complete level 2
        // Ask the user to input the chosen branch
        System.out.println("         OUR FAST FOOD BRANCHES");
        System.out.println("=========================================");

        List<Branch> branches = fomsApp.branchList;
        for (int i = 0; i < branches.size(); i++) {
            System.out.println(String.format("%20s", "(" + (i + 1) + ") " + branches.get(i).getBranchName()));
        }
        System.out.println("=========================================");
        
        Scanner sc = new Scanner(System.in);
        int selection = -1;

        while (selection < 1 || selection > branches.size()) {
            System.out.print("Please choose your branch: ");
            if (sc.hasNextInt()) {
                selection = sc.nextInt();
                sc.nextLine(); // Consume newline character
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // Clear the invalid input
            }
        }

        Branch selectedBranch = branches.get(selection - 1);
        ApplicationState.setCurrentBranch(selectedBranch);
        menu.displayMenu(selectedBranch);
    }

    public void displayCurrentOrder(Branch selectedBranch) { // Complete level 1
        int choice;
        do {
            System.out.println("-------------------------------");
            System.out.println("        Current orders         ");
            boolean found = false;
            for (Order order : orderList) {
                if (order.getStatus().equals("New") && order.getCustomerId().equals(selectedBranch.getBranchName())) {
                    System.out.println(order.getOrderId());
                    found = true; 
                }
            }
            if (!found){
                System.out.println("No current orders available.");
            }
            System.out.println("-------------------------------");
            System.out.println("(0) Back");
            System.out.println("(-1) Exit");
            choice = sc.nextInt();
            sc.nextLine();  
            switch (choice) {
                case 0:
                    break;
                case -1:
                    System.out.println("Program terminating ....");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0 && choice != -1);
    }

    public void menuList() { // Complete level 1
        int choice;
        do {
            String MenuList = "(1) Pad Thai\n(2) Kimchi";
            // String list_branch = "";

            System.out.printf("""
                    -------------------------------
                              List of Menu
                    %s

                    (0) back
                    (-1) exit
                    -------------------------------
                    \n
                    """, MenuList);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // TODO
                    break;
                case 2:
                    // TODO
                    break;
                case 0:
                    break;
                case -1:
                    System.out.println("Program terminating ....");
                    System.exit(0);

            }
        } while (choice < 3);
    }

    public static void main(String[] args) {
        fomsApp app = new fomsApp();
        initializer();
        app.userSelector(); // Call the instance method on the object

    }
}
