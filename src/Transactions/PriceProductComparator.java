package Transactions;

import java.util.Comparator;

public class PriceProductComparator implements Comparator<Transaction> {
    public PriceProductComparator() {
    }

    @Override
    public int compare(Transaction o1, Transaction o2) {
        int priceProductComp;
        //
        priceProductComp = o1.getPrice().compareTo(o2.getPrice());
        // if both values are the same, sort by product desc
        if (priceProductComp==0) {
            return o2.getProduct().compareTo(o1.getProduct());
        }
        return priceProductComp;
    }
}
