package hu.unideb.inf.controller;

import hu.unideb.inf.MainApp;
import hu.unideb.inf.model.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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
    private TextField SearchTextField;

    @FXML
    private CheckBox StartCheckbox;

    @FXML
    private ImageView ToCityPicture;

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;

    private MySearchListener mySearchListener;

    private Flights chosenFlight;

    private List<Flights> flights = new ArrayList<>();

    private void setChosenFlight(Flights flight)
    {
        LeftBarFromCity.setText(flight.getStart_city());
        LeftBarToCityLabel.setText(flight.getDestination_city());
        LeftBarPriceFromLabel.setText(MainApp.CURRENCY + Double.toString(flight.getPrice()));
        LeftBarStartTimeLabel.setText(flight.getStart_time());
        Image image1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/" + flight.getStart_city() + ".jpg")));
        FromCityPictures.setImage(image1);
        FromCityPictures.setFitWidth(180);
        Image image2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/" + flight.getDestination_city() + ".jpg")));
        ToCityPicture.setImage(image2);
        ToCityPicture.setFitWidth(180);

        chosenFlight = flight;
    }

    @FXML
    void HandleMyAccountButton(ActionEvent event) {

    }

    @FXML
    void HandleReserveButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/fxml/ReservePage.fxml")));
        Parent newRoot = loader.load();
        Stage currentStage = (Stage) ReserveButton.getScene().getWindow();
        currentStage.getScene().setRoot(newRoot);

        ReservePageController reserveController = loader.getController();
        reserveController.setReservationData(chosenFlight);
    }



    @FXML
    void HandleSearchButton(ActionEvent event) {

        String searchText = SearchTextField.getText();
        //searchText = searchText.substring(0, 1).toUpperCase() + searchText.substring(1).toLowerCase();
        if (Airport.getAirport_city_string_list().contains(searchText))
        {
            try (FlightsDAO fDao = new JpaFlightsDAO()) {
                flights.clear();
                //flights.addAll(fDao.findWith_start_city(searchText));

                if(StartCheckbox.isSelected() && DestinationCheckbox.isSelected()){
                    flights.addAll(fDao.findWith_start_and_destination_city(searchText));
                }
                else if(StartCheckbox.isSelected())
                {
                    flights.addAll(fDao.findWith_start_city(searchText));
                }else if (DestinationCheckbox.isSelected())
                {
                    flights.addAll(fDao.findWith_destination_city(searchText));
                }else flights.addAll(fDao.findWith_destination_city(searchText));

            } catch (Exception e) {
                e.printStackTrace();
            }

            grid.getChildren().clear();
            setGrid();
        }else
        {
            Alert searchAlert = new Alert(Alert.AlertType.WARNING);
            searchAlert.setTitle("We don find flights for this city in our database");
            searchAlert.show();
        }
    }

    @FXML
    void handleBackFromSearchPageButton(ActionEvent event) {

    }

    void setGrid()
    {
        MyFlightItemListener myFlightItemListener = new MyFlightItemListener() {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try (FlightsDAO fDao = new JpaFlightsDAO()) {
            flights.addAll(fDao.getFlights());
            //flights.addAll(fDao.findWith_start_city("London"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        setGrid();

    }
}


