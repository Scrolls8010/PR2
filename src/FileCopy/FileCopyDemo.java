package FileCopy;

import java.io.*;

public class FileCopyDemo {

    public static void main(String[] args) {

        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream("/Users/lukasreisinger/Desktop/FH/2.Semester/PR2/PR2/Files/FileCopy/01 Abstrake Klasse und Interface.pdf"));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("/Users/lukasreisinger/Desktop/FH/2.Semester/PR2/PR2/Files/FileCopy/CopiedFile/HISATZ.pdf"))) {

            byte[] buffer = new byte[1024];

            while (bis.read(buffer) > 0) {
                bos.write(buffer);
                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;


    }
}
