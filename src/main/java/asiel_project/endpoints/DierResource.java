package asiel_project.endpoints;

import asiel_project.dao.DierDAO;
import asiel_project.dao.VerblijfDAO;
import asiel_project.entity.Dier;
import asiel_project.entity.Verblijf;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Path("/dieren")
public class DierResource {

    @Inject
    DierDAO dierDAO;

    @Inject
    VerblijfDAO verblijfDAO;

    private Logger logger = Logger.getLogger("DierenResource");

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response ok(){
        List<Dier> result = dierDAO.getAll();
        return Response.ok().entity(result).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDier(@PathParam("id") Integer id) {
        return Response.ok().entity(dierDAO.findById(id)).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateContact(@PathParam("id") Integer id, Dier c) {
        Verblijf verblijf = verblijfDAO.findById(id);
        verblijf.setPlekkenBezet(1);
        verblijfDAO.update(verblijf);
        c.setVerblijf(verblijf);
        dierDAO.update(c);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteContact(@PathParam("id") Integer id) {
        Dier dier = dierDAO.findById(id);
        dierDAO.delete(dier);
        return Response.ok().entity(dier).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addContact(@Valid Dier nieuwDier) {
        dierDAO.create(nieuwDier);
        return Response.ok().entity(nieuwDier).build();
    }
}
