package sorting.ue.socialmedia;

import java.util.Comparator;

public class DateTimeDescComparator implements Comparator<Posting> {

    public DateTimeDescComparator() {
    }


    @Override
    public int compare(Posting o1, Posting o2) {
        return o2.getTimestamp().compareTo(o1.getTimestamp());
    }
}
