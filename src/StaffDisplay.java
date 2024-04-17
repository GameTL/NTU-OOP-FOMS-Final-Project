package src;

import java.util.List;

public class StaffDisplay {
    // Method to display staff list based on filters
    public static void displayStaffList(List<Staff> staffList, String branch, String role, String gender, Integer age) {
        staffList.stream()
                 .filter(staff -> (branch == null || staff.getBranch().equals(branch)) &&
                                  (role == null || staff.getRole().equals(role)) &&
                                  (gender == null || staff.getGender().equalsIgnoreCase(gender)) &&
                                  (age == null || staff.getAge() == age))
                 .forEach(System.out::println);
    }
}
