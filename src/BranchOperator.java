package src;

// import java.util.ArrayList;
import java.util.HashMap;

import static src.fomsApp.clearConsole;
import static src.fomsApp.divider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.IOException;

public class BranchOperator implements Serializable{
    private static final long serialVersionUID = 9L;
    private Admin adminOP;

    private Map<String, Branch> branchMap = new HashMap<>();
    private Branch currentBranch;
    private transient Scanner scanner = new Scanner(System.in);

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject(); // default deserialization logic
        scanner = new Scanner(System.in); // re-initialize scanner after deserialization
    }

    public void addOrReplaceBranch(String name, Branch branch) {
        branchMap.put(name, branch);
        currentBranch = branch; // Update the current branch
    }

    public void setCurrentBranch(String name) {
        this.currentBranch = branchMap.get(name);
    }

    public Branch getCurrentBranch() {
        return currentBranch;
    }

    public Map<String, Branch> getBranchMap() {
        return branchMap;
    }

    public void removeBranch(String name) {
        if (branchMap.containsKey(name)) {
            if (branchMap.get(name) == currentBranch) {
                currentBranch = null; // Clear current branch if it's the one being removed
            }
            branchMap.remove(name); // Remove the branch from the map
        }
    }
    public void initAdmin(Admin admin){
        adminOP = admin;
    }

    public List<Staff> getAllStaff() {
        List<Staff> allStaff = new ArrayList<>(); // Start with all staff members
        allStaff.add((Staff) adminOP);
        for (Branch branch : branchMap.values()) {
            allStaff.addAll(branch.getStaffMembers());
            allStaff.addAll(branch.getManagerMembers());
        }
        return allStaff;
    }

    public void listAndSelectBranch() {
        int index = 1;
        Map<Integer, String> indexMap = new HashMap<>(); // Maps index to branch names

        // Print all branches with an index
        System.out.println("List of Branches:");
        for (Map.Entry<String, Branch> entry : branchMap.entrySet()) {
            String branchName = entry.getKey();
            Branch branch = entry.getValue();
            String status = branch.isAvailable() ? "OPEN" : "CLOSE"; // Check each branch's availability
            System.out.println(index + ". " + branchName + " - " + status);
            indexMap.put(index, branchName);
            index++;
        }

        /*
         * for (String branchName : branchMap.keySet()) {
         * System.out.println(index + ". " + branchName);
         * indexMap.put(index, branchName);
         * index++;
         * }
         */

        // Allow user to select a branch by index
        divider();
        System.out.println("Enter the index of the branch to select, or 0 to exit:");
        int choice = scanner.nextInt();

        if (choice > 0 && choice < index) {
            String selectedBranchName = indexMap.get(choice);
            setCurrentBranch(selectedBranchName);
            System.out.println("Selected Branch: " + getCurrentBranch().getBranchName());
        } else if (choice != 0) {
            System.out.println("Invalid index. Please try again.");
        }
    }
    public void printStaffDetails(List<Staff> staffList, List<String> filterBranch, String sortByAttribute) {
        // How to use filter
        // List<String> filterBranches = new ArrayList<>();
        // filterBranches.add("NTU");
        // filterBranches.add("NUS");

        // Filter and sort the staff list
        if (filterBranch != null && !filterBranch.isEmpty()) {
            staffList.removeIf(staff -> !filterBranch.contains(staff.getBranch()));
        }

        if (sortByAttribute != null) {
            Collections.sort(staffList, Comparator.comparing(staff -> {
                switch (sortByAttribute.toLowerCase()) {
                    case "name":
                        return staff.getName();
                    case "age":
                        return String.valueOf(staff.getAge());
                    case "gender":
                        return staff.getGender().toString();
                    case "branch":
                        return staff.getBranch();
                    default:
                        return "";
                }
            }));
        }

        // Find maximum length of each attribute to align columns
        int maxName = "Name".length(), maxGender = "Gender".length(), maxAge = "Age".length(),
                maxBranch = "Branch".length();
        for (Staff staff : staffList) {
            maxName = Math.max(maxName, staff.getName().length());
            maxGender = Math.max(maxGender, staff.getGender().toString().length());
            maxBranch = Math.max(maxBranch, staff.getBranch().length());
            maxAge = Math.max(maxAge, String.valueOf(staff.getAge()).length());
        }

        // Printing the header
        System.out.printf(
                "%-5s%-" + (maxName + 4) + "s%-" + (maxGender + 4) + "s%-" + (maxAge + 4) + "s%-" + (maxBranch + 4)
                        + "s\n",
                "Index", "Name", "Gender", "Age", "Branch");

        // Printing each staff member details with index
        int index = 1;
        for (Staff staff : staffList) {
            System.out.printf(
                    "%-5d%-" + (maxName + 4) + "s%-" + (maxGender + 4) + "s%-" + (maxAge + 4) + "s%-" + (maxBranch + 4)
                            + "s\n",
                    index++, staff.getName(), staff.getGender(), staff.getAge(), staff.getBranch());
        }
    }

    public void modifyStaff(List<Staff> staffList) {
        System.out.println("Enter the index of the staff to modify, or 0 to exit:");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice > 0 && choice <= staffList.size()) {
            Staff selectedStaff = staffList.get(choice - 1);
            System.out.println("Selected: " + selectedStaff.getName());
            divider();
            System.out.println("Choose an attribute to modify:");
            System.out.println("1. Name");
            System.out.println("2. Age");
            System.out.println("3. Gender");
            System.out.println("4. Branch");
            System.out.println("Enter your choice:");
            divider();

            int attributeChoice = scanner.nextInt();
            scanner.nextLine();
            
            switch (attributeChoice) {
            case 1:
                System.out.println("Enter new name:");
                String newName = scanner.nextLine();
                selectedStaff.setName(newName);
                System.out.println("Updated name for " + selectedStaff.getName());
                break;
            case 2:
                System.out.println("Enter new age:");
                int newAge = scanner.nextInt();
                selectedStaff.setAge(newAge);
                System.out.println("Updated age for " + selectedStaff.getName() + " to " + newAge);
                break;
            case 3:
                System.out.println("Enter new gender (Male, Female, Other):");
                String newGenderStr = scanner.nextLine();
                User.Gender newGender;
                try {
                    newGender = User.Gender.valueOf(newGenderStr.toUpperCase());
                    selectedStaff.setGender(newGender);
                    System.out.println("Updated gender for " + selectedStaff.getName());
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid gender. Please enter Male, Female, or Other.");
                }
                break;
            case 4: //for transfering branch
                listAndSelectBranch(); // SET TO NEW SELECTED BRANCH
                String editBranch = scanner.nextLine();
                selectedStaff.setBranch(editBranch);
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
                break;
            }
        } else if (choice != 0) {
            System.out.println("Invalid index. Please try again.");
        }
    }

    public Order displayOrdersAndSelectForStaff() { // FOR STAFF
        Scanner scanner = new Scanner(System.in);
        int index = 1;

        // Header with padding
        List<Order> orders = this.getCurrentBranch().getOrders();
        // Determine the maximum length of each field to set column widths dynamically
        int maxOrderIdLength = "Order ID".length();
        int maxCustomerIdLength = "Customer ID".length();
        int maxStatusLength = "Status".length();
        for (Order order : orders) {
            maxOrderIdLength = Math.max(maxOrderIdLength, order.getOrderId().length());
            maxCustomerIdLength = Math.max(maxCustomerIdLength, order.getCustomerId().length());
            maxStatusLength = Math.max(maxStatusLength, order.getStatus().toString().length());
        }

        // Adding 4 spaces for padding
        int orderIdPadding = maxOrderIdLength + 4;
        int customerIdPadding = maxCustomerIdLength + 4;
        int statusPadding = maxStatusLength + 4;
        int isTakeawayPadding = "Is Takeaway".length() + 4; // Static since values are either "Yes" or "No"

        // Print the header
        System.out.printf(
                "%-5s %-" + orderIdPadding + "s %-" + customerIdPadding + "s %-" + statusPadding + "s %-"
                        + isTakeawayPadding + "s\n",
                "Index", "Order ID", "Customer ID", "Status", "Is Takeaway");

        // Print each order
        for (Order order : orders) {
            System.out.printf(
                    "%-5d %-" + orderIdPadding + "s %-" + customerIdPadding + "s %-" + statusPadding + "s %-"
                            + isTakeawayPadding + "s\n",
                    index++,
                    order.getOrderId(),
                    order.getCustomerId(),
                    order.getStatus(),
                    order.isTakeaway() ? "Yes" : "No");
        }

        // Allow user to select an order by index
        divider();
        System.out.println("""
                (Select Index to edit order)

                (0) back""");
        int choice = scanner.nextInt();
        if (choice > 0 && choice <= orders.size()) {
            Order selectedOrder = orders.get(choice - 1);
            clearConsole();
            divider();
            System.out.println("ORDER INFORMATION AND MODIFICATION");
            // Print the header
            System.out.printf(
                "%-5s %-" + orderIdPadding + "s %-" + customerIdPadding + "s %-" + statusPadding + "s %-"
                + isTakeawayPadding + "s\n",
                "Index", "Order ID", "Customer ID", "Status", "Is Takeaway");
                
                System.out.printf(
                    "%-5d %-" + orderIdPadding + "s %-" + customerIdPadding + "s %-" + statusPadding + "s %-"
                    + isTakeawayPadding + "s\n",
                    0,
                    selectedOrder.getOrderId(),
                    selectedOrder.getCustomerId(),
                    selectedOrder.getStatus(),
                    selectedOrder.isTakeaway() ? "Yes" : "No");
                    
                    // PRINT INFORMATION ABOUT A ORDER
        System.out.println("");
        System.out.println("ORDER ITEMS");

            List<OrderItem> CartMenuItemList = selectedOrder.getItems();
            int maxNameLength = "Item Name".length();
            int maxQuantityLength = String.valueOf("Quantity").length();
            int maxTakeawayLength = "Takeaway".length(); 
            for (OrderItem item : CartMenuItemList) {
                maxNameLength = Math.max(maxNameLength, item.getMenuItem().getName().length());
                maxQuantityLength = Math.max(maxQuantityLength, String.valueOf(item.getQuantity()).length());
                // Assuming `isTakeaway()` method returns a boolean that can be shown directly or needs conversion
                maxTakeawayLength = Math.max(maxTakeawayLength, selectedOrder.isTakeaway() ? "Yes".length() : "No".length()); 
            }
            
            int maxNamePadding = maxNameLength + 4;
            int maxQuantityPadding = maxQuantityLength + 4;
            int maxTakeawayPadding = maxTakeawayLength + 4; // Calculate padding for the takeaway column
            
            // Print header with Takeaway column
            System.out.printf("%-5s %-" + maxNamePadding + "s %-" + maxQuantityPadding + "s %-" + maxTakeawayPadding + "s%n", "Index", "Name", "Quantity", "Takeaway");
            for (OrderItem item : CartMenuItemList) {
                // Print each item with Takeaway status
                System.out.printf("%-5d %-" + maxNamePadding + "s %-" + maxQuantityPadding + "s %-" + maxTakeawayPadding + "s%n", 0, item.getMenuItem().getName(), item.getQuantity(), selectedOrder.isTakeaway() ? "Yes" : "No");
            }
            divider();
            System.out.printf("Total Price: %.2f\n",selectedOrder.getTotalCost());
            divider();
            return selectedOrder;
            // Further action can be taken here depending on what needs to be done with the
            // selected order
        } else if (choice < -1 || choice > orders.size()) {
            System.out.println("Invalid index. Please try again.");
            displayOrdersAndSelectForStaff();
        }
        return null;

    }
    public List<Order> findOrderById(String customerId) { //FOR CUSTOMER
        List<Order> matchingOrders = new ArrayList<>();
        if (currentBranch != null) {
            for (Order order : currentBranch.getOrders()) {
                if (order.getCustomerId().equals(customerId)) {
                    matchingOrders.add(order);
                }
            }
        }
        return matchingOrders;
    }
    

    public Order displayMenuAndSelect(Order orderCart) { // FOR CUSTOMER
        // Scanner scanner = new Scanner(System.in);
        int index = 1;
        clearConsole();
        divider();
        if (orderCart.getItems().size() == 0) {
            System.out.println("Your cart is empty!");
        } else {
            System.out.println("Your cart");
            List<OrderItem> CartMenuItemList = orderCart.getItems();
            int maxNameLength = "Item Name".length();
            int maxQuantityLength = String.valueOf("Quantity").length();
            for (OrderItem item : CartMenuItemList) {
                maxNameLength = Math.max(maxNameLength, item.getMenuItem().getName().length());
                maxQuantityLength = Math.max(maxQuantityLength, String.valueOf(item.getQuantity()).length());
            }
    
            int maxNamePadding = maxNameLength + 4;
            int maxQuantityPadding = maxQuantityLength + 4;
    
            System.out.printf("%-5s %-" + maxNamePadding + "s %-" + maxQuantityPadding + "s%n", "Index", "Name", "Quantity");
            for (OrderItem item : CartMenuItemList) {
                System.out.printf("%-5d %-" + maxNamePadding + "s %-" + maxQuantityPadding + "s%n", 0, item.getMenuItem().getName(), item.getQuantity());
            }
            divider();
            System.out.printf("Total Price: %.2f",orderCart.getTotalCost());
        }
        
        
        System.out.println("");
        divider();
        System.out.printf("""
                            Welcome to %s\n""", getCurrentBranch().getBranchName());
        List<MenuItem> MenuItemList = getCurrentBranch().getBranchMenu().getMenuItems();
        int maxNameLength = "Order ID".length();
        int maxPriceLength = String.valueOf("Price").length();
        int maxCatLength = "Status".length();
        for (MenuItem item : MenuItemList) {
            maxNameLength = Math.max(maxNameLength, item.getName().length());
            maxPriceLength = Math.max(maxPriceLength, String.valueOf(item.getPrice()).length());
            maxCatLength = Math.max(maxCatLength, item.getCategory().length());
        }
    
        int maxNamePadding = maxNameLength + 4;
        int maxPricePadding = maxPriceLength + 4;
        int maxCatPadding = maxCatLength + 4;
        System.out.println();
        System.out.printf("%-5s %-" + maxNamePadding + "s %-" + maxCatPadding + "s %-" + maxPricePadding + "s%n", "Index", "Name", "Category", "Price");
        for (MenuItem item : MenuItemList) {
            if (item.getBranch().equals(currentBranch.getBranchName())) {
                System.out.printf("%-5d %-" + maxNamePadding + "s %-" + maxCatPadding + "s %-" + maxPricePadding + "s%n", index++, item.getName(), item.getCategory(), item.getPrice());
            }
        }
        divider();
        System.out.println("");
        if (orderCart.getItems().size() == 0) {
            System.out.printf("""
                    Please Choose your menu 
                    (0) Back\n""");
        } else {
            System.out.printf("""
                Welcome to %s
                Please Choose your menu 
                (0) Checkout\n""", currentBranch.getBranchName());
        }
        divider();
    
        int choice = scanner.nextInt();
        if (choice != 0) {
            MenuItem selectedMenu = MenuItemList.get(choice - 1);
            clearConsole();
            System.out.println("MENU SELECTED");
            System.out.printf("%-5s %-" + maxNamePadding + "s %-" + maxCatPadding + "s %-" + maxPricePadding + "s%n", "Index", selectedMenu.getName(), selectedMenu.getCategory(), selectedMenu.getPrice());
            divider();
            System.out.println("""
                    Please insert Quantity
                    (0) back""");
            int quantity = scanner.nextInt();
            orderCart.addItem(selectedMenu, quantity);
            displayMenuAndSelect(orderCart);
        }
        return orderCart;
    }
    
    public void addItem(Menu menu) {
        if (menu != null) {
            System.out.println("Adding item to menu of " + currentBranch.getBranchName());
            System.out.println("Enter the name of the new menu item:");
            String name = scanner.nextLine();

            System.out.println("Enter the price of the new menu item:");
            double price = scanner.nextDouble();
            scanner.nextLine();  // Clear buffer after double input

            System.out.println("Enter the category of the new menu item:");
            String category = scanner.nextLine();

            MenuItem newItem = new MenuItem(name, price, currentBranch.getBranchName(), category);
            menu.addMenuItem(newItem);
            System.out.println("Item added successfully to " + currentBranch.getBranchName());
            divider();
            int index = 1;
            List<MenuItem> MenuItemList = getCurrentBranch().getBranchMenu().getMenuItems();
            int maxNameLength = "Order ID".length();
            int maxPriceLength = String.valueOf("Price").length();
            int maxCatLength = "Status".length();
            for (MenuItem item : MenuItemList) {
                maxNameLength = Math.max(maxNameLength, item.getName().length());
                maxPriceLength = Math.max(maxPriceLength, String.valueOf(item.getPrice()).length());
                maxCatLength = Math.max(maxCatLength, item.getCategory().length());
            }
        
            int maxNamePadding = maxNameLength + 4;
            int maxPricePadding = maxPriceLength + 4;
            int maxCatPadding = maxCatLength + 4;
            System.out.println();
            System.out.printf("%-5s %-" + maxNamePadding + "s %-" + maxCatPadding + "s %-" + maxPricePadding + "s%n","Index", "Name", "Category", "Price");
            for (MenuItem item : MenuItemList) {
                if (item.getBranch().equals(currentBranch.getBranchName())) {
                    System.out.printf("%-5d %-" + maxNamePadding + "s %-" + maxCatPadding + "s %-" + maxPricePadding + "s%n", index++, item.getName(), item.getCategory(), item.getPrice());
                }
            }
            divider();
        } else {
            System.out.println("No active menu found. Cannot add item.");
        }
    }

    public void removeItem(Menu menu) {
        if (menu != null) {
            divider();
            int index = 1;
            List<MenuItem> MenuItemList = getCurrentBranch().getBranchMenu().getMenuItems();
            int maxNameLength = "Order ID".length();
            int maxPriceLength = String.valueOf("Price").length();
            int maxCatLength = "Status".length();
            for (MenuItem item : MenuItemList) {
                maxNameLength = Math.max(maxNameLength, item.getName().length());
                maxPriceLength = Math.max(maxPriceLength, String.valueOf(item.getPrice()).length());
                maxCatLength = Math.max(maxCatLength, item.getCategory().length());
            }
        
            int maxNamePadding = maxNameLength + 4;
            int maxPricePadding = maxPriceLength + 4;
            int maxCatPadding = maxCatLength + 4;
            System.out.println();
            System.out.printf("%-5s %-" + maxNamePadding + "s %-" + maxCatPadding + "s %-" + maxPricePadding + "s%n","Index", "Name", "Category", "Price");
            for (MenuItem item : MenuItemList) {
                if (item.getBranch().equals(currentBranch.getBranchName())) {
                    System.out.printf("%-5d %-" + maxNamePadding + "s %-" + maxCatPadding + "s %-" + maxPricePadding + "s%n", index++, item.getName(), item.getCategory(), item.getPrice());
                }
            }
            divider();
            System.out.println("Enter the name of the menu item to remove:");
            String name = scanner.nextLine();
            MenuItem itemToRemove = new MenuItem(name, 0, currentBranch.getBranchName(), null);
            boolean removed = menu.removeMenuItem(itemToRemove);
            if (removed) {
                System.out.println("Item removed successfully from " + currentBranch.getBranchName());
            } else {
                System.out.println("Item not found in " + currentBranch.getBranchName());
            }
        } else {
            System.out.println("No active menu found. Cannot remove item.");
        }
    }

    public void updateItem(Menu menu) {
        if (menu != null) {
            int index = 1;
            List<MenuItem> MenuItemList = getCurrentBranch().getBranchMenu().getMenuItems();
            int maxNameLength = "Order ID".length();
            int maxPriceLength = String.valueOf("Price").length();
            int maxCatLength = "Status".length();
            for (MenuItem item : MenuItemList) {
                maxNameLength = Math.max(maxNameLength, item.getName().length());
                maxPriceLength = Math.max(maxPriceLength, String.valueOf(item.getPrice()).length());
                maxCatLength = Math.max(maxCatLength, item.getCategory().length());
            }
        
            int maxNamePadding = maxNameLength + 4;
            int maxPricePadding = maxPriceLength + 4;
            int maxCatPadding = maxCatLength + 4;
            System.out.println();
            System.out.printf("%-5s %-" + maxNamePadding + "s %-" + maxCatPadding + "s %-" + maxPricePadding + "s%n","Index", "Name", "Category", "Price");
            for (MenuItem item : MenuItemList) {
                if (item.getBranch().equals(currentBranch.getBranchName())) {
                    System.out.printf("%-5d %-" + maxNamePadding + "s %-" + maxCatPadding + "s %-" + maxPricePadding + "s%n", index++, item.getName(), item.getCategory(), item.getPrice());
                }
            }
            divider();
            System.out.println("Enter the name of the menu item to update:");
            String name = scanner.nextLine();

            MenuItem itemToUpdate = menu.findMenuItemByName(name, currentBranch.getBranchName());
            if (itemToUpdate != null) {
                System.out.println("Select attribute to update (name, price, category):");
                String attribute = scanner.nextLine();
                switch (attribute.toLowerCase()) {
                    case "name":
                        System.out.println("Enter new name:");
                        itemToUpdate.setName(scanner.nextLine());
                        break;
                    case "price":
                        System.out.println("Enter new price:");
                        itemToUpdate.setPrice(scanner.nextDouble());
                        scanner.nextLine(); // Consume newline
                        break;
                    case "category":
                        System.out.println("Enter new category:");
                        itemToUpdate.setCategory(scanner.nextLine());
                        break;
                    default:
                        System.out.println("Invalid attribute.");
                        return;
                }
                System.out.println("Item updated successfully in " + currentBranch.getBranchName());

            } else {
                System.out.println("Item not found in " + currentBranch.getBranchName());
            }
        } else {
            System.out.println("No active menu found. Cannot update item.");
        }
    }
}
