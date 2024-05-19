package sample;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;

public class Regist {
    public Button start;
    public TextField ussername;
    static String username;
    public void start(ActionEvent actionEvent) throws IOException {
        username=ussername.getText();
        Stage primaryStage=(Stage) start.getScene().getWindow();
        Parent root = load(getClass().getResource("game.fxml"));
        primaryStage.setTitle("game");
        primaryStage.setScene(new Scene(root, 941, 773));
        primaryStage.show();
    }
}
