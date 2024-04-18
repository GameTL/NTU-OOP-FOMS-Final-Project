package src;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Menu implements Serializable{
    private static final long serialVersionUID = 8L;
    
    private List<MenuItem> items;

    public Menu() {
        this.items = new ArrayList<>();
    }

    public List<MenuItem> getMenuItems() {
        return new ArrayList<>(items);
    }
    public void addMenuItem(MenuItem item) {
        items.add(item);
    }

    public boolean removeMenuItem(MenuItem itemToRemove) {
        return items.removeIf(item -> item.getName().equals(itemToRemove.getName()) && item.getBranch().equals(itemToRemove.getBranch()));
    }

    public MenuItem findMenuItem(String name, String branch){
        for (MenuItem item : items){
            if (item.getName().equals(name) && item.getBranch().equals(branch)) {
                return item;
            }
        }
        return null;
    }

    public MenuItem findMenuItemByName(String name, String branch) {
        for (MenuItem item : items) {
            if (item.getName().equalsIgnoreCase(name) && item.getBranch().equals(branch)) {
                return item;
            }
        }
        return null;
    }

    }
    

