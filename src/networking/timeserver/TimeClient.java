package networking.timeserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TimeClient {

    public static void main(String[] args) {
        System.out.println("Whats the time?");

        try (Socket socket = new Socket("localhost", 11111);
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));)
        {
            String line;
            while((line = br.readLine())!=null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
