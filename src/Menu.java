package src;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * Represents a menu in a system that can contain various menu items. This class is serializable.
 * @author Tracey Heso  Created at 26/3/24 Email : @author tracehheso@gmail.com
 * @version 1.00.00
 */
public class Menu implements Serializable{
    private static final long serialVersionUID = 8L;
    
    private List<MenuItem> items; // List of menu items.

    /**
     * Constructs an empty menu.
     */
    public Menu() {
        this.items = new ArrayList<>();
    }

    /**
     * Retrieves a list of all menu items in the menu.
     * @return A new list containing the menu items.
     */
    public List<MenuItem> getMenuItems() {
        return new ArrayList<>(items);
    }

    /**
     * Adds a menu item to the menu.
     * @param item The menu item to add.
     */
    public void addMenuItem(MenuItem item) {
        items.add(item);
    }

    /**
     * Removes a menu item from the menu based on its name and branch.
     * @param itemToRemove The menu item to remove.
     * @return true if an item was removed, false otherwise.
     */
    public boolean removeMenuItem(MenuItem itemToRemove) {
        return items.removeIf(item -> item.getName().equals(itemToRemove.getName()) && item.getBranch().equals(itemToRemove.getBranch()));
    }

    /**
     * Finds a menu item by name and branch with case-sensitive comparison.
     * @param name The name of the menu item to find.
     * @param branch The branch where the menu item is located.
     * @return The found menu item or null if no matching item is found.
     */
    public MenuItem findMenuItem(String name, String branch){
        for (MenuItem item : items){
            if (item.getName().equals(name) && item.getBranch().equals(branch)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Finds a menu item by name and branch with case-insensitive comparison.
     * @param name The name of the menu item to find.
     * @param branch The branch where the menu item is located.
     * @return The found menu item or null if no matching item is found.
     */
    public MenuItem findMenuItemByName(String name, String branch) {
        for (MenuItem item : items) {
            if (item.getName().equalsIgnoreCase(name) && item.getBranch().equals(branch)) {
                return item;
            }
        }
        return null;
    }
}
