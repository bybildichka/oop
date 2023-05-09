package GUI;

import Searches.*;
import Users.*;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ProgramMain extends Application {
    @Override
    public void start(Stage stage) {
        VBox mainBox = new VBox();
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setSpacing(10);

        ToggleGroup accountTypeToggleGroup = new ToggleGroup();
        RadioButton regularButton = new RadioButton("Regular");
        regularButton.setToggleGroup(accountTypeToggleGroup);
        regularButton.setSelected(true);
        RadioButton premiumButton = new RadioButton("Premium");
        premiumButton.setToggleGroup(accountTypeToggleGroup);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter your username");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");

        Button loginButton = new Button("Log In");
        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
        
            User user;
            if (accountTypeToggleGroup.getSelectedToggle() == regularButton) {
                user = new RegularUser(username, password);
            } else {
                user = new PremiumUser(username, password);
            }
            if (user.validate(username, password) && accountTypeToggleGroup.getSelectedToggle() == regularButton) {
                stage.close();
                RegularButtonGUI regularButtonDisplay = new RegularButtonGUI(user);
                regularButtonDisplay.display();
            } 
            else if (user.validate(username, password) && accountTypeToggleGroup.getSelectedToggle() == premiumButton){
                stage.close();
                PremiumButtonGUI premiumButtondisplay = new PremiumButtonGUI(user);
                premiumButtondisplay.display();
            }
            else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Login Error");
                alert.setHeaderText("Invalid username or password");
                alert.setContentText("Please try again.");
                alert.showAndWait();
            }
        });
        
        HBox buttonBox = new HBox(regularButton, premiumButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(10);
        mainBox.getChildren().addAll(buttonBox, usernameField, passwordField, loginButton);
        Scene scene = new Scene(mainBox, 400, 200);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
