/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.math.BigInteger;

/**
 *
 * @author datkh
 */
public class FibonanciCaculate {

    // Mảng dùng để lưu các số Fibonacci đã tính (tối đa 1000 phần tử)
    private BigInteger[] memo = new BigInteger[1000];

    public BigInteger Fibonanci(int n) {
        if (n <= 0) {
            return BigInteger.ZERO;
        }
        if (n == 1) {
            return BigInteger.ONE;
        }

        // Nếu số này đã được tính rồi, trả về ngay lập tức không cần tính lại
        if (memo[n] != null) {
            return memo[n];
        }

        // Đệ quy và lưu kết quả lại vào mảng memo
        memo[n] = Fibonanci(n - 1).add(Fibonanci(n - 2));
        return memo[n];
    }
}
