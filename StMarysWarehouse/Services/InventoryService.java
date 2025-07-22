package services;

import database.DatabaseManager;
import models.Inventory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryService {

    // Add a new inventory item
    public void addInventory(Inventory item) throws SQLException {
        String sql = "INSERT INTO inventory (item_name, item_quantity, item_location) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseManager.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, item.getName());
            pstmt.setInt(2, item.getQuantity());
            pstmt.setString(3, item.getLocation());
            pstmt.executeUpdate();
        }
    }

    // Retrieve all inventory items
    public List<Inventory> getAllInventory() throws SQLException {
        List<Inventory> list = new ArrayList<>();
        String sql = "SELECT * FROM inventory";
        try (Connection conn = DatabaseManager.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Inventory(
                    rs.getInt("item_id"),
                    rs.getString("item_name"),
                    rs.getInt("item_quantity"),
                    rs.getString("item_location")
                ));
            }
        }
        return list;
    }

    // Update an existing inventory item
    public void updateInventory(Inventory item) throws SQLException {
        String sql = "UPDATE inventory SET item_name = ?, item_quantity = ?, item_location = ? WHERE item_id = ?";
        try (Connection conn = DatabaseManager.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, item.getName());
            pstmt.setInt(2, item.getQuantity());
            pstmt.setString(3, item.getLocation());
            pstmt.setInt(4, item.getId());
            pstmt.executeUpdate();
        }
    }

    // Delete an inventory item
    public void deleteInventory(int id) throws SQLException {
        String sql = "DELETE FROM inventory WHERE item_id = ?";
        try (Connection conn = DatabaseManager.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    // Search inventory by name (optional helper)
    public List<Inventory> searchByName(String keyword) throws SQLException {
        List<Inventory> list = new ArrayList<>();
        String sql = "SELECT * FROM inventory WHERE item_name LIKE ?";
        try (Connection conn = DatabaseManager.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + keyword + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    list.add(new Inventory(
                        rs.getInt("item_id"),
                        rs.getString("item_name"),
                        rs.getInt("item_quantity"),
                        rs.getString("item_location")
                    ));
                }
            }
        }
        return list;
    }
}
