package pl.quizmemory;

import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;

        while (shouldContinue) {
            System.out.println("");
            System.out.println("Welcome in the Word Memory program");
            System.out.println("Pick what you wanna do: ");

            System.out.println("1. Create new file");
            System.out.println("1. Check input file");
            System.out.println("3. Add content to a file");
            System.out.println("4. ----------");
            System.out.println("5. Quit");

            int userChoice = scanner.nextInt();


            WordList wordList = new WordList();
            CreateFile file = new CreateFile();

            switch (userChoice) {

                case 1 -> CreateFile.crateFile();
                case 2 -> WordList.checkWordList();
                case 3 -> CreateFile.addContent();
                case 4 -> System.out.println("You picked number 3");
                case 5 -> shouldContinue = false;

            }
        }
    }
}
