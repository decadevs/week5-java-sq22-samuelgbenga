package model;

public class Teacher extends Person{

    final private String teacherId;

    public Teacher(String firstName, String lastName, String emailAddress, String teacherId) {
        super(firstName, lastName, emailAddress);
        this.teacherId = teacherId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    @Override
    public String toString() {
        return super.toString() +"\n"+ "TeacherId: "+teacherId;
    }
}
