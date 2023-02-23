package errorhandling;

import dtos.ExceptionDTO;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MissingInputExceptionMapper implements ExceptionMapper<MissingInputException> {

    @Override
    public Response toResponse(MissingInputException exception) {
        ExceptionDTO dto = new ExceptionDTO(400, "First Name and/or Last Name is missing");
        return Response.status(400).entity(dto).build();
    }
}