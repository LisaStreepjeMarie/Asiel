package asiel_project.endpoints;

import asiel_project.dao.DierDAO;
import asiel_project.dao.VerblijfDAO;
import asiel_project.dto.VerblijfDTO;
import asiel_project.entity.Verblijf;
import asiel_project.mapper.VerblijfMapper;
import org.mapstruct.factory.Mappers;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Path("/verblijf")
public class VerblijfResource {

    private VerblijfMapper verblijfMapper = Mappers.getMapper(VerblijfMapper.class);

    @Inject
    VerblijfDAO verblijfDAO;

    private Logger logger = Logger.getLogger("DierenResource");

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response ok(){

        List<VerblijfDTO> result = verblijfDAO.getAll()
                .stream()
                .map(x -> verblijfMapper.INSTANCE.toDTO(x))
                .collect(Collectors.toList());

        return Response.ok().entity(result).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVerblijf(@PathParam("id") Integer id) {
        return Response.ok().entity(VerblijfMapper.INSTANCE.toDTO(verblijfDAO.findById(id))).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addContact(@Valid Verblijf verblijf) {
        verblijfDAO.create(verblijf);
        return Response.ok().entity(verblijfMapper.INSTANCE.toDTO(verblijf)).build();
    }
}
