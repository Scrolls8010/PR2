package networking.pingpong;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class PingPongServer {

    public static void main(String[] args) {

        System.out.println("Starting Server");

        try (ServerSocket serverSocket = new ServerSocket(33333)) {

            while (true) {
                System.out.println("Waiting for Client");
                Socket clientSocket = serverSocket.accept();
                Thread clientThread = new Thread(new PingPongHandler(clientSocket));
                System.out.println("-- Thread started --");
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
