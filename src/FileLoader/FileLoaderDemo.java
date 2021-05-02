package FileLoader;

import java.util.ArrayList;
import java.util.Scanner;

public class FileLoaderDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Bitte Pfad eingeben!");
        String path = scanner.nextLine();

        System.out.println("Bitte Dateinamen eingeben die geladen werden sollen!");

        String files = scanner.nextLine();
        String[] fileArray = files.split(";");

        for (String s : fileArray) {
            System.out.println(s);
        }

        System.out.println("Dateien sind eingelesen, jetzt Threads je nach Filetyp Klassen erstellen und Threads aufrufen");
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < fileArray.length; i++) {
            if (fileArray[i].endsWith("txt")) {
                TextFileLoader tfl = new TextFileLoader(path+fileArray[i]);

                Thread th = new Thread(tfl);
                th.start();
                threads.add(th);
            } else {
                BinaryFileLoader bfl = new BinaryFileLoader(path+fileArray[i]);

                Thread th = new Thread(bfl);
                th.start();
                threads.add(th);
            }
            System.out.println("Amount of Threads:" +threads.size());
            for (Thread th : threads) {
                try {
                    th.join();
                    System.out.println(th.getId() + "joined");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
        System.out.println(GenericFileLoader.getCountBytes());

        //System.out.println(fileArray[0].endsWith("txt"));











    }







}
