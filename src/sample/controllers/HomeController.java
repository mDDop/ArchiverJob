package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    private ObservableList<Hyperlink> listHyperlinks = FXCollections.observableArrayList();






    @FXML
    ListView listView = new ListView(listHyperlinks);


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Hyperlink link = new Hyperlink();
        link.setText("http://example.com1");
        link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("This link is clicked");
            }
        });
        listHyperlinks.add(link);
        Hyperlink link2 = new Hyperlink();
        link2.setText("http://example.com2");
        link2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("This link is clicked");
            }
        });

        listHyperlinks.add(link2);

        Hyperlink link3 = new Hyperlink();
        link3.setText("http://example.com3");
        link3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("This link is clicked");
            }
        });

        listHyperlinks.add(link3);

        listView.setItems(listHyperlinks);
        System.out.println(listView.getItems().toString());
        System.out.println(listHyperlinks.toString());
    }
}
