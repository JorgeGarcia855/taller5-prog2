package co.edu.unbosque.taller5prog2.services;

import co.edu.unbosque.taller5prog2.jpa.entities.Official;
import co.edu.unbosque.taller5prog2.jpa.entities.Pet;
import co.edu.unbosque.taller5prog2.jpa.entities.Vet;
import co.edu.unbosque.taller5prog2.jpa.entities.Visit;
import co.edu.unbosque.taller5prog2.jpa.repositories.*;
import co.edu.unbosque.taller5prog2.resources.pojos.UserAppPOJO;
import co.edu.unbosque.taller5prog2.resources.pojos.VisitPOJO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Optional;

public class VisitService {
    public VisitPOJO createVisit(VisitPOJO visitPOJO, String vetId, Integer petId) {
        EntityManager manager = Persistence.createEntityManagerFactory("taller5-prog2").createEntityManager();
        GeneralRepository<Visit, Integer> repository = new VisitRepository(manager);
        GeneralRepository<Vet, String> vetRepository = new VetRepository(manager);
        GeneralRepository<Pet, Integer> petRepository = new PetRepository(manager);
        Optional<Vet> vet = vetRepository.findById(vetId);
        Optional<Pet> pet = petRepository.findById(petId);
        vet.ifPresent(v -> pet.ifPresent(p -> {
            Visit visit = new Visit(
                    visitPOJO.getVisitId(),
                    visitPOJO.getType(),
                    visitPOJO.getDescription(),
                    v,
                    p
            );
            vetRepository.save(v);
            petRepository.save(p);
            repository.save(visit);
        }));
        manager.close();
        return new VisitPOJO(
                visitPOJO.getVisitId(),
                visitPOJO.getType(),
                visitPOJO.getDescription()
        );
    }
}
