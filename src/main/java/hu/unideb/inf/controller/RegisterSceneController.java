package hu.unideb.inf.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterSceneController {
    @FXML
    private Button backButton;

    @FXML
    private PasswordField pwConfirmLabel;

    @FXML
    private PasswordField pwLabel;

    @FXML
    private Button registerButton;

    @FXML
    private CheckBox tcLabel;

    @FXML
    private TextField userLabel;

    @FXML
    private Label registerErrorLabel;

    @FXML
    void register(ActionEvent event) {
        CredentialChecker();


    }

    @FXML
     void toLogin(ActionEvent event) throws IOException {
        Parent newRoot = FXMLLoader.load(getClass().getResource("/FXML/MainScene.fxml"));
        Stage currentStage = (Stage) backButton.getScene().getWindow();
        currentStage.getScene().setRoot(newRoot);
    }

    //megnézzük , hogy mindegyik adat helyes
    private void CredentialChecker()
    {
        // lehetséges hibák:
        // 1. username fogalt
        // 2. email foglalt
        //3. nem ugyanaz a két jelszó
        //4. nincs elfogadva tc


        //if(username.foglalt(userLabel.getText()))


        if(!tcLabel.isSelected())
        {
            registerErrorLabel.setText("Nem fogadtad el a TC-t!");
        }
    }
}
