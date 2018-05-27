package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sample.Main;

import java.io.IOException;

import static sample.Main.borderPane;

public class SidePanelController {

    @FXML
    public HBox homeButton;
    @FXML
    public HBox jobsButton;
    @FXML
    public HBox resumesButton;

    @FXML
    public void homeContent() throws IOException {
            borderPane.setCenter(FXMLLoader.load(Main.class.getResource("views/homeContent.fxml")));
    }
    @FXML
    public void jobsContent() throws IOException {
            borderPane.setCenter(FXMLLoader.load(Main.class.getResource("views/addJob.fxml")));
    }
    @FXML
    public void resumesContent() throws IOException {
            borderPane.setCenter(FXMLLoader.load(Main.class.getResource("views/resumesContent.fxml")));
    }
}
