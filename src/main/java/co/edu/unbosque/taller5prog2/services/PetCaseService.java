package co.edu.unbosque.taller5prog2.services;

import co.edu.unbosque.taller5prog2.jpa.entities.Owner;
import co.edu.unbosque.taller5prog2.jpa.entities.PetCase;
import co.edu.unbosque.taller5prog2.jpa.repositories.GeneralRepository;
import co.edu.unbosque.taller5prog2.jpa.repositories.OwnerRepository;
import co.edu.unbosque.taller5prog2.jpa.repositories.PetCaseRepository;
import co.edu.unbosque.taller5prog2.resources.pojos.PetCasePOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.ws.rs.PathParam;
import java.util.Optional;

@Stateless
public class PetCaseService {
    public Optional<PetCasePOJO> createPetCase(PetCasePOJO petCasePOJO) {
        EntityManager manager = Persistence.createEntityManagerFactory("taller5-prog2").createEntityManager();
        GeneralRepository<PetCase, Integer> repository = new PetCaseRepository(manager);
        PetCase petCase = new PetCase(
                petCasePOJO.getCaseId(),
                petCasePOJO.getType(),
                petCasePOJO.getDescription()
        );
        Optional<PetCase> persistedPetCase = repository.save(petCase);
        manager.close();
        return persistedPetCase.map(value -> new PetCasePOJO(
                value.getCaseId(),
                value.getType(),
                value.getDescription()
        ));
    }
}
