package co.edu.unbosque.taller5prog2.resources;

import co.edu.unbosque.taller5prog2.resources.pojos.PetCasePOJO;
import co.edu.unbosque.taller5prog2.resources.pojos.UserAppPOJO;
import co.edu.unbosque.taller5prog2.services.OwnerService;
import co.edu.unbosque.taller5prog2.services.PetCaseService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/petcase")
public class PetCaseResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(PetCasePOJO petCase) {
        Optional<PetCasePOJO> persistedPetCase = new PetCaseService().createPetCase(petCase);
        return persistedPetCase.isPresent() ?
                Response.status(Response.Status.CREATED)
                        .entity(persistedPetCase.get())
                        .build() :
                Response.serverError()
                        .entity("Owner user could not be created")
                        .build();
    }

}
