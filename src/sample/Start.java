package sample;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;

public class Start {


    public Button playing;
    public Button Quit;

    public void play(ActionEvent actionEvent) throws IOException {
        Stage primaryStage=(Stage) playing.getScene().getWindow();
        Parent root = load(getClass().getResource("regist.fxml"));
        primaryStage.setTitle("REGIST");
        primaryStage.setScene(new Scene(root, 610, 369));
        primaryStage.show();
    }

    public void quit(ActionEvent actionEvent) {
        Stage stage = (Stage) Quit.getScene().getWindow();
        stage.close();
    }
}
