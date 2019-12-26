package win.ots.hellefx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import win.ots.hellefx.model.Person;

/**
 * @author sy.wang
 * @date 2019-12-23
 */
public class Main extends Application {

    ObservableList<Person> peoples = FXCollections.emptyObservableList();


    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Address.fxml"));


        primaryStage.setTitle("Address");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
