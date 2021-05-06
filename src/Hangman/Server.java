package Hangman;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(4321);
            System.out.println("Server started");
            Game game = new Game();

            while (true) {
                Socket client = serverSocket.accept();

                HangmanClient hc = new HangmanClient(game,client);
                Thread th = new Thread(hc);
                th.start();
                System.out.println("Client connected Hangman game started!");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }


