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
import java.util.List;
import util.ValidationUtil;
import java.util.ArrayList;

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
}
