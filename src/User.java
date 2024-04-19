package src;

import java.io.Serializable;

/**
 * Represents a generic user in the system. This is an abstract class meant to be extended by specific types of users.
 * Implements Serializable to allow user data to be serialized for storage or transmission.
 * @author Shuya Yamazaki  Created at 6/4/24 Email : @author shuya.yamazaki1223@gmail.com
 * @version 1.00.00
 */
public abstract class User implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * Enum for Gender options for a user.
     */
    public enum Gender {
        MALE, FEMALE, OTHER;
    }

    /**
     * Enum for Role options within the system.
     */
    public enum Role {
        Staff, Admin, Manager;
    }

    protected String id;    // Unique identifier for the user.
    protected String name;  // Name of the user.

    /**
     * Constructs a new User with the specified ID and name.
     * @param id The unique identifier for the user.
     * @param name The name of the user.
     */
    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Returns the ID of the user.
     * @return The unique identifier of the user.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the name of the user.
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the ID of the user.
     * @param id The new ID to be set for the user.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the name of the user.
     * @param name The new name to be set for the user.
     */
    public void setName(String name) {
        this.name = name;
    }
}
