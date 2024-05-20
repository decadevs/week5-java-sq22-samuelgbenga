package service.implementation;

import model.Book;
import service.LibraryService;

import java.util.ArrayList;
import java.util.Iterator;

public class LibraryServiceImpl implements LibraryService {

    // request pool
    private final ArrayList<ArrayList<Object>> requestPoolFcfs = new ArrayList<>();
    private final ArrayList<ArrayList<Object>> requestPoolPriority = new ArrayList<>();
    // set by priority
    private final ArrayList<ArrayList<Object>> teacherPriority = new ArrayList<>();
    private final ArrayList<ArrayList<Object>> snrStudentPriority = new ArrayList<>();
    private final ArrayList<ArrayList<Object>> jnrStudentPriority = new ArrayList<>();



// checks if the book exist in the arrays list
    private  boolean checkBook(Book requestedBook, ArrayList<ArrayList<Object>> bookInventory) {
        ArrayList<Book> books = new ArrayList<>();
        try {
            ArrayList<ArrayList<Object>> updatedInventory = deleteBook(bookInventory);
           // create a new array for the books only
            if(!updatedInventory.isEmpty()) {
                for (ArrayList<Object> book : updatedInventory) {
                    books.add((Book) book.getFirst());
                }
            }

            //decreases the number of books based on the index returned and if the book exists
            int indexOfBook = 0;
            if(!books.isEmpty()) {
                for(Book book : books) {
                    if(book.equals(requestedBook)) {
                        //System.out.println(indexOfBook);
                        decreaseNoOfBook(indexOfBook, bookInventory);
                        return true;
                    }
                    indexOfBook++;
                }
            }
            return false;
        }
        catch (Exception e){
            //System.out.println(e.getMessage());
            System.err.println(e.getMessage());
            return false;
        }
    }

    // decrease the number of books upon borrow
    private  void decreaseNoOfBook(int atIndex, ArrayList<ArrayList<Object>> bookInventory){
        try {
            ArrayList<Object> book = bookInventory.get(atIndex);
            int bookNumber = (int)book.get(1);
            bookInventory.get(atIndex).set(1, bookNumber - 1);
        }catch (Exception e){
            System.out.println("the error comes from here");
        }
    }

    // delete the book from inventory upon number equal to zero
    private ArrayList<ArrayList<Object>> deleteBook(ArrayList<ArrayList<Object>> bookInventory) throws Exception {
        try {
            // Using an iterator to safely remove elements during iteration
            Iterator<ArrayList<Object>> iterator = bookInventory.iterator();
            while (iterator.hasNext()) {
                ArrayList<Object> book = iterator.next();
                int bookNo = (int) book.get(1);
                if (bookNo <= 0) {
                    iterator.remove(); // Safe removal
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred in deleteBook method: " + e.getMessage());
            throw e; // Re-throw the exception after logging it
        }

        return bookInventory;
    }


    private void assignEngine(ArrayList<ArrayList<Object>> books, ArrayList<ArrayList<Object>> requestPool) {
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

    // assigns the book upon existing
    @Override
    public void assignBook(ArrayList<ArrayList<Object>> books) {
        sortedByPriority();
        // performs the assignment of books upon
        // request pool completion and book inventory provided sort
        // assign student books based on FCFS
        if(!requestPoolFcfs.isEmpty()) {
             assignEngine(books, requestPoolFcfs);
        }
        // assign books to student based on priority
//        if(!requestPoolPriority.isEmpty()) {
//           assignEngine(books, requestPoolPriority);
//        }


    }


// this method arranged them accordingly in order of priority
    private void sortedByPriority() {
        requestPoolFcfs.addAll(teacherPriority);
        teacherPriority.clear();
        requestPoolFcfs.addAll(snrStudentPriority);
        snrStudentPriority.clear();
        requestPoolFcfs.addAll(jnrStudentPriority);
        jnrStudentPriority.clear();

    }

    // sort the request by first come, first served

    @Override
    public <T> void setRequestPool( T requester, Book book) {
        sortedByPriority();
        ArrayList<Object> request = new ArrayList<>();
        request.add(requester);
        request.add(book);
        requestPoolFcfs.add(request);

    }

    // sort the request by priority because of tie
    @Override
    public <T> void setRequestPool(T requester, Book book, String requesterId) {
        int priority = requesterId.charAt(3)-'0';
        //System.out.println(priority);
        switch (priority){
            case 1: {
                ArrayList<Object> request = new ArrayList<>();
                request.add(requester);
                request.add(book);
                teacherPriority.add(request);
                //System.out.println("Teacher priority added");
                break;
            }
            case 2: {
                ArrayList<Object> request = new ArrayList<>();
                request.add(requester);
                request.add(book);
                snrStudentPriority.add(request);
               // System.out.println("Senior Student priority added");
                break;
            }
            case 3: {
                ArrayList<Object> request = new ArrayList<>();
                request.add(requester);
                request.add(book);
                jnrStudentPriority.add(request);
                //System.out.println("JNR Student priority added");
                break;
            }
            default:
                System.out.println("Invalid priority");
                break;
        }


    }

}
