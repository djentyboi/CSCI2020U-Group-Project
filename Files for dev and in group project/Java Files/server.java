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


//extends applicaiton goes here if javaFX
public class server extends Application {

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
                int score = 0;
                while ((clientGuess = inStream.readLine()) != null) {
                    System.out.println("Client's Guess is: " + clientGuess);
                    int randomNumber = rand.nextInt(4) + 1;
                    System.out.println("Computer Generated Number is: " + randomNumber);
                    int numGuess = Integer.parseInt(clientGuess);
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

    public static void main(String[] args){
        launch(args);
        ServerSocket serve = null;
        try {
            serve = new ServerSocket(1066); //0 -> lets your OS select a port; port > 1024
            serve.setReuseAddress(true);
            System.out.println("Starting server...");
            System.out.println("Waiting for client connection...");
//            serve.accept();
            while (true) {
                Socket sock = serve.accept();
                System.out.println("Client is connected " + sock.getInetAddress().getHostAddress()); //this will display the host address of client
                ClientHandler client = new ClientHandler(sock);
                new Thread(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            serve.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}