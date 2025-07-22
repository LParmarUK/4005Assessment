package models;

public class Order {
    private int id;
    private String orderDate;
    private String customerName;
    private String orderStatus;

    public Order(int id, String orderDate, String customerName, String orderStatus) {
        this.id = id;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.orderStatus = orderStatus;
    }

    public int getId() { return id; }
    public String getOrderDate() { return orderDate; }
    public String getCustomerName() { return customerName; }
    public String getOrderStatus() { return orderStatus; }

    public void setId(int id) { this.id = id; }
    public void setOrderDate(String orderDate) { this.orderDate = orderDate; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }

    @Override
    public String toString() {
        return id + " | " + orderDate + " | " + customerName + " | " + orderStatus;
    }
}