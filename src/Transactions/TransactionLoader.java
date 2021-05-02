package Transactions;

import java.io.*;
import java.util.ArrayList;

public class TransactionLoader {

    public static ArrayList<Transaction> loadTransactions (String path) throws LoadException {
        ArrayList<Transaction> transactions = new ArrayList<>();
        File input = new File(path);
        try (
                BufferedReader br = new BufferedReader(new FileReader(input))
        ) {

            String line;
            br.readLine(); // Header ignorieren
            while ((line = br.readLine())!=null) {
                String[] valuesFromLine = line.split(";");
                double price = Double.parseDouble(valuesFromLine[2]);
              transactions.add
                      (new Transaction
                              (valuesFromLine[0],valuesFromLine[1],price,valuesFromLine[3],valuesFromLine[4],valuesFromLine[5],valuesFromLine[6],valuesFromLine[7]));
            }
        } catch (IOException e) {
           throw new LoadException("Loading error");
        }
        return transactions;
    }
}
