package co.edu.unbosque.taller5prog2.jpa.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue
    @Column(name = "pet_id")
    private Integer petId;

    @Column(nullable = false, unique = true)
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

    @Column(nullable = false)
    private String picture;

    @ManyToOne
    @JoinColumn(name = "username")
    private Owner owner;

    @OneToMany(mappedBy = "pet", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PetCase> petCases;

    @OneToMany(mappedBy = "pet", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Visit> visits;

    public Pet() {}

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

    public void setOwnerId(Owner owner) {
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
}
