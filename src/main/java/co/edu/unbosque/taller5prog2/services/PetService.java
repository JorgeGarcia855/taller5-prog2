package co.edu.unbosque.taller5prog2.services;

import co.edu.unbosque.taller5prog2.jpa.entities.Pet;
import co.edu.unbosque.taller5prog2.jpa.repositories.GeneralRepository;
import co.edu.unbosque.taller5prog2.jpa.repositories.PetRepository;
import co.edu.unbosque.taller5prog2.resources.pojos.PetPOJO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Optional;

public class PetService {
    public Optional<PetPOJO> createPet(PetPOJO petPOJO) {
        EntityManager manager = Persistence.createEntityManagerFactory("taller5-prog2").createEntityManager();
        GeneralRepository<Pet, Integer> repository = new PetRepository(manager);
        Pet pet = new Pet(
                petPOJO.getPetId(),
                petPOJO.getMicrochip(),
                petPOJO.getName(),
                petPOJO.getSpecies(),
                petPOJO.getRace(),
                petPOJO.getSize(),
                petPOJO.getSex(),
                petPOJO.getPicture()
        );
        Optional<Pet> persistedPet = repository.save(pet);
        manager.close();
        return persistedPet.map(value -> new PetPOJO(
                value.getPetId(),
                value.getMicrochip(),
                value.getName(),
                value.getSpecies(),
                value.getRace(),
                value.getSize(),
                value.getSex(),
                value.getPicture()
        ));
    }

    public Optional<PetPOJO> updatePet(PetPOJO petPOJO, Integer id) {
        EntityManager manager = Persistence.createEntityManagerFactory("taller5-prog2").createEntityManager();
        GeneralRepository<Pet, Integer> repository = new PetRepository(manager);
        Pet pet = new Pet(
                petPOJO.getPetId(),
                petPOJO.getMicrochip(),
                petPOJO.getName(),
                petPOJO.getSpecies(),
                petPOJO.getRace(),
                petPOJO.getSize(),
                petPOJO.getSex(),
                petPOJO.getPicture()
        );
        Optional<Pet> persistedPet = repository.update(pet, id);
        manager.close();
        return persistedPet.map(value -> new PetPOJO(
                value.getPetId(),
                value.getMicrochip(),
                value.getName(),
                value.getSpecies(),
                value.getRace(),
                value.getSize(),
                value.getSex(),
                value.getPicture()
        ));
    }
}
