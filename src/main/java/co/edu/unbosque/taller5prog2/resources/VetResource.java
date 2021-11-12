package co.edu.unbosque.taller5prog2.resources;


import co.edu.unbosque.taller5prog2.resources.pojos.VetPOJO;
import co.edu.unbosque.taller5prog2.services.VetService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/vets")
public class VetResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(VetPOJO vet) {
        Optional<VetPOJO> persitedVet = new VetService().createVet(vet);
        return persitedVet.isPresent() ?
                Response.status(Response.Status.ACCEPTED)
                        .entity(persitedVet.get())
                        .build() :
                Response.serverError()
                        .entity("Vet user could not be created")
                        .build();
    }
}
