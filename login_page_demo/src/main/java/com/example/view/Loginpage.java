package com.example.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Loginpage extends Application {

    @Override
    public void start(Stage stage) {

        // ---------- LEFT: brand panel ----------

        // Logo mark: a soft circular badge with an exchange glyph, paired with the wordmark
        Circle logoBadge = new Circle(21);
        logoBadge.setFill(Color.web("rgba(255,255,255,0.16)"));
        logoBadge.setStroke(Color.web("rgba(255,255,255,0.55)"));
        logoBadge.setStrokeWidth(1.2);

        Label logoGlyph = new Label("\u21C4"); // ⇄ exchange arrows
        logoGlyph.setStyle("-fx-font-size: 19px; -fx-text-fill: white; -fx-font-weight: bold;");

        StackPane logoMark = new StackPane(logoBadge, logoGlyph);
        logoMark.setMinSize(42, 42);
        logoMark.setMaxSize(42, 42);

        Label brandLogo = new Label("BarterHub");
        brandLogo.setStyle("-fx-font-size: 26px; -fx-font-weight: 800; -fx-text-fill: white;");
        brandLogo.setFont(Font.font("Segoe UI", FontWeight.EXTRA_BOLD, 26));

        HBox logoRow = new HBox(12, logoMark, brandLogo);
        logoRow.setAlignment(Pos.CENTER_LEFT);

        Label brandTagline = new Label("Exchange what you have.\nGet what you need.");
        brandTagline.setStyle("-fx-font-size: 18px; -fx-text-fill: rgba(255,255,255,0.95); -fx-font-weight: 600;");
        brandTagline.setWrapText(true);

        Label brandSub = new Label(
                "A local, community-driven barter marketplace. Trade items you no longer "
                + "need, chat with nearby users, and buy or sell when a swap isn't the fit \u2014 "
                + "all in one secure platform.");
        brandSub.setStyle("-fx-font-size: 12.5px; -fx-text-fill: rgba(255,255,255,0.78); -fx-line-spacing: 3;");
        brandSub.setWrapText(true);

        VBox points = buildBrandPoints();

        Region brandSpacer = new Region();
        VBox.setVgrow(brandSpacer, Priority.ALWAYS);

        Separator brandDivider = new Separator();
        brandDivider.setStyle("-fx-background-color: rgba(255,255,255,0.18);");

        Label brandFooter = new Label("\u00A9 2026 BarterHub \u2014 Buy. Sell. Barter. Sustainably.");
        brandFooter.setStyle("-fx-font-size: 10.5px; -fx-text-fill: rgba(255,255,255,0.65);");

        VBox brandPanel = new VBox(20, logoRow, brandTagline, brandSub, points, brandSpacer, brandDivider, brandFooter);
        brandPanel.setPadding(new Insets(50, 42, 34, 42));
        brandPanel.setPrefWidth(370);
        brandPanel.setMinWidth(370);
        brandPanel.setAlignment(Pos.TOP_LEFT);
        brandPanel.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #0F766E, #134E4A);"
                + "-fx-background-radius: 20 0 0 20;");

        // ---------- RIGHT: form panel ----------
        Label formHeading = new Label("Welcome back");
        formHeading.setStyle("-fx-font-size: 24px; -fx-font-weight: 800; -fx-text-fill: #111827;");

        Label formSub = new Label("Login or create an account to start bartering");
        formSub.setStyle("-fx-font-size: 12.5px; -fx-text-fill: #6B7280;");

        String fieldStyle =
                "-fx-background-color: #F9FAFB; -fx-border-color: #E5E7EB; -fx-border-radius: 10;"
                + "-fx-background-radius: 10; -fx-padding: 11 14 11 14; -fx-font-size: 13px;";

        String primaryBtnStyle =
                "-fx-background-color: linear-gradient(to right, #0F766E, #0D9488);"
                + "-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px;"
                + "-fx-background-radius: 10; -fx-cursor: hand; -fx-padding: 11 0 11 0;"
                + "-fx-effect: dropshadow(gaussian, rgba(15,118,110,0.35), 10, 0, 0, 3);";

        String googleBtnStyle =
                "-fx-background-color: white; -fx-text-fill: #1F2937; -fx-font-size: 13px;"
                + "-fx-border-color: #E5E7EB; -fx-border-radius: 10; -fx-background-radius: 10;"
                + "-fx-cursor: hand; -fx-padding: 11 0 11 0;";

        String inactiveTabStyle =
                "-fx-background-color: transparent; -fx-text-fill: #6B7280;"
                + "-fx-background-radius: 8; -fx-cursor: hand; -fx-padding: 10 0 10 0; -fx-font-size: 13px;";

        String activeTabStyle =
                "-fx-background-color: white; -fx-text-fill: #0F766E; -fx-font-weight: bold;"
                + "-fx-font-size: 13px; -fx-background-radius: 8; -fx-cursor: hand; -fx-padding: 10 0 10 0;"
                + "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.08), 4, 0, 0, 1);";

        Button loginTab = new Button("Login");
        Button signupTab = new Button("Sign Up");
        loginTab.setPrefWidth(140);
        signupTab.setPrefWidth(140);

        HBox tabRow = new HBox(loginTab, signupTab);
        tabRow.setAlignment(Pos.CENTER);
        tabRow.setStyle("-fx-background-color: #F3F4F6; -fx-background-radius: 10;");
        tabRow.setPadding(new Insets(4));

        VBox formBox = new VBox(14);
        formBox.setAlignment(Pos.TOP_CENTER);
        formBox.setMaxWidth(320);

        loginTab.setOnAction(e -> {
            loginTab.setStyle(activeTabStyle);
            signupTab.setStyle(inactiveTabStyle);

            formBox.getChildren().clear();

            TextField emailOrPhone = new TextField();
            emailOrPhone.setPromptText("Email or phone number");
            emailOrPhone.setStyle(fieldStyle);

            PasswordField password = new PasswordField();
            password.setPromptText("Password");
            password.setStyle(fieldStyle);

            Hyperlink forgot = new Hyperlink("Forgot password?");
            forgot.setStyle("-fx-text-fill: #0F766E; -fx-font-size: 12px;");
            HBox forgotRow = new HBox(forgot);
            forgotRow.setAlignment(Pos.CENTER_RIGHT);

            Button loginBtn = new Button("Login");
            loginBtn.setMaxWidth(Double.MAX_VALUE);
            loginBtn.setStyle(primaryBtnStyle);
            loginBtn.setOnAction(ev -> {
                System.out.println("Login -> " + emailOrPhone.getText() + " / " + password.getText());
                // TODO: connect to backend auth
            });

            Separator sepL = new Separator();
            Separator sepR = new Separator();
            HBox.setHgrow(sepL, Priority.ALWAYS);
            HBox.setHgrow(sepR, Priority.ALWAYS);
            Label orLabel = new Label("OR");
            orLabel.setStyle("-fx-font-size: 11px; -fx-text-fill: #9CA3AF;");
            HBox orRow = new HBox(10, sepL, orLabel, sepR);
            orRow.setAlignment(Pos.CENTER);

            // --- Google Button with Logo ---
            Image googleLogo = new Image("assets\\icons\\image.png"); // path to your logo file
            ImageView googleIcon = new ImageView(googleLogo);

            // Resize the logo
            googleIcon.setFitWidth(18);
            googleIcon.setFitHeight(18);

            // Create button with text + logo
            Button googleBtn = new Button("Continue with Google", googleIcon);
            googleBtn.setMaxWidth(Double.MAX_VALUE);
            googleBtn.setStyle(googleBtnStyle);

            // Align logo to the left of text
            googleBtn.setContentDisplay(ContentDisplay.LEFT);
            googleBtn.setGraphicTextGap(8); // spacing between logo and text

            // Action on click
            googleBtn.setOnAction(ev -> {
                System.out.println("Google Auth clicked");
                // TODO: hook up Google OAuth
            });


            Label switchText = new Label("Don't have an account?");
            switchText.setStyle("-fx-font-size: 12px; -fx-text-fill: #6B7280;");
            Hyperlink switchLink = new Hyperlink("Sign Up");
            switchLink.setStyle("-fx-text-fill: #0F766E; -fx-font-size: 12px; -fx-font-weight: bold;");
            switchLink.setOnAction(ev -> signupTab.fire());
            HBox switchRow = new HBox(4, switchText, switchLink);
            switchRow.setAlignment(Pos.CENTER);

            formBox.getChildren().addAll(
                    emailOrPhone, password, forgotRow, loginBtn, orRow, googleBtn, switchRow);
        });

        signupTab.setOnAction(e -> {
            signupTab.setStyle(activeTabStyle);
            loginTab.setStyle(inactiveTabStyle);

            formBox.getChildren().clear();

            TextField name = new TextField();
            name.setPromptText("Full name");
            name.setStyle(fieldStyle);

            TextField email = new TextField();
            email.setPromptText("Email address");
            email.setStyle(fieldStyle);

            TextField phone = new TextField();
            phone.setPromptText("Phone number");
            phone.setStyle(fieldStyle);

            PasswordField password = new PasswordField();
            password.setPromptText("Password");
            password.setStyle(fieldStyle);

            PasswordField confirm = new PasswordField();
            confirm.setPromptText("Confirm password");
            confirm.setStyle(fieldStyle);

            Button signupBtn = new Button("Create Account");
            signupBtn.setMaxWidth(Double.MAX_VALUE);
            signupBtn.setStyle(primaryBtnStyle);
            signupBtn.setOnAction(ev -> {
                System.out.println("Signup -> " + name.getText() + ", " + email.getText() + ", " + phone.getText());
                // TODO: connect to backend registration
            });

            Separator sepL = new Separator();
            Separator sepR = new Separator();
            HBox.setHgrow(sepL, Priority.ALWAYS);
            HBox.setHgrow(sepR, Priority.ALWAYS);
            Label orLabel = new Label("OR");
            orLabel.setStyle("-fx-font-size: 11px; -fx-text-fill: #9CA3AF;");
            HBox orRow = new HBox(10, sepL, orLabel, sepR);
            orRow.setAlignment(Pos.CENTER);

            Image googleLogo = new Image("assets\\icons\\image.png"); // path to your logo file
            ImageView googleIcon = new ImageView(googleLogo);

            // Resize the logo
            googleIcon.setFitWidth(18);
            googleIcon.setFitHeight(18);

            // Create button with text + logo
            Button googleBtn = new Button("Continue with Google", googleIcon);
            googleBtn.setMaxWidth(Double.MAX_VALUE);
            googleBtn.setStyle(googleBtnStyle);

            // Align logo to the left of text
            googleBtn.setContentDisplay(ContentDisplay.LEFT);
            googleBtn.setGraphicTextGap(8); // spacing between logo and text

            // Action on click
            googleBtn.setOnAction(ev -> {
                System.out.println("Google Auth clicked");
                // TODO: hook up Google OAuth
            });


            Label switchText = new Label("Already have an account?");
            switchText.setStyle("-fx-font-size: 12px; -fx-text-fill: #6B7280;");
            Hyperlink switchLink = new Hyperlink("Login");
            switchLink.setStyle("-fx-text-fill: #0F766E; -fx-font-size: 12px; -fx-font-weight: bold;");
            switchLink.setOnAction(ev -> loginTab.fire());
            HBox switchRow = new HBox(4, switchText, switchLink);
            switchRow.setAlignment(Pos.CENTER);

            formBox.getChildren().addAll(
                    name, email, phone, password, confirm, signupBtn, orRow, googleBtn, switchRow);
        });

        // show login form by default
        loginTab.fire();

        VBox formPanel = new VBox(20, formHeading, formSub, tabRow, formBox);
        formPanel.setAlignment(Pos.TOP_CENTER);
        formPanel.setPadding(new Insets(55, 55, 55, 55));
        formPanel.setStyle("-fx-background-color: white; -fx-background-radius: 0 20 20 0;");
        HBox.setHgrow(formPanel, Priority.ALWAYS);

        // ---------- Card wrapper ----------
        HBox card = new HBox(brandPanel, formPanel);
        card.setMaxSize(920, 590);
        card.setPrefSize(920, 590);
        card.setStyle(
                "-fx-background-color: white; -fx-background-radius: 20;"
                + "-fx-effect: dropshadow(gaussian, rgba(15,118,110,0.22), 32, 0, 0, 10);");

        StackPane root = new StackPane(card);
        root.setStyle("-fx-background-color: linear-gradient(to bottom right, #ECFDF5, #F0FDFA);");

        Scene sc = new Scene(root, 970, 630);
        stage.setScene(sc);
        stage.setTitle("BarterHub");
        stage.setMinWidth(830);
        stage.setMinHeight(610);
        stage.show();
    }

    /** Builds the row of feature highlight points shown on the brand panel. */
    private VBox buildBrandPoints() {
        Label point1 = new Label("\u267B  Reduce waste, reuse more");
        Label point2 = new Label("\uD83D\uDCCD  Connect with people nearby");
        Label point3 = new Label("\uD83D\uDCB0  Swap for free, or buy/sell instead");
        for (Label p : new Label[]{point1, point2, point3}) {
            p.setStyle(
                    "-fx-font-size: 12.5px; -fx-text-fill: white; -fx-background-color: rgba(255,255,255,0.10);"
                    + "-fx-background-radius: 8; -fx-padding: 8 12 8 12;");
        }
        VBox points = new VBox(8, point1, point2, point3);
        for (Label p : new Label[]{point1, point2, point3}) {
            p.setMaxWidth(Double.MAX_VALUE);
        }
        return points;
    }
}
