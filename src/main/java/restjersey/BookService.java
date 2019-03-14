package main.java.restjersey;

import org.json.JSONException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/books")
public class BookService {
    MockedBooks mockedBooks = MockedBooks.getInstance();
    @GET
    @Produces("application/json")
    public Response getBooks() throws JSONException {
        return Response.status(200).entity(mockedBooks.toJsonArray()).build();
    }

    @Path("{f}")
    @GET
    @Produces("application/json")
    public Response getBookById(@PathParam("f") int f) throws JSONException {
        mockedBooks.addBook(new Book("Hi","Serhiy Mazur",13.45f));
        mockedBooks.addBook(new Book("Hi","Serhiy Mazur",13.45f));
        mockedBooks.addBook(new Book("Hi","Serhiy Mazur",13.45f));
        return Response.status(200).entity(mockedBooks.getBook(f).toJson()).build();
    }


}
