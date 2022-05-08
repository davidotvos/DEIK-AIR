package hu.unideb.inf.controller;

import hu.unideb.inf.MainApp;
import hu.unideb.inf.model.Flights;
import hu.unideb.inf.model.MyFlightItemListener;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class FlightItemController {

    @FXML
    private Label itemFromCity;

    @FXML
    private Label itemPriceFrom;

    @FXML
    private Label itemStartTime;

    @FXML
    private Label itemToCity;

    @FXML
    private void click(MouseEvent mouseEvent)
    {
        myFlightItemListener.onClickListener(flight);
    }

    private Flights flight;
    private MyFlightItemListener myFlightItemListener;


    public void setData(Flights flight, MyFlightItemListener myFlightItemListener){

        this.flight = flight;
        this.myFlightItemListener = myFlightItemListener;
        itemFromCity.setText(flight.getStart_city());
        itemToCity.setText(flight.getDestination_city());
        itemStartTime.setText(flight.getStart_time());
        itemPriceFrom.setText(MainApp.CURRENCY + Double.toString(flight.getPrice()));

    }

}