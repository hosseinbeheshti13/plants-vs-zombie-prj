package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import java.util.ArrayList;

public class Zombie {
    static double zombie_x=0;
    static double zombie_y=0;
    static int finish =0;
    public Zombie(GridPane backk, AnchorPane back, ImageView imageView){
        ArrayList<String> my_list = new ArrayList<String>();
        my_list.add("162");
        my_list.add("324");
        my_list.add("486");
        my_list.add("648");
        imageView.setX(900);
        imageView.setFitHeight(100);
        int index = (int)(Math.random() * my_list.size());
        imageView.setY(Double.parseDouble(my_list.get(index)));
        imageView.setFitWidth(110);
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.01), ev -> {
                    imageView.setX(imageView.getX()- 0.2);
                     zombie_x = imageView.getX();
                     zombie_y = imageView.getY();
                    if(imageView.getX()<=0){
                        backk.getChildren().remove(imageView);
                        back.getChildren().remove(imageView);
                        finish++;
                    }
                    Collision c = new Collision();
                    c.collision();
                    if (c.collision()==1){
                        imageView.setX(10000);
                        backk.getChildren().remove(imageView);
                        back.getChildren().remove(imageView);
                        Game.money =Game.money +50;
                        Game.record_calculate=Game.record_calculate+50;
                    }else if (c.collision()==2){
                        imageView.setX(10000);
                        backk.getChildren().remove(imageView);
                        back.getChildren().remove(imageView);
                        Game.money =Game.money +50;
                        Game.record_calculate=Game.record_calculate+50;
                    }else  if (c.collision()==3){
                        imageView.setX(10000);
                        backk.getChildren().remove(imageView);
                        back.getChildren().remove(imageView);
                        Game.money =Game.money +50;
                        Game.record_calculate=Game.record_calculate+50;
                    }else  if (c.collision()==4){
                        imageView.setX(10000);
                        backk.getChildren().remove(imageView);
                        back.getChildren().remove(imageView);
                        Game.money =Game.money +50;
                        Game.record_calculate=Game.record_calculate+50;
                    }
                    Collision d = new Collision();
                    d.bomb_collision();
                    if (d.bomb_collision() == 1) {
                        imageView.setX(10000);
                        backk.getChildren().remove(imageView);
                        back.getChildren().remove(imageView);
                        Game.money =Game.money +50;
                        Game.record_calculate=Game.record_calculate+50;
                    } else if (d.bomb_collision() == 2) {
                        imageView.setX(10000);
                        backk.getChildren().remove(imageView);
                        back.getChildren().remove(imageView);
                        Game.money =Game.money +50;
                        Game.record_calculate=Game.record_calculate+50;
                    } else if (d.bomb_collision() == 3) {
                        imageView.setX(10000);
                        backk.getChildren().remove(imageView);
                        back.getChildren().remove(imageView);
                        Game.money =Game.money +50;
                        Game.record_calculate=Game.record_calculate+50;
                    } else if (d.bomb_collision() == 4) {
                        imageView.setX(10000);
                        backk.getChildren().remove(imageView);
                        back.getChildren().remove(imageView);
                        Game.money =Game.money +50;
                        Game.record_calculate=Game.record_calculate+50;
                    }
                    })
        );
        backk.getChildren().add(imageView);
        back.getChildren().add(imageView);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }


}
