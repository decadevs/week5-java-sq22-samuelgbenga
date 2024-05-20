package service.implementation;

import model.Book;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianServiceImplTest {

    @Test
    void aBookIsAddedToTheLibrary() throws NoSuchFieldException, IllegalAccessException {
        LibrarianServiceImpl librarianService = new LibrarianServiceImpl();
        Book book = new Book("title", "author", 123);
        ArrayList<Object> books = new ArrayList<>();
        ArrayList<ArrayList<Object>> inventory = new ArrayList<>();
        books.add(book);
        books.add(3);
        inventory.add(books);

        Field field = librarianService.getClass().getDeclaredField("bookInventory");

        librarianService.addBookToInventory(book, 3);
        assertEquals(inventory, field.get(librarianService));

    }

    @Test
    void returnsBookInventory() throws NoSuchFieldException, IllegalAccessException {
        LibrarianServiceImpl librarianService = new LibrarianServiceImpl();
        Book book = new Book("title", "author", 123);
        ArrayList<Object> books = new ArrayList<>();
        ArrayList<ArrayList<Object>> inventory = new ArrayList<>();
        books.add(book);
        books.add(3);
        inventory.add(books);
        Field field = librarianService.getClass().getDeclaredField("bookInventory");
        field.set(librarianService, inventory);
        assertEquals(inventory, librarianService.getBookInventory());


    }

}