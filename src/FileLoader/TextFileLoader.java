package FileLoader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TextFileLoader extends GenericFileLoader implements Runnable{

    private ArrayList<String> content = new ArrayList<>();

    public TextFileLoader(String path) {
        super(path);
    }

    @Override
    public void loadFile() throws GenericFileLoadException {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            int byteread;
            while ((byteread = br.read()) != -1) {
                CountBytes += byteread;
                content.add(br.readLine());
            }
        } catch (IOException e) {
            throw new GenericFileLoadException("File load error", e);
        }
    }

    @Override
    public void run() {
        try {
            loadFile();
        } catch (GenericFileLoadException e) {
            e.printStackTrace();
        }
    }
}
