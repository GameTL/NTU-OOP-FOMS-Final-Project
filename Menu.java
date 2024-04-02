import java.util.ArrayList;

public class Menu {
    private List<MenuItem> items;

    public Menu(){
        this.items = new ArrayList<>();
        initializeMenuItems();
        sortItemsByCategory();
    }
    private void initializeMenuItems(){
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
    private void sortItemsByCategory(){
        items.sort(Comparator.comparing(MenuItem::getCategory));
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
    public static void main(String[] args) {
        Menu menu = new Menu();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Please select a branch (NTU, JP, or JE): ");
        String branch = scanner.nextLine();

        menu.setBranch();
        menu.displaymenu();
        
    }
}


