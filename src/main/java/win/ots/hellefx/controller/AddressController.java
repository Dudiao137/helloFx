package win.ots.hellefx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import win.ots.hellefx.model.Person;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * @author : sy.wang
 * @date : 2019-12-26
 */
public class AddressController implements Initializable {

    @FXML
    private TableView<Person> tableView;
    @FXML
    private TextField name;
    @FXML
    private TextField phone;
    @FXML
    private TextField group;
    @FXML
    private TextField birthDay;
    @FXML
    private TextField job;
    @FXML
    private TextField address;
    @FXML
    private TextField note;


    private ObservableList<Person> persons = FXCollections.emptyObservableList();;

    public ObservableList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ObservableList<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void addHandler(Event event) {
        String name = this.name.getText();
        String phone = this.phone.getText();
        String group = this.group.getText();
        String birthDay = this.birthDay.getText();
        String job = this.job.getText();
        String address = this.address.getText();
        String note = this.note.getText();

        Person person = new Person(name, phone, group, birthDay, job, address);
        person.setNote(note);

        this.persons.add(person);

        System.out.println(person);
    }

    @FXML
    private void updateHandler(Event event) {

    }

    @FXML
    private void deleteHandler(Event event) {

    }



}
