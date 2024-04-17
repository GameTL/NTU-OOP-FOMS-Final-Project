package src;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> items;

    public Menu() {
        this.items = new ArrayList<>();
        initializeMenuItems();
    }

    private void initializeMenuItems() {
        // Initialization for NTU branch
        items.add(new MenuItem("FRIES", 3.2, "NTU", "Side"));
        items.add(new MenuItem("3PC SET MEAL", 9.9, "NTU", "Set meal"));
        items.add(new MenuItem("COLE SLAW", 2.7, "NTU", "Side"));
        items.add(new MenuItem("CHICKEN NUGGET", 6.6, "NTU", "Side"));

        // Initialization for JP branch
        items.add(new MenuItem("CAJUN FISH", 5.6, "JP", "Burger"));
        items.add(new MenuItem("CHICKEN NUGGET", 6.9, "JP", "Side"));

        // Initialization for JE branch
        items.add(new MenuItem("COLE SLAW", 2.7, "JE", "Side"));
        items.add(new MenuItem("3PC SET MEAL", 10.4, "JE", "Set meal"));
        items.add(new MenuItem("PEPSI", 2.1, "JE", "Drink"));
    }

    public List<MenuItem> getMenuItems() {
        return items;
    }
    public void addMenuItem(MenuItem item) {
        items.add(item);
    }

    public void removeMenuItem(MenuItem item) {
        items.removeIf(existingItem -> existingItem.getName().equals(item.getName()) && existingItem.getBranch().equals(item.getBranch()));
    }

    public MenuItem findMenuItem(String name, String branch){
        for (MenuItem item : items){
            if (item.getName().equals(name) && item.getBranch().equals(branch)) {
                return item;
            }
        }
        return null;
    }

    public MenuItem findMenuItemByName(String name) {
        for (MenuItem item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public void displayMenu(Branch branch) {
        int index = 1;
        for (MenuItem item : items) {
            if (item.getBranch().equalsIgnoreCase(branch.getBranchName())) {
                System.out.println(index + ". " + item);
                index++;
            }
        }
        // sc.close();
    }
}
