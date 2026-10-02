/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bo.FruitInputer;
import bo.FruitManager;
import bo.OrderInputer;
import bo.OrderManager;
import entity.Fruit;
import entity.Order;
import java.util.ArrayList;
import java.util.Hashtable;
import util.ValidationUtil;

/**
 *
 * @author datkh
 */
public class FruitController {

    private FruitManager fruitManager;
    private FruitInputer fruitInputer;
    private OrderManager orderManager;
    private OrderInputer orderInputer;

    public FruitController() {
        fruitManager = new FruitManager();
        orderManager = new OrderManager();
    }

    // ===================== Fruit =====================
    // Trả về null nếu fruit đã tồn tại
    public Fruit inputFruit() {
        fruitInputer = new FruitInputer();
        Fruit f = fruitInputer.inputNameAndOrigin();
        if (fruitManager.isFruitExist(f)) {
            return null;
        }
        fruitInputer.inputPriceAndQuantity();
        if (fruitManager.addFruit(f)) {
            return f;
        }
        return null;
    }

    public ArrayList<Fruit> getFruits() {
        return fruitManager.getFruits();
    }

    public ArrayList<Fruit> getAvailableFruits() {
        return fruitManager.getAvailableFruits();
    }

    // ===================== Shopping =====================
    public int inputItem() {
        return ValidationUtil.getInt("Please select item: ", "Please only input number!",
                "Item must be greater than 0", 1, Integer.MAX_VALUE);
    }

    // Trả về null nếu item không tồn tại hoặc đã hết hàng
    public Fruit selectFruit(int id) {
        Fruit f = fruitManager.getFruitById(id);
        if (f == null || f.getQuantity() <= 0) {
            return null;
        }
        return f;
    }

    // Số lượng còn có thể mua (tồn kho trừ đi số đã có trong giỏ)
    public int getRemainQuantity(ArrayList<Order> cart, Fruit f) {
        return f.getQuantity() - orderManager.getQuantityInCart(cart, f);
    }

    public void addToCart(ArrayList<Order> cart, Fruit f, int maxQuantity) {
        orderInputer = new OrderInputer();
        orderManager.addToCart(cart, orderInputer.inputQuantity(f, maxQuantity));
    }

    public String inputCustomerName() {
        orderInputer = new OrderInputer();
        return orderInputer.inputCustomerName();
    }

    public void checkout(String customer, ArrayList<Order> cart) {
        orderManager.reduceStock(cart);
        orderManager.addOrder(customer, cart);
    }

    // ===================== Orders =====================
    public Hashtable<String, ArrayList<Order>> getOrders() {
        return orderManager.getOrder();
    }

    public double getTotal(ArrayList<Order> items) {
        return orderManager.getTotal(items);
    }
}
