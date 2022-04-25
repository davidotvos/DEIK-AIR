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
    private TextField emailLabel;

    @FXML
    private PasswordField pwConfirmLabel;

    @FXML
    private PasswordField pwLabel;

    @FXML
    private Button registerButton;

    @FXML
    private Label registerErrorLabel;

    @FXML
    private CheckBox tcLabel;

    @FXML
    private TextField userLabel;

    @FXML
    void register(ActionEvent event) {
        System.out.println(userLabel.getText());
        System.out.println(emailLabel.getText());
        System.out.println(pwLabel.getText());
        System.out.println(pwConfirmLabel.getText());

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
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Hiba");
        alert.setHeaderText("Az alábbi hibába ütköztél:");

        // Ellenőrzi hogy egyik mező sem üres.
        if(!checkIfLabelsEmpty()){
            alert.setContentText("Az összes mező kitöltése kötelező!");
        }
        alert.showAndWait();



        // lehetséges hibák:
        // 1. username fogalt
        // 2. email foglalt
        //3. nem ugyanaz a két jelszó
        //4. nincs elfogadva tc


        //if(username.foglalt(userLabel.getText()))


//        if(!tcLabel.isSelected())
//        {
//            registerErrorLabel.setText("Nem fogadtad el a TC-t!");
//        }
    }

    private boolean checkIfLabelsEmpty(){
        if(userLabel.getText().isEmpty()){
            return false;
        }
        if(emailLabel.getText().isEmpty()){
            return false;
        }
        if(pwLabel.getText().isEmpty()){
            return false;
        }
        if(pwConfirmLabel.getText().isEmpty()){
            return false;
        }
        return true;
    }
}
