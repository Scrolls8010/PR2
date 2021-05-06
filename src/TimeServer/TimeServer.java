package TimeServer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(1111)) {
            System.out.println("Server started, listening...");
            while (true) {


                Socket s = serverSocket.accept();
                System.out.println("Client connected!");

                try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()))) {

                    bw.write("Test ob ich beim Client ankomme");

                    bw.write("Test2");

                    bw.newLine();
                    bw.flush();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
