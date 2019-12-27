package win.ots.hellefx;

import com.jfoenix.controls.*;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author sy.wang
 * @date 2019-12-23
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Application.setUserAgentStylesheet(getClass().getResource("/css/main.css").toExternalForm());

        SplitPane splitPane = new SplitPane();
        splitPane.setPrefWidth(1000);

        VBox leftBox = new VBox(10.);
        leftBox.setAlignment(Pos.CENTER);
        initPane(leftBox);

        VBox rightBox = new VBox(10.);
        rightBox.setAlignment(Pos.CENTER);
        initAdvPane(rightBox);

        splitPane.getItems().addAll(leftBox, rightBox);

        primaryStage.setTitle("Address");
        primaryStage.setScene(new Scene(splitPane));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void initPane(Pane pane) {
        pane.setPrefWidth(500);
        pane.setPrefHeight(1000);
        // rippler
        Label label = new Label("Test");
        label.setStyle("-fx-background-color: white;-fx-padding: 20");
        JFXRippler rippler = new JFXRippler(label);
        pane.getChildren().add(rippler);

        // button
        JFXButton jfxButton = new JFXButton("Button");
        JFXButton jfxButtonWithCss = new JFXButton("Button With css");
        jfxButtonWithCss.getStyleClass().add("button-raised");
        pane.getChildren().addAll(jfxButton, jfxButtonWithCss);

        // check box
        JFXCheckBox checkBox = new JFXCheckBox("Checkbox");
        checkBox.getStyleClass().add("custom-jfx-check-box");
        pane.getChildren().add(checkBox);

        // combo box
        JFXComboBox<Label> jfxComboBox = new JFXComboBox<>();
        jfxComboBox.getItems().add(new Label("Java 1.8"));
        jfxComboBox.getItems().add(new Label("Java 1.7"));
        jfxComboBox.getItems().add(new Label("Java 1.6"));
        jfxComboBox.getItems().add(new Label("Java 11"));
        jfxComboBox.setPromptText("Select the java version");
        pane.getChildren().add(jfxComboBox);

        // hamburger
        JFXHamburger h1 = new JFXHamburger();
        HamburgerSlideCloseTransition burgerTrans = new HamburgerSlideCloseTransition(h1);
        burgerTrans.setRate(-1);
        h1.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            burgerTrans.setRate(burgerTrans.getRate() * -1);
            burgerTrans.play();
        });
        pane.getChildren().add(h1);

        // input field
        JFXTextField field = new JFXTextField();
        field.setLabelFloat(true);
        field.setPromptText("Floating prompt");
        JFXTextField validationField = new JFXTextField();
        RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setMessage("Input required");
        validationField.getValidators().add(validator);
        validationField.focusedProperty().addListener((o, oldValue, newValue) -> {
            if (!newValue) {
                validationField.validate();
            }
        });
        pane.getChildren().addAll(field, validationField);

        // progress bar
        JFXProgressBar jfxBar = new JFXProgressBar();
        jfxBar.setPrefWidth(100);
        JFXProgressBar jfxBarInf = new JFXProgressBar();
        jfxBarInf.setPrefWidth(500);
        jfxBarInf.setProgress(-1.0f);
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(jfxBar.progressProperty(), 0),
                        new KeyValue(jfxBar.progressProperty(), 0)),
                new KeyFrame(Duration.seconds(2), new KeyValue(jfxBar.progressProperty(), 1),
                        new KeyValue(jfxBar.progressProperty(), 1))
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        pane.getChildren().addAll(jfxBar, jfxBarInf);

        // radio button
        HBox radioBox = new HBox(30);
        radioBox.setAlignment(Pos.CENTER);
        final ToggleGroup group = new ToggleGroup();
        JFXRadioButton javaRadio = new JFXRadioButton("JavaFx");
        javaRadio.setPadding(new Insets(10));
        javaRadio.setToggleGroup(group);
        JFXRadioButton jfxRadio = new JFXRadioButton("JFoenix");
        jfxRadio.setPadding(new Insets(10));
        jfxRadio.setToggleGroup(group);
        radioBox.getChildren().addAll(javaRadio, jfxRadio);
        radioBox.setSpacing(10.);
        pane.getChildren().add(radioBox);

        // slider
        JFXSlider hor_left = new JFXSlider();
        JFXSlider hor_right = new JFXSlider();
        JFXSlider ver_left = new JFXSlider();
        JFXSlider ver_right = new JFXSlider();
        hor_left.setMinWidth(100);
        hor_right.setMinWidth(100);
        hor_right.setIndicatorPosition(JFXSlider.IndicatorPosition.RIGHT);
        ver_left.setMinWidth(100);
        ver_left.setOrientation(Orientation.VERTICAL);
        ver_right.setMinWidth(100);
        ver_right.setIndicatorPosition(JFXSlider.IndicatorPosition.RIGHT);
        ver_right.setOrientation(Orientation.VERTICAL);
        HBox sliderBox = new HBox(10);
        VBox sliderInBox = new VBox(50);
        sliderBox.setAlignment(Pos.CENTER);
        sliderInBox.setAlignment(Pos.CENTER);
        sliderInBox.getChildren().addAll(hor_left, hor_right);
        sliderBox.getChildren().addAll(ver_left, sliderInBox, ver_right);
        pane.getChildren().add(sliderBox);

        // spinner
        JFXSpinner spinner = new JFXSpinner();
        pane.getChildren().add(spinner);

        // tab
        JFXTabPane tabPane = new JFXTabPane();
        tabPane.setPrefSize(300, 200);
        Tab tab = new Tab();
        tab.setText("Tab 1");
        tab.setContent(new Label("Content1"));
        Tab tab2 = new Tab();
        tab2.setText("Tab 2");
        tab2.setContent(new Label("Content2"));
        tabPane.getTabs().addAll(tab, tab2);
        pane.getChildren().add(tabPane);

        // toggle button
        JFXToggleButton toggleButton = new JFXToggleButton();
        toggleButton.setText("001");
        JFXToggleButton toggleButton2 = new JFXToggleButton();
        toggleButton2.setText("002");
        pane.getChildren().addAll(toggleButton, toggleButton2);

    }

    private void initAdvPane(Pane pane) {
        pane.setPrefWidth(500);
        pane.setPrefHeight(1000);

        // list view
        JFXListView<Label> list = new JFXListView<>();
        for (int i = 0; i < 4; i++) {
            list.getItems().addAll(new Label("Item " + i));
        }
        list.getStyleClass().add("my-list-view");
        pane.getChildren().add(list);

        // tree table

        // picker

        // dialog
        JFXDialog dialog = new JFXDialog();
        dialog.setContent(new Label("Content"));
        StackPane stackPane = new StackPane();
        JFXButton button = new JFXButton("Click");
        button.setOnAction(event -> dialog.show(stackPane));
        pane.getChildren().addAll(button);



    }
}
