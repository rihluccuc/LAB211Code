/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Order;
import java.util.Hashtable;
import java.util.ArrayList;

/**
 *
 * @author datkh
 */
public class OrderManager {

    private Hashtable<String, ArrayList<Order>> orders;

    public OrderManager() {
        orders = new Hashtable<>();
    }

    public void addOrder(String customer, ArrayList<Order> items) {
        orders.put(customer, items);
    }

    public Hashtable<String, ArrayList<Order>> getOrder() {
        return orders;
    }
}
