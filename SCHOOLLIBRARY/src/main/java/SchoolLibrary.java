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
        Student student1 = new Student("samuel", "Joseph", "email", "snr323");

        // teacher object
        Teacher teacher = new Teacher("firstName","lastName", "emaill", "tch123");
        Teacher teacher1 = new Teacher("ogbona","ajaka", "email@email", "tch153");





        // service implementation
        // book inventory
        LibrarianServiceImpl librarianService = new LibrarianServiceImpl();
        librarianService.addBookToInventory(book1,7);
        librarianService.addBookToInventory(book2,1);
        librarianService.addBookToInventory(book3,33);
        // get the Book inventory
        ArrayList<ArrayList<Object>> bookInventory =  librarianService.getBookInventory();






        LibraryServiceImpl libraryService = new LibraryServiceImpl();

        // make request for book

        // implementation of first in first out pool using request pool.
        libraryService.setRequestPool(teacher1, teacher1.bookRequest(book2));
        libraryService.setRequestPool(teacher, teacher.bookRequest(book1));
        libraryService.setRequestPool(student1, student1.bookRequest(book2));
        libraryService.setRequestPool(teacher1, student.bookRequest(book3));

        // assign the books
        libraryService.assignBook(bookInventory);


//        String assignment1 = libraryService.assignBook(teacher, teacher.getBookRequested(), bookInventory);
//        String assignment2 = libraryService.assignBook(teacher1, teacher1.getBookRequested(), bookInventory);


//        System.out.println(assignment);
//        System.out.println("************");
//        System.out.println(assignment1);
//        System.out.println("*************");
//        System.out.println(assignment2);
//        System.out.println("**************");
//        System.out.println(assignment3);




    }
}
