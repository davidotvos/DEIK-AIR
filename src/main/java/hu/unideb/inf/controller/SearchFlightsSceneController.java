package hu.unideb.inf.controller;

import hu.unideb.inf.MainApp;
import hu.unideb.inf.model.Flights;
import hu.unideb.inf.model.FlightsDAO;
import hu.unideb.inf.model.JpaFlightsDAO;
import hu.unideb.inf.model.MyListener;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.util.List;

public class SearchFlightsSceneController implements Initializable {

    @FXML
    private CheckBox DestinationCheckbox;

    @FXML
    private ImageView FromCityPicture;

    @FXML
    private Button MyAccount;

    @FXML
    private Button ReserveButton;

    @FXML
    private Label LeftBarFromCity;

    @FXML
    private Label LeftBarStartTimeLabel;

    @FXML
    private Label LeftBarToCityLabel;

    @FXML
    private Label LeftBarPriceFromLabel;

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

    MyListener myListener;


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


    private void setChosenFlight(Flights flight)
    {
        LeftBarFromCity.setText(flight.getStart_city());
        LeftBarToCityLabel.setText(flight.getDestination_city());
        LeftBarPriceFromLabel.setText(MainApp.CURRENCY + Double.toString(flight.getPrice()));
        LeftBarStartTimeLabel.setText(flight.getStart_time());
        Image image1 = new javafx.scene.image.Image(String.valueOf(getClass().getResource("/img/" + flight.getStart_city().toLowerCase(Locale.ROOT) + ".jpg")));
        FromCityPicture.setImage(image1);
        Image image2 = new javafx.scene.image.Image(String.valueOf(getClass().getResource("/img/" + flight.getDestination_city().toLowerCase(Locale.ROOT) + ".jpg")));
        FromCityPicture.setImage(image2);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try (FlightsDAO fDao = new JpaFlightsDAO()) {
        flights.addAll(fDao.getFlights());
        myListener = new MyListener() {
            @Override
            public void MyClickListener(Flights flight) {
                setChosenFlight(flight);
            }
        };


        } catch (Exception e) {
            e.printStackTrace();
        }
        int column = 1;
        int row = 1;
        try {
            for (Flights flight : flights) {
                FXMLLoader fxmlLoaderForFlightItem = new FXMLLoader();
                fxmlLoaderForFlightItem.setLocation(getClass().getResource("/fxml/FlightItem.fxml"));

                AnchorPane anchorPane = fxmlLoaderForFlightItem.load();

                FlightItemController flightItemController = fxmlLoaderForFlightItem.getController();
                flightItemController.setData(flight, myListener);

                grid.add(anchorPane, column, row++);

                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}


