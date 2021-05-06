package PersonManager;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class PersonClient {

    public static void main(String[] args) {

        try (Socket s = new Socket("localhost",1234);
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
             ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        ) {

//            //Get Objet
//            bw.write("GET 11");
//            bw.newLine();
//            bw.flush();
//
//            // read object
//            Person p1 = (Person) ois.readObject();
//            System.out.println(p1.toString());

             //GET ALL
            bw.write("GETALL");
            bw.newLine();
            bw.flush();

            Person p;
            while ((p = (Person) ois.readObject() ) !=null) {
                System.out.println(p);
            }
//
//            bw.write("EXIT");
//            bw.flush();
//            bw.newLine();




        } catch (UnknownHostException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }






}
