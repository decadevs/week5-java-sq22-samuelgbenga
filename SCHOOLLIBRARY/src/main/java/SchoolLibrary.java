import model.Book;
import model.Student;
import model.Teacher;
import service.implementation.LibraryServiceImpl;

public class SchoolLibrary {

    public static void main(String[] args) {

        Book book1 = new Book("title", "author", 124);
        Book book2 = new Book("title", "author", 123);
        Book book3 = new Book("winning soul", "cartoon", 153);
        Book[] books = {book1, book2, book3};
        Student student = new Student("firstName",
                "secondName", "email", "jnr323");

        Teacher teacher = new Teacher("firstName","lastName", "emaill", "tch123");
         student.setBookRequest(book3);
//        teacher.setBook(book1);
//
//        System.out.println(teacher.getBook());

        //String testing = student.getBookRequested();
        //System.out.println(student.getBookRequested());
////        System.out.println(teacher);
////        System.out.println("************");
////        System.out.println(student);

        // service implementation

        teacher.setBookRequest(book3);
        LibraryServiceImpl libraryService = new LibraryServiceImpl();
       String assignment = libraryService.assignBook(student, student.getBookRequested(), books);
       String assignment1 = libraryService.assignBook(teacher, teacher.getBookRequested(), books);

        System.out.println(assignment1);


    }
}
