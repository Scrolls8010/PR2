package URLCACHEWEB;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        PageCache cache = new PageCache();
        cache.warumUp("Files/URLS/urls.txt");
        WebProxy proxy = new WebProxy(cache);


        try {
            ServerSocket serverSocket = new ServerSocket(5678);
            System.out.println("Serversocket created, bind on Port 5678");

            while (true) {
                System.out.println("Waiting for client...");
                Socket client = serverSocket.accept();
                System.out.println("Client connected!");
                ClientHandler ch = new ClientHandler(client,proxy);
                Thread th = new Thread(ch);
                th.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }






}
