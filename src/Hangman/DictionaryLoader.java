package Hangman;

import java.io.*;
import java.util.ArrayList;

public class DictionaryLoader {



    public ArrayList<String> load() throws DataFileException {

        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("Files/Hangman/words.txt"))) {
            String line;
            while ((line= br.readLine()) !=null ) {

                words.add(line);

            }

return words;
        } catch (FileNotFoundException e) {
           throw new DataFileException("Data load error!", e);
        } catch (IOException e) {
            throw new DataFileException("Data load error!", e);
        }

    }







}
