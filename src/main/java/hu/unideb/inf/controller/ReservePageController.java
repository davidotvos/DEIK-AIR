package hu.unideb.inf.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

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
    private ComboBox<?> Tickets;

    @FXML
    private Label ToCity;

    @FXML
    private Button backButton;

    @FXML
    private CheckBox iWillPayCheckbox;

    @FXML
    private Button reserveButton;

    @FXML
    void handleBackButton(ActionEvent event) {

    }

    @FXML
    void handleReserveButton(ActionEvent event) {

    }
}