package sorting.ue.carts;

import java.util.ArrayList;
import java.util.Collections;

public class CartDemo {

    public static void main(String[] args) {
        // ----- DEMO DATA -----
        Cart userLukas = new Cart("lukas", 5, 10, 150.75);
        Cart userGeri = new Cart("lukas", 1,1,1);
        Cart userKerstin = new Cart("lukas", 5, 25,330);
        Cart userMathias = new Cart("mathias", 5, 5, 25);
        Cart userMarkus = new Cart("markus", 7, 700, 4700);

        ArrayList<Cart> carts= new ArrayList<>();
        carts.add(userLukas);
        carts.add(userGeri);
        carts.add(userKerstin);
        carts.add(userMathias);
        carts.add(userMarkus);

        System.out.println("Hier wird die unsortierte Liste ausgegeben:");
        for (Cart cart : carts) {
            System.out.println(cart.toString());
        }

        //Sort with implemented comparable
        System.out.println();
        System.out.println("Aufsteigende Sortierung nach TotalAmount");
        Collections.sort(carts);
        for (int i = 0; i < carts.size(); i++) {
            System.out.println(carts.get(i).toString());
        }

        //Sort with implemented Comparators
        System.out.println();
        System.out.println("Aufsteigende Sortierung nach Username");
        carts.sort(new CartUsernameComparator());
        for (int i = 0; i < carts.size(); i++) {
            System.out.println(carts.get(i).toString());
        }

        //Sort with implemented Comparators
        System.out.println();
        System.out.println("Absteigende Sortierung nach TotalItems");
        carts.sort(new CartTotalItemsDescComparator());
        for (int i = 0; i < carts.size(); i++) {
            System.out.println(carts.get(i).toString());
        }

        //Sort with implemented Comparators
        System.out.println();
        System.out.println("Absteigende Sortierung nach TotalArticels, Aufsteigend nach TotalItemAmount");
        carts.sort(new ArticlesDescItemsAscComparator());
        for (int i = 0; i < carts.size(); i++) {
            System.out.println(carts.get(i).toString());
        }


        //Sort with implemented Comparators
        System.out.println();
        System.out.println("Absteigende Sortierung nach Username, Absteigend nach Totalamount");
        carts.sort(new UsernameDescTotalAmountAscComparator());
        for (int i = 0; i < carts.size(); i++) {
            System.out.println(carts.get(i).toString());
        }

        //Sort with implemented Comparators
        System.out.println();
        System.out.println("Aufsteigend nach Durchschnittspreis pro item (totalItemAmount");
        carts.sort(new AvgAmountPerItemAscComparator());
        for (int i = 0; i < carts.size(); i++) {
            System.out.println(carts.get(i).toString());
        }

        //Sort with implemented Comparators
        System.out.println();
        System.out.println("Absteigend nach Durchschnittspreis pro item (NumberOfItems");
        carts.sort(new AvgAmountPerArticleDescComparator());
        for (int i = 0; i < carts.size(); i++) {
            System.out.println(carts.get(i).toString());
        }



    }


}
