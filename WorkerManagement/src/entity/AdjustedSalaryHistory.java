/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author datkh
 */
public class AdjustedSalaryHistory {

    public enum SalaryStatus {
        UP, DOWN;

        public String getSalaryStatus() {
            switch (this) {
                case UP:
                    return "UP";
                case DOWN:
                    return "DOWN";
                default:
                    throw new AssertionError();
            }
        }
    }
    private Worker worker;
    private double salary;
    private SalaryStatus salaryStatus;
    private LocalDate date;

    public AdjustedSalaryHistory(Worker worker, double salary, SalaryStatus salaryStatus, LocalDate date) {
        this.worker = worker;
        this.salary = salary;
        this.salaryStatus = salaryStatus;
        this.date = date;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public SalaryStatus getSalaryStatus() {
        return salaryStatus;
    }

    public void setSalaryStatus(SalaryStatus salaryStatus) {
        this.salaryStatus = salaryStatus;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("%-6s %-15s %-5s %-10s %-8s %s",
                worker.getId(), worker.getName(), worker.getAge(),
                salary, salaryStatus.getSalaryStatus(), date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

}
