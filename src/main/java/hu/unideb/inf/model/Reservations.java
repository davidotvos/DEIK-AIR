package hu.unideb.inf.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reservations implements Serializable {

    //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String start_city;
    private String destination_city;
    private String start_time;
    private int NumberOfTickets;
    private boolean FirstClass;
    private Double price;
    private String CustomerName;

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStart_city() {
        return start_city;
    }

    public void setStart_city(String start_city) {
        this.start_city = start_city;
    }

    public String getDestination_city() {
        return destination_city;
    }

    public void setDestination_city(String destination_city) {
        this.destination_city = destination_city;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public int getNumberOfTickets() {
        return NumberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        NumberOfTickets = numberOfTickets;
    }

    public boolean isFirstClass() {
        return FirstClass;
    }

    public void setFirstClass(boolean firstClass) {
        FirstClass = firstClass;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
