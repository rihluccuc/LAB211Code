/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bo.FruitInputer;
import bo.FruitManager;
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

    public FruitController() {
        fruitManager = new FruitManager();
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

}
