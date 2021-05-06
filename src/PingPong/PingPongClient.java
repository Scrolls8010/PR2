package PingPong;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class PingPongClient {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try (Socket client = new Socket("localhost", 3333);
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
             BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
             BufferedReader cli = new BufferedReader(new InputStreamReader(System.in))
        ) {

            String cmdInput;
            while ((cmdInput = cli.readLine())!=null) {

                if (cmdInput.equalsIgnoreCase("quit")) {
                    System.out.println("Client exists");
                    break;
                }
                bw.write(cmdInput);
                bw.newLine();
                bw.flush();
                System.out.println("Sending " + cmdInput + " to server");
                String response = br.readLine();
                System.out.println("Recieved " + response + " from server");

            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }




}
