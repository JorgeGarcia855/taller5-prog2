package co.edu.unbosque.taller5prog2.resources;

import co.edu.unbosque.taller5prog2.resources.pojos.PetPOJO;
import co.edu.unbosque.taller5prog2.resources.pojos.UserAppPOJO;
import co.edu.unbosque.taller5prog2.services.OwnerService;
import co.edu.unbosque.taller5prog2.services.PetService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/owners")
public class OwnerResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(UserAppPOJO owner) {
        Optional<UserAppPOJO> persistedOwner = new OwnerService().createOwner(owner);
        return persistedOwner.isPresent() ?
                Response.status(Response.Status.CREATED)
                        .entity(persistedOwner.get())
                        .build() :
                Response.serverError()
                        .entity("Owner user could not be created")
                        .build();
    }


    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{username}")
    public Response update(UserAppPOJO owner, @PathParam("username") String username) {
        Optional<UserAppPOJO> updatedOwner = new OwnerService().updateOwner(owner, username);
        return Response.ok().entity(updatedOwner).build();
    }
}
