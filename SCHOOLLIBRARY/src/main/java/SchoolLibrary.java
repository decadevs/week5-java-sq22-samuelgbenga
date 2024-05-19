import model.Book;
import model.Student;
import model.Teacher;
import service.implementation.LibrarianServiceImpl;
import service.implementation.LibraryServiceImpl;

import java.util.ArrayList;

public class SchoolLibrary {

    public static void main(String[] args) {

        Book book1 = new Book("title", "author", 124);
        Book book2 = new Book("title", "author", 123);
        Book book3 = new Book("winning soul", "cartoon", 153);


        Student student = new Student("firstName",
                "secondName", "email", "jnr323");

        // teacher object
        Teacher teacher = new Teacher("firstName","lastName", "emaill", "tch123");



        // make request for book
         student.setBookRequest(book3);
         teacher.setBookRequest(book1);


        // service implementation
        // book inventory
        LibrarianServiceImpl librarianService = new LibrarianServiceImpl();
        librarianService.addBookToInventory(book2,8);
        librarianService.addBookToInventory(book3,6);
        librarianService.addBookToInventory(book1,7);
        ArrayList<ArrayList<Object>> bookInventory =  librarianService.getBookInventory();


        //teacher.setBookRequest(book3);
        LibraryServiceImpl libraryService = new LibraryServiceImpl();
        String assignment = libraryService.assignBook(student, student.getBookRequested(), bookInventory);
        String assignment1 = libraryService.assignBook(teacher, teacher.getBookRequested(), bookInventory);

        System.out.println(assignment);
        System.out.println(assignment1);




    }
}
