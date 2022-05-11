package hu.unideb.inf.controller;

import hu.unideb.inf.MainApp;
import hu.unideb.inf.model.Flights;
import hu.unideb.inf.model.JpaReservationsDAO;
import hu.unideb.inf.model.Reservations;
import hu.unideb.inf.model.ReservationsDAO;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadPoolExecutor;

public class ReservePageController implements Initializable {

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
    private ComboBox Tickets;

    @FXML
    private Label ToCity;

    @FXML
    private Button backButton;

    @FXML
    private CheckBox iWillPayCheckbox;

    @FXML
    private Button reserveButton;

    private Double normalprice;

    private Flights this_flight;

    public void setReservationData(Flights flight)
    {
        FromCity.setText(flight.getStart_city());
        ToCity.setText(flight.getDestination_city());
        StartTime.setText(flight.getStart_time());
        AirCraftType.setText(flight.getPlane_type());
        Price.setText(MainApp.CURRENCY + Double.toString(flight.getPrice()));

        normalprice = flight.getPrice();
        this_flight = flight;
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
    void handleReserveButton(ActionEvent event) throws Exception {
        if(iWillPayCheckbox.isSelected() && !Tickets.getSelectionModel().isEmpty())
        {
            AddReservation(this_flight);
            Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
            successAlert.setTitle("Reservation Done");
            successAlert.setContentText("You successfully reserved this flight, you have to pay: " + Price.getText());
            successAlert.show();
            Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/SearchScene.fxml")));
            Stage currentStage = (Stage) reserveButton.getScene().getWindow();
            currentStage.setHeight(750);
            currentStage.setWidth(1100);
            currentStage.setTitle("Search Page");
            currentStage.setX(0);
            currentStage.setY(0);
            currentStage.getScene().setRoot(newRoot);
        }else
        {
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setTitle("Warning");
            warningAlert.setContentText("You have to choose how many tickets would you reserve. \nAnd you have to confirm you will pay or cancel your reserve");
            warningAlert.show();
        }
    }

    @FXML
    void Select(ActionEvent event) {
        double newPrice = Double.parseDouble(Tickets.getSelectionModel().getSelectedItem().toString()) * normalprice;

        Price.setText(MainApp.CURRENCY + Double.toString(newPrice));
        FirstClassCheckbox.setSelected(false);
    }

    @FXML
    void FirstClass(ActionEvent event) {
        double newPrice = Double.parseDouble(Price.getText().substring(1));
        if(FirstClassCheckbox.isSelected())
        {
            newPrice = newPrice * 2;
        }else newPrice = newPrice / 2;
        Price.setText(MainApp.CURRENCY + newPrice);
    }

    private void AddReservation(Flights f) throws Exception {
        try (ReservationsDAO rDao = new JpaReservationsDAO()){
            Reservations r;
            r = new Reservations();
            r.setStart_city(f.getStart_city());
            r.setDestination_city(f.getDestination_city());
            r.setStart_time(f.getStart_time());
            r.setNumberOfTickets(Integer.parseInt(Tickets.getSelectionModel().getSelectedItem().toString()));
            r.setPrice(Double.parseDouble(Price.getText().substring(1)));
            r.setCustomerName(MainApp.LoggedInCustomer.getName());
            rDao.saveReservation(r);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Integer> Ticket_number_list = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9);
        Tickets.setItems(Ticket_number_list);
    }
}