package hu.unideb.inf.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerInfoSceneController {

    @FXML
    private Button backButton;

    @FXML
    void toHomeScene(ActionEvent event) throws IOException {
        Parent newRoot = FXMLLoader.load(getClass().getResource("/FXML/HomeScene.fxml"));
        Stage currentStage = (Stage) backButton.getScene().getWindow();
        currentStage.getScene().setRoot(newRoot);
    }

}
