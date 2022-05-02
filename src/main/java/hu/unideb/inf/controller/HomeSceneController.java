package hu.unideb.inf.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HomeSceneController {

    @FXML
    private Button HomeLogoutButton;

    @FXML
    void handleHomeLogoutButtonPushed(ActionEvent event) throws IOException {
        Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/MainScene.fxml")));
        Stage currentStage = (Stage) HomeLogoutButton.getScene().getWindow();
        currentStage.getScene().setRoot(newRoot);

    }
}
