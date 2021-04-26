package networking.timeserver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class TimeServer {

    public static void main(String[] args) {
        int counter = 0;

        try (ServerSocket timeServerSocket = new ServerSocket(11111)) {

            System.out.println("Server socket created!");
            while (counter != 5) {
                System.out.println("Waiting for Client...");
                Socket client = timeServerSocket.accept();
                try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))) {
                    String localDateTime = LocalDateTime.now().toString();
                    counter++;
                    bw.write(counter + "Connect!");
                    bw.newLine();
                    bw.flush();
                    bw.write(localDateTime);
                    bw.newLine();
                    bw.flush();

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
