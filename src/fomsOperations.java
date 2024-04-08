package src;
public interface fomsOperations {
    // Main
    void userSelector(); // 1.X

    // >Staff
    void adminHome(); // 1.2.1


    void staffLogin(); // 1.2.X

    void staffHome(); // 1.2.2.X

    // >>Admin

    void editStaff(); // 1.2.1.1

    void assignManager(); // 1.2.1.2

    void displayStaff(); // 1.2.1.3

    void editPayment(); // 1.2.1.4

    void openCloseBranch(); // 1.2.1.5

    void promoteStaff(); // 1.2.1.6

    void transferStaff(); // 1.2.1.7

    // >>BranchManager
    void branchManagerHome(); // 1.2.3.X

    void editMenu(); // 1.2.3.1

    void displayBranchStaff(); // 1.2.3.2


    // >User
    void branchSelector(); // 1.1.X

    void cardPaymentGateway();

    void displayCurrentOrder(); // 1.1.1

    void menuList(); // 1.1.2
    // Level X.X.1

}