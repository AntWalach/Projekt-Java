package pl.quizmemory;

import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordList {

    public static void checkWordList() throws IOException {

        List<String> wordList = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next();

        Scanner read = new Scanner(new FileReader(fileName));

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


    public static void addWordToList() {


    }

}
