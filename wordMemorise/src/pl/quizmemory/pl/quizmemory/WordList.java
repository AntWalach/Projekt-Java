package pl.quizmemory;

import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordList {

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




    public static void addWordToList() {

        List<String> plWords = new ArrayList<String>();
        List<String> enWords = new ArrayList<String>();










    }

}
