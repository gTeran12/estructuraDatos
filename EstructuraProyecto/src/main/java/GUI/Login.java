/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author guill
 */
public class Login extends Task<Void>{
    private Label lbUser;
    private TextField tfUser;
    private Label lbPassword;
    private PasswordField pfPassword;
    private Button btSignIn;
    
    private Stage stg1;
    private VBox vbox1;
    private HBox root, hb1, hb2;
    
    public Login(Stage primaryStage){
        this.lbUser = new Label("USUARIO");
        this.tfUser = new TextField("Ingrese Usuario en el textfield...");
        this.lbPassword = new Label("CONTRASEÑA:");
        this.pfPassword = new PasswordField();
        this.btSignIn = new Button("ACCEDER");
        
        this.stg1 = primaryStage;
        this.root = new HBox();
        this.vbox1 = new VBox();
        this.hb1 = new HBox();
        this.hb2 = new HBox();
        
        hb1.getChildren().addAll(lbUser, tfUser);
        hb2.getChildren().addAll(lbPassword,pfPassword);
        root.getChildren().addAll(hb1,hb2,btSignIn);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(5);
        hb1.setId("user");
        hb2.setId("password");
                
    }
    
    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    protected Void call() throws Exception{
        Scene escenaLogin = new Scene(root, 1000, 500);
        stg1.setTitle("Login");
        stg1.setScene(escenaLogin);
        stg1.show();
        return null;
    }
}
