package main.java.restjersey.service;

import main.java.restjersey.model.Book;
import main.java.restjersey.model.MockedBooks;
import org.json.JSONException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/books")
public class BookService {
    MockedBooks mockedBooks = MockedBooks.getInstance();

    @GET
    @Produces("application/json")
    public Response getBooks() throws JSONException {
        String result = "" + mockedBooks.toJsonArray();
        return Response.status(200).entity(result).build();
    }

    @Path("{f}")
    @GET
    @Produces("application/json")
    public Response getBookById(@PathParam("f") int f) throws JSONException {
        String result = "" + mockedBooks.getBook(f).toJson();
        return Response.status(200).entity(result).build();
    }

    @Path("{f}")
    @DELETE
    @Produces("application/json")
    public Response deleteBookByID(@PathParam("f") int delete) throws JSONException {
        mockedBooks.deleteBook(delete);
        String result = "" + mockedBooks.toJsonArray();
        return Response.status(200).entity(result).build();
    }
    @PostConstruct
    public void initializeShell(){
        mockedBooks.addBook(new Book("First Book", "Serhiy Mazur", 9.45f));
        mockedBooks.addBook(new Book("Second Book", "Serhiy Mazur", 5.44f));
        mockedBooks.addBook(new Book("Third Book", "Serhiy Mazur", 19.99f));
    }
    @PreDestroy
    public void clearShell(){
        mockedBooks.getBooks().clear();
    }


}
