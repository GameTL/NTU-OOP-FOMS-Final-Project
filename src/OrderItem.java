package src;

import java.io.Serializable;

/**
 * Represents an item within an order, including the menu item and quantity.
 * This class is serializable to facilitate easy storage and retrieval.
 * @author Shuya Yamazaki  Created at 6/4/24 Email : @author shuya.yamazaki1223@gmail.com
 * @version 1.00.00
 */
public class OrderItem implements Serializable{
    private static final long serialVersionUID = 5L;
    
    private MenuItem menuItem; // The menu item associated with this order item.
    private int quantity;      // The quantity of the menu item ordered.

    /**
     * Constructs a new OrderItem with a specified menu item and quantity.
     * @param menuItem The menu item that is being ordered.
     * @param quantity The quantity of this menu item in the order.
     */
    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    /**
     * Returns the menu item of this order item.
     * @return The menu item.
     */
    public MenuItem getMenuItem() {
        return menuItem;
    }

    /**
     * Returns the quantity of the menu item ordered.
     * @return The quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the menu item for this order item.
     * @param menuItem The new menu item to be associated with this order item.
     */
    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    /**
     * Sets the quantity of the menu item for this order.
     * @param quantity The new quantity of the menu item.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Provides a string representation of the order item, combining the menu item name and its quantity.
     * @return A string format of the order item, showing both the menu item name and quantity.
     */
    @Override
    public String toString() {
        return String.format("%s x%d", menuItem.getName(), quantity);
    }
}
