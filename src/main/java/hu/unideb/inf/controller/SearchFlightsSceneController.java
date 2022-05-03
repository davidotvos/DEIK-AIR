package hu.unideb.inf.controller;

import hu.unideb.inf.model.Flights;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class SearchFlightsSceneController {

    @FXML
    private CheckBox DestinationCheckbox;

    @FXML
    private ImageView FromCityPictures;

    @FXML
    private Button MyAccount;

    @FXML
    private Button ReserveButton;

    @FXML
    private Label RightbarFromCity;

    @FXML
    private Label RightbarStartTimeLabel;

    @FXML
    private Label RightbarToCityLabel;

    @FXML
    private Label RightbarPriceFromLabel;

    @FXML
    private Button SearchButton;

    @FXML
    private Button BackFromSearchPageButton;

    @FXML
    private TextField SearchTextfield;

    @FXML
    private CheckBox StartCheckbox;

    @FXML
    private ImageView ToCityPicture;

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;

    private List<Flights> flights = new ArrayList<>();

    @FXML
    void HandleMyAccountButton(ActionEvent event) {

    }

    @FXML
    void HandleReserveButton(ActionEvent event) {

    }

    @FXML
    void HandleSearchButton(ActionEvent event) {

    }

    @FXML
    void handleBackFromSearchPageButton(ActionEvent event) {

    }

}


