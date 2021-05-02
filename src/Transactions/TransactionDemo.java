package Transactions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class TransactionDemo {

    public static void main(String[] args) {

        try {
            ArrayList<Transaction> transactions = TransactionLoader.loadTransactions("Files/Transactions/transactions.csv");
            transactions.sort(new PriceProductComparator());
            for (Transaction t : transactions) {
                System.out.println(t.toString());
            }
            TransactionObjectHandler.saveTransactions(transactions, "Files/Transactions/transactions.dat");

            TransactionManager tm = new TransactionManager(transactions);


            for (Map.Entry<String,Integer> entry : tm.getTransactionCountByCity().entrySet()) {
                System.out.println(entry.getKey() + "   " + entry.getValue());
            }

            System.out.println(tm.getCountOfTransactionByCountry("Germany") + " Orders from Germany");

            for (Transaction t : tm.getTransactionsToProcut("Product1")) {
                System.out.println(t.toString());
            }

            for (Map.Entry<String,Double> entry : tm.getAverageTransactionAmountByPaymentType().entrySet()) {
                System.out.println(entry.getKey() + "   " + entry.getValue());
            }
        } catch (LoadException | TransactionObjectException e) {
            e.printStackTrace();
        }
    }
}
