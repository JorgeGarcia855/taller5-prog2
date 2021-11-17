package co.edu.unbosque.taller5prog2.jpa.entities;

import co.edu.unbosque.taller5prog2.resources.pojos.UserAppPOJO;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * Esta es la entidad del la tabla Pet. Contiene
 * relaciones con las entidades Owner, PetCase y Visits
 */
@Entity
@Table(name = "Pet")
public class Pet {
    @Id
    @Column(name = "pet_id")
    private Integer petId;

    @Column(unique = true)
    private String microchip;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String species;

    @Column(nullable = false)
    private String race;

    @Column(nullable = false)
    private String size;

    @Column(nullable = false)
    private String sex;

    @Column
    private String picture;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "username", unique = true)
    private Owner owner;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PetCase> petCases;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Visit> visits;

    public Pet() {}

    public Pet(Integer petId, String microchip, String name, String species, String race, String size, String sex, String picture) {
        this.petId = petId;
        this.microchip = microchip;
        this.name = name;
        this.species = species;
        this.race = race;
        this.size = size;
        this.sex = sex;
        this.picture = picture;
    }

    public Pet(Integer petId, String microchip, String name, String species, String race, String size, String sex, String picture, Owner owner) {
        this.petId = petId;
        this.microchip = microchip;
        this.name = name;
        this.species = species;
        this.race = race;
        this.size = size;
        this.sex = sex;
        this.picture = picture;
        this.owner = owner;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getMicrochip() {
        return microchip;
    }

    public void setMicrochip(String microchip) {
        this.microchip = microchip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<PetCase> getPetCases() {
        return petCases;
    }

    public void setPetCases(List<PetCase> petCases) {
        this.petCases = petCases;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    public void addPetCase(PetCase petcase) {
        petCases.add(petcase);
        petcase.setPet(this);
    }
}
