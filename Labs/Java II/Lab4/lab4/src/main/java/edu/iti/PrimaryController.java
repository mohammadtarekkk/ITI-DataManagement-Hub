package edu.iti;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.sql.SQLException;

public class PrimaryController {
    @FXML
    private TextField idField, fnameField, mnameField, lnameField, emailField, phoneField;

    private PersonDAO dao = new PersonDAO();

    public void initialize() {
        try {
            handleFirst();
        } catch (SQLException e) {
        }
    }

    private void displayPerson(Person p) {
        if (p != null) {
            idField.setText(String.valueOf(p.getId()));
            fnameField.setText(p.getFirstName());
            mnameField.setText(p.getMiddleName());
            lnameField.setText(p.getLastName());
            emailField.setText(p.getEmail());
            phoneField.setText(p.getPhone());
        } else {
            idField.clear();
            fnameField.clear();
            mnameField.clear();
            lnameField.clear();
            emailField.clear();
            phoneField.clear();
        }
    }

    @FXML
    private void handleNew() throws SQLException {
        Person p = new Person(Integer.parseInt(idField.getText()), fnameField.getText(), mnameField.getText(),
                lnameField.getText(), emailField.getText(), phoneField.getText());
        dao.insert(p);
        displayPerson(dao.last());
        dao.debugPrintTable(); 

    }

    @FXML
    private void handleUpdate() throws SQLException {
        Person p = new Person(Integer.parseInt(idField.getText()), fnameField.getText(), mnameField.getText(),
                lnameField.getText(), emailField.getText(), phoneField.getText());
        dao.update(p);
        dao.debugPrintTable(); 
    }

    @FXML
    private void handleDelete() throws SQLException {
        int id = Integer.parseInt(idField.getText());
        dao.delete(id);

        dao.refreshData();
        displayPerson(dao.first());
        dao.debugPrintTable();
    }

    @FXML
    private void handleNext() throws SQLException {
        displayPerson(dao.next());
    }

    @FXML
    private void handlePrevious() throws SQLException {
        displayPerson(dao.previous());
    }

    @FXML
    private void handleFirst() throws SQLException {
        displayPerson(dao.first());
    }

    @FXML
    private void handleLast() throws SQLException {
        displayPerson(dao.last());
    }
}