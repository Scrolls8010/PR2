package PersonManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PersonServer {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server started");
            while (true) {
                 Socket s = serverSocket.accept();
                System.out.println("Client connected");
                ClientCommunication cc = new ClientCommunication(s);
                Thread th = new Thread(cc);
                th.start();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }




    }








}
