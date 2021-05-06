package Hangman;

import java.util.ArrayList;

public class Game {

    private char[] currentWord;
    private char[] foundWord;
    private int counter;

    public Game() {
        loadWord();
    }

    public void loadWord() {
        try {

            ArrayList<String> words = new DictionaryLoader().load();
            currentWord = words.get(counter).toCharArray();
           char[] temp = new char[currentWord.length];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = '_';
            }
            foundWord = temp;
            counter++;
        } catch (DataFileException e) {
            e.printStackTrace();
        }

    }

    public String tryCharacter (Character c) {

        for (int i = 0; i < currentWord.length; i++) {
            if (currentWord[i] == c) {
                foundWord[i] = c;
            }
        }
        return new String(foundWord);
    }

    public boolean isFinished() {
        boolean wordfound = true;
        for (int i = 0; i < foundWord.length; i++) {
            if (foundWord[i] == '_') {
                wordfound = false;
                break;
            }
        }
        if (wordfound) {
            System.out.println("Congratz! Word found,loading next Word");
            loadWord();
            return wordfound;
        } else {
            System.out.println("Word not found yet! Try again!");
            return wordfound;
        }
    }






}
