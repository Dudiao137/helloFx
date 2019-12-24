package win.ots.hello;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.beans.binding.When;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author sy.wang
 * @date 2019-12-23
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Ellipse ellipse = new Ellipse(110, 70);

        Stop[] stops = new Stop[] {new Stop(0, Color.DODGERBLUE),
                new Stop(0.5, Color.LIGHTBLUE),
                new Stop(1.0, Color.LIGHTGREEN)};
        LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true,
                CycleMethod.NO_CYCLE, stops);
        ellipse.setFill(gradient);
        ellipse.setEffect(new DropShadow(30, 10, 10, Color.GRAY));

        Text text = new Text("My Shapes");
        text.setFont(new Font("Arial Bold", 24));
        Reflection r = new Reflection();
        r.setFraction(.8);
        r.setTopOpacity(1.0);
        text.setEffect(r);

        StackPane stackPane = new StackPane();
        stackPane.setPrefSize(350, 230);
        stackPane.getChildren().addAll(ellipse, text);

        RotateTransition rotate = new RotateTransition(Duration.millis(2500), stackPane);
        rotate.setToAngle(360);
        rotate.setFromAngle(0);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setCycleCount(Integer.MAX_VALUE);

        stackPane.setOnMouseClicked( mouseEvent -> {
            String msg = String.format("clicked at point (%.1f,%.1f), in scene (%.1f,%.1f), in window (%.1f,%.1f)",
                    mouseEvent.getX(), mouseEvent.getY(), mouseEvent.getSceneX(), mouseEvent.getSceneY(),
                    mouseEvent.getScreenX(), mouseEvent.getScreenY());

            System.out.println(msg);

            if (rotate.getStatus().equals(Animation.Status.RUNNING)) {
                rotate.pause();
            } else {
                rotate.play();
            }
        });


        Text statusText = new Text("Test");
        statusText.setFont(new Font("Arial Bold", 20));

        statusText.textProperty().bind(stackPane.rotateProperty().asString("Rotate : %.1f"));
        statusText.strokeProperty().bind(
                new When(rotate.statusProperty().isEqualTo(Animation.Status.RUNNING))
                        .then(Color.GREEN)
                        .otherwise(Color.RED)
        );


        VBox box = new VBox(stackPane, statusText);
        box.setAlignment(Pos.CENTER);

        Scene scene = new Scene(box, 500, 300, Color.LIGHTYELLOW);

        primaryStage.setTitle("MyShapes with java fx");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
