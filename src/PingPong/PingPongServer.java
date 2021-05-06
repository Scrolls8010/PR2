package PingPong;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class PingPongServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(3333);

            System.out.println("Server socket created!");

        while (true) {

                Socket client = serverSocket.accept();
                System.out.println("Client accepted!");
                processClient(client);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void processClient(Socket client) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))
        ) {
            String line;
            while ((line = br.readLine())!=null) {
                switch (line) {
                    case "ping":
                        bw.write("pong");
                        break;
                    case "pong":
                        bw.write("ping");
                        break;
                    default:
                        bw.write("error");
                }
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
