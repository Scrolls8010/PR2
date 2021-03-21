package sorting.ue.socialmedia;

import java.util.Comparator;

public class LikesDescSharesDescComparator implements Comparator <Posting> {

    public LikesDescSharesDescComparator() {
    }


    @Override
    public int compare(Posting o1, Posting o2) {
        // check first sort
        int compLike = Integer.compare(o2.getAmountLikes(), o1.getAmountLikes());
        // chef if likes are same, then sort by shares
        if (compLike == 0 ) {
            return Integer.compare(o2.getAmountShares(), o1.getAmountShares());
        }
        return compLike;
    }
}
