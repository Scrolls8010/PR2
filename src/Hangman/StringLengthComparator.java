package Hangman;

import java.util.Comparator;

public class StringLengthComparator implements Comparator<String> {


    @Override
    public int compare(String o1, String o2) {
        int compStringlen;

        compStringlen = Integer.compare(o1.length(), o2.length());

        if (compStringlen == 0) {
            return o1.compareTo(o2);
        }
        return compStringlen;
    }
}
