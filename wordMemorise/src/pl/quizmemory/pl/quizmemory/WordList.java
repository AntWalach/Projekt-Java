package pl.quizmemory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa zajmująca się listami słów oraz tłumaczeń
 */
public class WordList {
    protected static List<String> plWords = new ArrayList<String>();
    protected static List<String> enWords = new ArrayList<String>();

    /**
     * Pobieranie słowów i ich tłumaczeń z pliku .txt oraz przekazywanie ich do tablic
     * @param fileName - nazwa pliku
     * @throws IOException - wyjątek
     */
    public static void addWordsToList(String fileName) throws IOException {

        plWords.clear();
        enWords.clear();


        BufferedReader read = new BufferedReader(new FileReader(fileName));

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
}