package com.lewis.inventory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.stage.*;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource( "login.fxml" ));
        Scene scene = new Scene(root, 520, 400);

        primaryStage.setTitle("Inventory Management");
        primaryStage.getIcons().add(new Image("https://upload.wikimedia.org/wikipedia/commons/c/c6/Sign-check-icon.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}