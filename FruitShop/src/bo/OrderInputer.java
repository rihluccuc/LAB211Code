/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Fruit;
import entity.Order;
import util.ValidationUtil;

/**
 *
 * @author datkh
 */
public class OrderInputer {

    private Order o;

    public OrderInputer() {
        o = new Order();
    }

    public Order inputQuantity(Fruit fruit, int maxQuantity) {
        o.setFruit(fruit);
        o.setQuantity(ValidationUtil.getInt("Please input quantity: ", "Please only input number!",
                "Quantity must be from 1 to " + maxQuantity, 1, maxQuantity));
        return o;
    }

    public String inputCustomerName() {
        return ValidationUtil.normalFormName(ValidationUtil.getNonEmptyString("Input your name: "));
    }
}
