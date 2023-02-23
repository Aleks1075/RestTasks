package errorhandling;

import dtos.ExceptionDTO;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PersonNotFoundExceptionMapper implements ExceptionMapper<PersonNotFoundException> {

    @Override
    public Response toResponse(PersonNotFoundException ex) {
        ExceptionDTO err = new ExceptionDTO(404, ex.getMessage());
        return Response.status(404).entity(err).build();
    }
}