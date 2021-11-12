package co.edu.unbosque.taller5prog2.resources;

import co.edu.unbosque.taller5prog2.resources.pojos.OwnerPOJO;
import co.edu.unbosque.taller5prog2.services.OwnerService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/owners")
public class OwnerResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(OwnerPOJO owner) {
        Optional<OwnerPOJO> persistedOwner = new OwnerService().createOwner(owner);
        return persistedOwner.isPresent() ?
                Response.status(Response.Status.CREATED)
                        .entity(persistedOwner.get())
                        .build() :
                Response.serverError()
                        .entity("Owner user could not be created")
                        .build();
    }
}
