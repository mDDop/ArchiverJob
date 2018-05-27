package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.models.JobDTO;
import sample.persistanceData.DatabaseHandler;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    private ObservableList<JobDTO> listJobDTOs = FXCollections.observableArrayList();
    ResultSet resultsSelect;

    DatabaseHandler databaseHandler;

    @FXML
    TableView<JobDTO> tableView = new TableView<>();
    TableColumn<JobDTO, String> nameCol = new TableColumn<>("Name");
    TableColumn<JobDTO, String> positionCol = new TableColumn<>("Position");
    TableColumn<JobDTO, String> addressCol = new TableColumn<>("Address");
    TableColumn<JobDTO, String> emailCol = new TableColumn<>("Email");
    TableColumn<JobDTO, String> phoneCol = new TableColumn<>("Phone");
    TableColumn<JobDTO, String> linkCol = new TableColumn<>("Link");
    TableColumn<JobDTO, LocalDate> dateCol = new TableColumn<>("Date");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        databaseHandler = new DatabaseHandler();
        resultsSelect = databaseHandler.execQuery("SELECT * FROM JOB");
        try {
            while (resultsSelect.next()) {
                JobDTO jobDTO = new JobDTO(
                        resultsSelect.getString("name_company"),
                        resultsSelect.getString("position_job"),
                        resultsSelect.getString("email"),
                        resultsSelect.getString("address_job"),
                        resultsSelect.getString("phone"),
                        LocalDate.parse(resultsSelect.getString("date_sent")),
                        resultsSelect.getString("link"));
                listJobDTOs.add(jobDTO);
                tableView.setItems(listJobDTOs);

                nameCol.setCellValueFactory(new PropertyValueFactory("nameCompany"));
                positionCol.setCellValueFactory(new PropertyValueFactory("positionJob"));
                addressCol.setCellValueFactory(new PropertyValueFactory("address"));
                phoneCol.setCellValueFactory(new PropertyValueFactory("phone"));
                emailCol.setCellValueFactory(new PropertyValueFactory("email"));
                dateCol.setCellValueFactory(new PropertyValueFactory("date"));
                linkCol.setCellValueFactory(new PropertyValueFactory("link"));

                tableView.getColumns().setAll(nameCol, positionCol, addressCol, phoneCol, emailCol, dateCol, linkCol);
            }
        } catch (SQLException e){
            System.out.println("Exception" + e.getErrorCode() + " message " + e.getMessage());
        }
    }
}
