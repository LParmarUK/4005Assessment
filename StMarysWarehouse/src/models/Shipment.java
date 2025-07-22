package models;

public class Shipment {
    private int id;
    private String destination;
    private String shipmentDate;
    private String shipmentStatus;

    public Shipment(int id, String destination, String shipmentDate, String shipmentStatus) {
        this.id = id;
        this.destination = destination;
        this.shipmentDate = shipmentDate;
        this.shipmentStatus = shipmentStatus;
    }

    public int getId() { return id; }
    public String getDestination() { return destination; }
    public String getShipmentDate() { return shipmentDate; }
    public String getShipmentStatus() { return shipmentStatus; }

    public void setId(int id) { this.id = id; }
    public void setDestination(String destination) { this.destination = destination; }
    public void setShipmentDate(String shipmentDate) { this.shipmentDate = shipmentDate; }
    public void setShipmentStatus(String shipmentStatus) { this.shipmentStatus = shipmentStatus; }

    @Override
    public String toString() {
        return id + " | " + destination + " | " + shipmentDate + " | " + shipmentStatus;
    }
}