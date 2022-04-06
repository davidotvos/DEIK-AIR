package hu.unideb.inf.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginSceneConroller {
    @FXML
    private Button backButton;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField pwLabel;

    @FXML
    private PasswordField userLabel;

    @FXML
    void login(ActionEvent event) {

    }

    @FXML
    void toMain(ActionEvent event) throws IOException {
        Parent newRoot = FXMLLoader.load(getClass().getResource("/FXML/MainScene.fxml"));
        Stage currentStage = (Stage) backButton.getScene().getWindow();
        currentStage.getScene().setRoot(newRoot);
    }
}
