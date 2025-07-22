package services;

import database.DatabaseManager;
import models.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    public void addOrder(Order order) throws SQLException {
        String sql = "INSERT INTO orders (order_date, customer_name, order_status) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseManager.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, order.getOrderDate());
            pstmt.setString(2, order.getCustomerName());
            pstmt.setString(3, order.getOrderStatus());
            pstmt.executeUpdate();
        }
    }

    public List<Order> getAllOrders() throws SQLException {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders";
        try (Connection conn = DatabaseManager.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                orders.add(new Order(
                    rs.getInt("order_id"),
                    rs.getString("order_date"),
                    rs.getString("customer_name"),
                    rs.getString("order_status")
                ));
            }
        }
        return orders;
    }

    public void deleteOrder(int id) throws SQLException {
        String sql = "DELETE FROM orders WHERE order_id = ?";
        try (Connection conn = DatabaseManager.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}