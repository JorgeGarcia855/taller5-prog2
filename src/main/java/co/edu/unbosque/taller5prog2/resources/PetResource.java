package co.edu.unbosque.taller5prog2.resources;

import co.edu.unbosque.taller5prog2.resources.pojos.PetPOJO;
import co.edu.unbosque.taller5prog2.services.PetService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/owners/{username}/pets")
public class PetResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(PetPOJO pet, @PathParam("username") String username) {
        Optional<PetPOJO> persistedPet = Optional.ofNullable(new PetService().createPet(pet, username));
        return persistedPet.isPresent() ?
                Response.status(Response.Status.CREATED)
                        .entity(persistedPet.get())
                        .build() :
                Response.serverError()
                        .entity("Pet could not be created")
                        .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{pet_id}")
    public Response update(PetPOJO pet, @PathParam("pet_id") Integer petId) {
        Optional<PetPOJO> updatedPet = new PetService().updatePet(pet, petId);
        return Response.ok().entity(updatedPet).build();
    }
}
