package sorting.ue.carts;

import java.util.Comparator;

public class AvgAmountPerItemAscComparator implements Comparator <Cart>{

    public AvgAmountPerItemAscComparator() {
    }

    @Override
    public int compare(Cart o1, Cart o2) {
        return Double.compare(o1.getTotalAmount() / o1.getTotalItemAmount(), o2.getTotalAmount() / o2.getTotalItemAmount());
    }
}
