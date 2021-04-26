package networking.pingpong;

import java.io.*;
import java.net.Socket;

public class PingPongHandler implements Runnable{

    private Socket client;

    public PingPongHandler(Socket client) {
        this.client = client;
    }

    @Override
        public void run() {
processClient();
        }

        private void processClient() {

            try (
                    BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            ) {

                String line;
                while ((line = br.readLine())!= null) {
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
