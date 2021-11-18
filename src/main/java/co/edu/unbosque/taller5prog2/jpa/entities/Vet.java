package co.edu.unbosque.taller5prog2.jpa.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * Esta es la entidad del la tabla Vet, que extiende de la entidad UserApp
 */
@Entity
@Table(name = "Vet")
@PrimaryKeyJoinColumn
public class Vet extends UserApp {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String neighborhood;

    @OneToMany(mappedBy = "vet", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Visit> visits;

    public Vet(String username, String password, String email, String name, String address, String neighborhood) {
        super(username, password, email, "vet");
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
    }

    public Vet() {}

    @Override
    public void addPet(Pet pet) {

    }

    @Override
    public void addVisit(Visit visit) {
        visits.add(visit);
        visit.setVet(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }
}
