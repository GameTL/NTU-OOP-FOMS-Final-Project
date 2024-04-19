package src;

import java.io.Serializable;

/**
 * Represents an item on a menu, containing details such as name, price, category, and branch. 
 * This class is serializable to support storage and retrieval.
 * @author Tracey Heso  Created at 26/3/24 Email : @author tracehheso@gmail.com
 * @version 1.00.00
 */
public class MenuItem implements Serializable {
    private static final long serialVersionUID = 7L;

    private String name;
    private double price;
    private String category;
    private String branch;

    /**
     * Constructs a new menu item with specified name, price, branch, and category.
     * @param name The name of the menu item.
     * @param price The price of the menu item.
     * @param branch The branch where the menu item is available.
     * @param category The category of the menu item.
     */
    public MenuItem(String name, double price, String branch, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.branch = branch;
    }

    /**
     * Returns a string representation of the menu item, formatted with its name, price, and category.
     * @return A formatted string representing the menu item.
     */
    @Override
    public String toString() {
        return String.format("%s - $%.2f - %s", name, price, category);
    }

    /**
     * Gets the name of the menu item.
     * @return The name of the menu item.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the menu item.
     * @param name The new name for the menu item.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the price of the menu item.
     * @return The price of the menu item.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the menu item.
     * @param price The new price for the menu item.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the branch where the menu item is available.
     * @return The branch of the menu item.
     */
    public String getBranch() {
        return branch;
    }

    /**
     * Sets the branch where the menu item is available.
     * @param branch The new branch for the menu item.
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * Gets the category of the menu item.
     * @return The category of the menu item.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the menu item.
     * @param category The new category for the menu item.
     */
    public void setCategory(String category) {
        this.category = category;
    }
}
