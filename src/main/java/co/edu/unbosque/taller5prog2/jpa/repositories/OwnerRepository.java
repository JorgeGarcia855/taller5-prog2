package co.edu.unbosque.taller5prog2.jpa.repositories;

import co.edu.unbosque.taller5prog2.jpa.entities.Official;
import co.edu.unbosque.taller5prog2.jpa.entities.Owner;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class OwnerRepository implements GeneralRepository<Owner, String> {
    private final EntityManager manager;

    public OwnerRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Optional<Owner> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<Owner> save(Owner owner) {
        manager.getTransaction().begin();
        manager.persist(owner);
        manager.getTransaction().commit();
        return owner != null ? Optional.of(owner) : Optional.empty();
    }

    @Override
    public Optional<Owner> update(Owner owner) {
        owner = manager.createNamedQuery("Owner.update", Owner.class)
                .setParameter("name", owner.getName())
                .setParameter("address", owner.getAddress())
                .setParameter("neighborhood", owner.getNeighborhood())
                .getSingleResult();
        return owner != null ? Optional.of(owner) : Optional.empty();
    }
}
