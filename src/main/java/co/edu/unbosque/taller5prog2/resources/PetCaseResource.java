package co.edu.unbosque.taller5prog2.resources;

import co.edu.unbosque.taller5prog2.resources.pojos.PetCasePOJO;
import co.edu.unbosque.taller5prog2.resources.pojos.UserAppPOJO;
import co.edu.unbosque.taller5prog2.services.OwnerService;
import co.edu.unbosque.taller5prog2.services.PetCaseService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

//@Path("/petcase?username={username}&pet_id={petId}")
@Path("/owners/{username}/pets/{petId}/petcases")
public class PetCaseResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(PetCasePOJO petCase, @PathParam("petId") Integer petId, @PathParam("username") String username) {
        Optional<PetCasePOJO> persistedPetCase = Optional.of(new PetCaseService().createPetCase(petCase, petId, username));
        return persistedPetCase.isPresent() ?
                Response.status(Response.Status.CREATED)
                        .entity(persistedPetCase.get())
                        .build() :
                Response.serverError()
                        .entity("Pet case could not be created")
                        .build();
    }

}
