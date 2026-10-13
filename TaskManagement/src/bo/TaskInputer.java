/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Task;
import util.ValidationUtil;

/**
 *
 * @author datkh
 */
public class TaskInputer {

    private Task t;

    public TaskInputer() {
        t = new Task();
    }

    public Task input() {
        String name = ValidationUtil.getStringByRegex("Requirement Name: ", "Please input letters or digits only!", "(?=.*[A-Za-z0-9])[A-Za-z0-9 ]+");
        t.setName(ValidationUtil.removeUnnecessaryBlank(name));
        t.setTaskTypeId(Task.TaskTypeId.getTaskTypeByInt(ValidationUtil.getInt("Task Type: ", "Only input numbers please!", "Only input between 1-4 please!", 1, 4)));
        t.setDate(ValidationUtil.getDate("Date: ", "Please input a valid date with format dd-MM-yyyy!"));
        // From: 8.0 -> 17.0 (phải còn chỗ cho To), To: phải lớn hơn From, tối đa 17.5
        double from = ValidationUtil.getHalfHour("From: ", "Please input a number!", 8, 17);
        t.setPlanFrom(from);
        t.setPlanTo(ValidationUtil.getHalfHour("To: ", "Please input a number!", from + 0.5, 17.5));
        String assignee = ValidationUtil.getStringByRegex("Assignee: ", "Please input letters only!", "(?=.*[A-Za-z])[A-Za-z ]+");
        t.setAssignee(ValidationUtil.removeUnnecessaryBlank(assignee));
        String reviewer = ValidationUtil.getStringByRegex("Reviewer: ", "Please input letters only!", "(?=.*[A-Za-z])[A-Za-z ]+");
        t.setReviewer(ValidationUtil.removeUnnecessaryBlank(reviewer));
        return t;
    }

    public int inputId() {
        return ValidationUtil.getInt("ID: ", "Only input numbers please!", "ID must be greater than 0!", 1, Integer.MAX_VALUE);
    }

}
