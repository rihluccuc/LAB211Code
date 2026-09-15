/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author datkh
 */
public class ValidationAndNormalizingInputTextUtil {

    public static String getStringByRegex(String mess, String error, String regex) {
        String output = null;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(mess);
            output = sc.nextLine();
            if (output.matches(regex)) {
                return output;
            } else {
                System.err.println(error);
            }
        }
    }

    public static int getInt(String mess, String errorNumberFormat, String errorOutOfRange, int minValue, int maxValue) {
        while (true) {
            int re = Integer.parseInt(getStringByRegex(mess, errorNumberFormat, "[0-9]+"));
            if (re < minValue || re > maxValue) {
                System.err.println(errorOutOfRange);
            } else {
                return re;
            }
        }
    }

    public static String getNonEmtyString(String mess, String error, String regex) {
        String result = getStringByRegex(mess, error, regex);
        while (true) {
            if (result.isBlank()) {
                System.err.print("Please input non empty string");
            } else {
                return result;
            }
        }
    }

    public static boolean pressYNtoContinue(String mess) {
        String result = getStringByRegex(mess, "press Y/N only!", "[YNyn]");
        return result.equalsIgnoreCase("y");
    }

}
