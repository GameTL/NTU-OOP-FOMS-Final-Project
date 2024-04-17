package src;

import java.util.ArrayList;
import java.util.List;

public class BranchManager {
    private List<Branch> branchList;
    
    private BranchManager() {
        branchList = new ArrayList<>();
        branchList.add(new Branch("NTU"));
        branchList.add(new Branch("JP"));
        branchList.add(new Branch("JE"));
    }
    
    public void addBranch(Branch branch) {
        branchList.add(branch);
    }

    public void removeBranch(Branch branch) {
        branchList.remove(branch);
    }

    public List<Branch> getBranches() {
        return branchList;
    }
}

