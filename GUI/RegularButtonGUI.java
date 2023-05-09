package GUI;

import Searches.*;
import Users.*;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class RegularButtonGUI{
    private User user;

    public RegularButtonGUI(User user){
        this.user = user;
    }
    public void display(){
        Stage newStage = new Stage();
                Image image = new Image("file:Screenshot_4.jpg");
                ImageView ad = new ImageView(image);
                ad.setFitWidth(200);
                ad.setFitHeight(120);
                ToggleGroup timeCostToggleGroup = new ToggleGroup();
                RadioButton timeButton = new RadioButton("Time-related flights");
                timeButton.setToggleGroup(timeCostToggleGroup);
                timeButton.setSelected(true);
                RadioButton costButton = new RadioButton("Cost-related flights");
                costButton.setToggleGroup(timeCostToggleGroup);
        
                Button selectButton = new Button("Select");
                selectButton.setOnAction(selectEvent -> {
                    if (timeCostToggleGroup.getSelectedToggle() == timeButton) {
                        RegularTimeFlightSearchGUI timeSearch = new RegularTimeFlightSearchGUI(user);
                        timeSearch.display();
                        newStage.close();
                    } else {    
                        CostFlightSearchGUI costSearch = new CostFlightSearchGUI(user);
                        costSearch.show();
                        newStage.close();
                    }
                });
                
        
                HBox buttonBox = new HBox();
                buttonBox.setAlignment(Pos.CENTER_LEFT);
                buttonBox.setSpacing(10);

                VBox radioButtonBox = new VBox();
                radioButtonBox.setAlignment(Pos.CENTER_LEFT);
                radioButtonBox.setSpacing(10);
                radioButtonBox.getChildren().addAll(timeButton, costButton, selectButton);

                buttonBox.getChildren().add(radioButtonBox);
                
                HBox hboxWithImage = new HBox(buttonBox, ad);
                hboxWithImage.setAlignment(Pos.CENTER_LEFT);
                hboxWithImage.setSpacing(10);

                VBox newBox = new VBox(hboxWithImage);
                newBox.setAlignment(Pos.CENTER);
                newBox.setSpacing(10);
                newBox.setPadding(new Insets(10));
                
                StackPane stackPane = new StackPane();
                stackPane.getChildren().addAll(newBox);
                StackPane.setAlignment(ad, Pos.BOTTOM_RIGHT);
        
                Scene newScene = new Scene(stackPane, 400, 200);
                newStage.setScene(newScene);
                newStage.show();
    }
}
