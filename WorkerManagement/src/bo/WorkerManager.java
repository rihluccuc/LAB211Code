/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.AdjustedSalaryHistory;
import entity.AdjustedSalaryHistory.SalaryStatus;
import entity.Worker;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author datkh
 */
public class WorkerManager {

    private ArrayList<Worker> workers;
    private ArrayList<AdjustedSalaryHistory> histories;

    public WorkerManager() {
        workers = new ArrayList<>();
        histories = new ArrayList<>();
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public boolean addWorker(Worker w) {
        return workers.add(w);
    }

    private int getWorkerIndexById(String code) {
        for (int i = 0; i < workers.size(); i++) {
            if (workers.get(i).getId().equalsIgnoreCase(code.trim())) {
                return i;
            }
        }
        return -1;
    }

    public boolean isWorkerExist(Worker w) {
        int index = getWorkerIndexById(w.getId());
        return index != -1;
    }

    public Worker getWorkerById(String code) {
        int index = getWorkerIndexById(code);
        return workers.get(index);
    }

    public boolean changeSalary(SalaryStatus status, String code, double amount) throws Exception {
        int index = getWorkerIndexById(code);
        if (index == -1) {
            throw new Exception("Worker don't exist!");
        }
        Worker w = workers.get(index);
        if (status == SalaryStatus.UP) {
            w.setSalary(w.getSalary() + amount);
        } else {
            double newSalary = w.getSalary() - amount;
            if (newSalary <= 0) {
                throw new Exception("New Salary is negative! Please try again!");
            }
            w.setSalary(newSalary);
        }
        return histories.add(new AdjustedSalaryHistory(w, w.getSalary(), status, LocalDate.now()));
    }

    public ArrayList<AdjustedSalaryHistory> getAdjustedSalaryHistorys() {
        return histories;
    }
}
