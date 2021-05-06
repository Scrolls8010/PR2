package ChatServer;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ChatClient implements Runnable {

    private BufferedReader bufferedReader;
    private PrintWriter printWriter;
    private ArrayList<ChatClient> clients;
    private Socket client;
    private String name;

    public ChatClient(BufferedReader bufferedReader, PrintWriter printWriter, ArrayList<ChatClient> clients, Socket client) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
             PrintWriter pw = new PrintWriter(new OutputStreamWriter(client.getOutputStream()))
        ) {

            this.bufferedReader = bufferedReader;
            this.printWriter = printWriter;
            this.clients = clients;
            this.client = client;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        printWriter.print(message);
        printWriter.flush();
    }


    @Override
    public void run() {


    }

    public void close() {


    }

}
