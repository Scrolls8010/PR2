package sorting.ue.socialmedia;

import java.util.Comparator;

public class RealnameAscComparator implements Comparator<Posting> {

    public RealnameAscComparator() {
    }

    @Override
    public int compare(Posting o1, Posting o2) {
        return o1.getRealName().compareTo(o2.getRealName());
    }
}
