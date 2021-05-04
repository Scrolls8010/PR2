package Workers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReadWorker extends Worker implements Runnable{

    private String filePath;
    public ArrayList<String> lines = new ArrayList<>();

    public FileReadWorker(String name, String filePath) {
        super(name);
        this.filePath = filePath;
    }

    @Override
    protected void work() {

        printStarted();
        System.out.println("File " + filePath + "wird jetzt eingelesen!");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            while ((shouldRun) && br.readLine()!=null) {
                lines.add(br.readLine());
                Thread.sleep(1000);
            }
            System.out.println("File wurde eingelesen!");
            printStopped();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {
work();
    }

}
