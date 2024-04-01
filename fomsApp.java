import java.util.Scanner;

public class fomsApp {
    // Declare the Scanner as an instance variable of the class
    private Scanner sc;

    // Constructor
    public fomsApp() {
        // Initialize the Scanner with System.in as its input stream
        this.sc = new Scanner(System.in);
    }

    private void branchSelector() {
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
                case 3:

    private void staffLogin() {
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

    private void userSelector() {
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
                case -1:
                    System.out.println("Program terminating ....");
            }
        } while (choice < 3);
    }

    public static void main(String[] args) {
        fomsApp app = new fomsApp();
        app.userSelector(); // Call the instance method on the object

    }
}
