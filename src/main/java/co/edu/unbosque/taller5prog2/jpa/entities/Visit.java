package co.edu.unbosque.taller5prog2.jpa.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Esta es la entidad del la tabla Visit. Contiene Relaciones
 * con las entidades Vet y Pet
 */

@Entity
@Table(name = "Visit")
public class Visit {
    @Id
    @GeneratedValue
    @Column(name = "visit_id")
    private Integer visitId;

    @Column(name = "created_at", nullable = false)
    private String createdAt;

    @Pattern(regexp = "steri|mcImp|vacc|deworm|urg|ctrl", flags = Pattern.Flag.CASE_INSENSITIVE)
    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "vet_id", referencedColumnName = "username", unique = true)
    private Vet vet;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Visit() {}

    public Visit(Integer visitId, String type, String description) {
        this.visitId = visitId;
        this.createdAt = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        this.type = type;
        this.description = description;
    }

    public Visit(Integer visitId, String type, String description, Vet vet, Pet pet) {
        this.visitId = visitId;
        this.createdAt = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        this.type = type;
        this.description = description;
        this.vet = vet;
        this.pet = pet;
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

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
