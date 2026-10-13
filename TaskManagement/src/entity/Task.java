/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.time.LocalDate;

/**
 *
 * @author datkh
 */
public class Task {

    public enum TaskTypeId {
        Code, Test, Design, Review;

        public int getIntValue() {
            switch (this) {
                case Code:
                    return 1;
                case Test:
                    return 2;
                case Design:
                    return 3;
                case Review:
                    return 4;
                default:
                    throw new AssertionError();
            }
        }

        public static TaskTypeId getTaskTypeByInt(int taskInt) {
            switch (taskInt) {
                case 1:
                    return Code;
                case 2:
                    return Test;
                case 3:
                    return Design;
                case 4:
                    return Review;
                default:
                    throw new AssertionError();
            }
        }
    }
    private int id;
    private TaskTypeId taskTypeId;
    private String name;
    private String date;
    private double planFrom;
    private double planTo;
    private String assignee;
    private String reviewer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TaskTypeId getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(TaskTypeId taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    // Thời lượng = To - From (vd From 9.5, To 17.5 -> 8.0)
    public double getTime() {
        return planTo - planFrom;
    }

    @Override
    public String toString() {
        return String.format(java.util.Locale.ENGLISH, "%-4s %-25s %-10s %-12s %-6.1f %-12s %-12s",
                id, name, taskTypeId, date, getTime(), assignee, reviewer);
    }

}
