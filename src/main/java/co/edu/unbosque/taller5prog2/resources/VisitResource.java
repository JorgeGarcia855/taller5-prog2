package co.edu.unbosque.taller5prog2.resources;

import co.edu.unbosque.taller5prog2.resources.pojos.VisitPOJO;
import co.edu.unbosque.taller5prog2.services.VisitService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

//@Path("/vets/{vet_id}/pets/{pet_id}/visits")
@Path("/visits")
public class VisitResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(VisitPOJO visit, @PathParam("vet_id") String vet_id, @PathParam("pet_id") Integer pet_id) {
        Optional<VisitPOJO> persitedVisit = Optional.ofNullable(new VisitService().createVisit(visit, vet_id, pet_id));
        return persitedVisit.isPresent() ?
                Response.status(Response.Status.ACCEPTED)
                        .entity(persitedVisit.get())
                        .build() :
                Response.serverError()
                        .entity("Visit could not be created")
                        .build();
    }
}
