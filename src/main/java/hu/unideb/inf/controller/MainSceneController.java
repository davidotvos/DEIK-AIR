package hu.unideb.inf.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.io.IOException;

public class MainSceneController {


    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    void handleLoginButtonPushed(ActionEvent event) throws IOException {
        Parent newRoot = FXMLLoader.load(getClass().getResource("/FXML/LoginScene.fxml"));
        Stage currentStage = (Stage) loginButton.getScene().getWindow();
        currentStage.getScene().setRoot(newRoot);
    }

    @FXML
    void handleRegisterButtonPushed(ActionEvent event) throws IOException {
        Parent newRoot = FXMLLoader.load(getClass().getResource("/FXML/RegisterScene.fxml"));
        Stage currentStage = (Stage) registerButton.getScene().getWindow();
        currentStage.getScene().setRoot(newRoot);
    }

}
