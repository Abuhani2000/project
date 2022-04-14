/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h1;

import java.awt.Button;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tooltip; 
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */

    /**
     * @param args the command line arguments
     */
        
        

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ahmed mahdi
 */
public class h1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Label loginLabel, msgLabel, userNameLabel, passwordLabel, welcomeMsg, copyrightMsg, ads;
    HBox buttonHBox, userNameHBox, passwordHBox;
    VBox vBoxText, vBoxControll, msgVBox, topVBox, adsVBox;
    TextField userNameField;
    PasswordField passwordField;
    Button buttonGetUserName, buttonGetPassword, buttonFullScreen;
    Image logoImages, exit_fullscreen, fullscreen;
    ImageView fullScrenImages, exit_fullScrenImages;
    BorderPane borderPane;

    
    public void start(Stage primaryStage) {

        //creat Button and set size and Event
        buttonGetUserName = new Button("Get User Name");
        buttonGetUserName.setMaxSize(120, 30);
        buttonGetUserName.setOnAction((e) -> {
            if(!userNameField.getText().trim().isEmpty()){
            System.out.println("User Name :"+userNameField.getText());
            msgLabel.setText("Hello "+userNameField.getText());
            }
            
        });

        //creat Button and set size and Event
        buttonGetPassword = new Button("Get Password");
        buttonGetPassword.setMaxSize(120, 30);
        buttonGetPassword.setOnAction((e) -> {
            if(!passwordField.getText().trim().isEmpty()){
            System.out.println("Password :"+passwordField.getText());
            }
        });

        //get image from File
        try {
            fullscreen = new Image(new FileInputStream("src\\h1\\Image\\fullscreen.png"));
            exit_fullscreen = new Image(new FileInputStream("src\\h1\\Image\\exit_fullscreen.png")); 
        
        } catch (FileNotFoundException e) {
            Logger.getLogger(h1.class.getName()).log(Level.SEVERE, null, e);

        }

        //creat variable have the Iamge to use on Button and set Width and Height
        fullScrenImages = new ImageView(fullscreen);
        fullScrenImages.setFitHeight(20);
        fullScrenImages.setFitWidth(20);

        //creat variable have the Iamge to use on Button and set Width and Height
        exit_fullScrenImages = new ImageView(exit_fullscreen);
        exit_fullScrenImages.setFitHeight(20);
        exit_fullScrenImages.setFitWidth(20);

        //creat Button and set Image on Button
        buttonFullScreen = new Button();
        buttonFullScreen.setGraphic(fullScrenImages);
        buttonFullScreen.setTooltip(new Tooltip("Full Screan"));

        //set Event to Button
        buttonFullScreen.setonetOnAction((e) -> {
            if (primaryStage.isFullScreen()) {
                primaryStage.setFullScreen(!primaryStage.isFullScreen());
                buttonFullScreen.setGraphic(fullScrenImages);
                buttonFullScreen.setTooltip(new Tooltip("Full Screan"));
            } else {
                primaryStage.setFullScreen(!primaryStage.isFullScreen());
                buttonFullScreen.setGraphic(exit_fullScrenImages);
                buttonFullScreen.setTooltip(new Tooltip("Exit Full Screan"));
            }
        });

        //creat user name Field and user name Label and set him on HBox
        userNameField = new TextField();
        userNameField.setPromptText("User Name");
        userNameLabel = new Label("UserName");
        userNameHBox = new HBox(30, userNameLabel, userNameField);
        userNameHBox.setAlignment(Pos.CENTER);

        //creat password Field and password Label and set him on HBox
        passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordLabel = new Label("Password");
        passwordHBox = new HBox(35, passwordLabel, passwordField);
        passwordHBox.setAlignment(Pos.CENTER);

        //creat some label to get detal user 
        loginLabel = new Label("Login Form");
        msgLabel = new Label("Welcome User");
        copyrightMsg = new Label("© 2022 Model");

        welcomeMsg = new Label("Welcome to Model");
        ads = new Label("ads");

        adsVBox = new VBox(ads);
        adsVBox.setAlignment(Pos.CENTER_RIGHT);
        msgVBox = new VBox(welcomeMsg);
        msgVBox.setAlignment(Pos.CENTER);

        topVBox = new VBox(20, msgVBox, adsVBox);
        topVBox.setAlignment(Pos.CENTER);

        vBoxText = new VBox(10, msgLabel, loginLabel, userNameHBox, passwordHBox);
        vBoxText.setAlignment(Pos.CENTER);
        buttonHBox = new HBox(20, buttonGetUserName, buttonGetPassword, buttonFullScreen);
        buttonHBox.setAlignment(Pos.CENTER);

        vBoxControll = new VBox(20, vBoxText, buttonHBox);
        vBoxControll.setAlignment(Pos.CENTER);

        borderPane = new BorderPane();
        borderPane.setBottom(copyrightMsg);
        borderPane.setTop(topVBox);
        borderPane.setCenter(vBoxControll);
        Scene scene = new Scene(borderPane, 450, 450);

        //set Titel and set Logo on Stage
        try {
            logoImages = new Images(new FileInputStream("src\\h1\\Images\\logo.png"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(h1.class.getName()).log(Level.SEVERE, null, ex);
        }

        primaryStage.setResizable(false);
        primaryStage.getIcons().add(logoimages);
        primaryStage.setTitle("Model");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
        
        
        // TODO code application logic here
    
    

