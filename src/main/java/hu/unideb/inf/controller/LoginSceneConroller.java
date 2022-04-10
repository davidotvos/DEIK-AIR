package hu.unideb.inf.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    void login(ActionEvent event) {

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
