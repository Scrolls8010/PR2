package org.campus02.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileDemo {

    public static void main(String[] args) {

        File file = new File("/Users/lukasreisinger/Desktop/FH/2.Semester/PR2/PR2/Files/text.txt");
        System.out.println(file.exists());
        System.out.println(file.length());

        int bytesFromFile;
        try {
            FileInputStream fis = new FileInputStream(file);
            while ((bytesFromFile = fis.read()) != -1 ) {
                char[] ch = Character.toChars(bytesFromFile);
                System.out.print(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
