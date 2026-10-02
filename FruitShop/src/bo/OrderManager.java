/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Fruit;
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

    // Nếu khách đã từng mua thì gộp thêm vào danh sách cũ, tránh bị ghi đè
    public void addOrder(String customer, ArrayList<Order> items) {
        ArrayList<Order> old = orders.get(customer);
        if (old == null) {
            orders.put(customer, items);
        } else {
            old.addAll(items);
        }
    }

    public Hashtable<String, ArrayList<Order>> getOrder() {
        return orders;
    }

    // Số lượng 1 loại trái cây đã có trong giỏ
    public int getQuantityInCart(ArrayList<Order> cart, Fruit f) {
        for (Order o : cart) {
            if (o.getFruit().getId() == f.getId()) {
                return o.getQuantity();
            }
        }
        return 0;
    }

    // Thêm vào giỏ, nếu đã có cùng loại thì cộng dồn số lượng
    public void addToCart(ArrayList<Order> cart, Order newOrder) {
        for (Order o : cart) {
            if (o.getFruit().getId() == newOrder.getFruit().getId()) {
                o.setQuantity(o.getQuantity() + newOrder.getQuantity());
                return;
            }
        }
        cart.add(newOrder);
    }

    public double getTotal(ArrayList<Order> items) {
        double total = 0;
        for (Order o : items) {
            total += o.getAmount();
        }
        return total;
    }

    // Trừ tồn kho sau khi khách chốt đơn
    public void reduceStock(ArrayList<Order> items) {
        for (Order o : items) {
            Fruit f = o.getFruit();
            f.setQuantity(f.getQuantity() - o.getQuantity());
        }
    }
}
