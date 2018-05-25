package sample.controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable{
    public Controller() {
    }

    @FXML
    public Button closeButton;

    @FXML
    public VBox contentArea;

    @FXML
    public HBox homeButton;

    @FXML
    public Button maximizeButton;

    @FXML
    public Button minimizeButton;

    @FXML
    public void close() {
        Platform.exit();
    }

    @FXML
    public void minimize() {
        Stage stage = (Stage) minimizeButton.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    public ListView<String> listView;


    @FXML
    public void maximize() {
        Stage stage = (Stage) maximizeButton.getScene().getWindow();
        if (stage.isMaximized()) {
            stage.setMaximized(false);
        } else {
            stage.setMaximized(true);
        }
    }


    ObservableList<String> names = FXCollections.observableArrayList(
            "Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise");


    @FXML
    public void homeContent() {


        try {
            contentArea.getChildren().add(FXMLLoader.load(Controller.class.getResource("views/contentHome.fxml")));


            System.out.println(listView);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       // listView.setItems(names);
    }
}
