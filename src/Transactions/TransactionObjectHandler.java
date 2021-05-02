package Transactions;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TransactionObjectHandler {

    public static void saveTransactions (ArrayList<Transaction> transactions,String path) throws TransactionObjectException {

        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path)))) {
            for (Transaction t : transactions) {
                oos.writeObject(t);
                oos.flush();
            }
        } catch (IOException e) {
            throw new TransactionObjectException("Object write error", e);
        }


    }




}
