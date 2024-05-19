package service.implementation;

import model.Book;
import service.LibraryService;

import java.util.ArrayList;

public class LibraryServiceImpl implements LibraryService {

    // request pool
    private final ArrayList<ArrayList<Object>> requestPool = new ArrayList<>();


// checks if the book exist in the arrays list
    private  boolean checkBook(Book requestedBook, ArrayList<ArrayList<Object>> bookInventory) {
        ArrayList<Book> books = new ArrayList<>();
        deleteBook(bookInventory);
        for (ArrayList<Object> book : bookInventory) {
            books.add((Book) book.getFirst());
        }
        //System.out.println(books);
        int indexOfBook = 0;
        for(Book book : books) {
            if(book.equals(requestedBook)) {
                //System.out.println(indexOfBook);
                decreaseNoOfBook(indexOfBook, bookInventory);
                return true;
            }
            indexOfBook++;
        }
        return false;
    }

    // decrease the number of books upon borrow
    private  void decreaseNoOfBook(int atIndex, ArrayList<ArrayList<Object>> bookInventory){

        ArrayList<Object> book = bookInventory.get(atIndex);
        int bookNumber = (int)book.get(1);
        bookInventory.get(atIndex).set(1, bookNumber - 1);

    }

    // delete the book from inventory upon number equal to zero
    private void deleteBook(ArrayList<ArrayList<Object>> bookInventory) {
        for (ArrayList<Object> book : bookInventory) {
            //System.out.println(book.get(1));
            int bookNo = (int)book.get(1);
            if(bookNo <= 0){
                bookInventory.remove(book);
            }
        }
    }



    // assigns the book upon existing
    @Override
    public void assignBook(ArrayList<ArrayList<Object>> books) {

        for (ArrayList<Object> requester : requestPool) {
            Book requestedBook = (Book) requester.get(1);
            if(checkBook(requestedBook, books)) {
                System.out.println("Assign the book '"+requestedBook+"' "+ requester.getFirst());

            }else{
                System.out.println("Unable to assign book to " + requester.getFirst() + ",because '"
                        +requestedBook+"' is unavailable");
            }

        }

    }


    @Override
    public <T> void setRequestPool( T requester, Book book) {
        ArrayList<Object> request = new ArrayList<>();
        request.add(requester);
        request.add(book);
        requestPool.add(request);
    }

    private ArrayList<ArrayList<Object>> getRequestPool(){
        return requestPool;
    }
}
