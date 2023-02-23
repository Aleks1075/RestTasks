package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dtos.PersonDTO;
import errorhandling.PersonNotFoundException;
import facades.PersonFacade;
import utils.EMF_Creator;
import facades.FacadeExample;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

//Todo Remove or change relevant parts before ACTUAL use
@Path("person")
public class PersonResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
       
    private static final PersonFacade FACADE =  PersonFacade.getPersonFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    @Path("/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getById(@PathParam("id") int id) throws PersonNotFoundException {
        PersonDTO person = FACADE.getPersonById(id);
        if (person != null) {
            return Response.ok(person).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("{\"code\":404,\"message\":\"Person not found\"}").build();
        }
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addPerson(String input) {
        JsonObject json = new JsonParser().parse(input).getAsJsonObject();
        String firstName = json.get("firstName").getAsString();
        String lastName = json.get("lastName").getAsString();
        String phone = json.get("phone").getAsString();
        PersonDTO personAdded = FACADE.addPerson(firstName, lastName, phone);
        return Response.ok(personAdded).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editPerson(@PathParam("id") int id, String input) throws PersonNotFoundException {
        PersonDTO p = GSON.fromJson(input, PersonDTO.class);
        p.setId(id);
        PersonDTO editedPerson = FACADE.editPerson(p);
        return Response.ok().entity(editedPerson).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response deletePerson(@PathParam("id") int id) throws Exception {
        PersonDTO deletedPerson = FACADE.deletePerson(id);
        return Response.ok().entity(deletedPerson).build();
    }
}
