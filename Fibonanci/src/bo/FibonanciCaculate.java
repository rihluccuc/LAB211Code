/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

/**
 *
 * @author datkh
 */
public class FibonanciCaculate {

    public int Fibonanci(int n) {
        if (n <= 1) {
            return n;
        }
        return Fibonanci(n - 1) + Fibonanci(n - 2);
    }
}
