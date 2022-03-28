package hu.unideb.inf.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Airport {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String city;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Airport_id")
    private List<Flights> flights = new ArrayList<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flights> getFlights() {
        return flights;
    }

    public void setAnimals(List<Flights> animals) {
        this.flights = animals;
    }
}
