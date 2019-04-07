package main.java.restjersey.service;

import main.java.restjersey.dao.BookDAO;
import main.java.restjersey.model.Book;
import main.java.restjersey.model.BooksData;
import org.json.JSONArray;
import org.json.JSONException;

import javax.ws.rs.core.Response;
import java.util.List;

public class BookService {
    private final BooksData mockedBooks = BooksData.getInstance();
    private final BookDAO bookDAO = BookDAO.getInstance();

    public Response getBooks() throws JSONException {
        return Response.status(200).entity(toJsonArray(bookDAO.getAll())).build();
    }

    public Response getBookById(int ID) throws JSONException {
        String result = "" + bookDAO.get(ID).toJson();
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

    public Response editBook(Book book) {
        String result = "" + book.toJson();
        if (!mockedBooks.editBook(book)) {
            return Response.status(400).entity("This book isn't exist in base").build();
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

    public JSONArray toJsonArray(List<Book> books) {
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(books);
        return jsonArray;
    }
}
