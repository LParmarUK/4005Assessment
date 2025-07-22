package ui;

import services.InventoryService;
import services.OrderService;
import models.Inventory;
import models.Order;

import java.util.Scanner;
import java.util.List;

public class MainMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final InventoryService inventoryService = new InventoryService();
    private final OrderService orderService = new OrderService();

    public void show() {
        while (true) {
            System.out.println("\n=== St Mary’s Warehouse System ===");
            System.out.println("1. Manage Inventory");
            System.out.println("2. Process Orders");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> manageInventory();
                case "2" -> processOrders();
                case "0" -> System.exit(0);
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void manageInventory() {
        System.out.println("\n--- Inventory Menu ---");
        System.out.println("1. View all items");
        System.out.println("2. Add new item");
        System.out.println("3. Delete item");
        System.out.print("Select: ");
        String choice = scanner.nextLine();

        try {
            switch (choice) {
                case "1" -> {
                    List<Inventory> items = inventoryService.getAllInventory();
                    for (Inventory item : items) {
                        System.out.println(item.getId() + ": " + item.getName() + " (" + item.getQuantity() + ") - " + item.getLocation());
                    }
                }
                case "2" -> {
                    System.out.print("Item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Quantity: ");
                    int qty = Integer.parseInt(scanner.nextLine());
                    System.out.print("Location: ");
                    String loc = scanner.nextLine();

                    inventoryService.addInventory(new Inventory(0, name, qty, loc));
                    System.out.println("Item added.");
                }
                case "3" -> {
                    System.out.print("Enter ID to delete: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    inventoryService.deleteInventory(id);
                    System.out.println("Item deleted.");
                }
                default -> System.out.println("Invalid option.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void processOrders() {
        System.out.println("\n--- Order Menu ---");
        System.out.println("1. View all orders");
        System.out.println("2. Add new order");
        System.out.println("3. Delete order");
        System.out.print("Select: ");
        String choice = scanner.nextLine();

        try {
            switch (choice) {
                case "1" -> {
                    List<Order> orders = orderService.getAllOrders();
                    for (Order order : orders) {
                        System.out.println(order.toString());
                    }
                }
                case "2" -> {
                    System.out.print("Order Date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Customer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Order Status: ");
                    String status = scanner.nextLine();

                    orderService.addOrder(new Order(0, date, name, status));
                    System.out.println("Order added.");
                }
                case "3" -> {
                    System.out.print("Enter ID to delete: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    orderService.deleteOrder(id);
                    System.out.println("Order deleted.");
                }
                default -> System.out.println("Invalid option.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}