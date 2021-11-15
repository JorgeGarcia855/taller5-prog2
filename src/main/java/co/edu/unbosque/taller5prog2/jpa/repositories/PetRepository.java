package co.edu.unbosque.taller5prog2.jpa.repositories;

import co.edu.unbosque.taller5prog2.jpa.entities.Pet;

import javax.persistence.EntityManager;
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
    public Optional<Pet> update(Pet pet, Integer id) {
        Pet updatePet = manager.find(Pet.class, id);
        manager.getTransaction().begin();
        updatePet.setPetId(pet.getPetId());
        updatePet.setMicrochip(pet.getMicrochip());
        updatePet.setName(pet.getName());
        updatePet.setSpecies(pet.getSpecies());
        updatePet.setRace(pet.getRace());
        updatePet.setSize(pet.getSize());
        updatePet.setSex(pet.getSex());
        updatePet.setPicture(pet.getPicture());
        updatePet.setOwner(pet.getOwner());
        manager.merge(updatePet);
        manager.getTransaction().commit();
        return Optional.of(updatePet);
    }


}
