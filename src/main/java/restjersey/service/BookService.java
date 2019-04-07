package main.java.restjersey.service;

import main.java.restjersey.model.Book;
import main.java.restjersey.model.BooksData;
import org.json.JSONException;

import javax.ws.rs.core.Response;

public class BookService {
    private final BooksData mockedBooks = BooksData.getInstance();

    public Response getBooks() throws JSONException {
        String result = "" + mockedBooks.toJsonArray();
        return Response.status(200).entity(result).build();
    }

    public Response getBookById(int ID) throws JSONException {
        if (mockedBooks.getBookByID(ID) == null) {
            return Response.status(404).entity("Book with this ID doesn't exist..").build();
        } else {
            String result = "" + mockedBooks.getBookByID(ID).toJson();
            return Response.status(200).entity(result).build();
        }
    }

    public Response deleteBookByID(int ID) throws JSONException {
        if (mockedBooks.deleteBook(ID)) {
            String result = "" + mockedBooks.toJsonArray();
            return Response.status(200).entity(result).build();
        } else {
            return Response.status(404).entity("Book with this ID doesn't exist..").build();
        }
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
            return Response.status(400).entity("Book with this ID doesn't exist..").build();
        } else {
            return Response.status(201).entity(result).build();
        }
    }

    }
