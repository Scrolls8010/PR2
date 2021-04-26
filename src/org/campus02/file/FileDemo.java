package org.campus02.file;

import java.io.*;

public class FileDemo {

    public static void main(String[] args) {

        // Welcome to the FileDemo!
        // First we try to read some data binary data from a file into the program to be displayed on the console
        // we will start with Streams before checking on the reader

        //Get the file
        File file = new File("/Users/lukasreisinger/Desktop/FH/2.Semester/PR2/PR2/Files/Docs/doc1.txt");

        try {
            FileInputStream fis = new FileInputStream(file);
            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                char[] ch = Character.toChars(byteRead);
                System.out.print(ch[0]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // now we will write a new File!
        File output = new File("/Users/lukasreisinger/Desktop/FH/2.Semester/PR2/PR2/Files/Docs/outputdoc.txt");
        String outputText = "Content of outputdoc.txt!";

        try {
            FileOutputStream fos = new FileOutputStream(output);
            for (char c : outputText.toCharArray()) {
                fos.write(c);
            }
            fos.flush();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
// Schreiben Sie ein Programm, das ein String- Objekt „Hallo Welt“ in eine Datei „object.dat“ serialisiert und anschließend aus dieser wieder ausliest und auf die Konsole schreibt.
// Verwenden Sie die Klassen FileOutputStream und ObjectOutputStream sowie FileInputStream und ObjectInputStream
// Verwenden Sie für das Schreiben die Methode writeObject(...), für das Lesen die Methode readObject(). Beim Lesen müssen Sie das Ergebnis in einen String casten
// Betrachten Sie die Datei in einem Editor (Notepad, Notepad++)

        // Variable deklarieren
        String hw = "Hallo Welt";
        File obDat = new File("/Users/lukasreisinger/Desktop/FH/2.Semester/PR2/PR2/Files/Docs/Object/object.dat");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(obDat));
            oos.writeObject(hw);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(obDat));
            System.out.println((String) ois.readObject());
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
