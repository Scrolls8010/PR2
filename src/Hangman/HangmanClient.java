package Hangman;

import java.io.*;
import java.net.Socket;

public class HangmanClient implements Runnable{

    private Game game;
    private Socket client;
    private String name;

    public HangmanClient(Game game, Socket client) {
        this.game = game;
        this.client = client;
    }



    @Override
    public void run() {

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
             BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        ) {
            String line;
            label:
            while ((line=br.readLine())!=null) {

                //NAME Befehl
                String[] commands = line.split(" ");

                switch (commands[0]) {
                    case "NAME" -> {
                        this.name = commands[1];
                        bw.write("Name " + this.name + " wurde gesetzt!");
                        bw.newLine();
                        bw.flush();
                    }
                    case "TRY" -> {
                        bw.write(game.tryCharacter(commands[1].charAt(0)));
                        bw.newLine();
                        bw.flush();
                        if (game.isFinished()) {
                            bw.write("Gratulation, das gesuchte Wort wurde gefunden. Neues Game startet");
                            bw.newLine();
                            bw.flush();
                        }
                    }
                    case "EXIT" -> {
                        bw.write("EXIT initialited");
                        bw.newLine();
                        bw.flush();
                    }
                    default -> {
                        bw.write("Unkown command");
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
