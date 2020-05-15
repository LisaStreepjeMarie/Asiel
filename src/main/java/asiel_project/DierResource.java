package asiel_project;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Path("/dieren")
public class DierResource {

    private Logger logger = Logger.getLogger("DierenResource");

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dier> getDieren() {
        List<Dier> lijstMetDIeren = new ArrayList<>();
        lijstMetDIeren.add( new Dier(1, "Meneertje", "Dikke Kater"));
        lijstMetDIeren.add( new Dier (2, "Nemo",  "Vis"));
        return lijstMetDIeren;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Dier getDier(@PathParam("id") Long id) {
        return new Dier(1, "Meneertje",  "Dikke Kater");
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateContact(@PathParam("id") Integer id, Dier c) {
        c.setContactId(id);
        logger.info("updating id=" + id + " with c=" + c);
    }

    @DELETE
    @Path("/{id}")
    public void deleteContact(@PathParam("id") Integer id) {}

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Dier addContact(@Valid Dier c) {
        c.setContactId(5);
        return c;
    }
}
