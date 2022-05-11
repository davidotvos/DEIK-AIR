package hu.unideb.inf.model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Reservation {
    private String startCity;
    private String destCity;
    private String startTime;
    private int numberOfTickets;
    private boolean firstClass;
    private double price;

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getDestCity() {
        return destCity;
    }

    public void setDestCity(String destCity) {
        this.destCity = destCity;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Integer getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(Integer numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public Boolean getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(Boolean firstClass) {
        this.firstClass = firstClass;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Reservation(String startCity, String destCity, String startTime, Integer numberOfTickets, Boolean firstClass, Double price) {
        this.startCity = startCity;
        this.destCity = destCity;
        this.startTime = startTime;
        this.numberOfTickets = numberOfTickets;
        this.firstClass = firstClass;
        this.price = price;
    }

    public static double FirstClassPrice(double basePrice){
        return basePrice * 2;
    }
    public static double BaseClassPrice(double basePrice){
        return basePrice / 2;
    }

}


