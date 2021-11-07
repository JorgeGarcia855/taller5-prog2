package co.edu.unbosque.taller5prog2.jpa.entities;

import io.smallrye.common.constraint.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "userApp")
public class UserApp {
    @Id @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Email @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String role;

    @OneToOne(mappedBy = "userApp")
    private Owner owner;

    @OneToOne(mappedBy = "userApp")
    private Official official;

    @OneToOne(mappedBy = "userApp")
    private Vet vet;

    public UserApp() {}

    public UserApp(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Official getOfficial() {
        return official;
    }

    public void setOfficial(Official official) {
        this.official = official;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }
}
