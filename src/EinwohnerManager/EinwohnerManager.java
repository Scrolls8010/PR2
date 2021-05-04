package EinwohnerManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EinwohnerManager {


    public EinwohnerManager() {
    }

    public ArrayList<Einwohner> load(String path) throws DataFileException {
        ArrayList<Einwohner> einwohnerArrayList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                einwohnerArrayList.add(new Einwohner(Integer.valueOf(values[0]),values[1],values[2],Integer.valueOf(values[3])));
            }
        } catch (FileNotFoundException e) {
           throw new DataFileException("Data Error", e);
        } catch (IOException e) {
            throw new DataFileException("Data Error", e);
        }
return einwohnerArrayList;
    }

}
