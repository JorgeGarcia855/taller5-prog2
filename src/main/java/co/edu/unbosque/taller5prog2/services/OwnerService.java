package co.edu.unbosque.taller5prog2.services;

import co.edu.unbosque.taller5prog2.jpa.entities.Owner;
import co.edu.unbosque.taller5prog2.jpa.repositories.GeneralRepository;
import co.edu.unbosque.taller5prog2.jpa.repositories.OwnerRepository;
import co.edu.unbosque.taller5prog2.resources.pojos.UserAppPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Optional;

@Stateless
public class OwnerService {
    public Optional<UserAppPOJO> createOwner(UserAppPOJO ownerPOJO) {
        EntityManager manager = Persistence.createEntityManagerFactory("taller5-prog2").createEntityManager();
        GeneralRepository<Owner, String> repository = new OwnerRepository(manager);
        Owner owner = new Owner(
                ownerPOJO.getUsername(),
                ownerPOJO.getPassword(),
                ownerPOJO.getEmail(),
                ownerPOJO.getPersonId(),
                ownerPOJO.getName(),
                ownerPOJO.getAddress(),
                ownerPOJO.getNeighborhood()
        );

        Optional<Owner> persistedOwner = repository.save(owner);
        manager.close();

        return persistedOwner.map(value -> new UserAppPOJO(
                value.getUsername(),
                value.getPassword(),
                value.getEmail(),
                value.getPersonId(),
                value.getName(),
                value.getAddress(),
                value.getNeighborhood()
        ));
    }

    public Optional<UserAppPOJO> updateOwner(UserAppPOJO ownerPOJO, String id) {
        EntityManager manager = Persistence.createEntityManagerFactory("taller5-prog2").createEntityManager();
        GeneralRepository<Owner, String> repository = new OwnerRepository(manager);
        Owner owner = new Owner(
                ownerPOJO.getUsername(),
                ownerPOJO.getPassword(),
                ownerPOJO.getEmail(),
                ownerPOJO.getPersonId(),
                ownerPOJO.getName(),
                ownerPOJO.getAddress(),
                ownerPOJO.getNeighborhood()
        );

        Optional<Owner> persistedOwner = repository.update(owner, id);
        manager.close();

        return persistedOwner.map(value -> new UserAppPOJO(
                value.getUsername(),
                value.getPassword(),
                value.getEmail(),
                value.getPersonId(),
                value.getName(),
                value.getAddress(),
                value.getNeighborhood()
        ));
    }
}
