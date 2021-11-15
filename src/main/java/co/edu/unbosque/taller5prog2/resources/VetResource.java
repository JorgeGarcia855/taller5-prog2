package co.edu.unbosque.taller5prog2.resources;


import co.edu.unbosque.taller5prog2.resources.pojos.UserAppPOJO;
import co.edu.unbosque.taller5prog2.services.OfficialService;
import co.edu.unbosque.taller5prog2.services.VetService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/vets")
public class VetResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(UserAppPOJO vet) {
        Optional<UserAppPOJO> persitedVet = new VetService().createVet(vet);
        return persitedVet.isPresent() ?
                Response.status(Response.Status.ACCEPTED)
                        .entity(persitedVet.get())
                        .build() :
                Response.serverError()
                        .entity("Vet user could not be created")
                        .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{username}")
    public Response update(UserAppPOJO vet, @PathParam("username") String username) {
        Optional<UserAppPOJO> updatedVet = new VetService().updateVet(vet, username);
        return Response.ok().entity(updatedVet).build();
    }
}
