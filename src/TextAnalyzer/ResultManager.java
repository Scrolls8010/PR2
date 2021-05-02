package TextAnalyzer;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ResultManager {

    private String path;
    private HashMap<Character, Integer> resultMap = new HashMap<>();

    public ResultManager(String path) {
        this.path = path;
    }

    public void read() {

        File input = new File(path);
        try (

                FileInputStream fis = new FileInputStream(path);
                BufferedReader br = new BufferedReader(new InputStreamReader(fis))
        ) {
            String line;
            while ((line = br.readLine()) !=null) {
                String[] values = line.split(":");
                Character resultKey = values[0].charAt(0);
                Integer resultValue = Integer.valueOf(values[1]);
                resultMap.put(resultKey,resultValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void write() throws WrongHashMapFormatException {
        for (Map.Entry<Character, Integer> entry : resultMap.entrySet()) {
            if (!Character.isLetterOrDigit(entry.getKey())) {
                throw new WrongHashMapFormatException("Wrong Format!");
            }
        }
            File output = new File(path);
            try (BufferedWriter br = new BufferedWriter(new FileWriter(path))) {
                for (Map.Entry<Character,Integer> entry: resultMap.entrySet()) {
                    String line = entry.getKey().toString() + ":" + entry.getValue().toString();
                    br.write(line);
                    br.newLine();
                    br.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }



    public HashMap<Character, Integer> getResultMap() {
        return resultMap;
    }
}
