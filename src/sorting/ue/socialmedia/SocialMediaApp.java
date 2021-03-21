package sorting.ue.socialmedia;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class SocialMediaApp {

    public static void main(String[] args) {

        Posting post1 = new Posting("Lukas Reisinger", "Scrollz", LocalDateTime.of(2019, 3,10,12,21,22),7,2,22);
        Posting post2 = new Posting("Lukas Reisinger", "Scrollz", LocalDateTime.of(2019, 4,7,1,2,2),1,1,20);
        Posting post3 = new Posting("Gerald Reisinger", "sorny", LocalDateTime.of(2019, 6,1,0,1,22),74,20,220);
        Posting post4 = new Posting("Gerald Reisinger", "sorny", LocalDateTime.of(2020, 2,14,22,11,19),111,14,540);
        Posting post5 = new Posting("Gerald Reisinger", "sorny", LocalDateTime.of(2020, 2,1,1,1,1),1,1,1);
        Posting post6 = new Posting("Kerstin Knapp", "plantgirl", LocalDateTime.of(2020, 2,27,23,59,57),45,7,400);
        Posting post7 = new Posting("John Dorian", "JD", LocalDateTime.of(2020, 4,28,9,19,4),987,574,1000);
        Posting post8 = new Posting("Chris Turk", "Turk", LocalDateTime.of(2021, 1,20,12,10,1),4,0,8);
        Posting post9 = new Posting("Bob Kelso", "Chefdoc", LocalDateTime.of(2021, 1,3,20,1,44),1,1,10);
        Posting post10 = new Posting("Mathias Maier", "GenTec", LocalDateTime.of(2021, 2,10,10,21,22),1,8,54);
        Posting post11 = new Posting("Stefan Klambauer", "Toyboy", LocalDateTime.of(2021, 2,10,12,21,58),45,5,360);
        Posting post12 = new Posting("Eliot Reid", "Eliot", LocalDateTime.of(2021, 3,10,12,47,22),100,87,300);
        Posting post13 = new Posting("Susi Sorglos", "SusiOrg", LocalDateTime.of(2021, 3,14,11,35,45),2,1,10);
        Posting post14 = new Posting("Max Musti", "MrMuster777", LocalDateTime.of(2021, 3,28,19,52,3),1000,0,1000);
        Posting post15 = new Posting("Hassan Rassan", "01_H_R_11", LocalDateTime.of(2021, 3,30,5,21,40),1000,8,100_000);
        Posting post16 = new Posting("Erkan ol binida", "Erk4n", LocalDateTime.of(2021, 3,20,4,50,50),300,99,545);
        Posting post17 = new Posting("Roel van den Dungen", "DutchG0d", LocalDateTime.of(2021, 3,1,6,21,22),2,5,20);

        ArrayList <Posting> postings = new ArrayList<>();
        postings.add(post17);
        postings.add(post15);
        postings.add(post1);
        postings.add(post2);
        postings.add(post11);
        postings.add(post3);
        postings.add(post7);
        postings.add(post5);
        postings.add(post10);
        postings.add(post16);
        postings.add(post6);
        postings.add(post13);
        postings.add(post14);
        postings.add(post9);
        postings.add(post12);
        postings.add(post8);
        postings.add(post4);

        for (Posting posting : postings) {
            System.out.println(posting.toString());

        }

        // Erste Sortierung nach ID aufsteigend

        System.out.println(
        );
        System.out.println("Sortierung nach ID aufsteigend");
        Collections.sort(postings);
        for (Posting posting : postings) {
            System.out.println(posting.toString());
        }

        //  Sortierung nach RealName aufsteigend

        System.out.println(
        );
        System.out.println("Sortierung nach Realname aufsteigend");
        postings.sort(new RealnameAscComparator());
        for (Posting posting : postings) {
            System.out.println(posting.toString());
        }

        //  Sortierung nach Zeit absteigend

        System.out.println(
        );
        System.out.println("Sortierung nach Zeitstempel absteigend");
        postings.sort(new DateTimeDescComparator());
        for (Posting posting : postings) {
            System.out.println(posting.toString());
        }

        //  Sortierung nach Likes und Shares absteigend

        System.out.println(
        );
        System.out.println("Sortierung nach Likes und Shares absteigend");
        postings.sort(new LikesDescSharesDescComparator());
        for (Posting posting : postings) {
            System.out.println(posting.toString());
        }

        //  Sortierung nach Views und Shares aufsteigend/absteigend

        System.out.println(
        );
        System.out.println("Sortierung nach Views und Shares aufsteigend/absteigend");
        postings.sort(new ViewsDescSharesAscComparator());
        for (Posting posting : postings) {
            System.out.println(posting.toString());
        }

        //  Sortierung nach Likes per Views

        System.out.println(
        );
        System.out.println("Sortierung nach Likes per Views");
        postings.sort(new LikesPerViewAscComparator());
        for (Posting posting : postings) {
            System.out.println(posting.toString());
        }

        //  Sortierung nach Share zu View Ratio

        System.out.println(
        );
        System.out.println("Sortierung nach Share zu View Ratio");
        postings.sort(new ShareLikeRatioDescComparator());
        for (Posting posting : postings) {
            System.out.println(posting.toString());
        }



    }



}
