package sorting.ue.carts;

import java.util.Comparator;

public class AvgAmountPerArticleDescComparator implements Comparator<Cart> {

    public AvgAmountPerArticleDescComparator() {
    }


    @Override
    public int compare(Cart o1, Cart o2) {
        return Double.compare(o2.getTotalAmount()/o2.getNumberOfArticles(),
                o1.getTotalAmount()/o1.getNumberOfArticles());
    }
}
