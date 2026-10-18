/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author datkh
 */
public class FibonanciCaculate {

    // Mảng dùng để lưu các số Fibonacci đã tính (tối đa 1000 phần tử)
    private final List<BigInteger> memo = new ArrayList<>();

    public BigInteger Fibonanci(int n) {
        if (n <= 0) {
            return BigInteger.ZERO;
        }
        if (n == 1) {
            return BigInteger.ONE;
        }

        // ArrayList không tự có chỉ số n, nên phải thêm chỗ trống (null) cho đủ
        while (memo.size() <= n) {
            memo.add(null);
        }

        // Đã tính rồi thì trả về ngay
        if (memo.get(n) != null) {
            return memo.get(n);
        }

        // Đệ quy rồi lưu kết quả vào đúng vị trí n
        BigInteger result = Fibonanci(n - 1).add(Fibonanci(n - 2));
        memo.set(n, result);
        return result;
    }
}
