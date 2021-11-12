package co.edu.unbosque.taller5prog2.resources;

import co.edu.unbosque.taller5prog2.resources.pojos.OfficialPOJO;
import co.edu.unbosque.taller5prog2.services.OfficialService;

import javax.ws.rs.*;
import java.awt.*;
import java.util.Optional;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/officials")
public class OfficialResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(OfficialPOJO official) {
        Optional<OfficialPOJO> persistedOfficial = new OfficialService().createOfficial(official);
        return persistedOfficial.isPresent() ?
                Response.status(Response.Status.CREATED)
                        .entity(persistedOfficial.get())
                        .build() :
                Response.serverError()
                        .entity("Official user could not be created")
                        .build();
    }

//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response update() {
//        return null;
//    }
}
