package co.edu.unbosque.taller5prog2.jpa.repositories;

import co.edu.unbosque.taller5prog2.jpa.entities.Pet;
import co.edu.unbosque.taller5prog2.jpa.entities.Vet;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class PetRepository implements GeneralRepository<Pet, Integer> {
    private final EntityManager manager;

    public PetRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Optional<Pet> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Pet> save(Pet pet) {
        manager.getTransaction().begin();
        manager.persist(pet);
        manager.getTransaction().commit();
        return pet != null ? Optional.of(pet) : Optional.empty();
    }

    @Override
    public Optional<Pet> update(Pet pet) {
        pet = manager.createNamedQuery("Pet.update", Pet.class)
                .setParameter("name", pet.getName())
                .setParameter("species", pet.getSpecies())
                .setParameter("race", pet.getRace())
                .setParameter("size", pet.getSize())
                .setParameter("sex", pet.getSex())
                .setParameter("picture", pet.getPicture())
                .getSingleResult();
        return pet != null ? Optional.of(pet) : Optional.empty();
    }
}
