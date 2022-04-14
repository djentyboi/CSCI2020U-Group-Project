package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Scene bettingScene, gameScene;
    int userBet;

    //Betting Scene
    VBox finalTopBox = new VBox();
    HBox listBox = new HBox();

    VBox horseList = new VBox();
    Label horse1 = new Label("Horse 1");
    Label horse2 = new Label("Horse 2");
    Label horse3 = new Label("Horse 3");

    VBox betButtonsList = new VBox();
    Button bet1 = new Button("PLACE BET");
    Button bet2 = new Button("PLACE BET");
    Button bet3 = new Button("PLACE BET");

    Label currentBet = new Label("NO CURRENT BET");

    BorderPane bettingSceneLayout = new BorderPane();

    Button startGameButton = new Button("Start Button");

    @Override
    public void start(final Stage primaryStage) throws Exception{

        horseList.getChildren().addAll(horse1, horse2, horse3);

        betButtonsList.getChildren().addAll(bet1, bet2, bet3);
        bet1.setOnAction(e -> currentBet.setText("CURRENT BET: HORSE 1"));
        bet2.setOnAction(e -> currentBet.setText("CURRENT BET: HORSE 2"));
        bet3.setOnAction(e -> currentBet.setText("CURRENT BET: HORSE 3"));

        listBox.getChildren().addAll(horseList, betButtonsList);
        finalTopBox.getChildren().addAll(listBox, currentBet);

        //PADDING AND SPACING
        listBox.alignmentProperty().setValue(Pos.CENTER);
        finalTopBox.alignmentProperty().setValue(Pos.CENTER);
        horseList.alignmentProperty().setValue(Pos.CENTER);
        betButtonsList.alignmentProperty().setValue(Pos.CENTER);

        listBox.setSpacing(8);
        horseList.setSpacing(14);
        betButtonsList.setSpacing(7);
        currentBet.setPadding(new Insets(10, 0, 0, 0));
        finalTopBox.setPadding(new Insets(10, 0, 0, 0));

        bettingSceneLayout.setTop(finalTopBox);

        startGameButton.setOnAction(e -> primaryStage.setScene(gameScene));
        bettingSceneLayout.setCenter(startGameButton);

        bettingScene = new Scene(bettingSceneLayout, 300, 300);

        primaryStage.setTitle("CSCI2020U-Group-Project");
        primaryStage.setResizable(false);
        primaryStage.setScene(bettingScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
