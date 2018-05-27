package sample.models;

import javafx.scene.control.Hyperlink;
import lombok.Data;
import java.sql.Date;
import java.time.LocalDate;

@Data
public class Job {

    private int id;
    private String nameCompany;
    private String positionJob;
    private String address;
    private String email;
    private String phone;
    private LocalDate date;
    private String link;

}
