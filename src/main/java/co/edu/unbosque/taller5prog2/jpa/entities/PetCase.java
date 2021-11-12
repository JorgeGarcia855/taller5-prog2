package co.edu.unbosque.taller5prog2.jpa.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "PetCase")
public class PetCase {
    @Id
    @GeneratedValue
    @Column(name = "case_id")
    private Integer caseId;

    @Column(name = "created_at", nullable = false)
    private String createdAt;

    @Pattern(regexp = "perdida|robo|fallecimiento", flags = Pattern.Flag.CASE_INSENSITIVE)
    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public PetCase() {}

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
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

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
