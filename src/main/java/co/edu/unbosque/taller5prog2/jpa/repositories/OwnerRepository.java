package co.edu.unbosque.taller5prog2.jpa.repositories;

import co.edu.unbosque.taller5prog2.jpa.entities.Owner;
import co.edu.unbosque.taller5prog2.jpa.entities.UserApp;

import javax.persistence.EntityManager;
import java.util.Optional;

public class OwnerRepository implements GeneralRepository<Owner, String> {
    private final EntityManager manager;

    public OwnerRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Optional<Owner> findById(String id) {
        Owner owner = manager.find(Owner.class, id);
        return owner != null ? Optional.of(owner) : Optional.empty();
    }

    @Override
    public Optional<Owner> save(Owner owner) {
        manager.getTransaction().begin();
        manager.persist(owner);
        manager.getTransaction().commit();
        return owner != null ? Optional.of(owner) : Optional.empty();
    }

    @Override
    public Optional<Owner> update(Owner owner, String id) {
        Owner updateOwner = manager.find(Owner.class, id);
        manager.getTransaction().begin();
        updateOwner.setEmail(owner.getEmail());
        updateOwner.setName(owner.getName());
        updateOwner.setAddress(owner.getAddress());
        updateOwner.setNeighborhood(owner.getNeighborhood());
        manager.merge(updateOwner);
        manager.getTransaction().commit();
        return Optional.of(updateOwner);
    }
}
