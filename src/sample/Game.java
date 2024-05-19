package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.fxml.FXMLLoader.load;


public class Game implements Initializable {
    public AnchorPane back;
    public Button click;
    public ImageView plant;
    public GridPane backk;
    public Label money_calculate;
    static double plant_x = 0;
    static double plant_y = 0;
    static double bomb_x = 0;
    static double bomb_y = 0;
    static int money = 100;
    static int record_calculate;
    public ImageView bomb;
    public Label record_write;
    Image image = new Image("sample/Peashooter_transparent_gif.gif");
    Image bomb_image = new Image("sample/pngwing.com (1).png");
    ImageView imageView3 = new ImageView();
    ImageView bombb = new ImageView();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        money_calculate.setText(String.valueOf(money));
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(8), ev -> {
                    Image image = new Image("sample/plants-vs-zombies-gif-11.gif");
                    ImageView imageView = new ImageView(image);
                    Zombie zombie = new Zombie(backk, back, imageView);
                    money_calculate.setText(String.valueOf(money));
                    record_write.setText(String.valueOf(record_calculate));
                    if (Zombie.finish > 0) {
                        Stage primaryStage = (Stage) click.getScene().getWindow();
                        Parent root = null;
                        try {
                            root = load(getClass().getResource("losing.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        primaryStage.setTitle("lose");
                        primaryStage.setScene(new Scene(root, 863, 548));
                        primaryStage.show();
                    }
                })
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void click(ActionEvent actionEvent) {
        Stage stage = (Stage) click.getScene().getWindow();
        stage.close();
    }

    public void drag(MouseEvent mouseEvent) {
        imageView3.setTranslateX(mouseEvent.getX() + 65);
        imageView3.setTranslateY(mouseEvent.getY() - 200);
        imageView3.setFitHeight(110);
        imageView3.setFitWidth(120);
        back.getChildren().add(imageView3);
        backk.getChildren().add(imageView3);
    }

    public void release(MouseEvent mouseEvent) {
        if (money > 49) {
            money = money - 50;
            ImageView imageView2 = new ImageView(image);
            imageView2.setFitHeight(110);
            imageView2.setFitWidth(120);
            imageView2.setTranslateX(imageView3.getTranslateX());
            imageView2.setTranslateY(imageView3.getTranslateY());
            plant_x = imageView2.getTranslateX();
            plant_y = imageView2.getTranslateY();
            backk.getChildren().add(imageView2);
            Timeline timeline2 = new Timeline(
                    new KeyFrame(Duration.seconds(8), ev -> {
                        Circle circle = new Circle();
                        Fire fire = new Fire(backk, back, mouseEvent.getX(), mouseEvent.getY(), circle);
                        Timeline timeline = new Timeline(
                                new KeyFrame(Duration.seconds(0.01), ev2 -> {
                                    Collision c = new Collision();
                                    c.stop_zombie();
                                    if (c.stop_zombie() == 1) {
                                        Game.record_calculate=Game.record_calculate+50;
                                        System.out.println("decrease");
                                    } else if (c.stop_zombie() == 2) {
                                        System.out.println("decrease");
                                        Game.record_calculate=Game.record_calculate+50;
                                    } else if (c.stop_zombie() == 3) {
                                        System.out.println("decrease");
                                        Game.record_calculate=Game.record_calculate+50;
                                    } else if (c.stop_zombie() == 4) {
                                        System.out.println("decrease");
                                        Game.record_calculate=Game.record_calculate+50;
                                    }
                                })
                        );
                        timeline.setCycleCount(Animation.INDEFINITE);
                        timeline.play();
                    })
            );
            timeline2.setCycleCount(Animation.INDEFINITE);
            timeline2.play();


        } else {
            System.out.println("not enough");
            backk.getChildren().remove(imageView3);
        }
    }


    public void presss(MouseEvent mouseEvent) {
        if (money > 49) {
            imageView3.setImage(image);
            imageView3.setTranslateX(plant.getX());
            imageView3.setTranslateY(plant.getY());
            imageView3.setFitHeight(110);
            imageView3.setFitWidth(120);
            imageView3.setTranslateX(mouseEvent.getX() + 65);
            imageView3.setTranslateY(mouseEvent.getY() - 200);
            back.getChildren().add(imageView3);
            backk.getChildren().add(imageView3);
        } else {
            System.out.println("not enough");
        }

    }

    public void bomb_drag(MouseEvent mouseEvent) {
        bombb.setTranslateX(mouseEvent.getX() + 200);
        bombb.setTranslateY(mouseEvent.getY() - 200);
        bombb.setFitHeight(80);
        bombb.setFitWidth(90);
        back.getChildren().add(bombb);
        backk.getChildren().add(bombb);
    }

    public void bomb_press(MouseEvent mouseEvent) {
        if (money > 49) {

            bombb.setImage(bomb_image);
            bombb.setTranslateX(bomb.getX());
            bombb.setTranslateY(bomb.getY());
            bombb.setFitHeight(80);
            bombb.setFitWidth(90);
            bombb.setTranslateX(mouseEvent.getX() + 200);
            bombb.setTranslateY(mouseEvent.getY() - 200);
            back.getChildren().add(bombb);
            backk.getChildren().add(bombb);
        } else {
            System.out.println("not enough");
        }
    }

    public void bomb_release(MouseEvent mouseEvent) {
        if (money > 49) {
            money = money - 50;
            ImageView bomb2 = new ImageView(bomb_image);
            bomb2.setFitHeight(80);
            bomb2.setFitWidth(90);
            bomb2.setTranslateX(bombb.getTranslateX());
            bomb2.setTranslateY(bombb.getTranslateY());
            bomb_x = bomb2.getTranslateX();
            bomb_y = bomb2.getTranslateY();
            backk.getChildren().add(bomb2);
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(0.01), ev2 -> {
            Collision d = new Collision();
            d.bomb_collision();
            if (d.bomb_collision() == 1) {
                backk.getChildren().remove(bomb2);
                bomb2.setX(9000);
            } else if (d.bomb_collision() == 2) {
                backk.getChildren().remove(bomb2);
                bomb2.setX(9000);
            } else if (d.bomb_collision() == 3) {
                backk.getChildren().remove(bomb2);
                bomb2.setX(9000);
            } else if (d.bomb_collision() == 4) {
                backk.getChildren().remove(bomb2);
                bomb2.setX(9000);
                        }
                    })
            );
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();

            } else {
                System.out.println("not enough");
                backk.getChildren().remove(bombb);
            }
        }
    }

