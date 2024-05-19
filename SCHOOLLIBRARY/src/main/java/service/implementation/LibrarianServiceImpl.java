package service.implementation;

import model.Book;
import service.LibrarianService;

import java.util.ArrayList;

public class LibrarianServiceImpl implements LibrarianService {

    ArrayList<ArrayList<Object>> bookInventory= new ArrayList<>();
            public LibrarianServiceImpl() {
                //bookInventory.add("Title,Author,ISBN,NoOfBooks");
            }


            public void addBookToInventory(Book book, int noOfBook) {
                ArrayList<Object> newBook= new ArrayList<>();
                newBook.add(book);
                newBook.add(noOfBook);
                bookInventory.add(newBook);
            }

    @Override
    public ArrayList<ArrayList<Object>> getBookInventory() {
        return bookInventory;
    }
}
