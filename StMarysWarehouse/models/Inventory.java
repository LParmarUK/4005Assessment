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

    // Getters and Setters...
}
