package src;

import java.util.List;
import java.util.Scanner;

/**
 * Represents a manager within the system, extending the {@link Staff} class.
 * Managers have additional capabilities, such as viewing a list of staff members within their assigned branch.
 * @author Shuya Yamazaki  Created at 6/4/24 Email : @author shuya.yamazaki1223@gmail.com
 * @version 1.00.00
 */
public class Manager extends Staff {
    private static final long serialVersionUID = 12L;

    private Scanner scanner = new Scanner(System.in);

    /**
     * Constructs a new Manager with specified personal and professional details.
     * 
     * @param id The unique identifier for the manager.
     * @param name The name of the manager.
     * @param gender The gender of the manager.
     * @param age The age of the manager.
     * @param branch The branch the manager is assigned to oversee.
     */
    public Manager(String id, String name, Gender gender, Integer age, String branch) {
        super(id, name, gender, age, branch);
    }

    /**
     * Displays a list of all staff members who are assigned to the same branch as this manager.
     * The list is printed directly to the standard output.
     * 
     * @param staffList The list of all staff members in the system.
     */
    public void displayStaffList(List<Staff> staffList) {
        System.out.println("Staff List for Branch: " + this.getBranch());
        staffList.stream()
                 .filter(staff -> staff.getBranch().equals(this.getBranch()))
                 .forEach(System.out::println);
    }
}
