package PersonManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientCommunication implements Runnable{

private Socket socket;

    public ClientCommunication(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        ArrayList<Person> persons = null;
        try {
            persons = new PersonLoader("Files/PersonManager/inputdata.csv").load();

        } catch (PersonLoadException e) {
            e.printStackTrace();
        }

        try (

                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            )
        {
            String line;
            while ((line=br.readLine())!=null) {

                String[] values = line.split(" ");

                if (values[0].equals("GET")) {
                    System.out.println("THIS IS THE ID TRANSMITTED " + values[1]);
                                int id = Integer.parseInt(values[1]);
                    boolean found = false;
                    if (persons != null) {
                        for (Person p : persons) {
                            if (p.getID() == id) {
                                oos.writeObject(p);
                                found = true;
                            }
                        }
                    }
                    if (!found) {
                        oos.writeObject(null);
                    }
                }
                if (line.equals("GETALL")) {
                    System.out.println("Am i here?");
                    if (persons != null) {
                        for (Person p : persons) {
                            oos.writeObject(p);
                            oos.flush();
                        }
                    }
                    oos.writeObject(null);

                }
                if (values[0].equals("EXIT")) {
                    System.out.println("Client disconnected");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
