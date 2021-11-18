package co.edu.unbosque.taller5prog2.resources.pojos;

import co.edu.unbosque.taller5prog2.jpa.entities.Pet;

public class VisitPOJO {
    private Integer visitId;
    private String createdAt;
    private String type;
    private String description;
    private String vet_id;
    private Integer pet_id;
    private Pet pet;


    public VisitPOJO() {}

    public VisitPOJO(Integer visitId, String createdAt, String type, String description, String vet_id, Integer pet_id) {
        this.visitId = visitId;
        this.createdAt = createdAt;
        this.type = type;
        this.description = description;
        this.vet_id = vet_id;
        this.pet_id = pet_id;
    }

    public VisitPOJO(Integer visitId, String type, String description) {
        this.visitId = visitId;
        this.type = type;
        this.description = description;
    }

    public Integer getVisitId() {
        return visitId;
    }

    public void setVisitId(Integer visitId) {
        this.visitId = visitId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVet_id() {
        return vet_id;
    }

    public void setVet_id(String vet_id) {
        this.vet_id = vet_id;
    }

    public Integer getPet_id() {
        return pet_id;
    }

    public void setPet_id(Integer pet_id) {
        this.pet_id = pet_id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
