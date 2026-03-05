module edu.iti.lab {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens edu.iti.lab to javafx.fxml;
    exports edu.iti.lab;
}