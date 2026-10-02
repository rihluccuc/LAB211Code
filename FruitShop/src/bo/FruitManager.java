/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Fruit;
import java.util.ArrayList;

/**
 *
 * @author datkh
 */
public class FruitManager {

    private ArrayList<Fruit> fruits;
    private int lastId;

    public FruitManager(ArrayList<Fruit> fruits) {
        this.fruits = fruits;
//        lastId = fruits.size();
    }

    public FruitManager() {
        fruits = new ArrayList<>();
        lastId = 0;
    }

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }

    public boolean isFruitExist(Fruit f) {
        for (Fruit fruit : fruits) {
            if (fruit.getName().equalsIgnoreCase(f.getName()) && fruit.getOrigin().equalsIgnoreCase(f.getOrigin())) {
                return true;
            }
        }
        return false;
    }

    public boolean addFruit(Fruit f) {
        if (f == null) {
            return false;
        }
        f.setId(++lastId);
        return fruits.add(f);
    }

    public ArrayList<Fruit> getAvailableFruits() {
        ArrayList<Fruit> result = new ArrayList<>();
        for (Fruit f : fruits) {
            if (f.getQuantity() > 0) {
                result.add(f);
            }
        }
        return result;
    }

    public Fruit getFruitById(int id) {
        for (Fruit f : fruits) {
            if (f.getId() == id) {
                return f;
            }
        }
        return null;    
    }
}
