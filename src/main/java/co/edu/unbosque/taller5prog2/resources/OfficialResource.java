package co.edu.unbosque.taller5prog2.resources;

import co.edu.unbosque.taller5prog2.resources.pojos.UserAppPOJO;
import co.edu.unbosque.taller5prog2.services.OfficialService;

import javax.ws.rs.*;
import java.util.Optional;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/officials")
public class OfficialResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(UserAppPOJO official) {
        Optional<UserAppPOJO> persistedOfficial = new OfficialService().createOfficial(official);
        return persistedOfficial.isPresent() ?
                Response.status(Response.Status.CREATED)
                        .entity(persistedOfficial.get())
                        .build() :
                Response.serverError()
                        .entity("Official user could not be created")
                        .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{username}")
    public Response update(UserAppPOJO official, @PathParam("username") String username) {
        Optional<UserAppPOJO> updatedOfficial = new OfficialService().updateOfficial(official, username);
        return Response.ok().entity(updatedOfficial).build();
    }
}
