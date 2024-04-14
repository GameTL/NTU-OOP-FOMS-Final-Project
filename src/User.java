package src;

public abstract class User {
    protected String id;
    protected String name;
    protected String contactInfo;

    public User(String id, String name, String contactInfo) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    // Common getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getContactInfo() { return contactInfo; }

    // Common setters
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }
}
