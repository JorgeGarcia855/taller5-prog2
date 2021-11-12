package co.edu.unbosque.taller5prog2.services;

import co.edu.unbosque.taller5prog2.jpa.entities.Pet;
import co.edu.unbosque.taller5prog2.jpa.entities.Vet;
import co.edu.unbosque.taller5prog2.jpa.repositories.GeneralRepository;
import co.edu.unbosque.taller5prog2.jpa.repositories.VetRepository;
import co.edu.unbosque.taller5prog2.resources.pojos.VetPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Optional;

@Stateless
public class VetService {
    public Optional<VetPOJO> createVet(VetPOJO vetPOJO) {
        EntityManager manager = Persistence.createEntityManagerFactory("taller5-prog2").createEntityManager();
        GeneralRepository<Vet, String> repository = new VetRepository(manager);
        Vet vet = new Vet(
                vetPOJO.getUsername(),
                vetPOJO.getPassword(),
                vetPOJO.getEmail(),
                vetPOJO.getName(),
                vetPOJO.getAddress(),
                vetPOJO.getNeighborhood()
        );
        Optional<Vet> persistedVet = repository.save(vet);
        manager.close();
        return persistedVet.map(value -> new VetPOJO(
                value.getUsername(),
                value.getPassword(),
                value.getEmail(),
                value.getName(),
                value.getAddress(),
                value.getNeighborhood()
        ));
    }
}
