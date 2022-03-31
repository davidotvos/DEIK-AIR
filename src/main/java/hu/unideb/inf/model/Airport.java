package hu.unideb.inf.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Airport {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String city;
    private String country;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Airport_id")
    private List<Flights> flights = new ArrayList<>();
    public static Set<Airport> airports = new HashSet<>();

    public static void addAirportToSet(Airport a){ airports.add(a);}

    public Set<Airport> getAirportSet()
    {
        return airports;
    }

    public void addFlightToList(Flights f)
    {
        this.flights.add(f);
    }

    public List<Flights> getFlightList()
    {
        return flights;
    }
    //getters

    public int getId() {
        return id;
    }

    public String getName() {return name;}

    public String getCity() {return city;}

    public String getCountry() {return country;}

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCity(String city) {this.city = city;}

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {this.country = country;}


}
