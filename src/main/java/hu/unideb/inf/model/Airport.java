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

    @Override
    public String toString() {
        return city;
    }


    //visszaad egy string listát ami az összes légitársaság city -jét tartalmazza
    public static List<String> getAirport_city_string_list()
    {
        List<String> airport_city_string_list = new ArrayList<>();
        for (Airport s : Airport.getAirportSet()) {
            airport_city_string_list.add(s.toString());
        }
        return airport_city_string_list;
    }


    public static void addAirportToSet(Airport a){ airports.add(a);}

    public static Set<Airport> getAirportSet()
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
