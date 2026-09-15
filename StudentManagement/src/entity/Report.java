/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import entity.Student.CourseName;
/**
 *
 * @author datkh
 */
public class Report {
    private String studentName;
    private CourseName coureName;
    private int total;

    public Report(String studentName, CourseName coureName, int total) {
        this.studentName = studentName;
        this.coureName = coureName;
        this.total = total;
    }

    
    
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public CourseName getCoureName() {
        return coureName;
    }

    public void setCoureName(CourseName coureName) {
        this.coureName = coureName;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return String.format(" %-30s | %-5s | %-2s |",  studentName, coureName, total);
    }
    
    
    
}
