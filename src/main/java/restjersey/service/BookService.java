package main.java.restjersey.service;

import main.java.restjersey.model.Book;
import main.java.restjersey.model.BooksDataService;
import org.json.JSONException;

import javax.ws.rs.core.Response;

public class BookService {
    private final BooksDataService mockedBooks = BooksDataService.getInstance();

    public Response getBooks() throws JSONException {
        String result = "" + mockedBooks.toJsonArray();
        return Response.status(200).entity(result).build();
    }

    public Response getBookById(int ID) throws JSONException {
        String result = "" + mockedBooks.getBookByID(ID).toJson();
        return Response.status(200).entity(result).build();
    }

    public Response deleteBookByID(int ID) throws JSONException {
        mockedBooks.deleteBook(ID);
        String result = "" + mockedBooks.toJsonArray();
        return Response.status(200).entity(result).build();
    }

    public Response addBook(Book book){
        mockedBooks.getBooks().add(book);
        return Response.status(201).entity(book).build();
    }

    public void initializeShell() {
        mockedBooks.addBook(new Book(1,"First Book", "Serhiy Mazur", 9.45f));
        mockedBooks.addBook(new Book(2,"Second Book", "Serhiy Mazur", 5.44f));
        mockedBooks.addBook(new Book(3,"Third Book", "Serhiy Mazur", 19.99f));
    }

    public void clearShell() {
        mockedBooks.getBooks().clear();
    }

}
