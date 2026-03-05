package edu.iti.javafx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TextEditorController {

    @FXML
    private TextArea textArea;

    @FXML
    private void handleNew() {
        textArea.clear();
    }

    @FXML
    private void handleOpen() throws IOException {

        // FileChooser fileChooser = new FileChooser();
        // fileChooser.setTitle("Open File");
        // Stage stage = (Stage) textArea.getScene().getWindow();
        // File file = fileChooser.showOpenDialog(stage);

        // if (file != null) {
        //     BufferedReader reader = new BufferedReader(new FileReader(file));
        //     StringBuilder content = new StringBuilder();
        //     String line;
        //     while ((line = reader.readLine()) != null) {
        //         content.append(line).append("\n");
        //     }
        //     reader.close();
        //     textArea.setText(content.toString());
        // }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        Stage stage = (Stage) textArea.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            FileInputStream fis = new FileInputStream(file);
            byte[] data = fis.readAllBytes();
            fis.close();
            textArea.setText(new String(data));
        }

}

    @FXML
    private void handleSave() throws IOException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        Stage stage = (Stage) textArea.getScene().getWindow();
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            FileWriter writer = new FileWriter(file);
            writer.write(textArea.getText());
            writer.close();
        }

        // FileChooser fileChooser = new FileChooser();
        // fileChooser.setTitle("Save File");
        // Stage stage = (Stage) textArea.getScene().getWindow();
        // File file = fileChooser.showSaveDialog(stage);

        // if (file != null) {
        //     FileOutputStream fos = new FileOutputStream(file);
        //     fos.write(textArea.getText().getBytes());   
        //     fos.close();
        // }
    }

    @FXML
    private void handleExit() {
        Platform.exit();
    }

    @FXML
    private void handleCut() {
        textArea.cut();
    }

    @FXML
    private void handleCopy() {
        textArea.copy();
    }

    @FXML
    private void handlePaste() {
        textArea.paste();
    }

    @FXML
    private void handleDelete() {
        textArea.deleteText(textArea.getSelection());
    }

    @FXML
    private void handleSelectAll() {
        textArea.selectAll();
    }

    @FXML
    private void handleAbout() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Text Editor");
        alert.setContentText("This is a simple text editor.");
        alert.showAndWait();
    }
}
