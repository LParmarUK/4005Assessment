package models;

public class Inventory {
    private int id;
    private String name;
    private int quantity;
    private String location;

    public Inventory(int id, String name, int quantity, String location) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.location = location;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public String getLocation() { return location; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setLocation(String location) { this.location = location; }
}