package pl.quizmemory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordList {


    private static List<String> plWords = new ArrayList<String>();
    private static List<String> enWords = new ArrayList<String>();

    public static void checkWordList() throws IOException {

        List<String> wordList = new ArrayList<String>();

        Scanner read = new Scanner(new FileReader(CreateFile.nameFile()));

        String line;

        while (read.hasNext()) {
            line = read.next();
            wordList.add(line);
        }

        String[] array = wordList.toArray(new String[0]);

        for (String eachString : array) {
            System.out.print(eachString);
            System.out.print(" ");
        }

    }


    public static void addWordsToList() throws IOException {

//        Scanner read = new Scanner(new FileReader(CreateFile.nameFile()));
//
//        while (read.hasNext()) {
//            plWords.add(read.next());
//            enWords.add(read.next());
//        }

        BufferedReader read = new BufferedReader(new FileReader(CreateFile.nameFile()));

        StringBuilder word1 = new StringBuilder();
        StringBuilder word2 = new StringBuilder();
        boolean addToFirstList = true;
        int sign;
        while ((sign = read.read()) != -1) {
            char c = (char) sign;
            if (c == ',') {
                if (addToFirstList) {
                    plWords.add(word1.toString());

                    word1 = new StringBuilder();
                } else {
                    enWords.add(word2.toString());
                    word2 = new StringBuilder();
                }
                addToFirstList = !addToFirstList;
            } else {
                if (addToFirstList) {
                    word1.append(c);
                } else {
                    word2.append(c);
                }
            }
        }

        if (word1.length() > 0) {
            plWords.add(word1.toString());
        }

        if (word2.length() > 0) {
            enWords.add(word2.toString());
        }

        read.close();

    }


    public static void showWords() throws IOException {


        addWordsToList();

        System.out.print("Content of polish words array: ");
        for (var i = 0; i < plWords.size(); i++) {
            System.out.print(plWords.get(i));
            System.out.print(" ");
        }

        System.out.print("\n");
        System.out.print("Content of english words array: ");
        for (var i = 0; i < enWords.size(); i++) {
            System.out.print(enWords.get(i));
            System.out.print(" ");
        }
        System.out.print("\n");

    }

    public static boolean compareTwoWords(String word1, String word2) {
        if (word1.equals(word2))
            return true;
        else
            return false;
    }


    public static void translation(List<String> words, List<String> words2) {
        Scanner scanner = new Scanner(System.in);
        for (var i = 0; i < words.size(); i++) {
            System.out.print(words.get(i));
            System.out.print(" - translation: ");

            String word = scanner.nextLine();

            if (compareTwoWords(word, words2.get(i)))
                System.out.println("Correct!");
            else
                System.out.println("Wrong :(");
        }

    }

    public static void wordQuiz() throws IOException {
        Scanner scanner = new Scanner(System.in);

        addWordsToList();

        System.out.println("1:PL->EN");
        System.out.println("2:EN->PL");
        String usersChoice = scanner.nextLine();

        switch (usersChoice) {
            case "1" -> {
                translation(plWords, enWords);
            }
            case "2" -> {

                translation(enWords, plWords);
            }
            default -> System.out.println("The picked option doesn't exist.");
        }
    }


}

