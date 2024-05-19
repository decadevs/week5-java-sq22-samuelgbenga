package service;

import model.Book;

import java.util.ArrayList;

public interface LibraryService {



    public void assignBook(ArrayList<ArrayList<Object>> bookInventory);
    public <T> void setRequestPool( T requester, Book book);
    public <T> void setRequestPool( T requester, Book book, String requesterId);

}
