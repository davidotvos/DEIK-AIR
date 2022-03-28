package hu.unideb.inf.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

@Entity
public class Flights implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String start_city;
    private String destination_city;
    private String plane_type;
    private String start_time;

    public Flights(String name, String start_city, String destination_city, String plane_type, String start_time) {

        this.name = name;
        this.start_city = start_city;
        this.destination_city = destination_city;
        this.plane_type = plane_type;
        this.start_time = start_time;
    }

    public String getStart_city() { return start_city; }

    public String getDestination_city() { return destination_city; }

    public String getPlane_type() { return plane_type; }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStart_time() { return start_time; }

    public void setId(int id) {
        this.id = id;
    }

    public void setStart_time(String start_time) { this.start_time = start_time; }

    public void setName(String name) {
        this.name = name;
    }

    public void setStart_city(String start_city) { this.start_city = start_city; }

    public void setDestination_city(String destination_city) { this.destination_city = destination_city; }

    public void setPlane_type(String plane_type) { this.plane_type = plane_type; }
}
