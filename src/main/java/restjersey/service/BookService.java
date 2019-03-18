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

    public Response addBook(Book book) {
        String result = "" + book.toJson();
        if (!mockedBooks.addBook(book)) {
            return Response.status(400).entity("This book is already exist").build();
        } else {
            return Response.status(201).entity(result).build();
        }
    }

    public void initializeShell() {
        mockedBooks.addBook(new Book(1, "First Book", "Serhiy Mazur", 10));
        mockedBooks.addBook(new Book(2, "Second Book", "Serhiy Mazur", 11));
        mockedBooks.addBook(new Book(3, "Third Book", "Serhiy Mazur", 12));
    }

    public void clearShell() {
        mockedBooks.getBooks().clear();
    }

}
