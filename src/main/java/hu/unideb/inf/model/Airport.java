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

    public void flightToList(Flights f)
    {
        this.flights.add(f);
    }
    public List<Flights> getFlightList()
    {
        return flights;
    }
    public String getCity() {return city;}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCity(String city) {this.city = city;}

    public void setName(String name) {
        this.name = name;
    }




}
