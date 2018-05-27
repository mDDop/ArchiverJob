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
    public ListView<String> listView;



    ObservableList<String> names = FXCollections.observableArrayList(
            "Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise");




    @Override
    public void initialize(URL location, ResourceBundle resources) {
       // listView.setItems(names);
    }
}
