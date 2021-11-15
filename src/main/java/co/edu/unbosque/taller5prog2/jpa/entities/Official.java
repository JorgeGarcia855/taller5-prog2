package co.edu.unbosque.taller5prog2.jpa.entities;

import javax.persistence.*;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
