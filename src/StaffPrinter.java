package src;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// public class StaffDisplay {
//     // Method to display staff list based on filters
//     public static void displayStaffList(List<Staff> staffList, String branch, String role, String gender, Integer age) {
//         staffList.stream()
//                  .filter(staff -> (branch == null || staff.getBranch().equals(branch)) &&
//                                 //   (role == null || staff.getRole().equals(role)) &&
//                                   (gender == null || staff.getGender().equals(gender)) &&
//                                   (age == null || staff.getAge() == age))
//                  .forEach(System.out::println);
//     }
// }


public class StaffPrinter {
    private Scanner scanner = new Scanner(System.in);

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
}
