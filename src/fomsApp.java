package src;

import java.util.Scanner;

public class fomsApp implements fomsOperations {
    // Declare the Scanner as an instance variable of the class
    private Scanner sc;
    private String CurrentStaffType;

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

                case 2:
                    staffLogin();
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
        String CurrentStaffType = "staff";
        // String CurrentStaffType = "branchmanager";
        switch (CurrentStaffType) {
            case "admin":
                adminHome();
                break;
            case "staff":
                staffHome();
                break;
            // TODO
            case "branchmanager":

                break;
            // TODO

        }
    }

    public void staffHome() { // Complete level 1
        // Show all the order that's the staff suppose to be doing
        int choice;
        do {
            String CurrentOrderList = "(1] OrderID2\n(2) ";
            // String list_branch = "";

            System.out.printf("""
                    -------------------------------
                             Staff HomePage

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
        int choice;
        do {
            String list_branch = "(1) Branch A\n(2) Branch A";
            // String list_branch = "";

            System.out.printf("""
                    -------------------------------
                    Which branch would you like to select?
                    %s

                    (0) back
                    (-1) exit
                    -------------------------------
                    """, list_branch);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 0:
                    break;
                case -1:
                    System.out.println("Program terminating ....");
                    System.exit(0);

            }
        } while (choice < 3);
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
