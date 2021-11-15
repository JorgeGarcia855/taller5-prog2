package co.edu.unbosque.taller5prog2.jpa.repositories;

import co.edu.unbosque.taller5prog2.jpa.entities.PetCase;

import javax.persistence.EntityManager;
import java.util.Optional;

public class PetCaseRepository implements GeneralRepository<PetCase, Integer> {
    private final EntityManager manager;

    public PetCaseRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Optional<PetCase> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<PetCase> save(PetCase petCase) {
        manager.getTransaction().begin();
        manager.merge(petCase);
        manager.getTransaction().commit();
        return petCase != null ? Optional.of(petCase) : Optional.empty();
    }

    @Override
    public Optional<PetCase> update(PetCase petCase, Integer id) {
        return Optional.empty();
    }
}
