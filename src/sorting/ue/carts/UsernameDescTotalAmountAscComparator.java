package sorting.ue.carts;

import java.util.Comparator;

public class UsernameDescTotalAmountAscComparator implements Comparator<Cart> {

    public UsernameDescTotalAmountAscComparator() {
    }

    @Override
    public int compare(Cart o1, Cart o2) {
        int compName = o2.getUserName().compareTo(o1.getUserName());
        // check if value is the same and sort further
        if (compName == 0) {
            return Double.compare(o1.getTotalAmount(),o2.getTotalAmount());
        }
        return compName;
    }
}
