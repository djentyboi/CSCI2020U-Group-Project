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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller2 extends server implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ProgressBar prog1;
    @FXML
    private ProgressBar prog2;
    @FXML
    private ProgressBar prog3;
    @FXML
    private ProgressBar prog4;
    @FXML
    private ProgressBar userp1;
    @FXML
    private ProgressBar userp2;
    @FXML
    private ProgressBar userp3;
    @FXML
    private ProgressBar userp4;
    @FXML
    private Button but1;
    @FXML
    private Label lScore;



    public void switchToGuess(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("serverFX.fxml"));

        scene = new Scene(root);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }


    public void initialize(URL location, ResourceBundle resources) {
        if(randomNumber == 1){
            prog1.setProgress(1.00);
            prog2.setProgress(0);
            prog3.setProgress(0);
            prog4.setProgress(0);

        }else if(randomNumber == 2){
            prog1.setProgress(0);
            prog2.setProgress(1.00);
            prog3.setProgress(0);
            prog4.setProgress(0);

        }else if(randomNumber == 3){
            prog1.setProgress(0);
            prog2.setProgress(0);
            prog3.setProgress(1.00);
            prog4.setProgress(0);
        }else if(randomNumber == 4){
            prog1.setProgress(0);
            prog2.setProgress(0);
            prog3.setProgress(0);
            prog4.setProgress(1.00);
        }




        if(numGuess == 1){
            userp1.setProgress(1.00);
            userp2.setProgress(0);
            userp3.setProgress(0);
            userp4.setProgress(0);

        }else if(numGuess == 2){
            userp1.setProgress(0);
            userp2.setProgress(1.00);
            userp3.setProgress(0);
            userp4.setProgress(0);

        }else if(numGuess == 3){
            userp1.setProgress(0);
            userp2.setProgress(0);
            userp3.setProgress(1.00);
            userp4.setProgress(0);

        }else if(numGuess == 4){
            userp1.setProgress(0);
            userp2.setProgress(0);
            userp3.setProgress(0);
            userp4.setProgress(1.00);
        }
//        lScore.setText(Integer.toString(score));
    }
}
