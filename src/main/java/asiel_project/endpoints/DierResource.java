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
import java.time.LocalDate;
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


    @GET
    @Path("/{id}/baasje")
    @Produces(MediaType.APPLICATION_JSON)
    public Response dierBaasje(@PathParam("id") Integer id) {
        Dier dier = dierDAO.findById(id);
        dier.setDatumBuiten(LocalDate.now().toString());

        if(dier.getVerblijf() != null) {
            dier.getVerblijf().setPlekkenBezet(-1);
            verblijfDAO.update(dier.getVerblijf());
            dier.setVerblijf(null);
        }

        dierDAO.update(dier);
        return Response.ok().entity(dier).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateContact(@PathParam("id") Integer id, Dier c) {

    verblijfDAO.getAll().stream()
            .filter(x -> x.getVerblijfId().equals(id))
            .forEach(x -> {
                x.setPlekkenBezet(1);
                c.setVerblijf(x);
                verblijfDAO.update(x);
                dierDAO.update(c);
            });

        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteContact(@PathParam("id") Integer id) {
        Dier dier = dierDAO.findById(id);

        if(dier.getVerblijf() != null){
            dier.getVerblijf().setPlekkenBezet(-1);
            verblijfDAO.update(dier.getVerblijf());
        }

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
