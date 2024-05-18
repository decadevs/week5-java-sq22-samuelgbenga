package model;

import enums.StudentType;

public class Student extends Person{

   final private String studentId;

    public Student(String firstName, String lastName, String emailAddress, String studentId) {
        super(firstName, lastName, emailAddress);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "Student{" +super.toString()+
                "studentId='" + studentId + '\'' +
                '}';
    }
}
