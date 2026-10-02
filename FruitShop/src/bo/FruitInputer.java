/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Fruit;
import util.ValidationUtil;

/**
 *
 * @author datkh
 */
public class FruitInputer {

    private Fruit f;

    public FruitInputer() {
        f = new Fruit();
    }

    public Fruit inputNameAndOrigin() {
        f.setName(ValidationUtil.getNonEmptyString("Please enter fruit name: "));   
        f.setOrigin(ValidationUtil.getStringByRegex("Please enter origin: ", "Please only input letters!", "[A-Za-z ]+"));
        return f;
    }

    public void inputPriceAndQuantity() {
        f.setPrice(ValidationUtil.getDouble("Please enter price: ", "Please only enter decimal numbers", "Price must be from 1 to 1000", 1, 1000));
        f.setQuantity(ValidationUtil.getInt("Please enter a quantity: ", "Please only input a numbers", "Quantity must be greater than 0", 1, Integer.MAX_VALUE));
    }
}
