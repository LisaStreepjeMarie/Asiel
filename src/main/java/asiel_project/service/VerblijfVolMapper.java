package asiel_project.service;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class VerblijfVolMapper implements ExceptionMapper<VerblijfVolException> {

    @Override
    public Response toResponse(VerblijfVolException exception) {
        return Response.status(Response.Status.CONFLICT)
                .header("Conflict-Reason", exception.getMessage())
                .build();
    }
}
