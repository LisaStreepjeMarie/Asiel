package asiel_project.endpoints;

import asiel_project.dao.DierDAO;
import asiel_project.dao.VerblijfDAO;
import asiel_project.entity.Verblijf;
import asiel_project.entity.Dier;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Path("/verblijf")
public class VerblijfResource {

    @Inject
    VerblijfDAO verblijfDAO;

    private Logger logger = Logger.getLogger("DierenResource");

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response ok(){
        List<Verblijf> result = verblijfDAO.getAll();
        return Response.ok().entity(result).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVerblijf(@PathParam("id") Integer id) {
        return Response.ok().entity(verblijfDAO.findById(id)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addContact(@Valid Verblijf verblijf) {
        verblijfDAO.create(verblijf);
        return Response.ok().entity(verblijf).build();
    }
}
