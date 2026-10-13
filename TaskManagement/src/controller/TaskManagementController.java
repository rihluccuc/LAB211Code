/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bo.TaskInputer;
import bo.TaskManager;
import entity.Task;
import java.util.ArrayList;

/**
 *
 * @author datkh
 */
public class TaskManagementController {

    private TaskInputer taskInputer;
    private TaskManager taskManager;

    public TaskManagementController() {
        taskManager = new TaskManager();
    }

    // Trả về Task vừa thêm (đã có ID), lỗi thì ném exception
    public Task addNewTask() throws Exception {
        taskInputer = new TaskInputer();
        Task t = taskInputer.input();
        if (!taskManager.addTask(t)) {
            throw new Exception("Add task failed!");
        }
        return t;
    }

    public void deleteTask() throws Exception {
        taskInputer = new TaskInputer();
        taskManager.deleteTask(taskInputer.inputId());
    }

    public ArrayList<Task> getDataTasks() {
        return taskManager.getDataTasks();
    }
}
