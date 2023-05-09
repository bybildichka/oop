package GUI;

import Searches.*;
import Users.*;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegularTimeFlightSearchGUI{
    private User user;

    public RegularTimeFlightSearchGUI(User user){
        this.user = user;
    }
    public void display() {
        // TimeFlightSearch timeSearch = new PremiumFlightSearch(user);
        TextField FirstCityTextFieldTime;
        TextField SecondCityTextFieldTime;
        Slider maxTimeSlider;
        TextArea TimeResultTextArea;
        Stage TimeStage = new Stage();
        TimeStage.setTitle("Time Flight Search");

        Label firstcityLabel = new Label("Your city:");
        Label secondcityLabel = new Label("Friend's city:");
        Label maxTimeLabel = new Label("Max time: 24");
        FirstCityTextFieldTime = new TextField();
        SecondCityTextFieldTime = new TextField();
        maxTimeSlider = new Slider(0, 48, 24);
        maxTimeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            maxTimeLabel.setText("Max time:" + newValue.intValue());
        });

        Button searchButton = new Button("Search");
        TimeResultTextArea = new TextArea();
        TimeResultTextArea.setEditable(false);
        TimeResultTextArea.setWrapText(true);
        
        searchButton.setOnAction(event -> {
            TimeFlightSearch timeSearch = new TimeFlightSearch(user);
            String FirstCity = FirstCityTextFieldTime.getText();
            String SecondCity = SecondCityTextFieldTime.getText();
            double maxTime = maxTimeSlider.getValue();
            String result = timeSearch.startSearch(FirstCity, SecondCity, maxTime);
            TimeResultTextArea.setText(result);
            FirstCityTextFieldTime.clear();
            SecondCityTextFieldTime.setText("");
        });

        GridPane TimegridPane = new GridPane();
        TimegridPane.setAlignment(Pos.CENTER);
        TimegridPane.setHgap(10);
        TimegridPane.setVgap(10);
        TimegridPane.setPadding(new Insets(10, 10, 10, 10));
        TimegridPane.add(firstcityLabel, 0, 0);
        TimegridPane.add(FirstCityTextFieldTime, 1, 0);
        TimegridPane.add(secondcityLabel, 0, 1);
        TimegridPane.add(SecondCityTextFieldTime, 1, 1);
        TimegridPane.add(maxTimeLabel, 0, 3);
        TimegridPane.add(maxTimeSlider, 1, 3);
        TimegridPane.add(searchButton, 1, 4);

        VBox mainBox = new VBox();
        mainBox.setAlignment(Pos.CENTER);
        mainBox.getChildren().addAll(TimegridPane, TimeResultTextArea);

        Scene scene = new Scene(mainBox, 350, 250);
        TimeStage.setScene(scene);
        TimeStage.show();
    }
}