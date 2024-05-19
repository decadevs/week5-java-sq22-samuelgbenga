package model;

public class Teacher extends Person{

    final private String teacherId;
    private Book book;


    public Teacher(String firstName, String lastName, String emailAddress, String teacherId) {
        super(firstName, lastName, emailAddress);
        this.teacherId = teacherId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public Book bookRequest(Book book) {
        this.book = book;
        return this.book;
    }


    @Override
    public String toString() {
        return (getFirstName() + " " + getLastName() + " " + getTeacherId());
    }
}
