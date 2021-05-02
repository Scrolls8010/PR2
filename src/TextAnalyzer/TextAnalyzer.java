package TextAnalyzer;

import java.io.*;

public class TextAnalyzer {

    private ResultManager rm;
    private String path;

    public TextAnalyzer(ResultManager rm, String path) {
        this.rm = rm;
        this.path = path;
    }

    public void read() {

        File textInput = new File(path);

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            int byteRead;

            while ((byteRead = br.read()) !=-1) {
                Character currentCharacter = (char) byteRead;
                //Wenn der Char kein Buchstabe ist, Wert überspringen
                if (!Character.isAlphabetic(currentCharacter)) {
                    continue;
                }
                // Wenn der Buchstabe schon in der Liste ist, Wert aus der Hashmap holen, um 1 erhöhen, und wieder zurück in die Liste legen
                if (rm.getResultMap().containsKey(currentCharacter)) {
                    Integer value = rm.getResultMap().get(currentCharacter);
                    value++;
                    rm.getResultMap().put(currentCharacter,value);
                } else {
                    // Wenn noch nicht in der Liste, neuen Eintrag mit 1 anlegen
                    rm.getResultMap().put(currentCharacter,1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ResultManager getRm() {
        return rm;
    }
}
