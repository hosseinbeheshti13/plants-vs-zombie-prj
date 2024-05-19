package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class Losing implements Initializable {
    public Label record;
    public void initialize(URL location, ResourceBundle resources) {
        record.setText(String.valueOf(Game.record_calculate));
        try {
            String filePath = "record.txt";
            BufferedWriter write = new BufferedWriter(new FileWriter(filePath, true));
            write.write("\nusername:" + Regist.username  );
            write.write("\nrecord:" + Game.record_calculate);
            write.close();
        } catch (IOException e) {
            System.out.println("an error");
            e.printStackTrace();
        }

    }
}
