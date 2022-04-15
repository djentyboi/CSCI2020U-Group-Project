//Riley Dunn (100760858)
//Frank Delgado Rodriguez (100784073)
//Jacob Turner (100762152)
//Braeden Gibson (100790228)

//Class Description
//client is going to be the guesser (player) in the game
//this class sends the player input to the server

package csci2020u.GroupProject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.*;
import java.io.*;
import java.util.*;

public class client {

    public static void main(String[] args){
        //starts client in socket
        try (Socket sock = new Socket("localhost", 1066)){
            System.out.println("Connected to Game...");
            System.out.println("Input \"68\" to end the game...");
            //get input from terminal and send as a guess to the game class (server.java)
            PrintWriter dout = new PrintWriter(sock.getOutputStream(), true);
            //get guess from player
            Scanner scanner = new Scanner(System.in);
            int clientGuess = 0;
            //guessing will go as long as guess is not '68'
            while(clientGuess != 68){
                clientGuess = scanner.nextInt();
                dout.println(clientGuess);
            }
            scanner.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Game Over... GoodBye...");
    }
}