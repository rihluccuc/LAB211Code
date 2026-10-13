/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

/**
 *
 * @author datkh
 */
public class ValidationUtil {

    private static final Scanner scan = new Scanner(System.in);

    public static String removeUnnecessaryBlank(String input) {
        return input.trim().replaceAll("\\s+", " ");
    }

    public static String removeAllBlank(String input) {
        return input.trim().replaceAll("\\s+", "");
    }

    public static boolean pressYNtoContinue(String mess) {
        //"Do you want to continue (Y/N): "
        String input = getStringByRegex(mess, "Y/N only!!!", "[YNyn]");
        return input.equalsIgnoreCase("y");
    }

    public static String normalFormName(String input) {
        input = removeUnnecessaryBlank(input);
        String temp[] = input.split(" ");
        input = "";
        for (int i = 0; i < temp.length; i++) {
            input += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1) {
                input += " ";
            }
        }
        return input;
    }

    public static String getNonEmptyString(String mess) {
        String ret = "";
        while (true) {
            System.out.print(mess);
            ret = removeUnnecessaryBlank(scan.nextLine());
            if (ret.equalsIgnoreCase("")) {
                System.err.println("Please input Non-Empty String!!!");
                continue;
            }
            return ret;
        }
    }

    public static String normalFormStringAfterDot(String input) {
        String output = "";
        input = removeUnnecessaryBlank(input);
        input = String.valueOf(input.charAt(0)).toUpperCase() + input.substring(1);

        input = input.replaceAll("\\.\\s+", "\\.").replaceAll("\\s+\\.", "\\.");
        output += input.charAt(0);
        for (int i = 1; i < input.length(); i++) {

            if (input.charAt(i - 1) == '.' && Character.isAlphabetic(input.charAt(i))) {
                output += " " + Character.toUpperCase(input.charAt(i));
            } else {
                output += input.charAt(i);
            }
        }
        return output;
    }

    public static int getInt(String mess, String errorNumberFormat, String errorOutOfRange, int min, int max) {
        while (true) {
            try {
                int ret = Integer.parseInt(getStringByRegex(mess, errorNumberFormat, "[0-9]+"));
                if (ret < min || ret > max) {
                    System.err.println(errorOutOfRange);
                } else {
                    return ret;
                }
            } catch (NumberFormatException e) {
                System.err.println(errorOutOfRange);
            }
        }

    }

    public static String getStringByRegex(String mess, String error, String regex) {
        String output = null;
        while (true) {
            System.out.print(mess);
            output = scan.nextLine();
            if (output.matches(regex)) {
                return output;
            } else {
                System.err.println(error);
            }
        }
    }

    public static String getEmail(String mess) {

        String regex = "^[A-Za-z](.*)([@]{1})(.{2,})(\\.)(.{2,})";//phai bat dau bang chu cai
        String email = getStringByRegex(mess, "Please enter email with format <account name>@<domain>", regex);
        return email;
    }

    public static String getPhone(int minLength, String mess) {
        String regex = "[0-9 ]+";
        while (true) {
            String phoneNum = getStringByRegex(mess, "Please enter number only!!", regex).replaceAll("\\s+", "");
            if (phoneNum.length() < minLength) {
                System.err.println("Phone number must be at least 10 characters");
            } else {
                return phoneNum;
            }
        }
    }

    public static String getDate(String msg, String errorMsg) {
        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern("dd-MM-uuuu")
                        .withResolverStyle(ResolverStyle.STRICT);
        while (true) {
            try {
                System.out.print(msg);
                String input = scan.nextLine().trim();
                LocalDate date = LocalDate.parse(input, formatter);
                return date.format(formatter);
            } catch (DateTimeParseException e) {
                System.err.println(errorMsg);
            }
        }
    }

    public static double getDouble(String mess, String errorNumberFormat, String errorOutOfRange, double min, double max) {
        while (true) {
            double ret = Double.parseDouble(getStringByRegex(mess, errorNumberFormat, "[0-9]+(\\.[0-9]+)?"));
            if (ret < min || ret > max) {
                System.err.println(errorOutOfRange);
            } else {
                return ret;
            }
        }

    }

    // Nhập giờ theo bước 0.5 (8.0, 8.5, 9.0, ...), trong khoảng [min, max]
    public static double getHalfHour(String mess, String errorNumberFormat, double min, double max) {
        String errorOutOfRange = "Time must be from " + min + " to " + max + ", in steps of 0.5";
        while (true) {
            double ret = getDouble(mess, errorNumberFormat, errorOutOfRange, min, max);
            if (ret * 2 == Math.floor(ret * 2)) {
                return ret;
            }
            System.err.println(errorOutOfRange);
        }
    }

}
