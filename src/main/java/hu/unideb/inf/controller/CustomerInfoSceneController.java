package hu.unideb.inf.controller;

import hu.unideb.inf.MainApp;
import hu.unideb.inf.model.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.collections.FXCollections;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class CustomerInfoSceneController implements Initializable {

    @FXML
    private Label EmailLabel;

    @FXML
    private TableView<Reservation> ReservationTable;

    @FXML
    private Label UserLabel;

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<Reservation, String> destColumn;

    @FXML
    private TableColumn<Reservation, Boolean> firstclassColumn;

    @FXML
    private TableColumn<Reservation, Double> priceColumn;

    @FXML
    private TableColumn<Reservation, String> startColumn;

    @FXML
    private TableColumn<Reservation, String> startTimeColumn;

    @FXML
    private TableColumn<Reservation, Integer> ticketsColumn;

    @FXML
    void toHomeScene(ActionEvent event) throws IOException {
        Parent newRoot = FXMLLoader.load(getClass().getResource("/FXML/HomeScene.fxml"));
        Stage currentStage = (Stage) backButton.getScene().getWindow();
        currentStage.setHeight(437.6000061035156);
        currentStage.setWidth(614.4000244140625);
        currentStage.getScene().setRoot(newRoot);

    }

    public void showReservations(){
        try( ReservationsDAO rDao = new JpaReservationsDAO()){
            ObservableList<Reservation> resLi = ReservationTable.getItems();
            List<Reservations> templi = rDao.getReservations();
            for(Reservations r : templi)
            {
                if(Objects.equals(r.getCustomerName(), MainApp.LoggedInCustomer.getName()))
                {
                    Reservation temp = new Reservation(r.getStart_city(),r.getDestination_city(),r.getStart_time(),r.getNumberOfTickets(),r.isFirstClass(),r.getPrice());
                    resLi.add(temp);
                }
            }
            ReservationTable.setItems(resLi);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startColumn.setCellValueFactory(new PropertyValueFactory<>("startCity"));
        destColumn.setCellValueFactory(new PropertyValueFactory<>("destCity"));
        startTimeColumn.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        ticketsColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfTickets"));
        firstclassColumn.setCellValueFactory(new PropertyValueFactory<>("firstClass"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));


        UserLabel.setText(MainApp.LoggedInCustomer.getName());
        EmailLabel.setText(MainApp.LoggedInCustomer.getEmail());

        showReservations();
    }


}
