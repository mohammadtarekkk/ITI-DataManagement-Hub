module edu.iti.javafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.iti.javafx to javafx.fxml;
    exports edu.iti.javafx;
}
