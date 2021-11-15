package co.edu.unbosque.taller5prog2.services;

import co.edu.unbosque.taller5prog2.jpa.entities.Official;
import co.edu.unbosque.taller5prog2.jpa.repositories.GeneralRepository;
import co.edu.unbosque.taller5prog2.jpa.repositories.OfficialRepository;
import co.edu.unbosque.taller5prog2.resources.pojos.UserAppPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Optional;

@Stateless
public class OfficialService {
    public Optional<UserAppPOJO> createOfficial(UserAppPOJO officialPOJO) {
        EntityManager manager = Persistence.createEntityManagerFactory("taller5-prog2").createEntityManager();
        GeneralRepository<Official, String> repository = new OfficialRepository(manager);
        Official official = new Official(
                officialPOJO.getUsername(),
                officialPOJO.getPassword(),
                officialPOJO.getEmail(),
                officialPOJO.getName()
        );

        Optional<Official> persistedOfficial = repository.save(official);
        manager.close();

        return persistedOfficial.map(value -> new UserAppPOJO(
                value.getUsername(),
                value.getPassword(),
                value.getEmail(),
                value.getName()
        ));
    }

    public Optional<UserAppPOJO> updateOfficial(UserAppPOJO officialPOJO, String id) {
        EntityManager manager = Persistence.createEntityManagerFactory("taller5-prog2").createEntityManager();
        GeneralRepository<Official, String> repository = new OfficialRepository(manager);
        Official official = new Official(
                officialPOJO.getUsername(),
                officialPOJO.getPassword(),
                officialPOJO.getEmail(),
                officialPOJO.getName()
        );

        Optional<Official> persistedOfficial = repository.update(official, id);
        manager.close();

        return persistedOfficial.map(value -> new UserAppPOJO(
                value.getUsername(),
                value.getPassword(),
                value.getEmail(),
                value.getName()
        ));
    }
}
