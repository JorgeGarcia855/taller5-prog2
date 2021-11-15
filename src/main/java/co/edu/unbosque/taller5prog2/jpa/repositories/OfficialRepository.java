package co.edu.unbosque.taller5prog2.jpa.repositories;

import co.edu.unbosque.taller5prog2.jpa.entities.Official;

import javax.persistence.EntityManager;
import java.util.Optional;

public class OfficialRepository implements GeneralRepository<Official, String> {
    private final EntityManager manager;

    public OfficialRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Optional<Official> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<Official> save(Official official) {
        manager.getTransaction().begin();
        manager.persist(official);
        manager.getTransaction().commit();
        return official != null ? Optional.of(official) : Optional.empty();
    }


    @Override
    public Optional<Official> update(Official official, String id) {
        Official updateOfficial = manager.find(Official.class, id);
        manager.getTransaction().begin();
        updateOfficial.setEmail(official.getEmail());
        updateOfficial.setName(official.getName());
        manager.merge(updateOfficial);
        manager.getTransaction().commit();
        return Optional.of(updateOfficial);
    }
}
