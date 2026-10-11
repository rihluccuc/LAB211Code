/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ui;

import controller.WorkerManagementController;
import entity.AdjustedSalaryHistory;
import entity.Worker;
import util.ValidationAndNormalizationText;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author datkh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WorkerManagementController workerManagementController = new WorkerManagementController();
        Main main = new Main();
        String menu = """
                      Create a program to manage worker:
                      1. Add a Worker.
                      2. Increase salary for worker.
                      3. Decrease for worker.
                      4. Show adjusted salary worker information.
                      5. Exit
                      """;
        while (true) {
            System.out.println(menu);
            int choice = ValidationAndNormalizationText.getInt("Your choice: ", "Please input only numbers", "no", 1, 5);
            switch (choice) {
                case 1:
                    while (true) {
                        try {
                            Worker w = workerManagementController.addNewWorker();
                            System.out.println("Add success full");
                            break;
                        } catch (Exception ex) {
                            System.err.println(ex);
                        }
                    }
                    ArrayList<Worker> list = workerManagementController.getWorkers();
                    main.displayWorker(list);
                    break;
                case 2:
                    while (true) {
                        try {
                            Worker w = workerManagementController.changeSalary(AdjustedSalaryHistory.SalaryStatus.UP);
                            System.out.println(w);
                            break;
                        } catch (Exception ex) {
                            System.err.println(ex);
                        }
                    }
                    break;
                case 3:
                    while (true) {
                        try {
                            Worker w = workerManagementController.changeSalary(AdjustedSalaryHistory.SalaryStatus.DOWN);
                            System.out.println(w);
                            break;
                        } catch (Exception ex) {
                            System.err.println(ex);
                        }
                    }
                    break;
                case 4:
                    ArrayList<AdjustedSalaryHistory> adjustedList = workerManagementController.getHistories();
                    main.displayAdjusted(adjustedList);
                    break;
                case 5:
                    return;
            }
        }
    }

    private void displayWorker(ArrayList<Worker> workers) {
        System.out.println("===LIST===");
        for (Worker w : workers) {
            System.out.println(w);
        }
    }

    private void displayAdjusted(ArrayList<AdjustedSalaryHistory> history) {
        System.out.println("===LIST===");
        for (AdjustedSalaryHistory a : history) {
            System.out.println(a);
        }
    }
}
