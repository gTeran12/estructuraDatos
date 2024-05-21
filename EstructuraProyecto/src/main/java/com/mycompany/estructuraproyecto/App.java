package com.mycompany.estructuraproyecto;

import GUI.Login;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        Login login = new Login(primaryStage);
        login.run();
    }

    public static void main(String[] args) {
        launch(args);
    }

}