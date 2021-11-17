package co.edu.unbosque.taller5prog2.resources;

import co.edu.unbosque.taller5prog2.resources.pojos.UserAppPOJO;
import co.edu.unbosque.taller5prog2.resources.pojos.VisitPOJO;
import co.edu.unbosque.taller5prog2.services.VetService;
import co.edu.unbosque.taller5prog2.services.VisitService;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/vets/{vetId}/pets/{petId}/visits")
public class VisitResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(VisitPOJO visit, @PathParam("vetId") String vetId, @PathParam("petId") Integer petId) {
        Optional<VisitPOJO> persitedVisit = Optional.ofNullable(new VisitService().createVisit(visit, vetId, petId));
        return persitedVisit.isPresent() ?
                Response.status(Response.Status.ACCEPTED)
                        .entity(persitedVisit.get())
                        .build() :
                Response.serverError()
                        .entity("Visit could not be created")
                        .build();
    }
}
