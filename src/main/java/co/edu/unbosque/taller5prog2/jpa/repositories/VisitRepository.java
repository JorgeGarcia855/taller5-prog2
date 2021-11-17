package co.edu.unbosque.taller5prog2.jpa.repositories;

import co.edu.unbosque.taller5prog2.jpa.entities.Visit;

import javax.persistence.EntityManager;
import java.util.Optional;

/**
 * El repositorio de la entidad Visit, que implementa los
 * metodos de la interfaz GeneralRepository
 */
public class VisitRepository implements GeneralRepository<Visit, Integer> {
    private final EntityManager manager;

    public VisitRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Optional<Visit> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Visit> save(Visit visit) {
        manager.getTransaction().begin();
        manager.merge(visit);
        manager.getTransaction().commit();
        return visit != null ? Optional.of(visit) : Optional.empty();
    }

    @Override
    public Optional<Visit> update(Visit visit, Integer id) {
        return Optional.empty();
    }
}
