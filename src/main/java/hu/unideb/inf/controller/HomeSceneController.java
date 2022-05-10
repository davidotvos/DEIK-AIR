package hu.unideb.inf.controller;

import hu.unideb.inf.MainApp;
import hu.unideb.inf.model.JpaCustomerDAO;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;


public class HomeSceneController implements Initializable {

    @FXML
    private Button MyAccount;

    @FXML
    private Button HomeLogoutButton;

    @FXML
    private Button aboutButton;

    @FXML
    private ImageView imageView;

    @FXML
    private Button helpButton;

    @FXML
    private Button searchButton;

    @FXML
    void handleHomeLogoutButtonPushed(ActionEvent event) throws IOException {
        MainApp.LoggedInCustomer = null;
        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("Logout");
        successAlert.setContentText("Sikeresen kijelentkeztél!");
        successAlert.showAndWait();
        Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/MainScene.fxml")));
        Stage currentStage = (Stage) HomeLogoutButton.getScene().getWindow();
        currentStage.getScene().setRoot(newRoot);

    }

    @FXML
    void toAbout(ActionEvent event) {

    }

    @FXML
    void toHelp(ActionEvent event) {

    }

    @FXML
    void toCustomerScene(ActionEvent event) throws IOException {
        Parent newRoot = FXMLLoader.load(getClass().getResource("/FXML/CustomerInfoScene.fxml"));
        Stage currentStage = (Stage) MyAccount.getScene().getWindow();
        currentStage.getScene().setRoot(newRoot);
    }

    @FXML
    void toSearch(ActionEvent event) throws IOException {
        Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/SearchScene.fxml")));
        Stage currentStage = (Stage) searchButton.getScene().getWindow();
        currentStage.setMinHeight(600);
        currentStage.setMinWidth(900);
        currentStage.setHeight(750);
        currentStage.setWidth(1100);
        currentStage.setTitle("Search Page");
        currentStage.setX(0);
        currentStage.setY(0);
        currentStage.getScene().setRoot(newRoot);
    }

    int count;

    public void slideshow(){

//        SequentialTransition slideshow = new SequentialTransition();
//
//        images[0] = new ImageView(new Image(("img/homepagepic1.jpg")));
//        images[1] = new ImageView(new Image("img/homepagepic3.jpg"));
//        images[2] = new ImageView(new Image("img/homepagepic4.jpg"));
//        images[3] = new ImageView(new Image("img/homepagepic5.jpg"));
//
//        for(ImageView image : images){
//            SequentialTransition sequentialTransition = new SequentialTransition();
//
//            FadeTransition fadeIn = getFadeTransition(image, 0.0, 1.0, 2000);
//            PauseTransition stayOn = new PauseTransition(Duration.millis(2000));
//            FadeTransition fadeOut = getFadeTransition(image, 1.0, 0.0, 2000);
//
//            sequentialTransition.getChildren().addAll(fadeIn, stayOn, fadeOut);
//            image.setOpacity(0);
//            this.root.getChildren().add(image);
//            slideshow.getChildren().add(sequentialTransition);
//        }


        ArrayList<Image> images = new ArrayList<>();
        images.add(new Image("img/homepagepic1.jpg"));
        //images.add(new Image("img/homepagepic2.jpg"));
        images.add(new Image("img/homepagepic3.jpg"));
        images.add(new Image("img/homepagepic4.jpg"));
        images.add(new Image("img/homepagepic5.jpg"));

        imageView.setImage(images.get(0));
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(4), event -> {
            imageView.setImage(images.get(count));
            count++;
            if(count == 4){
                count = 0;
            }
        }));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        }

        @Override
        public void initialize(URL location, ResourceBundle resources){
            slideshow();
        }
    }


