package Hangman;

import java.util.ArrayList;
import java.util.Collections;

public class HangmanDemo {

    public static void main(String[] args) {
//
//        try {
//            ArrayList<String> words = new DictionaryLoader().load();
//            for (String s : words) {
//                System.out.println(s);
//            }
//            Collections.sort(words, new StringLengthComparator());
//            for (String s : words) {
//                System.out.println(s);
//            }
//        } catch (DataFileException e) {
//            e.printStackTrace();
//        }

        Game game = new Game();
        System.out.println(game.tryCharacter('b'));
        System.out.println(game.isFinished());
        System.out.println(game.tryCharacter('a'));
        System.out.println(game.tryCharacter('u'));
        System.out.println(game.tryCharacter('m'));
        System.out.println(game.isFinished());
        System.out.println(game.tryCharacter('s'));

    }




}
