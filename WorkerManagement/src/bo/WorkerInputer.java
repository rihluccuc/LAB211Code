/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Worker;
import util.ValidationAndNormalizationText;

/**
 *
 * @author datkh
 */
public class WorkerInputer {

    private Worker w;

    public WorkerInputer() {
        w = new Worker();
    }

    public Worker inputWorkerId() {
        w.setId(ValidationAndNormalizationText.getStringByRegex("Enter Code: ", "No", "^[a-zA-Z0-9-]+$"));
        return w;
    }

    public void inputWorkerInfomation() {
        w.setName(ValidationAndNormalizationText.getStringByRegex("Enter Name: ", "Name wrong!", "[A-Za-z ]+"));
        w.setAge(ValidationAndNormalizationText.getInt("Enter Age: ", "Please input only numbers!", "Please input only in range(18 - 50)!", 18, 50));
        w.setSalary(ValidationAndNormalizationText.getDouble("Enter Salary: ", "Please inpy numbers or decimals only!", "No", 0, Double.MAX_VALUE));
        w.setWorkLocation(ValidationAndNormalizationText.getStringByRegex("Enter work location: ", "no!", "[A-Za-z ]+"));
    }

}
