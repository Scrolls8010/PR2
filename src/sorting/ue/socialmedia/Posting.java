package sorting.ue.socialmedia;

import java.time.LocalDateTime;
import java.util.Comparator;

public class Posting implements Comparable<Posting> {
    private static int counter = 1;

    private int id;
    private String realName;
    private String userName;
    private LocalDateTime timestamp;
    private int amountLikes;
    private int amountShares;
    private int amountViews;

    public Posting(String realName, String userName, LocalDateTime timestamp, int amountLikes, int amountShares, int amountViews) {
        this.id = counter;
        counter++;
        this.realName = realName;
        this.userName = userName;
        this.timestamp = timestamp;
        this.amountLikes = amountLikes;
        this.amountShares = amountShares;
        this.amountViews = amountViews;
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }

    public String getRealName() {
        return realName;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getAmountLikes() {
        return amountLikes;
    }

    public int getAmountShares() {
        return amountShares;
    }

    public int getAmountViews() {
        return amountViews;
    }

    @Override
    public String toString() {
        return "Posting{" +
                "id=" + id +
                ", realName='" + realName + '\'' +
                ", userName='" + userName + '\'' +
                ", timestamp=" + timestamp +
                ", amountLikes=" + amountLikes +
                ", amountShares=" + amountShares +
                ", amountViews=" + amountViews +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Posting posting = (Posting) o;

        return id == posting.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public int compareTo(Posting o) {
        return Integer.compare(this.getId(), o.getId());
    }

}

