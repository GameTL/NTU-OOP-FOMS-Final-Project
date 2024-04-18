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

public class BranchOperator {

    private Map<String, Branch> branchMap = new HashMap<>();
    private Branch currentBranch;

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

    private Scanner scanner = new Scanner(System.in);

    public List<Staff> getAllStaff() {
        List<Staff> allStaff = new ArrayList<>(); // Start with all staff members
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

    public void printAndModifyStaffDetails(List<Staff> staffList, List<String> filterBranch, String sortByAttribute) {

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

        // Allow user to select and modify a staff member
        modifyStaff(staffList);
    }

    private void modifyStaff(List<Staff> staffList) {
        System.out.println("Enter the index of the staff to modify, or 0 to exit:");
        int choice = scanner.nextInt();
        if (choice > 0 && choice <= staffList.size()) {
            Staff selectedStaff = staffList.get(choice - 1);
            System.out.println("Selected: " + selectedStaff.getName());
            System.out.println("Enter new age:");
            int newAge = scanner.nextInt();
            selectedStaff.setAge(newAge); // Assuming a setter exists
            System.out.println("Updated age for " + selectedStaff.getName() + " to " + newAge);
        }

    }

    public Order displayOrdersAndSelect() { // FOR STAFF
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
            System.out.println("ORDER SELECTED");
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
            return selectedOrder;
            // Further action can be taken here depending on what needs to be done with the
            // selected order
        } else if (choice < -1 || choice > orders.size()) {
            System.out.println("Invalid index. Please try again.");
            displayOrdersAndSelect();
        }
        return null;

    }

    public Order displayMenuAndSelect(Order orderCart) { // FOR CUSTOMER
        Scanner scanner = new Scanner(System.in);
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
    
    
}
