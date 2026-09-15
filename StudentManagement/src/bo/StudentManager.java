/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Report;
import entity.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author datkh
 */
public class StudentManager {

    private ArrayList<Student> students;
    private int lastId;

    public StudentManager() {
        students = new ArrayList<>();
        lastId = 0;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public StudentManager(ArrayList<Student> students) {
        this.students = students;
    }

    public Student addStudent(Student s) {
        s.setId(++lastId);
        students.add(s);
        return s;
    }

//tim 
    public ArrayList<Student> findByNameAndSort(String name) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(name.toLowerCase().trim())) {
                result.add(s);
            }
        }
        Collections.sort(result, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });
        return result;
    }

    public int findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return id;
            }
        }
        return -1;
    }

    public Student getStudentById(int id) {
        int index = findStudentById(id);
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public Student deleteStudentById(int id) throws Exception {
        int index = findStudentById(id);
        if (index != -1) {
            return students.remove(id);
        }
        throw new Exception("Remove failed!");
    }

    public Student updateStudentById(int id, Student s) throws Exception {
        int index = findStudentById(id);
        if (index != -1) {
            students.set(index, s);
            s.setId(id);
            return s;
        }
        throw new Exception("Update failed!");
    }

    public boolean moreThanTenStudent(ArrayList<Student> student) {
        if (student.size() < 2) {
            return true;
        } else {
            return false;
        }
    }

//    private List<Student> getStudentReport() {
//        ArrayList<Student> result = new ArrayList<>();
//        for (Student s : students) {
//
//        }
//    }
    private boolean isProcessed(Student student, ArrayList<Student> processed) {
        for (Student s : processed) {
            if (s.getName().equalsIgnoreCase(student.getName())
                    && s.getCourseName() == student.getCourseName()) {
                return true;
            }
        }

        return false;
    }

    public ArrayList<Report> getStudentReport() {
        ArrayList<Report> result = new ArrayList<>();
        ArrayList<Student> processed = new ArrayList<>();
        for (Student current : students) {
            // Already counted this student/course
            if (isProcessed(current, processed)) {
                continue;
            }
            int count = 0;
            for (Student s : students) {
                if (s.getName().equalsIgnoreCase(current.getName())
                        && s.getCourseName() == current.getCourseName()) {
                    count++;
                }
            }
            result.add(
                    new Report(
                            current.getName(),
                            current.getCourseName(),
                            count
                    )
            );
            processed.add(current);
        }

        return result;
    }

}
