package hu.unideb.inf.controller;

import hu.unideb.inf.MainApp;
import hu.unideb.inf.model.Flights;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FlightItemController {

    @FXML
    private Label itemFromCity;

    @FXML
    private Label itemPriceFrom;

    @FXML
    private Label itemStartTime;

    @FXML
    private Label itemToCity;

    private Flights flight;

    public void setData(Flights flight){
        this.flight = flight;
        itemFromCity.setText(flight.getStart_city());
        itemToCity.setText(flight.getDestination_city());
        itemStartTime.setText(flight.getStart_time());
        itemPriceFrom.setText(MainApp.CURRENCY + Double.toString(flight.getPrice()));

    }

}