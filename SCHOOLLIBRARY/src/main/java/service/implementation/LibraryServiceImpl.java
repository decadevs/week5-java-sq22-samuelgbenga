package service.implementation;

import model.Book;
import service.LibraryService;

public class LibraryServiceImpl implements LibraryService {


    public <T> boolean checkBook(T requestedBook, Book[] books) {
        boolean result = false;
        for (Book book : books) {
            result = book.equals(requestedBook);
            if(result) break;
        }
        return result;
    }

    @Override
    public <T, V> String assignBook(T requester, V requestedBook, Book[] books) {
       if(checkBook(requestedBook, books)) {
           return "Assign the book '"+requestedBook+"' "+ requester;
       }
        return ("Unable to assign book to " + requester + ",because '" +requestedBook+"' is unavailable");
    }
}
