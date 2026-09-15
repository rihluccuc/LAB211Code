/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Student;
import entity.Student.CourseName;
import utils.ValidationAndNormalizingInputTextUtil;

/**
 *
 * @author datkh
 */
public class StudentInputer {

    private Student s;

    public Student getStudentInputer() {
        return s;
    }

    public StudentInputer() {
        s = new Student();
    }

    public void input() {
        s.setName(ValidationAndNormalizingInputTextUtil.getNonEmtyString("Please input name: ", "Please input only letters!", "[A-Za-z ]+"));
        s.setSemester(ValidationAndNormalizingInputTextUtil.getInt("Please input Semseter: ", "Please input only numbers", "Please input between", 1, 10));
        s.setCourseName(inputCourseName()   );
    }

    private CourseName inputCourseName() {
        while (true) {
            int courseName = ValidationAndNormalizingInputTextUtil.getInt("Please input Course Name(1 - .NET, 2 - JAVA, 3 - C/C++)", "Please enter only number!", "Courses not availible", 1, 3);
            switch (courseName) {
                case 1:
                    return CourseName.Net;
                case 2:
                    return CourseName.Java;
                case 3:
                    return CourseName.C;
                default:
                    System.out.println("Invalid Course!");
            }
        }
    }

    public String inputFind() {
        String result = ValidationAndNormalizingInputTextUtil.getStringByRegex("Search for: ", "Please enter a letters", "[A-Za-z ]+");
        return result;
    }

}
