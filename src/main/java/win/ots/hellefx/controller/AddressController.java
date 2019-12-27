package win.ots.hellefx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.apache.commons.lang3.StringUtils;
import win.ots.hellefx.model.Person;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author : sy.wang
 * @date : 2019-12-26
 */
public class AddressController implements Initializable {

    @FXML
    private TableView<Person> tableView;
    @FXML
    private TableColumn<Person, String> columnName;
    @FXML
    private TableColumn<Person, String> columnPhone;
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


    private ObservableList<Person> persons = FXCollections.observableArrayList();
    ;

    public ObservableList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ObservableList<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView.setItems(persons);
        columnName.setCellValueFactory(cell -> cell.getValue().nameProperty());
        columnPhone.setCellValueFactory(cell -> cell.getValue().phoneProperty());

        tableView.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, oldValue, newVale) -> {
                    this.showDetails(newVale);
                }
        );
    }

    @FXML
    private void addHandler(Event event) {
        Person person = this.updatePersonFromInput(null);

        if (this.checkDetail(person)) {
            this.persons.add(person);
            System.out.println(person);
        }
    }

    @FXML
    private void updateHandler(Event event) {
        Person person = tableView.getSelectionModel().getSelectedItem();
        if (person == null) {
            System.out.println("no user selected, no update!");
            return;
        }
        this.updatePersonFromInput(person);

    }

    @FXML
    private void deleteHandler(Event event) {
        int index = tableView.getSelectionModel().getFocusedIndex();
        if (index < 0) {
            System.out.println("no user selected, no delete!");
            return;
        }
        persons.remove(index);
    }


    private void showDetails(Person person) {
        if (person != null) {
            this.name.setText(person.getName());
            this.phone.setText(person.getPhone());
            this.group.setText(person.getGroup());
            this.birthDay.setText(person.getBirthDay());
            this.job.setText(person.getJob());
            this.address.setText(person.getAddress());
            this.note.setText(person.getNote());
        }
    }

    private Person updatePersonFromInput(Person person) {
        String name = this.name.getText();
        String phone = this.phone.getText();
        String group = this.group.getText();
        String birthDay = this.birthDay.getText();
        String job = this.job.getText();
        String address = this.address.getText();
        String note = this.note.getText();

        person = person == null ? new Person(name, phone) : person;

        person.setName(name);
        person.setPhone(phone);
        person.setGroup(group);
        person.setBirthDay(birthDay);
        person.setJob(job);
        person.setAddress(address);
        person.setNote(note);

        return person;
    }

    private boolean checkDetail(Person person) {
        if (person == null) {
            return false;
        }
        if (StringUtils.isEmpty(person.getName())) {
            return false;
        }
        if (StringUtils.isEmpty(person.getPhone())) {
            return false;
        }

        return true;
    }

}
