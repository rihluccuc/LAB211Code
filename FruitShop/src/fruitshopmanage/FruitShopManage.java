/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fruitshopmanage;

import controller.FruitController;
import entity.Fruit;
import entity.Order;
import java.util.ArrayList;
import java.util.Hashtable;
import util.ValidationUtil;

/**
 *
 * @author datkh
 */
public class FruitShopManage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FruitController fruitController = new FruitController();
        String menu = """

                      FRUIT SHOP SYSTEM
                      1. Create Fruit
                      2. View orders
                      3. Shopping (for buyer)
                      4. Exit
                      (Please choose 1 to create product, 2 to view order, 3 for shopping, 4 to Exit program).
                      Your choice: """;
        while (true) {
            int choice = ValidationUtil.getInt(menu, "Please enter a digit", "Please enter 1-4", 1, 4);
            switch (choice) {
                case 1:
                    createFruits(fruitController);
                    break;
                case 2:
                    viewOrders(fruitController);
                    break;
                case 3:
                    shopping(fruitController);
                    break;
                case 4:
                    return;
            }
        }
    }

    // ===================== 1. Create Fruit =====================
    private static void createFruits(FruitController fruitController) {
        while (true) {
            Fruit f = fruitController.inputFruit();
            if (f == null) {
                System.out.println("Fruit already exists!");
                continue;
            }
            if (!ValidationUtil.pressYNtoContinue("Do you want to continue (Y/N)? : ")) {
                break;
            }
        }
        System.out.println("List of Fruit:");
        System.out.printf("%-5s | %-20s | %-15s | %-8s | %-8s |\n", "ID", "Name", "Origin", "Price", "Quantity");
        for (Fruit f : fruitController.getFruits()) {
            System.out.println(f);
        }
    }

    // ===================== 2. View orders =====================
    private static void viewOrders(FruitController fruitController) {
        Hashtable<String, ArrayList<Order>> orders = fruitController.getOrders();
        if (orders.isEmpty()) {
            System.out.println("No orders yet!");
            return;
        }
        for (String customer : orders.keySet()) {
            System.out.println("Customer: " + customer);
            displayItems(fruitController, orders.get(customer), true);
            System.out.println();
        }
    }

    // ===================== 3. Shopping =====================
    private static void shopping(FruitController fruitController) {
        if (fruitController.getAvailableFruits().isEmpty()) {
            System.out.println("No fruit available for sale!");
            return;
        }
        ArrayList<Order> cart = new ArrayList<>();
        while (true) {
            displayAvailableFruits(fruitController.getAvailableFruits());
            int item = fruitController.inputItem();
            Fruit f = fruitController.selectFruit(item);
            if (f == null) {
                System.err.println("This item is not available!");
                continue;
            }
            int remain = fruitController.getRemainQuantity(cart, f);
            if (remain <= 0) {
                System.err.println("You already ordered all remaining " + f.getName() + "!");
                continue;
            }
            System.out.println("You selected: " + f.getName());
            fruitController.addToCart(cart, f, remain);

            if (ValidationUtil.pressYNtoContinue("Do you want to order now (Y/N)? ")) {
                break;
            }
        }
        displayItems(fruitController, cart, false);
        String customer = fruitController.inputCustomerName();
        fruitController.checkout(customer, cart);
        System.out.println("Order successfully!");
    }

    // ===================== Display =====================
    private static void displayAvailableFruits(ArrayList<Fruit> fruits) {
        System.out.println("List of Fruit:");
        System.out.printf("| %-8s | %-20s | %-15s | %-8s |\n", "++ Item ++", "++ Fruit Name ++", "++ Origin ++", "++ Price ++");
        for (Fruit f : fruits) {
            System.out.printf("  %-10s   %-20s   %-15s   %-8s\n", f.getId(), f.getName(), f.getOrigin(),
                    ValidationUtil.formatMoney(f.getPrice()));
        }
    }

    // withIndex = true: đánh số thứ tự (dùng cho View orders)
    private static void displayItems(FruitController fruitController, ArrayList<Order> items, boolean withIndex) {
        System.out.println("Product | Quantity | Price | Amount");
        int i = 1;
        for (Order o : items) {
            String prefix = withIndex ? (i++) + ". " : "";
            System.out.printf("%s%-12s %-8d %-6s %s\n", prefix, o.getFruit().getName(), o.getQuantity(),
                    ValidationUtil.formatMoney(o.getFruit().getPrice()), ValidationUtil.formatMoney(o.getAmount()));
        }
        System.out.println("Total: " + ValidationUtil.formatMoney(fruitController.getTotal(items)));
    }
}
