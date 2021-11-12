package co.edu.unbosque.taller5prog2.jpa.repositories;

import co.edu.unbosque.taller5prog2.jpa.entities.Vet;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class VetRepository implements GeneralRepository<Vet, String> {
    private final EntityManager manager;

    public VetRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Optional<Vet> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<Vet> save(Vet vet) {
        manager.getTransaction().begin();
        manager.persist(vet);
        manager.getTransaction().commit();
        return vet != null ? Optional.of(vet) : Optional.empty();
    }

    @Override
    public Optional<Vet> update(Vet vet) {
        vet = manager.createNamedQuery("Vet.update", Vet.class)
                .setParameter("name", vet.getName())
                .setParameter("address", vet.getAddress())
                .setParameter("neighborhood", vet.getNeighborhood())
                .getSingleResult();
        return vet != null ? Optional.of(vet) : Optional.empty();
    }
}
