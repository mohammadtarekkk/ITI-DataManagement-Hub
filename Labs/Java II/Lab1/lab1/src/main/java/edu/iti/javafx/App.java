package edu.iti.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        Text helloworld = new Text("Hello, world!");
        helloworld.setFill(Color.RED);
        // helloworld.setStyle("-fx-font-size: 80px;");

        StackPane rootPane = new StackPane(helloworld);
        Scene scene = new Scene(rootPane, 800, 600);

        Reflection reflection = new Reflection();
        helloworld.setEffect(reflection);

        Stop[] stops = new Stop[] {
            new Stop(0, Color.BLACK),
            new Stop(0.5, Color.WHITE),
            new Stop(1, Color.BLACK)
        };

        LinearGradient gradient = new LinearGradient(
            0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops
        );
        scene.setFill(gradient);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}