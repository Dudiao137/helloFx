package win.ots.hellefx;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * @author sy.wang
 * @date 2019-12-23
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 20, 10, 20));
        Scene scene = new Scene(gridPane);

        gridPane.add(initPane1(), 0, 0);
        gridPane.add(initPane2(), 1, 0);
        gridPane.add(initPane3(), 2, 0);

        primaryStage.setTitle("MyShapes with java fx");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private StackPane initPane3() {
        StackPane stackPane = new StackPane();

        Button btn = new Button("Hello");

        btn.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Heeeeeeeello");
            alert.showAndWait();
        });

        stackPane.getChildren().add(btn);

        return stackPane;
    }


    public static void main(String[] args) {
        launch(args);
    }




    private Pane initPane1() {
        Pane pane1 = new Pane();
        pane1.setPrefSize(200.0, 200.0);

        Circle circle = new Circle();
        circle.centerXProperty().bind(pane1.widthProperty().divide(2));
        circle.centerYProperty().bind(pane1.heightProperty().divide(2));
        circle.radiusProperty().bind(pane1.widthProperty().divide(4));
        circle.setStroke(Color.BLUEVIOLET);
        circle.setFill(Color.CYAN);

        pane1.getChildren().addAll(circle);

        return pane1;
    }

    private GridPane initPane2() {

        GridPane pane2 = new GridPane();
        pane2.setPrefSize(300.0, 200.0);
        pane2.setPadding(new Insets(10,10,10,10));
        pane2.setHgap(5);
        pane2.setVgap(5);
        Label num1Label = new Label("数字1");
        Label operationLabel = new Label("+");
        Label num2Label = new Label("数字2");
        Label resultLabel = new Label("=");
        TextField num1Text = new TextField();
        TextField num2Text = new TextField();
        TextField resultText1 = new TextField();
        TextField resultText2 = new TextField();
        TextField resultText3 = new TextField();
        num1Label.setLabelFor(num1Text);
        num2Label.setLabelFor(num2Text);
        num1Text.setPrefWidth(50.);
        num2Text.setPrefWidth(50.);
        resultText1.setPrefWidth(50.);
        resultText2.setPrefWidth(50.);
        resultText3.setPrefWidth(50.);

        IntegerProperty num1 = new SimpleIntegerProperty();
        IntegerProperty num2 = new SimpleIntegerProperty();
        // 001 fluent api
        NumberBinding result1 = num1.add(num2);
        // 002 bindings
        NumberBinding result2 = Bindings.add(num1, num2);
        // 003 low level
        NumberBinding result3 = new IntegerBinding() {
            {
                super.bind(num1Text.textProperty(), num2Text.textProperty());
            }

            @Override
            protected int computeValue() {
                String num1str = num1Text.textProperty().get();
                String num2str = num2Text.textProperty().get();

                num1str = num1str.equals("") ? "0" : num1str;
                num2str = num2str.equals("") ? "0" : num2str;

                return Integer.valueOf(num1str) + Integer.valueOf(num2str);
            }
        };

        num1Text.textProperty().addListener((observableValue, oldValue, newValue) -> {
            num1.setValue(Integer.valueOf(newValue));
        });

        num2Text.textProperty().addListener((observableValue, oldValue, newValue) -> {
            num2.setValue(Integer.valueOf(newValue));
        });

        result1.addListener((observableValue, oldValue, newValue) -> {
            resultText1.setText(newValue.toString());
        });

        result2.addListener((observableValue, oldValue, newValue) -> {
            resultText2.setText(newValue.toString());
        });

        result3.addListener((observableValue, oldValue, newValue) -> {
            resultText3.setText(newValue.toString());
        });

        pane2.add(num1Label, 0, 0);
        pane2.add(num1Text, 1, 0);
        pane2.add(operationLabel, 0, 1);
        pane2.add(num2Label, 0, 2);
        pane2.add(num2Text, 1, 2);
        pane2.add(resultLabel, 0, 3);
        pane2.add(resultText1, 1, 4);
        pane2.add(resultText2, 1, 5);
        pane2.add(resultText3, 1, 6);

        return pane2;
    }
}
