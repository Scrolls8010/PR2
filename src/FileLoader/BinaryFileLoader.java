package FileLoader;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class BinaryFileLoader extends GenericFileLoader implements Runnable{

    private ArrayList<Integer> bytes = new ArrayList<>();

    public BinaryFileLoader(String path) {
        super(path);

    }

    @Override
    public void loadFile() throws GenericFileLoadException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path))) {
            int byteRead;
            while ((byteRead = bis.read()) !=-1) {
                CountBytes+=byteRead;
                bytes.add(bis.read());
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
