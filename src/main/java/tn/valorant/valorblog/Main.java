package tn.valorant.valorblog;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the addPost.fxml file
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("addPost.fxml")));

        // Create a scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Set the scene in the primary stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Add Post");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}