/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import util.ValidationUtil;

/**
 *
 * @author datkh
 */
public class OrderInputer {

    public int inputFruitId() {
        return ValidationUtil.getInt(
                "Please select item: ",
                "Please only input number!",
                "Invalid ID!",
                1,
                Integer.MAX_VALUE
        );
    }

    public int inputQuantity() {
        return ValidationUtil.getInt(
                "Please input quantity: ",
                "Please only input number!",
                "Quantity must be greater than 0!",
                1,
                Integer.MAX_VALUE
        );
    }

    public String inputCustomerName() {
        return ValidationUtil.getNonEmptyString(
                "Input your name: "
        );
    }

}
