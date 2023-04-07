package pl.quizmemory;

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

        Scanner read = new Scanner(new FileReader(CreateFile.nameFile()));

        while (read.hasNext()) {
            plWords.add(read.next());
            enWords.add(read.next());
        }

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

}
