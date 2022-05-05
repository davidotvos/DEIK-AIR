package hu.unideb.inf.controller;

import hu.unideb.inf.model.Flights;
import hu.unideb.inf.model.FlightsDAO;
import hu.unideb.inf.model.JpaFlightsDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class SearchFlightsSceneController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try (FlightsDAO fDao = new JpaFlightsDAO()) {
        flights.addAll(fDao.getFlights());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int column = 0;
        int row = 1;
        try {
            for (Flights flight : flights) {
                FXMLLoader fxmlLoaderForFlightItem = FXMLLoader.load(getClass().getResource("/FXML/FlightItem.fxml"));

                AnchorPane anchorPane = fxmlLoaderForFlightItem.load();

                FlightItemController flightItemController = fxmlLoaderForFlightItem.getController();
                flightItemController.setData(flight);

                grid.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(10));
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}


