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
public class PremiumButtonGUI{
    private User user;

    public PremiumButtonGUI(User user){
        this.user = user;
    }
    public void display(){
        Stage PremiumStage = new Stage();
        Button extendButton = new Button("Extend Subscription");
        extendButton.setOnAction(ExtendEvent -> {
            Stage extendingStage = new Stage();
            ToggleGroup Extendings = new ToggleGroup();
            RadioButton month = new RadioButton("Month");
            month.setToggleGroup(Extendings);
            month.setSelected(true);
            RadioButton ThreeMonth = new RadioButton("Three Months");
            ThreeMonth.setToggleGroup(Extendings);
            RadioButton HalfYear = new RadioButton("Six Months");
            HalfYear.setToggleGroup(Extendings);
            Button selectExtentionButton = new Button("Submit");
            selectExtentionButton.setOnAction(SelectExtention -> {
                if(Extendings.getSelectedToggle() == month)
                    user.extendSubscription(30);
                    extendingStage.close();
                if(Extendings.getSelectedToggle() == ThreeMonth)
                    user.extendSubscription(90);
                    extendingStage.close();
                if(Extendings.getSelectedToggle() == HalfYear)
                    user.extendSubscription(180);
                    extendingStage.close();
            });
            VBox Extends = new VBox();
            Extends.setSpacing(10);
            Extends.setAlignment(Pos.CENTER);
            Extends.getChildren().addAll(month, ThreeMonth, HalfYear, selectExtentionButton);
            Scene ExtendingScene = new Scene(Extends, 400, 200);
            extendingStage.setScene(ExtendingScene);
            extendingStage.show();
        });
        Button checkSubsctiption = new Button("Subscription expiration");
        checkSubsctiption.setOnAction(checkEvent -> {
            Stage ShowExpiration = new Stage();
            TextArea Expiration = new TextArea();
            double DaysLeft = user.SubscriptionDaysLeft();
            String result = "Subscription expire in:" + DaysLeft;
            Expiration.setText(result);
            Button closeExpiration = new Button("Back");
            closeExpiration.setOnAction(CloseEvent -> {
                ShowExpiration.close();
            });
            VBox expirationBox = new VBox(Expiration, closeExpiration);
            Scene ExpirationScene = new Scene(expirationBox, 250, 50);
            ShowExpiration.setScene(ExpirationScene);
            ShowExpiration.show();
        });
        Button SearchChoosing = new Button("Go to searching");
        SearchChoosing.setOnAction(SearchEvent -> {
            PremiumStage.close();
            Stage newStage = new Stage();        
                ToggleGroup timeCostToggleGroup = new ToggleGroup();
                RadioButton timeButton = new RadioButton("Time-related flights");
                timeButton.setToggleGroup(timeCostToggleGroup);
                timeButton.setSelected(true);
                RadioButton costButton = new RadioButton("Cost-related flights");
                costButton.setToggleGroup(timeCostToggleGroup);
                

                Button selectButton = new Button("Select");
                selectButton.setOnAction(selectEvent -> {
                    if (timeCostToggleGroup.getSelectedToggle() == timeButton) {
                        PremiumTimeFlightSearchGUI timeSearch = new PremiumTimeFlightSearchGUI(user);
                        timeSearch.display();
                        newStage.close();
                    } else {    
                        CostFlightSearchGUI costSearch = new CostFlightSearchGUI(user);
                        costSearch.show();
                        newStage.close();
                    }
                });
                
        
                VBox radioButtonBox = new VBox();
                radioButtonBox.setAlignment(Pos.CENTER);
                radioButtonBox.setSpacing(10);
                radioButtonBox.getChildren().addAll(timeButton, costButton, selectButton);
        
                Scene newScene = new Scene(radioButtonBox, 400, 200);
                newStage.setScene(newScene);
                newStage.show();
        });
        VBox PremiumButtons = new VBox();
        PremiumButtons.getChildren().addAll(extendButton, checkSubsctiption, SearchChoosing);
        PremiumButtons.setSpacing(10);
        PremiumButtons.setAlignment(Pos.CENTER);
        Scene PremiumScene = new Scene(PremiumButtons, 400, 200);
        PremiumStage.setScene(PremiumScene);
        PremiumStage.show();
    }
}