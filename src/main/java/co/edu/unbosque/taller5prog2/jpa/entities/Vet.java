package co.edu.unbosque.taller5prog2.jpa.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vet")
public class Vet {
    @Id
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String neighborhood;

    @OneToOne
    @JoinColumn(name = "username") @MapsId
    private UserApp userApp;

    @OneToMany(mappedBy = "vet", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Visit> visits;

    public Vet() {}

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

    public UserApp getUserApp() {
        return userApp;
    }

    public void setUserApp(UserApp userApp) {
        this.userApp = userApp;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }
}
