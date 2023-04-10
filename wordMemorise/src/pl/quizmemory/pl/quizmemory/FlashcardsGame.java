package pl.quizmemory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FlashcardsGame {

    static int currentIndex=0;
    static boolean changeLanguage=true;

    public static void flipCard(){
        if(changeLanguage)
            FlashcardsGUI.buttonCard.setText(WordList.plWords.get(currentIndex));
        else
            FlashcardsGUI.buttonCard.setText(WordList.enWords.get(currentIndex));

        changeLanguage=!changeLanguage;
    }

    public static void nextCard(){
        if(currentIndex==WordList.plWords.size()-1)
            currentIndex=0;
        else
            currentIndex++;

        FlashcardsGUI.buttonCard.setText(WordList.plWords.get(currentIndex));
    }

    public static void previousCard(){
        if(currentIndex==0)
            currentIndex=WordList.plWords.size()-1;
        else
            currentIndex--;

        FlashcardsGUI.buttonCard.setText(WordList.plWords.get(currentIndex));
    }
}
