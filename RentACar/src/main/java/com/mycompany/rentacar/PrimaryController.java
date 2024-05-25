/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.rentacar;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
/**
 * FXML Controller class
 *
 * @author guill
 */
public class PrimaryController implements Initializable {


    @FXML
    private AnchorPane wrongLogin;
    @FXML
    private AnchorPane login;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button btLogin;
    @FXML
    private Label incorrect;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        validarCredenciales();
    }    
    
    @FXML
    private void validarCredenciales() {
        btLogin.setOnAction((t) -> {
            System.out.println(username.getText());
            System.out.println(password.getText());
            if (username.getText().equals("admin")&&password.getText().equals("admin")) {
                try {
                    App.setRoot("secondary");
                } catch (IOException ex) {
                    Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else{
                incorrect.setText("Pin o usario incorrecto");
            }
        });
    }

}
