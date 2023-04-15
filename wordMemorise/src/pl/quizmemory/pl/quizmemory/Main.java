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
            System.out.println("Pick what you want to do: ");

            System.out.println("1. Create/delete file");
            System.out.println("2. Check input file");
            System.out.println("3. Add content to a file");
            System.out.println("4. View content of en/pl arrays");
            System.out.println("5. GAMES!");
            System.out.println("6. Quit");
            LoginGUI.ILogin();
            //MenuGUI.menuGUI();

            System.out.print("Type option: ");
            int userChoice = scanner.nextInt();


            WordList wordList = new WordList();
            CreateFile file = new CreateFile();


            switch (userChoice) {

                case 1 -> {
                    System.out.println("1. Create file");
                    System.out.println("2. Delete file");
                    System.out.print("Type option: ");
                    int userChoice1 = scanner.nextInt();

                    switch(userChoice1){
                        case 1 -> CreateFile.createFile();
                        case 2 -> CreateFile.deleteFile();
                        default -> System.out.println("The picked option doesn't exist.");
                    }
                }
                case 2 -> WordList.checkWordList();
                case 3 -> CreateFile.addContent();
                case 4 -> WordList.showWords();
                case 5 -> {
                    GamesManagement.gamesInterface();
                }
                case 6 -> shouldContinue = false;
                default -> System.out.println("The picked option doesn't exist.");
            }

        }
    }
}
