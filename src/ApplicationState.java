package src;

public class ApplicationState {
    private static Branch currentBranch;

    public static Branch getCurrentBranch() {
        return currentBranch;
    }

    public static void setCurrentBranch(Branch branch) {
        ApplicationState.currentBranch = branch;
    }
}
