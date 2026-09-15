/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ui;

import controller.StudentManagerController;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ValidationAndNormalizingInputTextUtil;

/**
 *
 * @author datkh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentManagerController studentManagerController = new StudentManagerController();
        String menu = """
                      
                      WELCOME TO STUDENT MANAGEMENT
                      1. Create
                      2. Find and Sort
                      3. Update/Delete
                      4. Report
                      5. Exit
                      (Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program).
                      Your choice:  """;
        while (true) {
            int choice = ValidationAndNormalizingInputTextUtil.getInt(menu, "Please enter a digit", "Please enter 1-5", 1, 5);
            switch (choice) {
                case 1:
                    studentManagerController.addMiniumStudent();
                    break;
                case 2:
                    studentManagerController.searchAndSortByName();
                    break;
                case 3: {
                    try {
                        studentManagerController.updateAndDeleteById();
                    } catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }
                }
                break;
                case 4:
                    studentManagerController.report();
                    break;
                case 5:
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }
}
