package sorting.ue.socialmedia;

import java.util.Comparator;

public class LikesPerViewAscComparator implements Comparator<Posting> {

    public LikesPerViewAscComparator() {
    }


    @Override
    public int compare(Posting o1, Posting o2) {
        double  ratio1 = 1.0 * o1.getAmountLikes() /o1.getAmountViews();
        double  ratio2 = 1.0 * o2.getAmountLikes() /o2.getAmountViews();
        //return Double.compare(ratio1,ratio2);
        return Double.compare(1.0 * o1.getAmountLikes()/ o1.getAmountViews(), 1.0 * o2.getAmountLikes()/o2.getAmountViews());
    }
}

