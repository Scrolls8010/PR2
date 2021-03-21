package sorting.ue.socialmedia;

import java.util.Comparator;

public class ViewsDescSharesAscComparator implements Comparator<Posting> {

    public ViewsDescSharesAscComparator() {
    }

    @Override
    public int compare(Posting o1, Posting o2) {
        // check first sort value
        int compViews = Integer.compare(o2.getAmountViews(), o1.getAmountViews());
        // check if both are same and sort continue sorting
        if (compViews == 0) {
            return Integer.compare(o1.getAmountShares(), o2.getAmountShares());
        }
        return compViews;
    }
 }
