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

    public static boolean compareTwoWords(String word1, String word2)
    {
        if(word1.equals(word2))
            return true;
        else
            return false;
    }

    public static void wordQuiz() throws IOException{
        Scanner scanner = new Scanner(System.in);

        addWordsToList();

        System.out.println("1:PL->EN");
        System.out.println("2:EN->PL");
        String usersChoice = scanner.nextLine();

        switch(usersChoice){
            case "1" ->{
                for (var i = 0; i < plWords.size(); i++) {
                    System.out.print(plWords.get(i));
                    System.out.print(" - translation: ");
                    String word=scanner.nextLine();

                    if(compareTwoWords(word, enWords.get(i)))
                        System.out.println("Correct!");
                    else
                        System.out.println("Wrong :(");
                }
            }
            case "2" ->{
                for (var i = 0; i < enWords.size(); i++) {
                    System.out.print(enWords.get(i));
                    System.out.print(" - translation: ");
                    String word=scanner.nextLine();

                    if(compareTwoWords(word, plWords.get(i)))
                        System.out.println("Correct!");
                    else
                        System.out.println("Wrong :(");
                }
            }
            default -> System.out.println("The picked option doesn't exist.");
        }
    }

    
}

