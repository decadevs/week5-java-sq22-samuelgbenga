import model.Book;
import model.Student;
import model.Teacher;
import service.implementation.LibrarianServiceImpl;
import service.implementation.LibraryServiceImpl;

import java.util.ArrayList;

public class SchoolLibrary {

    public static void main(String[] args) {


        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", 281);
        Book book2 = new Book("1984", "George Orwell", 328);
        Book book3 = new Book("Pride and Prejudice", "Jane Austen", 279);
        Book book4 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 180);
        Book book5 = new Book("Moby Dick", "Herman Melville", 635);
        Book book6 = new Book("War and Peace", "Leo Tolstoy", 1225);
        Book book7 = new Book("The Catcher in the Rye", "J.D. Salinger", 214);
        Book book8 = new Book("The Hobbit", "J.R.R. Tolkien", 310);
        Book book9 = new Book("Crime and Punishment", "Fyodor Dostoevsky", 430);
        Book book10 = new Book("Brave New World", "Aldous Huxley", 268);


        Student student = new Student("John", "Doe", "john.doe@example.com", "jnr323");
        Student student1 = new Student("Samuel", "Joseph", "samuel.joseph@example.com", "snr223");
        Student student2 = new Student("Alice", "Smith", "alice.smith@example.com", "jnr356");
        Student student3 = new Student("Emily", "Brown", "emily.brown@example.com", "snr289");
        Student student4 = new Student("Michael", "Johnson", "michael.johnson@example.com", "jnr301");
        Student student5 = new Student("Emma", "Williams", "emma.williams@example.com", "snr212");
        Student student6 = new Student("David", "Jones", "david.jones@example.com", "jnr331");
        Student student7 = new Student("Olivia", "Garcia", "olivia.garcia@example.com", "snr215");
        Student student8 = new Student("James", "Martinez", "james.martinez@example.com", "jnr362");
        Student student9 = new Student("Sophia", "Miller", "sophia.miller@example.com", "snr273");


        // teacher object
        Teacher teacher = new Teacher("John", "Smith", "john.smith@example.com", "tch156");
        Teacher teacher1 = new Teacher("Alice", "Johnson", "alice.johnson@example.com", "tch189");
        Teacher teacher2 = new Teacher("Michael", "Williams", "michael.williams@example.com", "tch101");
        Teacher teacher3 = new Teacher("Emma", "Brown", "emma.brown@example.com", "tch112");
        Teacher teacher4 = new Teacher("David", "Jones", "david.jones@example.com", "tch131");






        // service implementation
        // book inventory
        LibrarianServiceImpl librarianService = new LibrarianServiceImpl();
        librarianService.addBookToInventory(book1,1);
        librarianService.addBookToInventory(book2,5);
        librarianService.addBookToInventory(book3, 5);
//        librarianService.addBookToInventory(book4, 5);
//        librarianService.addBookToInventory(book5,5);
//        librarianService.addBookToInventory(book6,5);
//        librarianService.addBookToInventory(book7,5);
//        librarianService.addBookToInventory(book8,5);
//        librarianService.addBookToInventory(book9,5);
//        librarianService.addBookToInventory(book10,5);
        // get the Book inventory

        ArrayList<ArrayList<Object>> bookInventory =  librarianService.getBookInventory();

        LibraryServiceImpl libraryService = new LibraryServiceImpl();

        // make request for book

        // implementation of first in first out pool using request pool.
//        libraryService.setRequestPool(student1, student1.bookRequest(book3));
//        libraryService.setRequestPool(student, student.bookRequest(book3));
//        libraryService.setRequestPool(teacher1, teacher1.bookRequest(book3));
//        libraryService.setRequestPool(teacher, teacher.bookRequest(book3));
//        libraryService.setRequestPool(student2, student2.bookRequest(book3));
//        libraryService.setRequestPool(student2, student2.bookRequest(book3));



//        libraryService.setRequestPool(student, student.bookRequest(book2));
//        libraryService.setRequestPool(teacher2, teacher2.bookRequest(book1));
//        libraryService.setRequestPool(teacher1, teacher1.bookRequest(book4));
//        libraryService.setRequestPool(teacher2, teacher2.bookRequest(book5));
//        libraryService.setRequestPool(teacher3, teacher3.bookRequest(book6));
//        libraryService.setRequestPool(teacher4, teacher4.bookRequest(book7));
//        libraryService.setRequestPool(teacher1, teacher1.bookRequest(book8));
//          libraryService.setRequestPool(student1, student1.bookRequest(book9));
//          libraryService.setRequestPool(student2, student2.bookRequest(book1));
//          libraryService.setRequestPool(student3, student3.bookRequest(book1));


//        libraryService.setRequestPool(student, student.bookRequest(book1), student.getStudentId());
//        libraryService.setRequestPool(student1, student1.bookRequest(book2), student1.getStudentId());


        libraryService.setRequestPool(student, student.bookRequest(book1), student.getStudentId());
        libraryService.setRequestPool(student1, student1.bookRequest(book1), student1.getStudentId());

        libraryService.setRequestPool(student1, student1.bookRequest(book2));

        libraryService.setRequestPool(student2, student2.bookRequest(book2), student2.getStudentId());
        libraryService.setRequestPool(teacher4, teacher4.bookRequest(book2), teacher4.getTeacherId());

        libraryService.setRequestPool(student2, student2.bookRequest(book3));
        libraryService.setRequestPool(student3, student3.bookRequest(book3));


//         libraryService.setRequestPool(teacher1, teacher1.bookRequest(book3));
//         libraryService.setRequestPool(student5, student5.bookRequest(book4));
//
//        libraryService.setRequestPool(teacher, teacher.bookRequest(book3), teacher.getTeacherId());
//
//          libraryService.setRequestPool(teacher1, teacher1.bookRequest(book2), teacher1.getTeacherId());
//          libraryService.setRequestPool(student1, student1.bookRequest(book3), student1.getStudentId());
//          libraryService.setRequestPool(student4, student4.bookRequest(book9), student4.getStudentId());


        // assign the books
        libraryService.assignBook(bookInventory);








    }
}
