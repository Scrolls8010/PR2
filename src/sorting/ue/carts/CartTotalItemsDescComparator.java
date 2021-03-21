package sorting.ue.carts;

import java.util.Comparator;

public class CartTotalItemsDescComparator implements Comparator<Cart> {

    public CartTotalItemsDescComparator() {
    }


    @Override
    public int compare(Cart o1, Cart o2) {
        return Integer.compare(o2.getTotalItemAmount(), o1.getTotalItemAmount());
    }
}
