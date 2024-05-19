package service;

import model.Book;

import java.util.ArrayList;

public interface LibraryService {

    public <T> void setRequestPool( T requester, Book book);

    public void assignBook(ArrayList<ArrayList<Object>> bookInventory);

}
