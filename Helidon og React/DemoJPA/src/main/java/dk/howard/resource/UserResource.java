package dk.howard.resource;

import dk.howard.resource.dto.CreateUserDTO;
import dk.howard.resource.dto.UserDTO;
import dk.howard.service.Service;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class UserResource {
    private final Service service;
    private final Mapper mapper;

    @Inject
    public UserResource(Service service, Mapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/users")
    @POST
    public void createUser(CreateUserDTO userDTO) {
        service.createUser(mapper.mapName(userDTO.getName()), mapper.mapAge(userDTO.getAge()), mapper.mapIDen(userDTO.getIDen()));
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/users")
    @GET
    public List<UserDTO> findByName(@QueryParam("name") String name, @QueryParam("age") Integer age, @QueryParam("iDen") String iDen) {
        if (age != null) {
            return mapper.map(service.findByAge(mapper.mapAge(age)));
        } else if (iDen != null) {
            return mapper.map(service.findUserByLogin(mapper.mapName(name), mapper.mapIDen(iDen)));
        }
        return mapper.map(service.findByName(mapper.mapName(name)));
    }
}
