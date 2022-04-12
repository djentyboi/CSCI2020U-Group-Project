package sample;

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Scene teamSelectScene, gameScene;

    @Override
    public void start(final Stage primaryStage) throws Exception{

        //Will figure out how to use controller class optimally to reduce clutter in main class

        primaryStage.setTitle("CSCI2020U-Group-Project");

        //Borderpane layout for team select screen. (experiment with other layouts possibly)
        BorderPane teamSelectLayout = new BorderPane();
        teamSelectScene = new Scene(teamSelectLayout, 600, 600);
        Button button1 = new Button("Go to game scene");
        button1.setOnAction(e -> primaryStage.setScene(gameScene));
        teamSelectLayout.setCenter(button1);

        //Temporary scene 2 layout (This is where game will take place)
        VBox gameLayout = new VBox(20);
        gameScene = new Scene(gameLayout, 600, 600);
        Button button2 = new Button("Back to scene 1");
        button2.setOnAction(e -> primaryStage.setScene(teamSelectScene));
        gameLayout.getChildren().addAll(button2);

        primaryStage.setResizable(false);
        primaryStage.setScene(teamSelectScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
