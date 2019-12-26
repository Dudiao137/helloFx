package win.ots.hellefx.model;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

/**
 * @author: sy.wang
 * @date: 2019-12-26
 */
public class Person {

    private StringProperty name;

    private StringProperty phone;

    private StringProperty group;

    private StringProperty birthDay;

    private StringProperty job;

    private StringProperty address;

    private StringProperty note;

    public Person(String name, String phone) {
        this.name = new SimpleStringProperty(name);
        this.phone = new SimpleStringProperty(phone);
        this.group = new SimpleStringProperty("");
        this.birthDay = new SimpleStringProperty("");
        this.job = new SimpleStringProperty("");
        this.address = new SimpleStringProperty("");
        this.note = new SimpleStringProperty("");
    }

    public Person(String name, String phone, String group, String birthDay, String job, String address) {
        this.name = new SimpleStringProperty(name);
        this.phone = new SimpleStringProperty(phone);
        this.group = new SimpleStringProperty(group);
        this.birthDay = new SimpleStringProperty(birthDay);
        this.job = new SimpleStringProperty(job);
        this.address = new SimpleStringProperty(address);
        this.note = new SimpleStringProperty("");
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPhone() {
        return phone.get();
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getGroup() {
        return group.get();
    }

    public StringProperty groupProperty() {
        return group;
    }

    public void setGroup(String group) {
        this.group.set(group);
    }

    public String getBirthDay() {
        return birthDay.get();
    }

    public void setBirthDay(String birthDay) {
        this.birthDay.set(birthDay);
    }

    public String getJob() {
        return job.get();
    }

    public StringProperty jobProperty() {
        return job;
    }

    public void setJob(String job) {
        this.job.set(job);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getNote() {
        return note.get();
    }

    public StringProperty noteProperty() {
        return note;
    }

    public void setNote(String note) {
        this.note.set(note);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", phone=" + phone +
                ", group=" + group +
                ", birthDay=" + birthDay +
                ", job=" + job +
                ", address=" + address +
                ", note=" + note +
                '}';
    }
}
