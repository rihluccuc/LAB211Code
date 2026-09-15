/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author datkh
 */
public class Student {

    public enum CourseName {
        Java, Net, C;

        public String getCourseName() {
            switch (this) {
                case Java:
                    return "Java";
                case Net:
                    return ".Net";
                case C:
                    return "C/C++";
            }
            throw new IllegalStateException("Course not legal in this time");
        }
    }
    private int id;
    private String name;
    private int semester;
    private CourseName courseName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public CourseName getCourseName() {
        return courseName;
    }

    public void setCourseName(CourseName courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return String.format("%-5s | %-30s | %-8s | %-10s |", id, name, semester, courseName);
    }

}
