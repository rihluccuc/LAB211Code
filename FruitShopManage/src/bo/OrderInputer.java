/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

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

    public Order inputQuantity() {
        o.setQuantity(ValidationUtil.getInt("Please input quantity: ", "Please only input number!", "Quantity must be greater than 0", 1, Integer.MAX_VALUE));
        return o;
    }

}
