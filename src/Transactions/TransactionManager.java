package Transactions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TransactionManager {

    private ArrayList<Transaction> transactions;

    public TransactionManager(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public HashMap<String,Integer> getTransactionCountByCity() {

        HashMap<String,Integer> cityMap = new HashMap<>();

        for (Transaction t : transactions) {
            // wenn City schon in der Map liegt, wert rausholen, zwsichenspeichern, um 1 erhöhen, wieder reinlegen
            if (cityMap.containsKey(t.getCity())) {
                Integer value = cityMap.get(t.getCity());
                value++;
                cityMap.put(t.getCity(),value);
            } else {                    // wenn city noch nicht drinnen liegt, neues Pair in Map legen mit 1
                cityMap.put(t.getCity(),1);
            }

        }
        return cityMap;
    }


    public Integer getCountOfTransactionByCountry (String country) {
        int count=0;
        for (Transaction t : transactions) {
            if (t.getPaymentType().equals(country)) {
                count = count + 1;
            }

        }
        return count;
    }

    public ArrayList<Transaction> getTransactionsToProcut (String product) {
        ArrayList<Transaction> transactionsByProduct = new ArrayList<>();

        for (Transaction t :transactions) {
            if (t.getProduct().equals(product)) {
                transactionsByProduct.add(t);
            }
        }
        return transactionsByProduct;
    }

    public HashMap<String,Double> getAverageTransactionAmountByPaymentType() {
        //finale Liste mit den richtien Werten die zum Schluss zurückgegebn wird
        HashMap<String,Double> averageMap = new HashMap<>();

        // jeden PaymentType und die Anzahl an Payments einmal in eine eigene Hashmap legen
        HashMap<String, Integer> amountByPaymentMap = new HashMap<>();
        for (Transaction tr : transactions) {
           if (amountByPaymentMap.containsKey(tr.getPaymentType())) {
               Integer value = amountByPaymentMap.get(tr.getPaymentType());
               value++;
               amountByPaymentMap.put(tr.getPaymentType(),value);
           } else {
               amountByPaymentMap.put(tr.getPaymentType(),1);
           }
        }

        //neue Map mit gesamtSumme an Price je Payment type
        HashMap<String,Double> completePricePerPaymentType = new HashMap<>();
        for (Transaction tr : transactions) {
            if (completePricePerPaymentType.containsKey(tr.getPaymentType())) {
                Double fullPrice = completePricePerPaymentType.get(tr.getPaymentType());
                fullPrice = fullPrice + tr.getPrice();
                completePricePerPaymentType.put(tr.getPaymentType(),fullPrice);
            } else {
                completePricePerPaymentType.put(tr.getPaymentType(),tr.getPrice());
            }
        }

        //Jeden Map Entry von der vollen Liste durchlaufen und dann mit dem entsprechenden Wert in der Map mit Anzahl dividieren und in finale Map legen
        for (Map.Entry<String, Double> entry : completePricePerPaymentType.entrySet()) {
            averageMap.put(entry.getKey(),entry.getValue()/amountByPaymentMap.get(entry.getKey()));
        }
        return averageMap;
    }

}
