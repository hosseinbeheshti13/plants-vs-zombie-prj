package sample;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static java.lang.Thread.sleep;

public class Loading implements Initializable {

    public ImageView tractor;
    public AnchorPane background;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new Thread(() -> {
            try {
                while (true) {
                    if (tractor.getX() != 284) {
                        tractor.setX(tractor.getX() + 4);
                        try {
                            sleep(40);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        break;
                    }

                }
                if (tractor.getX() == 284) {
                    Platform.runLater(() -> {
                        Button button = new Button("NEXT");
                        button.setStyle("-fx-background-color: #000000; ");
                        button.setTranslateX(340);
                        button.setTranslateY(350);
                        background.getChildren().add(button);
                        button.setOnAction(new EventHandler() {

                            @Override
                            public void handle(Event event) {
                                Stage primaryStage=(Stage) background.getScene().getWindow();
                                Parent root = null;
                                try {
                                    root = FXMLLoader.load(getClass().getResource("start.fxml"));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                primaryStage.setTitle("start");
                                primaryStage.setScene(new Scene(root, 744, 411));
                                primaryStage.show();
                            }
                        });
                    });

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}

