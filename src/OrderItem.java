package src;

public class OrderItem{
    private MenuItem menuItem;
    private int quantity;

    public OrderItem(MenuItem menuItem, int quantity){
        this.menuItem = menuItem;
        this.quantity = quantity;
    }
    public MenuItem getmenuItem(){
        return menuItem;
    }
    public MenuItem setmenuItem(MenuItem menuItem){
        this.menuItem = menuItem;
    }
    public int getQuantity(){
        return quantity;
    }
    public int setQuantity(int quantity){
        this.quantity = quantity;
    }
}