package co.edu.unbosque.taller5prog2.jpa.entities;

import javax.persistence.*;

@Entity
@Table(name = "official")
public class Official {
    @Id
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "username") @MapsId
    private UserApp userApp;

    public Official() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserApp getUserApp() {
        return userApp;
    }

    public void setUserApp(UserApp userApp) {
        this.userApp = userApp;
    }
}
