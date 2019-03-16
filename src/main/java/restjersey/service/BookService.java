package main.java.restjersey.service;

import main.java.restjersey.model.Book;
import main.java.restjersey.model.MockedBooks;
import org.json.JSONException;

import javax.ws.rs.core.Response;

public class BookService {
    private final MockedBooks mockedBooks = MockedBooks.getInstance();

    public Response getBooks() throws JSONException {
        String result = "" + mockedBooks.toJsonArray();
        return Response.status(200).entity(result).build();
    }

    public Response getBookById(int ID) throws JSONException {
        String result = "" + mockedBooks.getBook(ID).toJson();
        return Response.status(200).entity(result).build();
    }

    public Response deleteBookByID(int ID) throws JSONException {
        mockedBooks.deleteBook(ID);
        String result = "" + mockedBooks.toJsonArray();
        return Response.status(200).entity(result).build();
    }

    public void initializeShell() {
        mockedBooks.addBook(new Book("First Book", "Serhiy Mazur", 9.45f));
        mockedBooks.addBook(new Book("Second Book", "Serhiy Mazur", 5.44f));
        mockedBooks.addBook(new Book("Third Book", "Serhiy Mazur", 19.99f));
    }

    public void clearShell() {
        mockedBooks.getBooks().clear();
    }

}
