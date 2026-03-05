package edu.iti.lab;

import java.io.*;
import java.net.*;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatClientController implements Initializable {

    @FXML
    private TextArea chatArea;
    @FXML
    private TextField messageField;

    Socket s;
    DataInputStream dis;
    PrintStream ps;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            s = new Socket("127.0.0.1", 5005);
            dis = new DataInputStream(s.getInputStream());
            ps = new PrintStream(s.getOutputStream());

            new Thread(() -> {
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(dis));
                    while (true) {
                        String msg = br.readLine();
                        if (msg != null) {
                            Platform.runLater(() -> {
                                chatArea.appendText(msg + "\n");
                            });
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }).start();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void handleSendAction(ActionEvent event) {
        String msg = messageField.getText();
        if (!msg.isEmpty()) {
            ps.println(msg);
            messageField.clear();
        }
    }
}