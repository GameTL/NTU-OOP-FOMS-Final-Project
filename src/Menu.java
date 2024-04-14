package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public void addMenuItem(MenuItem item) {
        items.add(item);
    }

    public void removeMenuItem(MenuItem item) {
        items.remove(item);
    }

    public void displayMenu(Branch branch) {
        List<MenuItem> branchMenu = branch.getBranchMenu();
        System.out.println("Please choose your order from the menu.");
        System.out.println("\n                MENU");
        System.out.println("=========================================");
        int index = 1;
        for (MenuItem item : items) {
            if (item.getBranch().equalsIgnoreCase(branch.getBranchName())) {
                System.out.println(index + ". " + item);
                index++;
            }
        }
        System.out.println("=========================================");
        // sc.close();
    }
}
