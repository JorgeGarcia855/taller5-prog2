package co.edu.unbosque.taller5prog2.jpa.entities;

import javax.persistence.*;

/**
 * Esta es la entidad del la tabla Official, que extiende de la entidad UserApp
 */
@Entity
@Table(name = "Official")
@PrimaryKeyJoinColumn
public class Official extends UserApp {

    @Column(nullable = false)
    private String name;

    public Official(String username, String password, String email, String name) {
        super(username, password, email, "official");
        this.name = name;
    }

    public Official() {}

    @Override
    public void addPet(Pet pet) {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
