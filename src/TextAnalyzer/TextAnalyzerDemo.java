package TextAnalyzer;

import java.util.Map;

public class TextAnalyzerDemo {

    public static void main(String[] args) {

        ResultManager rm = new ResultManager("Files/TextAnalyzer/valuepairs.txt");
        System.out.println("Initalfile einlesen und in Hasmap legen");
        rm.read();

        System.out.println("Werte aus Initalfile ausgeben");
        for (Map.Entry<Character,Integer> entry : rm.getResultMap().entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }

        System.out.println("Zusatzwerte eingeben");
        rm.getResultMap().put('G',555);
        rm.getResultMap().put('F',54);
        rm.getResultMap().put('1',44);

        System.out.println("Alle Werte jetzt wieder zurück ins File");
        try {
            rm.write();
        } catch (WrongHashMapFormatException e) {
            e.printStackTrace();
        }

        // new Resultmanager with new path to check the outcome of the textanalyzer
        ResultManager rm2 = new ResultManager("Files/TextAnalyzer/valuepairs_new.txt");
        TextAnalyzer tm = new TextAnalyzer(rm2,"Files/TextAnalyzer/BreText.txt");
        tm.read();

        try {
            tm.getRm().write();
        } catch (WrongHashMapFormatException e) {
            e.printStackTrace();
        }


    }








}
