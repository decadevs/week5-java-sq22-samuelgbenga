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
        Student student1 = new Student("samuel", "Joseph", "email", "snr223");

        // teacher object
        Teacher teacher = new Teacher("firstName","lastName", "emaill", "tch123");
        Teacher teacher1 = new Teacher("ogbona","ajaka", "email@email", "tch153");





        // service implementation
        // book inventory
        LibrarianServiceImpl librarianService = new LibrarianServiceImpl();
        librarianService.addBookToInventory(book1,3);
        librarianService.addBookToInventory(book2,5);
        librarianService.addBookToInventory(book3,2);
        // get the Book inventory
        ArrayList<ArrayList<Object>> bookInventory =  librarianService.getBookInventory();






        LibraryServiceImpl libraryService = new LibraryServiceImpl();

        // make request for book

        // implementation of first in first out pool using request pool.
        libraryService.setRequestPool(teacher1, teacher1.bookRequest(book2));
        libraryService.setRequestPool(teacher, teacher.bookRequest(book1));
        libraryService.setRequestPool(student1, student1.bookRequest(book2));
        libraryService.setRequestPool(teacher1, teacher1.bookRequest(book3));
        libraryService.setRequestPool(student, student.bookRequest(book3));
        libraryService.setRequestPool(teacher, teacher.bookRequest(book3), teacher.getTeacherId());
        libraryService.setRequestPool(student, student.bookRequest(book1), student.getStudentId());
         libraryService.setRequestPool(teacher1, teacher1.bookRequest(book3));
        System.out.println("************");
        libraryService.setRequestPool(teacher, teacher.bookRequest(book3), teacher.getTeacherId());

          libraryService.setRequestPool(teacher1, teacher1.bookRequest(book2), teacher1.getTeacherId());
          libraryService.setRequestPool(student1, student1.bookRequest(book3), student1.getStudentId());


        // assign the books
        libraryService.assignBook(bookInventory);







    }
}
