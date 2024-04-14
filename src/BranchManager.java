package src;

import java.util.ArrayList;
import java.util.List;

public class BranchManager {
    private List<Branch> branches;
    
    public BranchManager() {
        this.branches = new ArrayList<>();
        initializeBranches();
    }

    private void initializeBranches(){
        branches.add(new Branch("NTU"));
        branches.add(new Branch("JP"));
        branches.add(new Branch("JE"));
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

