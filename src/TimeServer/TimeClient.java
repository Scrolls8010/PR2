package TimeServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TimeClient {

    public static void main(String[] args) {

        try (
                Socket socket = new Socket("localhost", 1111);
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            while (br.readLine() != null) {
                System.out.println("Testoutput direkt im Client");
                System.out.println(br.readLine());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }




//                try (
//                Socket socket = new Socket("localhost", 1111);
//                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
//
//                    System.out.println(br.readLine());
//
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }


    }



}



