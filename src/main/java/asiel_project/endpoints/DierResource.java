package asiel_project.endpoints;

import asiel_project.dao.DierDAO;
import asiel_project.entity.Dier;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Path("/dieren")
public class DierResource {

    @EJB
    DierDAO dierDAO;

    private Logger logger = Logger.getLogger("DierenResource");

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response ok(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("cursus");
        EntityManager entityManager = factory.createEntityManager();
        List<Dier> result = entityManager.createNamedQuery("Dier.findAll", Dier.class).getResultList();
        entityManager.close();
        factory.close();
        return Response.ok().entity(result).build();
    }
//    public List<Dier> getDieren() {
//
////        EntityManagerFactory factory = Persistence.createEntityManagerFactory("cursus");
////        EntityManager entityManager = factory.createEntityManager();
////        List<Dier> result = entityManager.createNamedQuery("Dier.findAll", Dier.class).getResultList();
////        entityManager.close();
////        factory.close();
//
//        return dierDAO.getAll();
//    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Dier getDier(@PathParam("id") Integer id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("cursus");
        EntityManager entityManager = factory.createEntityManager();
        Dier dier = entityManager.find(Dier.class, id);
        entityManager.close();
        factory.close();
        return dierDAO.findById(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateContact(@PathParam("id") Integer id, Dier c) {
        c.setDierId(id);
        logger.info("updating id=" + id + " with c=" + c);
    }

    @DELETE
    @Path("/{id}")
    public void deleteContact(@PathParam("id") Integer id) {}

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Dier addContact(@Valid Dier nieuwDier) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("cursus");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.persist(nieuwDier);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
        return nieuwDier;
    }
}
