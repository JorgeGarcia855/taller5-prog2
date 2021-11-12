package co.edu.unbosque.taller5prog2.services;

import co.edu.unbosque.taller5prog2.jpa.entities.UserApp;
import co.edu.unbosque.taller5prog2.jpa.repositories.GeneralRepository;
import co.edu.unbosque.taller5prog2.jpa.repositories.UserAppRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

@Stateless
public class UserAppService {

    public Optional<String> validateUser(String username, String password) {
        EntityManager entityManager = Persistence
                .createEntityManagerFactory("taller5-prog2")
                .createEntityManager();

        GeneralRepository<UserApp, String> generalRepository = new UserAppRepository(entityManager);
        Optional<UserApp> user = generalRepository.findById(username);
        entityManager.close();

        if (user.isPresent())
            if (user.get().getUsername().equals(username) && user.get().getPassword().equals(password))
                return Optional.of(user.get().getRole());

        return Optional.empty();
    }
}
