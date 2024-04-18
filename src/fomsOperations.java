package src;
public interface fomsOperations {
    // Main
    public abstract void  userSelector(); // 1.X
    
    // >Staff
    public abstract void  adminHome(); // 1.2.1
    
    
    public abstract void  staffLogin(); // 1.2.X
    
    public abstract void  staffHome(); // 1.2.2.X

    public abstract void  displayStaffCurrentOrder(Order order); // 1.1.1
    
    // public abstract void  displayBranchCurrentOrder(Branch branch);
    // >>Admin

    public abstract void  editStaff(); // 1.2.1.1

    public abstract void  assignManager(); // 1.2.1.2

    public abstract void  displayStaff(); // 1.2.1.3

    public abstract void  editPayment(); // 1.2.1.4

    public abstract void  openCloseBranch(); // 1.2.1.5

    public abstract void  promoteStaff(); // 1.2.1.6

    public abstract void  transferStaff(); // 1.2.1.7

    // >>BranchManager
    public abstract void  ManagerHome(); // 1.2.3.X

    public abstract void  editMenu(); // 1.2.3.1

    public abstract void  displayBranchStaff(); // 1.2.3.2

    // >User
    public abstract void  UserBranchSelector(); // 1.1.X

    public abstract void  paymentGateway(Order order);

    public abstract boolean  displayUserCurrentOrder(Order order); // 1.1.1

    public abstract void  menuList(); // 1.1.2
    // Level X.X.1

}