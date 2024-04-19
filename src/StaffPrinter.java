package src;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Handles the display and modification of staff details based on user input.
 * Allows filtering and sorting of staff records as well as modifying specific staff attributes.
 * @author Game Limsila  Created at 17/3/24 Email : @author limsila.limsila@yahoo.com
 * @version 1.00.00
 */
public class StaffPrinter {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Prints staff details after applying specified filters and sort criteria, and allows modification of staff details.
     * This method filters the staff list based on branches, sorts them based on the specified attribute,
     * and displays the list in a formatted manner. Users can select a staff member to modify their details.
     *
     * @param staffList The list of staff members to process.
     * @param filterBranch A list of branch names to filter the staff list by.
     * @param sortByAttribute The attribute name to sort the list by ("name", "age", "gender", "branch").
     */
    public void printAndModifyStaffDetails(List<Staff> staffList, List<String> filterBranch, String sortByAttribute) {
        // Filter and sort the staff list
        // How to use filter 
        // List<String> filterBranches = new ArrayList<>();
        // filterBranches.add("NTU");
        // filterBranches.add("NUS");
        if (filterBranch != null && !filterBranch.isEmpty()) {
            staffList.removeIf(staff -> !filterBranch.contains(staff.getBranch()));
        }

        if (sortByAttribute != null) {
            Collections.sort(staffList, Comparator.comparing(staff -> {
                switch (sortByAttribute.toLowerCase()) {
                    case "name": return staff.getName();
                    case "age": return String.valueOf(staff.getAge());
                    case "gender": return staff.getGender().toString();
                    case "branch": return staff.getBranch();
                    default: return "";
                }
            }));
        }

        // Find maximum length of each attribute to align columns
        int maxName = "Name".length(), maxGender = "Gender".length(), maxAge = "Age".length(), maxBranch = "Branch".length();
        for (Staff staff : staffList) {
            maxName = Math.max(maxName, staff.getName().length());
            maxGender = Math.max(maxGender, staff.getGender().toString().length());
            maxBranch = Math.max(maxBranch, staff.getBranch().length());
            maxAge = Math.max(maxAge, String.valueOf(staff.getAge()).length());
        }

        // Printing the header
        System.out.printf("%-5s%-"+ (maxName + 4) +"s%-"+ (maxGender + 4) +"s%-"+ (maxAge + 4) +"s%-"+ (maxBranch + 4) +"s\n", 
                          "Index", "Name", "Gender", "Age", "Branch");

        // Printing each staff member details with index
        int index = 1;
        for (Staff staff : staffList) {
            System.out.printf("%-5d%-"+ (maxName + 4) +"s%-"+ (maxGender + 4) +"s%-"+ (maxAge + 4) +"s%-"+ (maxBranch + 4) +"s\n",
                              index++, staff.getName(), staff.getGender(), staff.getAge(), staff.getBranch());
        }

        // Allow user to select and modify a staff member
        modifyStaff(staffList);
    }

    /**
     * Prompts the user to select a staff member by index and modify their age.
     * Assumes that the user provides valid input.
     * 
     * @param staffList The list of staff members displayed to the user.
     */
    private void modifyStaff(List<Staff> staffList) {
        System.out.println("Enter the index of the staff to modify, or 0 to exit:");
        int choice = scanner.nextInt();
        if (choice > 0 && choice <= staffList.size()) {
            Staff selectedStaff = staffList.get(choice - 1);
            System.out.println("Selected: " + selectedStaff.getName());
            System.out.println("Enter new age:");
            int newAge = scanner.nextInt();
            selectedStaff.setAge(newAge); 
            System.out.println("Updated age for " + selectedStaff.getName() + " to " + newAge);
        }
    }
}
