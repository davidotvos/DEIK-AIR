package hu.unideb.inf.controller;

import hu.unideb.inf.MainApp;
import hu.unideb.inf.model.Flights;
import hu.unideb.inf.model.FlightsDAO;
import hu.unideb.inf.model.JpaFlightsDAO;
import hu.unideb.inf.model.MyFlightItemListener;
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

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.List;

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

    private MyFlightItemListener myFlightItemListener;

    private List<Flights> flights = new ArrayList<>();

    private void setChosenFlight(Flights flight)
    {
        LeftBarFromCity.setText(flight.getStart_city());
        LeftBarToCityLabel.setText(flight.getDestination_city());
        LeftBarPriceFromLabel.setText(MainApp.CURRENCY + Double.toString(flight.getPrice()));
        LeftBarStartTimeLabel.setText(flight.getStart_time());
        Image image1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/" + flight.getStart_city().toLowerCase() + ".jpg")));
        FromCityPictures.setImage(image1);
        Image image2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/" + flight.getDestination_city().toLowerCase() + ".jpg")));
        ToCityPicture.setImage(image2);

    }

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

        myFlightItemListener = new MyFlightItemListener() {
            @Override
            public void onClickListener(Flights flight) {
                setChosenFlight(flight);
            }
        };



        int column = 1;
        int row = 1;
        try {
            for (Flights flight : flights) {
                FXMLLoader fxmlLoaderForFlightItem = new FXMLLoader();
                fxmlLoaderForFlightItem.setLocation(getClass().getResource("/fxml/FlightItem.fxml"));

                AnchorPane anchorPane = fxmlLoaderForFlightItem.load();

                FlightItemController flightItemController = fxmlLoaderForFlightItem.getController();
                flightItemController.setData(flight, myFlightItemListener);

                grid.add(anchorPane, column, row++);
                GridPane.setMargin(anchorPane, new Insets(10));
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}


