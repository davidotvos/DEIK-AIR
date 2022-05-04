package hu.unideb.inf.controller;

import hu.unideb.inf.model.JpaCustomerDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.io.IOException;

public class LoginSceneConroller {
    @FXML
    private Button backButton;

    @FXML
    private Button loginButton;

    @FXML
    private Button loginRegsiterButton;

    @FXML
    private PasswordField pwLabel;

    @FXML
    private TextField userLabel;


    @FXML
    void login(ActionEvent event) throws IOException{
        System.out.println("Hello");

        JpaCustomerDAO loginDAO = new JpaCustomerDAO();
        String pass = loginDAO.getCustomerPass(userLabel.getText());

        //ha a lekért jelszó megegyezik a megadottal akkor bent van a user
        if(pass.equals(pwLabel.getText()))
        {
            loginDAO.SetLoggedInCustomer(userLabel.getText());
            System.out.println(userLabel.getText());
            Parent newRoot = FXMLLoader.load(getClass().getResource("/FXML/HomeScene.fxml"));
            Stage currentStage = (Stage) backButton.getScene().getWindow();
            currentStage.getScene().setRoot(newRoot);

        }
        else{
            System.out.println("hibás felhasználónév/jeleszó!");
            Alert hiba = new Alert(Alert.AlertType.WARNING);
            hiba.setTitle("Hiba");
            hiba.setHeaderText("Az alábbi hibába ütköztél:");
            hiba.setContentText("Hibás felhasználónév vagy jelszó!");
            hiba.showAndWait();
        }
    }

    @FXML
    void toMain(ActionEvent event) throws IOException {
        Parent newRoot = FXMLLoader.load(getClass().getResource("/FXML/MainScene.fxml"));
        Stage currentStage = (Stage) backButton.getScene().getWindow();
        currentStage.getScene().setRoot(newRoot);
    }

    @FXML
    void handleRegisterButtonPushed(ActionEvent event) throws IOException {
        Parent newRoot = FXMLLoader.load(getClass().getResource("/FXML/RegisterScene.fxml"));
        Stage currentStage = (Stage) loginRegsiterButton.getScene().getWindow();
        currentStage.getScene().setRoot(newRoot);
    }

}
