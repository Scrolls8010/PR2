package URLCACHEWEB;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private Socket socket;
    private WebProxy webProxy;

    public ClientHandler(Socket socket, WebProxy webProxy) {
        this.socket = socket;
        this.webProxy = webProxy;
    }

    @Override
    public void run() {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
            ) {
            String line;
            while ((line = br.readLine())!=null) {

                String[] commands = line.split(" ");

                if (commands[0].equals("bye")) {
                    break;
                }
                if (commands.length != 2) {
                    bw.write("error: command invalid");
                    bw.newLine();
                    bw.flush();
                }
                if (commands[0].equals("fetch")) {
                    try {
                        bw.write(webProxy.fetch(commands[1]).getContent());
                        bw.newLine();
                        bw.flush();
                    } catch (UrlLoaderException e) {
                        bw.write("error: loading the url failed");
                        bw.newLine();
                        bw.flush();
                    }
                }
                if (commands[0].equals("stats")) {
                    if (commands[1].equals("hits")) {
                        bw.write(webProxy.statHits());
                        bw.newLine();
                        bw.flush();
                    } else if (commands[1].equals("misses")) {
                        bw.write(webProxy.statsMisses());
                        bw.newLine();
                        bw.flush();
                    } else {
                        bw.write("error: invalid command");
                        bw.newLine();
                        bw.flush();
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
