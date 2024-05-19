package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


public class Fire {
    static double fire_x =0;
    static double fire_y =0;
    public Fire(GridPane backk, AnchorPane back, double transx , double transy, Circle circle){
        circle.setTranslateX(transx+120);
        circle.setTranslateY(transy);
        circle.setRadius(10.0f);
        circle.setFill(Color.GREEN);
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.01), ev -> {
                    circle.setTranslateX(circle.getTranslateX()+1);
                    fire_x = circle.getTranslateX();
                    fire_y = circle.getTranslateY();
                    if(circle.getTranslateX()>=900){
                        Game.record_calculate=Game.record_calculate+50;
                        circle.setTranslateX(-90000);
                        backk.getChildren().remove(circle);
                        back.getChildren().remove(circle);
                    }
                })
        );
        backk.getChildren().add(circle);
        back.getChildren().add(circle);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }


}
