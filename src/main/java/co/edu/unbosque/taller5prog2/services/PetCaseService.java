package co.edu.unbosque.taller5prog2.services;

import co.edu.unbosque.taller5prog2.jpa.entities.Owner;
import co.edu.unbosque.taller5prog2.jpa.entities.Pet;
import co.edu.unbosque.taller5prog2.jpa.entities.PetCase;
import co.edu.unbosque.taller5prog2.jpa.repositories.GeneralRepository;
import co.edu.unbosque.taller5prog2.jpa.repositories.OwnerRepository;
import co.edu.unbosque.taller5prog2.jpa.repositories.PetCaseRepository;
import co.edu.unbosque.taller5prog2.jpa.repositories.PetRepository;
import co.edu.unbosque.taller5prog2.resources.pojos.PetCasePOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.ws.rs.PathParam;
import java.util.Optional;

@Stateless
public class PetCaseService {
    public PetCasePOJO createPetCase(PetCasePOJO petCasePOJO, Integer petId, String username) {
        EntityManager manager = Persistence.createEntityManagerFactory("taller5-prog2").createEntityManager();
        GeneralRepository<PetCase, Integer> petCaseRepository = new PetCaseRepository(manager);
        GeneralRepository<Pet, Integer> petRepository = new PetRepository(manager);
        GeneralRepository<Owner, String> ownerRepository = new OwnerRepository(manager);
        Optional<Owner> owner = ownerRepository.findById(username);
        Optional<Pet> pet = petRepository.findById(petId);
        pet.ifPresent(p -> {
            PetCase petCase = new PetCase(
                    petCasePOJO.getCaseId(),
                    petCasePOJO.getType(),
                    petCasePOJO.getDescription()
            );
            p.setOwner(ownerRepository.findById(username).get());
            petCase.setPet(p);
            p.addPetCase(petCase);
            petCaseRepository.save(petCase);
        });
        manager.close();
        return new PetCasePOJO(
                petCasePOJO.getCaseId(),
                petCasePOJO.getType(),
                petCasePOJO.getDescription()
        );
    }
}
