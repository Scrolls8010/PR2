package sorting.ue.socialmedia;

import java.util.Comparator;

public class ShareLikeRatioDescComparator implements Comparator<Posting> {

    public ShareLikeRatioDescComparator() {
    }

    @Override
    public int compare(Posting o1, Posting o2) {
        return Double.compare(1.0 * o2.getAmountShares()/o2.getAmountLikes(), 1.0 * o1.getAmountShares()/o1.getAmountLikes());
    }
}
