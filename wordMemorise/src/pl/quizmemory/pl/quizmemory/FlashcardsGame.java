package pl.quizmemory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class FlashcardsGame {

    static int currentIndex = 0;
    static boolean changeLanguage = true;

    protected List<String> words_1 = new ArrayList<>();
    protected List<String> words_2 = new ArrayList<>();

    FlashcardsGame() {
        words_1 = WordList.plWords;
        words_2 = WordList.enWords;
    }

    public void flipCard() {
        if (changeLanguage)
            FlashcardsGUI.buttonCard.setText(words_1.get(currentIndex));
        else
            FlashcardsGUI.buttonCard.setText(words_2.get(currentIndex));

        changeLanguage = !changeLanguage;
    }

    public void nextCard() {
        if (currentIndex == words_1.size() - 1)
            currentIndex = 0;
        else
            currentIndex++;

        FlashcardsGUI.buttonCard.setText(words_1.get(currentIndex));
    }

    public void previousCard() {
        if (currentIndex == 0)
            currentIndex = words_1.size() - 1;
        else
            currentIndex--;

        FlashcardsGUI.buttonCard.setText(words_1.get(currentIndex));
    }

    public void learned() { //do dopracowania!!!!
        if(words_1.size()==0){
            FlashcardsGUI.buttonCard.setText("Koniec gry!");
        }
        else {
            words_1.remove(currentIndex);
            words_2.remove(currentIndex);
            currentIndex--;
        }
    }
}
