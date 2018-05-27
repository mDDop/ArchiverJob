package sample.models;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Hyperlink;
import javafx.application.HostServices;
import lombok.Data;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;

@Data
public class JobDTO {

    private int id;
    private String nameCompany;
    private String positionJob;
    private String address;
    private String email;
    private String phone;
    private LocalDate date;
    private Hyperlink link;
    private HostServices hostServices;

    public JobDTO(String nameCompany, String positionJob, String address, String email,
                  String phone, LocalDate date, String linkString){
        this.nameCompany = nameCompany;
        this.positionJob = positionJob;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.date = date;
        link = new Hyperlink();
        link.setText(linkString);
        link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (link.getText().startsWith("http://") || link.getText().startsWith("https://")) {
                        Desktop.getDesktop().browse(URI.create(link.getText()));
                        System.out.println("Link clicked " + link.getText());
                    } else {
                        Desktop.getDesktop().browse(URI.create("http://" + link.getText()));
                        System.out.println("Link clicked http://" + link.getText());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
