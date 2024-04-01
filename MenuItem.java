public class MenuItem {
    private String id;
    private String name;
    private double price;
    private String description;
    private String category;
    private String branch;
    private boolean available;

    public MenuItem(String id, String name, String description, double price, String category, String branch){
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.branch = branch;
        this.available = true;
    }
    public void displayMenu(){
       System.out.println("Please choose from the menu below: ");
       for ()  //refer to weeklysales.java
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;  
    }
    public String getPrice(){
        return price;
    }
    public void setName(double price){
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
    public String isAvailable(){
        return available;
    }
    public void setAvailable(boolean available){
        this.available = available;  
    }
}
