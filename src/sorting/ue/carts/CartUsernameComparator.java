package sorting.ue.carts;

import java.util.Comparator;

public class CartUsernameComparator implements Comparator<Cart> {

        public CartUsernameComparator() {
        }


    @Override
    public int compare(Cart o1, Cart o2) {
        return o1.getUserName().compareTo(o2.getUserName());
    }


}
