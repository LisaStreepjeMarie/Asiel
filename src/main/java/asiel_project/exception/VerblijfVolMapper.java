package asiel_project.exception;


import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class VerblijfVolMapper implements ExceptionMapper<VerblijfVolException> {


    @Override
    public Response toResponse(VerblijfVolException exception) {
        return Response.status(418)
                .header("Conflict-Reason", exception.getMessage()).entity("oh neeee")
                .build();
    }
}
