package com.mycompany.rentacar;

import Clases.Marca;
import Clases.Modelo;
import com.mycompany.rentacar.clases.LinkedList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import javafx.scene.image.Image;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 700, 500);
        stage.getIcons().add(new Image("file:src/main/resources/assets/logoCarRent.jpg"));//img icono
        stage.setTitle("CAR RENTAL");//titulo de app
        stage.setScene(scene);
        stage.show();

        
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}