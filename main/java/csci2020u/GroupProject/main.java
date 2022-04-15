package csci2020u.GroupProject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class main extends server implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;



    // code for the buttons to allow you to switch to the main menu scene
    public void switchToGame(javafx.event.ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("serverFX2.fxml"));

        scene = new Scene(root);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    //call server
    //wait 5 seconds
    //call client
    //wait 5 seconds
    //launch javaFX
}
