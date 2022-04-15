//client is going to be the guesser in the game and store amount of wins in a game

package csci2020u.GroupProject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.*;
import java.io.*;
import java.util.*;

//extends applications goes here
public class client {

//    //calls the javaFX stuff
//    public void start(Stage primaryStage) throws Exception {
//        try{
//            Parent first = FXMLLoader.load(getClass().getResource("clientFX.fxml"));
//            Scene mainMenu = new Scene(first);
//            primaryStage.setTitle("Client");
//            primaryStage.setScene(mainMenu);
//            primaryStage.show();
//        }catch(Exception error){
//            error.printStackTrace();
//        }
//    }

    public static void main(String[] args){
        //launch(args);
        try (Socket sock = new Socket("localhost", 1066)){
            System.out.println("Connected to server...");
            System.out.println("Input \"69\" to terminate connection...");
            //get input from the user to send as a message
            PrintWriter dout = new PrintWriter(sock.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
            int clientGuess = 0;
            //guessing will go as long as guess is not '69' (lol)
            while(clientGuess != 69){
                clientGuess = scanner.nextInt();
                dout.println(clientGuess);
            }
            scanner.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Connection terminated...");
    }

//    public static void clientSide(){
//        try (Socket sock = new Socket("localhost", 1066)){
//            System.out.println("Connected to server...");
//            System.out.println("Input \"69\" to terminate connection...");
//            //get input from the user to send as a message
//            PrintWriter dout = new PrintWriter(sock.getOutputStream(), true);
//            Scanner scanner = new Scanner(System.in);
//            int clientGuess = 0;
//            //guessing will go as long as guess is not '69' (lol)
//            while(clientGuess != 69){
//                clientGuess = scanner.nextInt();
//                dout.println(clientGuess);
//            }
//            scanner.close();
//        }
//        catch(IOException e){
//            e.printStackTrace();
//        }
//        System.out.println("Connection terminated...");
//    }
}