package com.superx.view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        Image img = new Image("assets\\Gemini_Generated_Image_4rceit4rceit4rce.png");
        ImageView iv = new ImageView(img);
        iv.setFitHeight(1200);
        iv.setFitWidth(800);
        iv.setPreserveRatio(true);

        Text title = new Text("Welcome to BarterHub!");
        title.setStyle("-fx-font-size: 40px; -fx-weight: bold;");
        Text t1 = new Text("Login to continue your exchange journy.");
        t1.setStyle("-fx-font-size: 10px;");

        Button login = new Button("login");
        login.setStyle("-fx-border-radius : 5px; -fx-padding: 10px 10px; -fx-background-color: transparent");

        Button signUp = new Button("sign Up");
        signUp.setStyle("-fx-border-radius : 5px; -fx-padding: 10px 10px; -fx-background-color: transparent");

        Label l1 = new Label("Email Address");
        TextField tf1 = new TextField();
        tf1.setPromptText("Enter your email");

        Label l2 = new Label("Password");
        PasswordField pf = new PasswordField();
        pf.setPromptText("Enter your password");

        Text t2 = new Text("Forgot Password?");
        t2.setStyle("-fx-font-size: 10px;");

        Button bt = new Button("Login");
        bt.setStyle("-fx-border-radius: 10px; -fx-padding: 20px 60px; -fx-background-color: #86a8f9");



        HBox hb1 = new HBox(200,login,signUp);

        VBox vb = new VBox(15);
        vb.getChildren().addAll(title,t1,hb1,l1,tf1,l2,pf,t2,bt);
        vb.setAlignment(Pos.CENTER);

        HBox hb2 = new HBox(iv);
        hb2.setAlignment(Pos.CENTER);

        HBox whole = new HBox(50,hb2,vb);

        stage.setTitle("Login Page");
        Scene sc = new Scene(whole,1200,800);
        stage.setScene(sc);
        stage.show();
    }
    
    
}
