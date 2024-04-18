package src;

import java.io.Serializable;

public abstract class User implements Serializable{
    private static final long serialVersionUID = 1L;
    
    public enum Gender {
        MALE, FEMALE, OTHER;
    }
    public enum Role {
        Staff, Admin, Manager;
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
