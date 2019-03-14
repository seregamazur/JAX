package main.java.restjersey;

import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/books")
public class BookService {

    @GET
    @Produces("application/json")
    public Response getBooks() throws JSONException {

        JSONObject jsonObject = new JSONObject();
       // jsonObject.put("Book name", );
      //  jsonObject.put("C Value", celsius);

        String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
        return Response.status(200).entity(result).build();
    }

    @Path("{f}")
    @GET
    @Produces("application/json")
    public Response convertFtoCfromInput(@PathParam("f") float f) throws JSONException {

        JSONObject jsonObject = new JSONObject();
        float celsius;
        celsius = (f - 32) * 5 / 9;
        jsonObject.put("F Value", f);
        jsonObject.put("C Value", celsius);

        String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
        return Response.status(200).entity(result).build();
    }
}
