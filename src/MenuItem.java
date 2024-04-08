package src;
public class MenuItem {
    private String name;
    private double price;
    private String category;
    private String branch;

    public MenuItem(String name, double price, String branch, String category){
        this.name = name;
        this.price = price;
        this.category = category;
        this.branch = branch;
    }
    public String toString(){
        return String.format("%s - $%.2f - %s", name, price, category);
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public String getBranch(){
        return branch;
    }
    public void setBranch(String branch){
        this.branch = branch;
    }
    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;
    }
}
