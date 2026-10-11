/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bo.WorkerInputer;
import bo.WorkerManager;
import entity.AdjustedSalaryHistory;
import entity.AdjustedSalaryHistory.SalaryStatus;
import entity.Worker;
import java.time.LocalDate;
import util.ValidationAndNormalizationText;
import java.util.ArrayList;

/**
 *
 * @author datkh
 */
public class WorkerManagementController {

    private WorkerInputer workerInputer;
    private WorkerManager workerManager;

    public WorkerManagementController() {
        workerManager = new WorkerManager();
    }

    public ArrayList<Worker> getWorkers() {
        return workerManager.getWorkers();
    }

    public Worker addNewWorker() throws Exception {
        workerInputer = new WorkerInputer();
        Worker w = workerInputer.inputWorkerId();
        if (workerManager.isWorkerExist(w)) {
            throw new Exception("Worker Already Exist");
        }
        workerInputer.inputWorkerInfomation();
        if (workerManager.addWorker(w)) {
            return w;
        }
        return null;
    }

    public Worker changeSalary(SalaryStatus status) throws Exception {
        String code = ValidationAndNormalizationText.getStringByRegex("Enter Code: ", "Bro no!", "^[a-zA-Z0-9-]+$");
        double salary = ValidationAndNormalizationText.getDouble("Enter Salary: ", "No", "no", 0, Double.MAX_VALUE);
        if (workerManager.changeSalary(status, code.trim(), salary)) {
            Worker w = workerManager.getWorkerById(code);
            return w;
        }
        return null;
    }

    public ArrayList<AdjustedSalaryHistory> getHistories() {
        return workerManager.getAdjustedSalaryHistorys();
    }
}
