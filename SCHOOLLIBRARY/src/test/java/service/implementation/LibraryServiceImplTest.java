package service.implementation;

import model.Book;
import model.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

import java.lang.reflect.Method;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceImplTest {

    @Test
    void checkIfBookExists() throws Exception{
        LibraryServiceImpl libraryService = new LibraryServiceImpl();
        Book book = new Book("title", "author", 123);
        ArrayList<Object> books = new ArrayList<>();
        ArrayList<ArrayList<Object>> inventory = new ArrayList<>();
        books.add(book);
        books.add(3);
        inventory.add(books);

        Method method = libraryService.getClass().getDeclaredMethod("checkBook",Book.class, ArrayList.class);
        method.setAccessible(true);

        assertTrue((boolean)method.invoke(libraryService,book, inventory));

    }

    @Test
    void checkIfBookDoesNotExist() throws Exception {
        LibraryServiceImpl libraryService = new LibraryServiceImpl();
        Book book = new Book("title", "author", 123);
        Book book1 = new Book("title1", "author1", 124);
        ArrayList<Object> books = new ArrayList<>();
        ArrayList<ArrayList<Object>> inventory = new ArrayList<>();
        books.add(book1);
        books.add(3);
        inventory.add(books);
        Method method = libraryService.getClass().getDeclaredMethod("checkBook",Book.class, ArrayList.class);
        method.setAccessible(true);
        assertFalse((boolean)method.invoke(libraryService,book, inventory));

    }

    @Test
    void checkForBookDecrease() throws Exception{
        LibraryServiceImpl libraryService = new LibraryServiceImpl();
        Book book = new Book("title", "author", 123);


        ArrayList<Object> books = new ArrayList<>();
        ArrayList<Object> books1 = new ArrayList<>();

        ArrayList<ArrayList<Object>> inventory = new ArrayList<>();
        ArrayList<ArrayList<Object>> inventory1 = new ArrayList<>();
        books.add(book);
        books.add(5);
        books1.add(book);
        books1.add(5);
        inventory.add(books);
        inventory1.add(books1);
        Method method = libraryService.getClass().getDeclaredMethod("decreaseNoOfBook", int.class, ArrayList.class);
        method.setAccessible(true);
        method.invoke(libraryService,0, inventory);
        System.out.println(inventory);
        System.out.println(inventory1);
        assertNotEquals(inventory1, inventory);

    }

    @Test
    void testToDelete()throws Exception{
        LibraryServiceImpl libraryService = new LibraryServiceImpl();
        Book book = new Book("title", "author", 123);
        Book book1 = new Book("title1", "author1", 124);
        ArrayList<Object> books = new ArrayList<>();
        ArrayList<Object> books1 = new ArrayList<>();
        ArrayList<ArrayList<Object>> inventory = new ArrayList<>();
        ArrayList<ArrayList<Object>> inventory1 = new ArrayList<>();
        books.add(book);
        books.add(0);
        books1.add(book1);
        books1.add(5);
        inventory.add(books);
        inventory.add(books1);
        inventory1.add(books1);
        Method method = libraryService.getClass().getDeclaredMethod("deleteBook", ArrayList.class);
        method.setAccessible(true);
        method.invoke(libraryService,inventory);

        assertEquals(inventory1, inventory);
    }

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    @AfterEach
    public void restoreStream(){
        System.setOut(originalOut);
    }

    // testing in the engine of the book stuff is the big one
    @Test
    public void testTheAssignEngineForBookPresent() throws Exception{
       LibraryServiceImpl libraryService = new LibraryServiceImpl();
        Book book = new Book("title", "author", 123);
        Book book1 = new Book("title1", "author1", 124);
        ArrayList<Object> books = new ArrayList<>();
        ArrayList<Object> books1 = new ArrayList<>();
        ArrayList<ArrayList<Object>> inventory = new ArrayList<>();
        books.add(book);
        books.add(0);
        books1.add(book1);
        books1.add(5);
        inventory.add(books);
        inventory.add(books1);

        Student student = new Student("Samuel", "Joseph", "email@email", "snr234");
        ArrayList<ArrayList<Object>> requestPool = new ArrayList<>();
        ArrayList<Object> requester = new ArrayList<>();
        requester.add(student);
        requester.add(book1);
        requestPool.add(requester);

        Method method = libraryService.getClass().getDeclaredMethod("assignEngine", ArrayList.class, ArrayList.class);
        method.setAccessible(true);

        method.invoke(libraryService, inventory, requestPool);
        //System.out.println("outcome");
        //assertEquals("outcome\n", outContent.toString());

        assertEquals("Assign the book 'title1,author1,124' Samuel Joseph snr234\n", outContent.toString());
    }

    @Test
    public void testTheAssignEngineForBookNotPresent() throws Exception{
        LibraryServiceImpl libraryService = new LibraryServiceImpl();
        Book book = new Book("title", "author", 123);
        Book book1 = new Book("title1", "author1", 124);
        ArrayList<Object> books = new ArrayList<>();
        ArrayList<Object> books1 = new ArrayList<>();
        ArrayList<ArrayList<Object>> inventory = new ArrayList<>();
        books.add(book);
        books.add(0);
        books1.add(book1);
        books1.add(5);
        inventory.add(books);
        inventory.add(books1);

        Student student = new Student("Samuel", "Joseph", "email@email", "snr234");
        ArrayList<ArrayList<Object>> requestPool = new ArrayList<>();
        ArrayList<Object> requester = new ArrayList<>();
        requester.add(student);
        requester.add(book);
        requestPool.add(requester);

        Method method = libraryService.getClass().getDeclaredMethod("assignEngine", ArrayList.class, ArrayList.class);
        method.setAccessible(true);

        method.invoke(libraryService, inventory, requestPool);

        assertEquals("Unable to assign book to Samuel Joseph snr234,because 'title,author,123' is unavailable\n", outContent.toString());
    }

    @Test
    public void testSetRequestPoolBasedOnFcfs() throws Exception{
        LibraryServiceImpl libraryService = new LibraryServiceImpl();
        Student student = new Student("Samuel", "Joseph", "email@email", "snr234");
        Book book = new Book("title", "author", 123);
        ArrayList<Object> request = new ArrayList<>();
        ArrayList<ArrayList<Object>> requestPool = new ArrayList<>();
        request.add(student);
        request.add(book);
        requestPool.add(request);
        libraryService.setRequestPool(student, book);

        Field field = libraryService.getClass().getDeclaredField("requestPool");
        field.setAccessible(true);

        assertEquals(requestPool, field.get(libraryService));
    }

    @Test
    public void testSetRequestPoolBasedOnPriority() throws Exception{
        LibraryServiceImpl libraryService = new LibraryServiceImpl();
        Student student = new Student("Samuel", "Joseph", "email@email", "snr234");
        Book book = new Book("title", "author", 123);
        ArrayList<Object> request = new ArrayList<>();
        ArrayList<ArrayList<Object>> requestPool = new ArrayList<>();
        request.add(student);
        request.add(book);
        requestPool.add(request);
        libraryService.setRequestPool(student, book, student.getStudentId());

        Book book1 = new Book("title1", "author1", 124);
        ArrayList<Object> books = new ArrayList<>();
        ArrayList<Object> books1 = new ArrayList<>();
        ArrayList<ArrayList<Object>> inventory = new ArrayList<>();
        books.add(book);
        books.add(0);
        books1.add(book1);
        books1.add(5);
        inventory.add(books);
        inventory.add(books1);

        libraryService.assignBook(inventory);

        Field field = libraryService.getClass().getDeclaredField("requestPool");
        field.setAccessible(true);

        assertEquals(requestPool, field.get(libraryService));
    }

}
