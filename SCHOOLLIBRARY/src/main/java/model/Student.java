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


    public void setBookRequest(Book book) {
        this.book = book;
    }
    public Book getBookRequested() {
        return book;
    }


    @Override
    public String toString() {
        return (getFirstName() + " " + getLastName() + " " + getStudentId());
    }
}
