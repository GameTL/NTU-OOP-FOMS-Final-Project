import java.util.ArrayList;

public class Menu {
    private List<MenuItem> items;

    public Menu(){
        this.items = new ArrayList<>();
    }
    public void addMenuItem(MenuItem item) {
        items.add(item);
    }
    public void removeMenuItem(String item) {
        items.remove(item);
    }
    public void displaymenu() {
        System.out.println("Please choose your order from the menu.");
        System.out.println("=========================================");
        for (MenuItem item : items){
                if (item.getBranch().equals(branch)){
                    System.out.println(item.getName() + "\t" + item.getPrice() + "\t" + item.getCategory());
                }
        }
    }
}
