package src;
import java.util.List;
public class Manager extends Staff {
    public Manager(String id, String name, String role, String branch, String gender, Integer age) {
        super(id, name, role, branch, gender, age);
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
        staffList.stream()
                 .filter(staff -> staff.getBranch().equals(this.getBranch()))
                 .forEach(System.out::println);
    }
}
