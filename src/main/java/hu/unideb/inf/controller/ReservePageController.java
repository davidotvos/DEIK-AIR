package hu.unideb.inf.controller;

import hu.unideb.inf.MainApp;
import hu.unideb.inf.model.Flights;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ThreadPoolExecutor;

public class ReservePageController {

    @FXML
    private Label AirCraftType;

    @FXML
    private CheckBox FirstClassCheckbox;

    @FXML
    private Label FromCity;

    @FXML
    private Label StartTime;

    @FXML
    private Label Price;

    @FXML
    private ComboBox<?> Tickets;

    @FXML
    private Label ToCity;

    @FXML
    private Button backButton;

    @FXML
    private CheckBox iWillPayCheckbox;

    @FXML
    private Button reserveButton;

    public void setReserveData(Flights flight)
    {
        FromCity.setText(flight.getStart_city());
        ToCity.setText(flight.getDestination_city());
        StartTime.setText(flight.getStart_time());
        AirCraftType.setText(flight.getPlane_type());
        Price.setText(MainApp.CURRENCY + Double.toString(flight.getPrice()));
    }

    @FXML
    void handleBackButton(ActionEvent event) throws IOException {
        Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/SearchScene.fxml")));
        Stage currentStage = (Stage) backButton.getScene().getWindow();
        currentStage.setMinHeight(600);
        currentStage.setMinWidth(900);
        currentStage.setHeight(750);
        currentStage.setWidth(1100);
        currentStage.setTitle("Search Page");
        currentStage.setX(0);
        currentStage.setY(0);
        currentStage.getScene().setRoot(newRoot);
    }

    @FXML
    void handleReserveButton(ActionEvent event) {

    }
}