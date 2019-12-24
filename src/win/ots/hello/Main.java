package win.ots.hello;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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

//        ellipse.setFill(Color.LIGHTBLUE);
        ellipse.setFill(gradient);
        ellipse.setEffect(new DropShadow(30, 10, 10, Color.GRAY));

        Text text = new Text("My Shapes");
        text.setFont(new Font("Arial Bold", 24));
        Reflection r = new Reflection();
        r.setFraction(.8);
        r.setTopOpacity(1.0);
        text.setEffect(r);

        StackPane root = new StackPane();
        root.getChildren().addAll(ellipse, text);

//        Group root = new Group(ellipse, text);
//        ellipse.setCenterX(350/2);
//        ellipse.setCenterY(230/2);
//
//        text.setX(350/2-text.getLayoutBounds().getWidth()/2);
//        text.setY(230/2+text.getLayoutBounds().getHeight()/2);

//        BorderPane root = new BorderPane();
//        Label colorLabel = new Label("Color: Light blue");
//        colorLabel.setFont(new Font("Verdana", 18));
//        root.setTop(colorLabel);
//        Rectangle rectangle = new Rectangle(100, 50, Color.LIGHTBLUE);
//        root.setCenter(rectangle);
//        BorderPane.setAlignment(colorLabel, Pos.CENTER);
//        BorderPane.setMargin(colorLabel, new Insets(20, 10, 5, 10));


        Scene scene = new Scene(root, 350, 230, Color.LIGHTYELLOW);

        primaryStage.setTitle("MyShapes with java fx");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
