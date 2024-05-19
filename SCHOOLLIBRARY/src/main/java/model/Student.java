package model;

public class Student extends Person{
    private Book book;
   final private String studentId;

    public Student(String firstName, String lastName, String emailAddress, String studentId) {
        super(firstName, lastName, emailAddress);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }


    public Book bookRequest(Book book) {
        this.book = book;
        return this.book;
    }


    @Override
    public String toString() {
        return (getFirstName() + " " + getLastName() + " " + getStudentId());
    }
}
