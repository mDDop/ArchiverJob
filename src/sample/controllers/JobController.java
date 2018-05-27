package sample.controllers;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import sample.Main;
import sample.persistanceData.DatabaseHandler;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class JobController implements Initializable {

    DatabaseHandler databaseHandlerd;

    @FXML
    JFXTextField nameCompany;
    @FXML
    JFXTextField positionJob;
    @FXML
    JFXTextField address;
    @FXML
    JFXTextField email;
    @FXML
    JFXTextField phone;
    @FXML
    JFXTextField link;
    @FXML
    JFXDatePicker date;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        databaseHandlerd = new DatabaseHandler();
    }

    public boolean addJob(ActionEvent actionEvent) throws IOException {

        String nameJ = nameCompany.getText();
        String positionJ = positionJob.getText();
        String addresJ = address.getText();
        String emailJ = email.getText();
        String phoneJ = phone.getText();
        LocalDate dateJ = date.getValue();
        String linkJ = link.getText();

        if(nameJ.isEmpty() || addresJ.isEmpty() || emailJ.isEmpty() || phoneJ.isEmpty() || positionJ.isEmpty() || linkJ.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("None field cannot be empty.");
            alert.showAndWait();
        }

        String insertQuery = "INSERT INTO JOB (name_company, position_job, address_job, email, phone, date_sent, link) VALUES ("+
                "'" + nameJ + "', " +
                "'" + positionJ + "', " +
                "'" + addresJ + "', " +
                "'" + emailJ + "', " +
                "'" + phoneJ + "', " +
                "'" + dateJ + "', " +
                "'" + linkJ + "')";
        databaseHandlerd.setAction(insertQuery);
        Main.borderPane.setCenter(FXMLLoader.load(Main.class.getResource("views/homeContent.fxml")));
        return true;

    }

    public void returnToHome(ActionEvent actionEvent) throws IOException {
        String dropTable = "DROP TABLE JOB";
        databaseHandlerd.setAction(dropTable);
        Main.borderPane.setCenter(FXMLLoader.load(Main.class.getResource("views/homeContent.fxml")));
    }
}
