package asiel_project.endpoints;

import asiel_project.dao.DierDAO;
import asiel_project.dao.DierRepository;
import asiel_project.dao.VerblijfDAO;
import asiel_project.dto.DierDTO;
import asiel_project.entity.Dier;
import asiel_project.entity.Verblijf;
import asiel_project.exception.VerblijfVolException;
import asiel_project.mapper.DierMapper;
import org.mapstruct.factory.Mappers;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Stateless
@Path("/dieren")
public class DierResource {

    private DierMapper diermapper = Mappers.getMapper(DierMapper.class);

    @Inject
    DierDAO dierDAO;

    @Inject
    private DierRepository dierRepository;

    @Inject
    VerblijfDAO verblijfDAO;

    private Logger logger = Logger.getLogger("DierenResource");

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response ok(){
        List<DierDTO> result = dierDAO.getAll().stream()
                .map(x -> diermapper.toDierDto(x))
                .collect(Collectors.toList());
        return Response.ok().entity(result).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDier(@PathParam("id") Integer id) {
        return Response.ok().entity(diermapper.INSTANCE.toDierDto(dierRepository.getOne(id))).build();
    }


    @GET
    @Path("/{id}/baasje")
    @Produces(MediaType.APPLICATION_JSON)
    public Response dierBaasje(@PathParam("id") Integer id) {
        Dier dier = dierDAO.findById(id);
        dier.setDatumBuiten(LocalDate.now().toString());

        if(dier.getVerblijf() != null) {
            verblijfDAO.update(dier.getVerblijf());
            dier.setVerblijf(null);
        }

        dierDAO.update(dier);
        return Response.ok().entity(diermapper.toDierDto(dier)).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response dierVerblijf(@PathParam("id") Integer verblijfId, DierDTO dierDTO) {
        Dier dier = dierDAO.findById(dierDTO.getDierId());
        Verblijf verblijf = verblijfDAO.findById(verblijfId);

        dier.setVerblijf(verblijf);

        verblijfDAO.update(verblijf);
        dierDAO.update(dier);

        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDier(@PathParam("id") Integer id) {
        Dier dier = dierDAO.findById(id);

        if(dier.getVerblijf() != null){
            verblijfDAO.update(dier.getVerblijf());
        }

        dierDAO.delete(dier);
        return Response.ok().entity(dier).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response voegDierToe(@Valid Dier nieuwDier) throws VerblijfVolException {
        nieuwDier.setVerblijf(verblijfDAO.findById(nieuwDier.getVerblijf().getVerblijfId()));


            dierDAO.create(nieuwDier);
            return Response.ok().entity(diermapper.toDierDto(nieuwDier)).build();


    }
}
