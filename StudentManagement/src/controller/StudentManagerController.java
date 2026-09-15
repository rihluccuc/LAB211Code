/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bo.StudentInputer;
import bo.StudentManager;
import entity.Report;
import entity.Student;
import java.util.ArrayList;
import java.util.List;
import utils.ValidationAndNormalizingInputTextUtil;

/**
 *
 * @author datkh
 */
public class StudentManagerController {

    private StudentInputer studentInputer;
    private StudentManager studentManager;

    public StudentManagerController() {
        studentManager = new StudentManager();
    }

    private Student inputStudent() {
        Student s = new Student();
        studentInputer = new StudentInputer();
        studentInputer.input();
        s = studentInputer.getStudentInputer();
        return s;
    }

    private Student addStudent() {
        return studentManager.addStudent(inputStudent());
    }

    public void addMiniumStudent() {
        while (studentManager.moreThanTenStudent(studentManager.getStudents())) {
            addStudent();
        }
        do {
            addStudent();
        } while (ValidationAndNormalizingInputTextUtil.pressYNtoContinue("Do you want to continue (Y/N)? "));
        System.out.println("List of Student");
        for (Student student : studentManager.getStudents()) {
            System.out.println(student);
        }
    }

    private void displayAllStudent() {
        for (Student s : studentManager.getStudents()) {
            System.out.println(s);
        }
    }

    public void searchAndSortByName() {
        displayAllStudent();
        studentInputer = new StudentInputer();
        String result = studentInputer.inputFind();
        ArrayList<Student> list = studentManager.findByNameAndSort(result);
        if (list.isEmpty()) {
            System.out.println("No Student Found");
        } else {
            System.out.println("List Found:");
            System.out.printf("%-5s | %-30s | %-8s | %-10s |\n", "ID", "Name", "Semester", "Course");
            for (Student s : list) {
                System.out.println(s);
            }
        }
    }

    public void updateAndDeleteById() throws Exception {
        displayAllStudent();
        studentInputer = new StudentInputer();
        if (studentManager.getStudents().isEmpty()) {
            System.out.println("No Student in the list");
            return;
        }

        int id = ValidationAndNormalizingInputTextUtil.getInt("Please enter id: ", "No", "Out of bond", 1, Integer.MAX_VALUE);
        if (studentManager.findStudentById(id) == -1) {
            System.out.println("No Student Found");
        } else {
            Student s = studentManager.getStudentById(id);
            System.out.println("Student Found:");
            System.out.printf("%-5s | %-30s | %-8s | %-10s |\n", "ID", "Name", "Semester", "Course");
            System.out.println(s);
            String choice = ValidationAndNormalizingInputTextUtil.getStringByRegex("Do you want to update (U) or delete (D) student: ", "Please only enter U(Update) or D(Delete)", "[UuDd]");
            if (choice.equalsIgnoreCase("u")) {
                studentManager.updateStudentById(id, inputStudent());
            } else {
                studentManager.deleteStudentById(id);
            }
        }
    }

    public void report() {
        if (studentManager.getStudents().isEmpty()) {
            System.out.println("No Student in the list");
            return;
        }

        ArrayList<Report> reports = studentManager.getStudentReport();

        System.out.println("Student name | Course | Total");

        for (Report report : reports) {
            System.out.println(report);
        }
    }

}
