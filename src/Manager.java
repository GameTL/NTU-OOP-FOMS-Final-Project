package src;
import java.util.List;
public class Manager extends Staff {
    public Manager(String id, String name, String contactInfo, String role, String branch) {
        super(id, name, contactInfo, role, branch);
    }

    public void manageMenu(Menu menu, MenuItem item, String action) {
        // action: "add", "remove", "update"
        switch (action) {
            case "add":
                menu.addMenuItem(item);
                break;
            case "remove":
                menu.removeMenuItem(item);
                break;
            case "update":
                // Detailed implementation for updating a menu item
                break;
        }
        System.out.println("Menu updated.");
    }

    public void displayStaffList(List<Staff> staffList) {
        System.out.println("Staff List for Branch: " + this.getBranch());
        for (Staff staff : staffList) {
            // Display only staff from the same branch as the manager
            if (staff.getBranch().equals(this.getBranch())) {
                System.out.println(staff);
            }
        }
    }
}
