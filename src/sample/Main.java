package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private double xOffset = 0;
    private double yOffset = 0;

    public static BorderPane borderPane;

    @Override
    public void start(Stage primaryStage) throws Exception{
                borderPane = new BorderPane();
        borderPane.setLeft(FXMLLoader.load(Main.class.getResource("views/sidePanel.fxml")));
        borderPane.setCenter(FXMLLoader.load(Main.class.getResource("views/mainContent.fxml")));
        borderPane.setTop(FXMLLoader.load(Main.class.getResource("views/topMenu.fxml")));

        Parent root = FXMLLoader.load(Main.class.getResource("views/sidePanel.fxml"));

        primaryStage.setTitle("JobArchiver");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(borderPane, 900, 500));
        primaryStage.show();

        borderPane.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        borderPane.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
