package pl.quizmemory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GamesManagement {

    public static void gamesInterface() throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nChoose game: ");
        System.out.println("1. Translation game");
        System.out.println("2. Flashcards");
        int userChoice = scanner.nextInt();


        switch (userChoice) {

            case 1 -> TranslationGame();
            case 2 -> Flashcards();
            default -> System.out.println("The picked option doesn't exist.");

        }
    }
    public static boolean compareTwoWords(String word1, String word2) {
        if (word1.equals(word2))
            return true;
        else
            return false;
    }


    public static void translation(List<String> words, List<String> words2) {
        Scanner scanner = new Scanner(System.in);

        int learnedWordsCounter = 0;
        int primaryWordsNumber = words.size();
        int numberOfDeletedWords = 0;
        List<String> unlearnedWords = new ArrayList<String>();
        List<String> answerWords = new ArrayList<String>();
        unlearnedWords.addAll(words);
        answerWords.addAll(words2);

        while(unlearnedWords.size() != 0) {
            for(int i=0; i<words.size(); i++) {
                System.out.print(words.get(i));
                System.out.print(" - translation: ");

                String word = scanner.nextLine();

                if (compareTwoWords(word, words2.get(i))) {
                    System.out.println("Correct!");
                    unlearnedWords.remove(unlearnedWords.get(i-numberOfDeletedWords));
                    answerWords.remove(answerWords.get(i-numberOfDeletedWords));
                    learnedWordsCounter++;
                    numberOfDeletedWords++;
                    System.out.println("Acquired vocabulary " + learnedWordsCounter + "/" + primaryWordsNumber );
                } else
                    System.out.println("Wrong :(");
            }
            words.clear();
            words2.clear();
            words.addAll(unlearnedWords);
            words2.addAll(answerWords);
            numberOfDeletedWords = 0;
        }

    }

    public static void TranslationGame() throws IOException {
        Scanner scanner = new Scanner(System.in);

        WordList.addWordsToList();

        System.out.println("1:PL->EN");
        System.out.println("2:EN->PL");
        String usersChoice = scanner.nextLine();

        switch (usersChoice) {
            case "1" -> {
                translation(WordList.plWords, WordList.enWords);
            }
            case "2" -> {

                translation(WordList.enWords, WordList.plWords);
            }
            default -> System.out.println("The picked option doesn't exist.");
        }
    }

    public static void Flashcards() throws IOException {
        System.out.println("chuj");
    }
}
