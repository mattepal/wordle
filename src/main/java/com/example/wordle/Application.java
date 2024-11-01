package com.example.wordle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/com/example/wordle/view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Wordle Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void restart() throws IOException{
        Controller.secondaryStage.close();
        primaryStage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/com/example/wordle/view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Wordle Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}