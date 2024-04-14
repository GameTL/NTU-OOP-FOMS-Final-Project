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
    public void Initalizer() {
        // Initialize branch
        List<Branch> branchList = new ArrayList<>();
        branchList.add(new Branch("NTU"));
        branchList.add(new Branch("JP"));
        branchList.add(new Branch("JE"));

        // Initizalize order
        List<OrderItem> items = new ArrayList<>();
    }
    //

    private String currentBranchName;
    private String currentUser;

    private Scanner sc;
    private String CurrentStaffType;

    Menu menu = new Menu();

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
                    //show current order specific to branch
                    break;
                case 2:
                    // display branch staff
                case 3:
                    // edit branch menu
                case 0:
                    break;
                case -1:
                    System.exit(0);

            }
        } while (choice < 3);
    }

    public void editMenu() { // Complete level 1
        int choice;
        do {
            String CurrentOrderList = "(1) OrderID2\n(2) OrderID1";
            // String list_branch = "";

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

    public void displayBranchStaff() { // Complete level 1
        int choice;
        do {
            String CurrentOrderList = "(1) Jack\n(2) Jill";

            System.out.printf("""
                    -------------------------------
                        All staff @ this branch
                    %s

                    (0) back
                    (-1) exit
                    -------------------------------
                    \n
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

    // >User
    public void branchSelector() { // Complete level 2
        Menu menu = new Menu();
        BranchManager branchManager = new BranchManager();

        // Ask the user to input the chosen branch
        Scanner scanner = new Scanner(System.in);
        System.out.println("         OUR FAST FOOD BRANCHES");
        System.out.println("=========================================");

        List<Branch> branches = branchManager.getBranches();
        for (int i = 0; i < branches.size(); i++) {
            String branchName = branches.get(i).getBranchName();
            System.out.println(String.format("%20s", "(" + (i + 1) + ") " + branchName));
        }
        System.out.println("=========================================");
        int selection = -1;
        while (selection < 1 || selection > branches.size()) {
            System.out.print("Please choose your branch: ");
            if (scanner.hasNextInt()) {
                selection = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }

        Branch selectedBranch = branches.get(selection - 1);
        menu.displayMenu(selectedBranch);

    }

    public void displayCurrentOrder() { // Complete level 1
        int choice;
        do {
            String CurrentOrderList = "(1) OrderID2\n(2) OrderID1";
            // String list_branch = "";

            System.out.printf("""
                    -------------------------------
                             Current Order
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
        app.userSelector(); // Call the instance method on the object

    }
}
