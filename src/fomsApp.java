package src;

import java.util.Scanner;

public class fomsApp implements fomsOperations {
    // Declare the Scanner as an instance variable of the class
    private Scanner sc;

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
                    Are you a customer or a staff?
                    (1) Customer
                    (2) Staff
                    -------------------------------
                    (0) back
                    (-1) exit
                    """);
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
            String CurrentOrderList = "(1) OrderID2\n(2) OrderID1";
            // String list_branch = "";

            System.out.printf("""

                    %s
                    -------------------------------
                    (0) back
                    (-1) exit
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

    public void editStaff() { // Complete level 1
        int choice;
        do {
            String CurrentOrderList = "(1) OrderID2\n(2) OrderID1";
            // String list_branch = "";

            System.out.printf("""

                    %s
                    -------------------------------
                    (0) back
                    (-1) exit
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

    public void staffLogin() { // Complete level 2
        int choice;
        String list_branch = "(1) Branch A\n(2) Branch A";
        // String list_branch = "";

        System.out.println("""
                Staff Login
                -------------------------------
                Username:\n""");
        String username = sc.nextLine();
        System.out.println(username);
        System.out.println("""
                Password:\n""");
        String password = sc.nextLine();

        System.out.println(password);
    }

    public void staffHome() { // Complete level 1
        int choice;
        do {
            String CurrentOrderList = "(1) OrderID2\n(2) OrderID1";
            // String list_branch = "";

            System.out.printf("""

                    %s
                    -------------------------------
                    (0) back
                    (-1) exit
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

    // >Admin
    public void assignManager() { // Complete level 1
        int choice;
        do {
            String CurrentOrderList = "(1) OrderID2\n(2) OrderID1";
            // String list_branch = "";

            System.out.printf("""

                    %s
                    -------------------------------
                    (0) back
                    (-1) exit
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

    public void cardPaymentGateway() { // Complete level 1
        int choice;
        do {
            String CurrentOrderList = "(1) OrderID2\n(2) OrderID1";
            // String list_branch = "";

            System.out.printf("""

                    %s
                    -------------------------------
                    (0) back
                    (-1) exit
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

    public void displayStaff() { // Complete level 1
        int choice;
        do {
            String CurrentOrderList = "(1) OrderID2\n(2) OrderID1";
            // String list_branch = "";

            System.out.printf("""

                    %s
                    -------------------------------
                    (0) back
                    (-1) exit
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

    public void editPayment() { // Complete level 1
        int choice;
        do {
            String CurrentOrderList = "(1) OrderID2\n(2) OrderID1";
            // String list_branch = "";

            System.out.printf("""

                    %s
                    -------------------------------
                    (0) back
                    (-1) exit
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

    public void openCloseBranch() { // Complete level 1
        int choice;
        do {
            String CurrentOrderList = "(1) OrderID2\n(2) OrderID1";
            // String list_branch = "";

            System.out.printf("""

                    %s
                    -------------------------------
                    (0) back
                    (-1) exit
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

    public void promoteStaff() { // Complete level 1
        int choice;
        do {
            String CurrentOrderList = "(1) OrderID2\n(2) OrderID1";
            // String list_branch = "";

            System.out.printf("""

                    %s
                    -------------------------------
                    (0) back
                    (-1) exit
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

    public void transferStaff() { // Complete level 1
        int choice;
        do {
            String CurrentOrderList = "(1) OrderID2\n(2) OrderID1";
            // String list_branch = "";

            System.out.printf("""

                    %s
                    -------------------------------
                    (0) back
                    (-1) exit
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

    // >BranchManager
    public void editMenu() { // Complete level 1
        int choice;
        do {
            String CurrentOrderList = "(1) OrderID2\n(2) OrderID1";
            // String list_branch = "";

            System.out.printf("""

                    %s
                    -------------------------------
                    (0) back
                    (-1) exit
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
            String CurrentOrderList = "(1) OrderID2\n(2) OrderID1";
            // String list_branch = "";

            System.out.printf("""

                    %s
                    -------------------------------
                    (0) back
                    (-1) exit
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
                    Which branch would you like to select?
                    %s
                    -------------------------------
                    (0) back
                    (-1) exit
                    \n
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

                    %s
                    -------------------------------
                    (0) back
                    (-1) exit
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

    public void menuList() { // Complete level 1
        int choice;
        do {
            String MenuList = "(1) Pad Thai\n(2) Kimchi";
            // String list_branch = "";

            System.out.printf("""

                    %s
                    -------------------------------
                    (0) back
                    (-1) exit
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
