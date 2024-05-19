package service;

import model.Book;

import java.util.ArrayList;

public interface LibraryService {
    public<T> String assignBook(T requester, Book requestedBook, ArrayList<ArrayList<Object>> bookInventory);

}
