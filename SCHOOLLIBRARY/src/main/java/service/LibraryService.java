package service;

import model.Book;

public interface LibraryService {
    public<T, V> String assignBook(T requester, V requestedBook, Book[] books);
}
