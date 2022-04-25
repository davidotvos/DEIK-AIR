package hu.unideb.inf.controller;
import hu.unideb.inf.model.Customer;
import hu.unideb.inf.model.CustomerDAO;
import hu.unideb.inf.model.JpaCustomerDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

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

        CredentialChecker();


    }

    @FXML
     void toLogin(ActionEvent event) throws IOException {
        Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/MainScene.fxml")));
        Stage currentStage = (Stage) backButton.getScene().getWindow();
        currentStage.getScene().setRoot(newRoot);
    }

    //megnézzük , hogy mindegyik adat helyes
    private void CredentialChecker()
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Hiba");
        alert.setHeaderText("Az alábbi hibába ütköztél:");
        String alertText = "";
        boolean Stimmel = true;

        // Ellenőrzi hogy egyik mező sem üres.
        if(!checkIfLabelsEmpty()){
            alertText += "Az összes mező kitöltése kötelező!\n";
            Stimmel = false;
        }

        // Ellenőrzi hogy az felhasználónév szabad-e
        if(!checkIfUsernameIsFree(userLabel.getText())){
            alertText += "Ez a felhasználónév már foglalt!\n";
            Stimmel = false;
        }

        // Ellenőrzi hogy az e-mail cím szabad-e
        if(!checkIfEmailIsFree(emailLabel.getText())){
            alertText += "Ez az e-mail cím már foglalt!\n";
            Stimmel = false;
        }

        // Jelszó legalább 3 karakter hosszú
        if(!checkIfPasswordCorrect()){
            alertText += "Jelszó hossz minimum 3 karakter!\n";
            Stimmel = false;
        }

        // Ellenőrzi hogy a két jelszó eggyezik-e
        if(!checkIfPasswordsMatch()){
            alertText += "A jelszavak nem eggyeznek!\n";
            Stimmel = false;
        }




        if(!Stimmel) {
            alert.setContentText(alertText);
            alert.showAndWait();
        }




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

    // True ha az összes mező ki van töltve, más esetben False
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
        return !pwConfirmLabel.getText().isEmpty();
    }

    // True ha a felhasználónév szabad, más esetben False
    private boolean checkIfUsernameIsFree(String name){
        try( CustomerDAO cDao = new JpaCustomerDAO()){
            List<Customer> templi = cDao.getCustomers();
            for(Customer c : templi){
                System.out.println(c.getName());
                System.out.println(name);
                if(Objects.equals(c.getName(), name))
                {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    // True ha az email cím szabad, más esetben False
    private boolean checkIfEmailIsFree(String email){
        try( CustomerDAO cDao = new JpaCustomerDAO()){
            List<Customer> templi = cDao.getCustomers();
            for(Customer c : templi){
                if(Objects.equals(c.getEmail(), email))
                {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private boolean checkIfPasswordsMatch(){
        return pwLabel.getText().equals(pwConfirmLabel.getText());
    }

    private boolean checkIfPasswordCorrect(){
        return pwLabel.getText().length() >= 3;
    }
}
