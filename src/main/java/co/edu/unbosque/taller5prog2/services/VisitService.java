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
    public VisitPOJO createVisit(VisitPOJO visitPOJO, String vet_id, Integer pet_id) {
        EntityManager manager = Persistence.createEntityManagerFactory("taller5-prog2").createEntityManager();
        GeneralRepository<Visit, Integer> repository = new VisitRepository(manager);
        GeneralRepository<Vet, String> vetRepository = new VetRepository(manager);
        GeneralRepository<Pet, Integer> petRepository = new PetRepository(manager);
        Optional<Vet> vet = vetRepository.findById(vet_id);
        Optional<Pet> pet = petRepository.findById(pet_id);
        vet.ifPresent(v -> {
            v.addVisit(new Visit(
                    visitPOJO.getVisitId(),
                    visitPOJO.getType(),
                    visitPOJO.getDescription()
            ));
            vetRepository.save(v);
        });

        pet.ifPresent(p -> {
            p.addVisit(new Visit(
                    visitPOJO.getVisitId(),
                    visitPOJO.getType(),
                    visitPOJO.getDescription()
            ));
            petRepository.save(p);
        });
        manager.close();
        return new VisitPOJO(
                visitPOJO.getVisitId(),
                visitPOJO.getType(),
                visitPOJO.getDescription()
        );
    }
}
