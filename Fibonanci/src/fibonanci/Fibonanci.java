/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fibonanci;

import bo.FibonanciCaculate;
import util.ValidationUtil;

/**
 *
 * @author datkh
 */
public class Fibonanci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = ValidationUtil.getInt("Please Enter number for Fibonanci: ", "Error");
        FibonanciCaculate fibonanciCaculate = new FibonanciCaculate();
        System.out.print("The Fibonanci line is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonanciCaculate.Fibonanci(i) + " ");
        }
    }

}
