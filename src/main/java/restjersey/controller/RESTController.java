package main.java.restjersey.controller;

import com.google.gson.Gson;
import main.java.restjersey.model.Book;
import main.java.restjersey.service.BookService;
import org.json.JSONException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/books")
public class RESTController {
    private final BookService service = new BookService();

    @GET
    @Produces("application/json")
    public Response getBooks() throws JSONException {
        return service.getBooks();
    }

    @Path("{bookID}")
    @GET
    @Produces("application/json")
    public Response getBookById(@PathParam("bookID") int ID) throws JSONException {
        return service.getBookById(ID);
    }

    @Path("{bookID}")
    @DELETE
    @Produces("application/json")
    public Response deleteBookByID(@PathParam("bookID") int ID) throws JSONException {
        return service.deleteBookByID(ID);
    }

    @POST
    @Path("/save")
    @Consumes("application/json")
    @Produces("application/json")

    public Response saveBook(String json) {
        Gson gson = new Gson();
        Book book = gson.fromJson(json, Book.class);
        return service.addBook(book);
    }

    @PostConstruct
    public void init() {
        service.initializeShell();
    }

    @PreDestroy
    public void destroy() {
        service.clearShell();
    }


}
