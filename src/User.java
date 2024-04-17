    package src;

public abstract class User {
    public enum Gender {
        Male, Female
    }
    public enum Role {
        Staff, Admin, Manager
    }
    protected String id;
    protected String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Common getters
    public String getId() { return id; }
    public String getName() { return name; }
  
    // Common setters
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
}
