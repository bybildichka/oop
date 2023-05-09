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

public class CostFlightSearchGUI {
    private User user;

    public CostFlightSearchGUI(User user) {
        this.user = user;
    }

    public void show() {
        CostFlightSearch costSearch = new CostFlightSearch(user);

        Stage stage = new Stage();
        stage.setTitle("Cost Flight Search");

        Label firstcityLabel = new Label("Your city:");
        Label secondcityLabel = new Label("Friend's city:");
        Label maxCostLabel = new Label("Max cost:");
        TextField firstCityTextField = new TextField();
        TextField secondCityTextField = new TextField();
        Slider maxCostSlider = new Slider(0, 1000, 500);
        maxCostSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            maxCostLabel.setText("Max cost:" + newValue.intValue());
        });
        Button searchButton = new Button("Search");
        TextArea resultTextArea = new TextArea();
        resultTextArea.setEditable(false);
        resultTextArea.setWrapText(true);

        searchButton.setOnAction(event -> {
            String firstCity = firstCityTextField.getText();
            String secondCity = secondCityTextField.getText();
            double maxCost = maxCostSlider.getValue();
            String result = costSearch.startSearch(firstCity, secondCity, maxCost);
            resultTextArea.setText(result);
            firstCityTextField.clear();
            secondCityTextField.setText("");
        });

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.add(firstcityLabel, 0, 0);
        gridPane.add(firstCityTextField, 1, 0);
        gridPane.add(secondcityLabel, 0, 1);
        gridPane.add(secondCityTextField, 1, 1);
        gridPane.add(maxCostLabel, 0, 2);
        gridPane.add(maxCostSlider, 1, 2);
        gridPane.add(searchButton, 1, 3);

        VBox mainBox = new VBox();
        mainBox.setAlignment(Pos.CENTER);
        mainBox.getChildren().addAll(gridPane, resultTextArea);

        Scene scene = new Scene(mainBox, 300, 200);
        stage.setScene(scene);
        stage.show();
    }
}