package co.edu.unbosque.taller5prog2.jpa.repositories;

import co.edu.unbosque.taller5prog2.jpa.entities.UserApp;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class UserAppRepository implements GeneralRepository<UserApp, String> {
    private final EntityManager manager;

    public UserAppRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Optional<UserApp> findById(String id) {
        UserApp userApp = manager.find(UserApp.class, id);
        return userApp != null ? Optional.of(userApp) : Optional.empty();
    }

    public Optional<List<UserApp>> findByRole(String role) {
        List<UserApp> userApp = manager.createNamedQuery("UserApp.findByRole", UserApp.class)
                .setParameter("role", role)
                .getResultList();
        return userApp != null ? Optional.of(userApp) : Optional.empty();
    }

    public List<UserApp> findAll() {
        return manager.createNamedQuery("UserApp.findAll", UserApp.class).getResultList();
    }

    @Override
    public Optional<UserApp> save(UserApp userApp) {
        manager.getTransaction().begin();
        manager.persist(userApp);
        manager.getTransaction().commit();
        return userApp != null ? Optional.of(userApp) : Optional.empty();
    }

    @Override
    public Optional<UserApp> update(UserApp userApp) {
        userApp = manager.createNamedQuery("UserApp.updateUserEmail", UserApp.class)
                .setParameter("email", userApp.getEmail())
                .getSingleResult();
        return userApp != null ? Optional.of(userApp) : Optional.empty();
    }
}
