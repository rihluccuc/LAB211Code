/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ui;

import controller.TaskManagementController;
import entity.Task;
import java.util.ArrayList;
import util.ValidationUtil;

/**
 *
 * @author datkh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TaskManagementController controller = new TaskManagementController();
        String menu = """

                      ========= Task program =========
                      1. Add Task
                      2. Delete task
                      3. Display Task
                      4. Exit
                      (Please choose 1 to Add, 2 to Delete, 3 to Display and 4 to Exit program).
                      Your choice: """;
        while (true) {
            int choice = ValidationUtil.getInt(menu, "Please enter a digit", "Please enter 1-4", 1, 4);
            switch (choice) {
                case 1:
                    addTask(controller);
                    break;
                case 2:
                    deleteTask(controller);
                    break;
                case 3:
                    displayTasks(controller);
                    break;
                case 4:
                    return;
            }
        }
    }

    // ===================== 1. Add Task =====================
    private static void addTask(TaskManagementController controller) {
        System.out.println("------------Add Task---------------");
        try {
            Task t = controller.addNewTask();
            System.out.println("Add task successfully! ID: " + t.getId());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    // ===================== 2. Delete Task =====================
    private static void deleteTask(TaskManagementController controller) {
        System.out.println("---------Del Task------");
        if (controller.getDataTasks().isEmpty()) {
            System.out.println("No task in the list!");
            return;
        }
        try {
            controller.deleteTask();
            System.out.println("Delete task successfully!");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    // ===================== 3. Display Task =====================
    private static void displayTasks(TaskManagementController controller) {
        ArrayList<Task> tasks = controller.getDataTasks();
        if (tasks.isEmpty()) {
            System.out.println("No task in the list!");
            return;
        }
        System.out.println("----------------------------------------- Task ---------------------------------------");
        System.out.printf("%-4s %-25s %-10s %-12s %-6s %-12s %-12s\n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        for (Task t : tasks) {
            System.out.println(t);
        }
    }
}
