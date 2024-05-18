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

    public void setBookRequest(Book book) {
        this.book = book;
    }
    public Book getBookRequested() {
        return book;
    }


    @Override
    public String toString() {
        return (getFirstName() + " " + getLastName() + " " + getTeacherId());
    }
}
