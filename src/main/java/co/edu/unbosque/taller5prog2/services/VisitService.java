package co.edu.unbosque.taller5prog2.services;

import co.edu.unbosque.taller5prog2.jpa.entities.Official;
import co.edu.unbosque.taller5prog2.jpa.entities.Visit;
import co.edu.unbosque.taller5prog2.jpa.repositories.GeneralRepository;
import co.edu.unbosque.taller5prog2.jpa.repositories.OfficialRepository;
import co.edu.unbosque.taller5prog2.jpa.repositories.VisitRepository;
import co.edu.unbosque.taller5prog2.resources.pojos.UserAppPOJO;
import co.edu.unbosque.taller5prog2.resources.pojos.VisitPOJO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Optional;

public class VisitService {
    public Optional<VisitPOJO> createVisit(VisitPOJO visitPOJO) {
        EntityManager manager = Persistence.createEntityManagerFactory("taller5-prog2").createEntityManager();
        GeneralRepository<Visit, Integer> repository = new VisitRepository(manager);
        Visit visit = new Visit(
                visitPOJO.getVisitId(),
                visitPOJO.getType(),
                visitPOJO.getDescription()
        );

        Optional<Visit> persistedVisit = repository.save(visit);
        manager.close();

        return persistedVisit.map(value -> new VisitPOJO(
                value.getVisitId(),
                value.getType(),
                value.getDescription()
        ));
    }
}
