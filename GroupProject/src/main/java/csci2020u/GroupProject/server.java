//Riley Dunn (100760858)
//Frank Delgado Rodriguez (100784073)
//Jacob Turner (100762152)
//Braeden Gibson (100790228)

//Class Description
//server class is running the game
//it is responsible for making the random numbers for the player to guess
//it compares the number received from the client class and the random generated number to get a score

package csci2020u.GroupProject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;



public class server extends Application{
    public static int randomNumber;
    public static int numGuess;
    public static int score;

    private static class ClientHandler implements Runnable {
        private final Socket clientSock;
        public ClientHandler(Socket socket) {
            clientSock = socket;
        }

        public void run() {
            Random rand = new Random();
            BufferedReader inStream = null;
            try {
                inStream = new BufferedReader(new InputStreamReader(clientSock.getInputStream()));

                String clientGuess;
                score = 0;
                while ((clientGuess = inStream.readLine()) != null) {
                    System.out.println("Client's Guess is: " + clientGuess);
                    randomNumber = rand.nextInt(4) + 1;
                    System.out.println("Computer Generated Number is: " + randomNumber);
                    numGuess = Integer.parseInt(clientGuess);
                    if (numGuess == randomNumber){
                        score++;
                        System.out.println("Correct! Adding one point...");
                        System.out.println("Player Score: " + score);
                    }else{
                        System.out.println("Wrong Number!");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    inStream.close();
                    clientSock.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //starts up the javaFX
    public void start(Stage primaryStage) throws Exception {
        try{
            Parent first = FXMLLoader.load(getClass().getResource("serverFX.fxml"));
            Scene mainMenu = new Scene(first);
            primaryStage.setTitle("Gambling Simulator");
            primaryStage.setScene(mainMenu);
            primaryStage.show();
        }catch(Exception error){
            error.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //starts server in socket
        ServerSocket game = null;
        try {
            game = new ServerSocket(1066);
            game.setReuseAddress(true);
            System.out.println("Starting Game...");
            System.out.println("Waiting for Player connection...");
            while (true) {
                Socket sock = game.accept();
                System.out.println("Player is connected " + sock.getInetAddress().getHostAddress());
                ClientHandler client = new ClientHandler(sock);
                new Thread(client).start();
                //launches javafx after connection to client class (player)
                launch(args);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            game.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}