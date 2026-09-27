/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fruitshopmanage;

import controller.FruitController;
import entity.Fruit;
import java.util.List;
import util.ValidationUtil;
import java.util.ArrayList;

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
        FruitShopManage main = new FruitShopManage();
        String menu = """
                      FRUIT SHOP SYSTEM
                      1. Create Fruit
                      2. View orders
                      3. Shopping (for buyer)
                      4. Exit
                       (Please choose 1 to create product, 2 to view order, 3 for shopping, 4 to Exit program).
                      """;
        while (true) {
            System.out.println(menu);
            int choice = ValidationUtil.getInt("Your choice: ", "No", "No out of range", 1, 4);
            switch (choice) {
                case 1:
                    List<Fruit> list = new ArrayList<>();
                    while (true) {
                        Fruit f = fruitController.inputFruit();
                        if (f == null) {
                            System.out.println("Fruit already exists!");
                            continue;
                        }
                        list.add(f);
                        if (!ValidationUtil.pressYNtoContinue(
                                "Do you want to continue (Y/N)? : ")) {
                            break;
                        }
                    }
                    main.displayAll(list);
                    break;
            }
        }
    }

    private void displayAll(List<Fruit> fruits) {
        for (Fruit f : fruits) {
            System.out.println(f);
        }
    }
}
