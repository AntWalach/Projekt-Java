package pl.quizmemory;

import java.util.ArrayList;
import java.util.List;

public class FlashcardsGame {
    private int currentIndex = 0;
    private boolean changeLanguage = true;

    protected List<String> words_1;
    protected List<String> words_2;

    FlashcardsGame() {
        words_1 = WordList.plWords;
        words_2 = WordList.enWords;
    }

    public void flipCard() {
        if(words_1.size() != 0) {
            if (changeLanguage)
                FlashcardsGUI.buttonCard.setText(words_1.get(currentIndex));
            else
                FlashcardsGUI.buttonCard.setText(words_2.get(currentIndex));

            changeLanguage = !changeLanguage;
        }
    }

    public void nextCard() {
        if(words_1.size() != 0) {
            if (currentIndex == words_1.size() - 1)
                currentIndex = 0;
            else
                currentIndex++;

            FlashcardsGUI.buttonCard.setText(words_1.get(currentIndex));
        }
    }

    public void previousCard() {
        if(words_1.size() != 0) {
            if (currentIndex == 0)
                currentIndex = words_1.size() - 1;
            else
                currentIndex--;

            FlashcardsGUI.buttonCard.setText(words_1.get(currentIndex));
        }
    }

    public void learned() {
        if(words_1.size() == 1){
            FlashcardsGUI.buttonCard.setText("End of the game!");
            words_1.remove(currentIndex);
            words_2.remove(currentIndex);
        }
        else {
            if(currentIndex >= 0 && currentIndex < words_1.size() - 1) {
                FlashcardsGUI.buttonCard.setText(words_1.get(currentIndex+1));
                words_1.remove(currentIndex);
                words_2.remove(currentIndex);
            } else if (currentIndex == words_1.size() - 1) {
                words_1.remove(currentIndex);
                words_2.remove(currentIndex);
                currentIndex = 0;
                FlashcardsGUI.buttonCard.setText(words_1.get(currentIndex));
            }
        }
    }
}
