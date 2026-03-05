module edu.iti {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens edu.iti to javafx.fxml;
    exports edu.iti;
}
