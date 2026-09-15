/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Scanner;

/**
 *
 * @author datkh
 */
public class ValidationUtil {

    public static int getInt(String mess, String formatError) {
        Scanner sc = new Scanner(System.in);
        String output = null;
        while (true) {
            System.out.print(mess);
            output = sc.nextLine();
            try {
                int result = Integer.parseInt(output);
                if (output.matches("[0-9]+") && result > 0 && result < Integer.MAX_VALUE) {
                    return result;
                } else if (result < 0 || result > Integer.MAX_VALUE) {
                    System.err.println("Out Of Bond");
                }
            } catch (Exception e) {
                System.err.println(formatError);
            }
        }
    }
}
