package src;
import java.util.List;
import java.util.Scanner;

public class Manager extends Staff {
    private Scanner scanner = new Scanner(System.in);

    public Manager(String id, String name, String contactInfo, String role, String branch) {
        super(id, name, contactInfo, role, branch);
    }

    public void addItem(Menu menu) {
        System.out.println("Enter the name of the new menu item: ");
        String name = scanner.nextLine();

        System.out.println("Enter the price of the new menu item: ");
        Double price = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter the branch for the new menu item: ");
        String branch = scanner.nextLine();
        
        System.out.println("Enter the category of the new menu item: ");
        String category = scanner.nextLine();

        MenuItem newItem = new MenuItem(name, price, branch, category);
        menu.addMenuItem(newItem);
        System.out.println("Item added successfully.");
    }

    public void removeItem(Menu menu) {
        System.out.println("Enter the name of the new menu item: ");
        String name = scanner.nextLine();

        System.out.println("Enter the branch for the new menu item: ");
        String branch = scanner.nextLine();

        MenuItem itemToRemove = new MenuItem(name, 0, branch, null);
        menu.removeMenuItem(itemToRemove);
        System.out.println("Item removed successfully.");
    }

    public void updateItem(Menu menu) {
        System.out.println("Enter the name of the menu item to update:");
        String name = scanner.nextLine();
        System.out.println("Enter the branch of the menu item:");
        String branch = scanner.nextLine();

        MenuItem itemToUpdate = menu.findMenuItem(name, branch);
        if (itemToUpdate != null) {
            System.out.println("What would you like to update? (name, price, branch, category)");
            String attribute = scanner.nextLine();
            switch (attribute.toLowerCase()) {
                case "name":
                    System.out.println("Enter the new name:");
                    itemToUpdate.setName(scanner.nextLine());
                    break;
                case "price":
                    System.out.println("Enter the new price:");
                    itemToUpdate.setPrice(Double.parseDouble(scanner.nextLine()));
                    break;
                case "branch":
                    System.out.println("Enter the new branch:");
                    itemToUpdate.setBranch(scanner.nextLine());
                    break;
                case "category":
                    System.out.println("Enter the new category:");
                    itemToUpdate.setCategory(scanner.nextLine());
                    break;
                default:
                    System.out.println("Invalid attribute.");
                    return;
            }
            System.out.println("Item updated successfully.");
        } else {
            System.out.println("Item not found.");
        }
    }

    public void displayStaffList(List<Staff> staffList) {
        System.out.println("Staff List for Branch: " + this.getBranch());
        staffList.stream()
                 .filter(staff -> staff.getBranch().equals(this.getBranch()))
                 .forEach(System.out::println);
    }
}
