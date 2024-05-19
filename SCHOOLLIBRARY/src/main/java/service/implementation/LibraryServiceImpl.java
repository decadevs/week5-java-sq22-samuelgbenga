package service.implementation;

import model.Book;
import service.LibraryService;

import java.util.ArrayList;

public class LibraryServiceImpl implements LibraryService {

// checks if the book exist in the arrays list
    public  boolean checkBook(Book requestedBook, ArrayList<ArrayList<Object>> bookInventory) {
        ArrayList<Book> books = new ArrayList<>();

        for (ArrayList<Object> book : bookInventory) {
            books.add((Book) book.getFirst());
        }
        //System.out.println(books);
        for(Book book : books) {
            if(book.equals(requestedBook)) {
                return true;
            }
        }
        return false;
    }

    // assigns the book upon existing
    @Override
    public <T> String assignBook(T requester, Book requestedBook, ArrayList<ArrayList<Object>> books) {
       if(checkBook(requestedBook, books)) {
           return "Assign the book '"+requestedBook+"' "+ requester;
       }
        return ("Unable to assign book to " + requester + ",because '" +requestedBook+"' is unavailable");
    }
}
