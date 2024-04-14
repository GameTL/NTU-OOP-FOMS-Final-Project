package src;

import java.util.ArrayList;
import java.util.List;

public class BranchManager {
    private List<Branch> branches;
    
    public BranchManager() {
<<<<<<< Updated upstream
        this.branches = new ArrayList<>();
        initializeBranches();
    }

    private void initializeBranches(){
        branches.add(new Branch("NTU"));
        branches.add(new Branch("JP"));
        branches.add(new Branch("JE"));
=======
        branchList = new ArrayList<>();
        branchList.add(new Branch("NTU"));
        branchList.add(new Branch("JP"));
        branchList.add(new Branch("JE"));
>>>>>>> Stashed changes
    }
    
    public void addBranch(Branch branch) {
        branches.add(branch);
    }

    public void removeBranch(Branch branch) {
        branches.remove(branch);
    }

    public List<Branch> getBranches() {
        return branches;
    }
}

