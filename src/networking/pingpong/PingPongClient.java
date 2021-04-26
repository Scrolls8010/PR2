package networking.pingpong;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class PingPongClient {


    public static void main(String[] args) {

        System.out.println("Client starting ping pong");

        try (Socket s = new Socket("localhost", 33333);
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        BufferedReader cli = new BufferedReader(new InputStreamReader(System.in));)
        {
            System.out.println("Connected to server!");
            String cmd;
            while ((cmd = cli.readLine())!=null) {
                if (cmd.equalsIgnoreCase("quit")) {
                    System.out.println("--- EXIT BY USER ---");
                    break;
                }

                // write to server
                System.out.println("<--- sending " + cmd);
                bw.write(cmd);
                bw.newLine();
                bw.flush();
                // read response
                String response = br.readLine();
                System.out.println("----> recvieved " + response);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Exiting");

    }


}
