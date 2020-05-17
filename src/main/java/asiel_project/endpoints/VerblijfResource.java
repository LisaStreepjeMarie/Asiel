package asiel_project.endpoints;

import asiel_project.entity.Verblijf;
import asiel_project.entity.Dier;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Path("/verblijf")
public class VerblijfResource {

    private Logger logger = Logger.getLogger("verblijfResource");

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Verblijf> getVerblijven() {
        List<Verblijf> lijstMetVerblijven = new ArrayList<>();
        List<Dier> dierenlijst = new ArrayList<>();
        dierenlijst.add(new Dier("Meneertje", "Dikke Kater"));
        Verblijf verblijf = new Verblijf(1, "Paleis", 1);
        verblijf.setDieren(dierenlijst);
        lijstMetVerblijven.add( verblijf);
        lijstMetVerblijven.add( new Verblijf (2, "Plastic tas", 5));
        return lijstMetVerblijven;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Verblijf getVerblijf(@PathParam("id") Long id) {
        List<Dier> dierenlijst = new ArrayList<>();
        dierenlijst.add(new Dier("Meneertje", "Dikke Kater"));
        Verblijf verblijf = new Verblijf(1, "Paleis", 1);
        verblijf.setDieren(dierenlijst);
        return verblijf;
    }
}
