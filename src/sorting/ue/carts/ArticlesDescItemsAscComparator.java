package sorting.ue.carts;

import java.util.Comparator;

public class ArticlesDescItemsAscComparator implements Comparator<Cart> {

    public ArticlesDescItemsAscComparator() {
    }


    @Override
    public int compare(Cart o1, Cart o2) {
        // First Value to compare
        int compArt = Integer.compare(o2.getNumberOfArticles(), o1.getNumberOfArticles());
        // chef if value is the same and sort with secondary values
        if (compArt == 0) {
            return Integer.compare(o1.getTotalItemAmount(), o2.getTotalItemAmount());
        }
        return compArt;
    }
}
