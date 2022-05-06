package hu.unideb.inf.controller;

import hu.unideb.inf.model.JpaCustomerDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.util.Objects;

public class HomeSceneController{

    @FXML
    private Button MyAccount;

    @FXML
    private Button HomeLogoutButton;

    @FXML
    private Button aboutButton;

    @FXML
    private Button helpButton;

    @FXML
    private Button searchButton;

    @FXML
    void handleHomeLogoutButtonPushed(ActionEvent event) throws IOException {
        JpaCustomerDAO loginDAO = new JpaCustomerDAO();
        loginDAO.SetLoggedInCustomer(null);
        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("Logout");
        successAlert.setContentText("Sikeresen kijelentkeztél!");
        successAlert.showAndWait();
        Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/MainScene.fxml")));
        Stage currentStage = (Stage) HomeLogoutButton.getScene().getWindow();
        currentStage.getScene().setRoot(newRoot);

    }

    @FXML
    void toAbout(ActionEvent event) {

    }

    @FXML
    void toHelp(ActionEvent event) {

    }

    @FXML
    void toSearch(ActionEvent event) throws IOException {
        Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/SearchScene.fxml")));
        Stage currentStage = (Stage) searchButton.getScene().getWindow();
        currentStage.setMinHeight(600);
        currentStage.setMinWidth(900);
        currentStage.setHeight(750);
        currentStage.setWidth(1100);
        currentStage.setTitle("Search Page");
        currentStage.setX(0);
        currentStage.setY(0);
        currentStage.getScene().setRoot(newRoot);

    }

}

