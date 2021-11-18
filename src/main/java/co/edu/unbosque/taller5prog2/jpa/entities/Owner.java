package co.edu.unbosque.taller5prog2.jpa.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * Esta es la entidad del la tabla Owner, que extiende de la entidad UserApp
 */
@Entity
@Table(name = "Owner")
@PrimaryKeyJoinColumn
public class Owner extends UserApp {

    @Column(name = "person_id", unique = true, nullable = false, updatable = false)
    @GeneratedValue
    private Long personId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String neighborhood;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Pet> pets;

    public Owner(String username, String password, String email, Long personId, String name, String address, String neighborhood) {
        super(username, password, email, "owner");
        this.personId = personId;
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
    }

    public Owner(String username, Long personId) {
        super(username, "owner");
        this.personId = personId;
    }

    public Owner() {}

    @Override
    public void addPet(Pet pet) {
        pets.add(pet);
        pet.setOwner(this);
    }

    @Override
    public void addVisit(Visit visit) {

    }


    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
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

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

}
