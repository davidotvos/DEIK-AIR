package hu.unideb.inf.controller;

import hu.unideb.inf.MainApp;
import hu.unideb.inf.model.Flights;
import hu.unideb.inf.model.MyListener;
import javafx.event.ActionEvent;
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

    private Flights flight;
    private MyListener myListener;

    @FXML
    private void click(MouseEvent mouseEvent)
    {
        myListener.MyClickListener(flight);
    }

    public void setData(Flights flight, MyListener myListener){
        this.flight = flight;
        this.myListener = myListener;
        itemFromCity.setText(flight.getStart_city());
        itemToCity.setText(flight.getDestination_city());
        itemStartTime.setText(flight.getStart_time());
        itemPriceFrom.setText(MainApp.CURRENCY + Double.toString(flight.getPrice()));

    }

}