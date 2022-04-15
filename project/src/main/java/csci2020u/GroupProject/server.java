//server is actually running the game and receiving the guess from the client

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


//extends Application goes here if javaFX
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

    //starts up the javaFX stuff
    //this might have to go into main
    public void start(Stage primaryStage) throws Exception {
        try{
            Parent first = FXMLLoader.load(getClass().getResource("serverFX.fxml"));
            Scene mainMenu = new Scene(first);
            primaryStage.setTitle("Server");
            primaryStage.setScene(mainMenu);
            primaryStage.show();
        }catch(Exception error){
            error.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //launch(args);
        ServerSocket serve = null;
        try {
            serve = new ServerSocket(1066);
            serve.setReuseAddress(true);
            System.out.println("Starting server...");
            System.out.println("Waiting for client connection...");
            while (true) {
                Socket sock = serve.accept();
                System.out.println("Client is connected " + sock.getInetAddress().getHostAddress());
                ClientHandler client = new ClientHandler(sock);
                new Thread(client).start();
                //launches javafx after connection
                launch(args);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            serve.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //sleep is used so the server has time to load before client loads in
        //TimeUnit.SECONDS.sleep(5);
        //client.clientSide();
        //one more sleep so client can load before the javaFX window is called
        //TimeUnit.SECONDS.sleep(5);
        //launch(args);
    }
}