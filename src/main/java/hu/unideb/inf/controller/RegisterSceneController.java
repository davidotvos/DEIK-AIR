package hu.unideb.inf.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterSceneController {

    @FXML
    private PasswordField userLabel;

    @FXML
    private PasswordField pwLabel;

    @FXML
    private PasswordField pwConfirmLabel;

    @FXML
    private CheckBox tcLabel;

    @FXML
    private Button backButton;

    @FXML
    private Button registerButton;

    @FXML
    void register(ActionEvent event) {

    }

    @FXML
     void toLogin(ActionEvent event) throws IOException {
        Parent newRoot = FXMLLoader.load(getClass().getResource("/FXML/MainScene.fxml"));
        Stage currentStage = (Stage) backButton.getScene().getWindow();
        currentStage.getScene().setRoot(newRoot);
    }
}
