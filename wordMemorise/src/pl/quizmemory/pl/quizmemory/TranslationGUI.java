package pl.quizmemory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 * Graficzna implementacja gry tłumaczeniowej
 */
public class TranslationGUI extends CreateFile {

    private MenuGUI.Panel filenamePanel;
    private MenuGUI.Panel traslationGamePanel;
    private MenuGUI.Panel endScreenPanel;
    private JRadioButton PLtoEN;
    private JRadioButton ENtoPL;
    private JLabel wordToTranslate;
    private JLabel Score;
    private JLabel answerResult;
    private JLabel correctResult;
    private JTextField answerField;
    private java.util.List<String> LearnWords;
    private java.util.List<String> AnswerWords;
    private int answersPointer = 0;
    private int deletedWords = 0;
    private int maxScore = 0;
    private String word;

    /**
     * konstruktor wywołujący funkcje filenameGUItranslation
     */
    TranslationGUI() {
        filenameGUItranslation();
    }

    /**
     * Dodanie graficznych elementów do wyświetlanego panelu
     */
    public void filenameGUItranslation() {
        JLabel title = new JLabel();
        title.setText("Translation Game");
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("Arial", Font.PLAIN, 40));
        title.setBounds(470, 50, 500, 100);

        JLabel text1 = new JLabel();
        text1.setText("Enter file name:");
        text1.setHorizontalTextPosition(JLabel.CENTER);
        text1.setForeground(new Color(255, 255, 255));
        text1.setFont(new Font("Arial", Font.PLAIN, 25));
        text1.setBounds(500, 300, 200, 100);

        JButton buttonFile = MenuGUI.setButton(550, 500, 100, 50);
        buttonFile.setText("Submit");

        JButton buttonExit = MenuGUI.setButton(50, 50, 100, 50);
        buttonExit.setText("Return");
        buttonExit.addActionListener(e -> returnMenu(filenamePanel));

        JTextField textField = new JTextField();
        textField.setBounds(500, 400, 200, 50);
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        buttonFile.addActionListener(e -> {
            try {
                savefileTranslation(e, textField, buttonFile);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        PLtoEN = new JRadioButton("Polish - English");
        PLtoEN.setBounds(490, 180, 300, 50);
        PLtoEN.setOpaque(false);
        PLtoEN.setForeground(new Color(255, 255, 255));
        PLtoEN.setFont(new Font("Arial", Font.PLAIN, 25));
        PLtoEN.setRequestFocusEnabled(false);
        PLtoEN.setSelected(true);
        ENtoPL = new JRadioButton("English - Polish");
        ENtoPL.setBounds(490, 230, 300, 50);
        ENtoPL.setOpaque(false);
        ENtoPL.setForeground(new Color(255, 255, 255));
        ENtoPL.setFont(new Font("Arial", Font.PLAIN, 25));
        ENtoPL.setRequestFocusEnabled(false);

        ButtonGroup group = new ButtonGroup();
        group.add(PLtoEN);
        group.add(ENtoPL);

        filenamePanel = new MenuGUI.Panel();
        filenamePanel.setLayout(null);
        filenamePanel.add(title);
        filenamePanel.add(text1);
        filenamePanel.add(PLtoEN);
        filenamePanel.add(ENtoPL);
        filenamePanel.add(textField);
        filenamePanel.add(buttonFile);
        filenamePanel.add(buttonExit);

        GameChoiceGUI.choiceMenu.setVisible(false);
        LoginGUI.mainFrame.add(filenamePanel);
    }

    /**
     * Funkcja pobierająca słowa i ich tłumaczenia z pliku .txt
     * @param e - action event
     * @param textField - pole tekstowe
     * @param buttonFile - przycisk
     * @throws IOException - wyjątek
     */
    public void savefileTranslation(ActionEvent e, JTextField textField, JButton buttonFile) throws IOException {
        if (e.getSource() == buttonFile) {
            String fileName = textField.getText();
            WordList.addWordsToList(this.checkFileName(fileName));
            translationGame();
        }
    }

    /**
     * Wybór języka
     */
    public void languageChoice() {
        String fixedString = "";
        for (int i = 0; i < WordList.plWords.size(); i++) {
            fixedString = WordList.plWords.get(i);
            WordList.plWords.set(i, fixedString.trim());
        }

        LearnWords = new ArrayList<String>();
        AnswerWords = new ArrayList<String>();

        if (PLtoEN.isSelected()) {
            LearnWords.addAll(WordList.plWords);
            AnswerWords.addAll(WordList.enWords);

            ArrayList<String> tempLearn = new ArrayList<>(LearnWords);
            ArrayList<String> tempAnswer = new ArrayList<>(AnswerWords);

            long seed = System.nanoTime();
            Collections.shuffle(tempLearn, new Random(seed));
            Collections.shuffle(tempAnswer, new Random(seed));

            LearnWords.clear();
            AnswerWords.clear();

            LearnWords.addAll(tempLearn);
            AnswerWords.addAll(tempAnswer);
        } else {
            LearnWords.addAll(WordList.enWords);
            AnswerWords.addAll(WordList.plWords);
        }
    }

    /**
     * Funkcja porównująca słowo i jego tłumaczenie
     * @param word1 - słowo
     * @param word2 - tłumaczenie słowa
     * @return true or false
     */
    public boolean compareTwoWords(String word1, String word2) {
        if (word1.equals(word2))
            return true;
        else
            return false;
    }

    /**
     * Funckcja porównująca słowo wraz z propozycją tłumaczenia podaną przez użytkownika
     */
    public void translationEngine() {
        if (compareTwoWords(word, AnswerWords.get(answersPointer))) {
            LearnWords.remove(answersPointer);
            AnswerWords.remove(answersPointer);
            deletedWords++;

            Score.setText("Your Score: " + deletedWords + "/" + maxScore);
            answerResult.setText("Correct");
            correctResult.setText("");
            answerResult.setForeground(new Color(47, 250, 2));
        } else {
            answerResult.setText("Wrong");
            answerResult.setForeground(new Color(250, 9, 9));
            correctResult.setText(AnswerWords.get(answersPointer));
            correctResult.setForeground(Color.blue);
            answersPointer++;
        }

        if (LearnWords.size() != 0) {
            if (answersPointer == LearnWords.size()) {
                answersPointer = 0;
            }
            answerField.setText("");
            wordToTranslate.setText(LearnWords.get(answersPointer));
        } else
            endScreen();
    }

    /**
     * Dodanie graficznych elementów do wyświetlanego panelu
     * @throws IOException - wyjątek
     */
    public void translationGame() throws IOException {
        answersPointer = 0;
        deletedWords = 0;
        languageChoice();
        maxScore = LearnWords.size();

        JLabel title = new JLabel();
        title.setText("Translation Game");
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("Arial", Font.PLAIN, 40));
        title.setBounds(470, 50, 500, 100);

        wordToTranslate = new JLabel();
        wordToTranslate.setText(LearnWords.get(0));
        wordToTranslate.setHorizontalTextPosition(JLabel.CENTER);
        wordToTranslate.setForeground(new Color(255, 255, 255));
        wordToTranslate.setFont(new Font("Arial", Font.PLAIN, 35));

        wordToTranslate.setBounds(500, 300, 800, 50);//w:200


        answerField = new JTextField();
        answerField.setBounds(520, 390, 150, 50);
        answerField.setFont(new Font("Arial", Font.PLAIN, 20));
        answerField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                word = answerField.getText();
                translationEngine();
            }
        });

        Score = new JLabel();
        Score.setText("Your Score: " + deletedWords + "/" + maxScore);
        Score.setForeground(new Color(255, 255, 255));
        Score.setFont(new Font("Arial", Font.PLAIN, 30));
        Score.setBounds(495, 490, 500, 100);

        answerResult = new JLabel();
        answerResult.setText("");
        answerResult.setFont(new Font("Arial", Font.PLAIN, 30));
        answerResult.setBounds(700, 360, 200, 100);

        correctResult = new JLabel();
        correctResult.setText("");
        correctResult.setFont(new Font("Arial", Font.PLAIN, 30));
        correctResult.setBounds(700,400,300,100);


        JButton buttonExit = MenuGUI.setButton(50, 50, 100, 50);
        buttonExit.setText("Return");
        buttonExit.addActionListener(e -> returnMenu(traslationGamePanel));

        traslationGamePanel = new MenuGUI.Panel();
        traslationGamePanel.setLayout(null);
        traslationGamePanel.add(title);
        traslationGamePanel.add(wordToTranslate);
        traslationGamePanel.add(answerField);
        traslationGamePanel.add(correctResult);
        traslationGamePanel.add(Score);
        traslationGamePanel.add(answerResult);
        traslationGamePanel.add(buttonExit);

        filenamePanel.setVisible(false);
        LoginGUI.mainFrame.add(traslationGamePanel);
    }

    /**
     * Graficzna reprezentacja ekranu końcowego(po zakończeniu gry tłumaczeniowej)
     */
    public void endScreen() {
        JLabel title = new JLabel();
        title.setText("Session ended");
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("Arial", Font.PLAIN, 40));
        title.setBounds(470, 50, 500, 100);

        JButton menuButton = MenuGUI.setButton(400, 400, 130, 50);
        menuButton.setText("Back to menu");
        menuButton.addActionListener(e -> {
            endScreenPanel.setVisible(false);
            MenuGUI.menuPanel.setVisible(true);
        });

        JButton resetButton = MenuGUI.setButton(650, 400, 130, 50);
        resetButton.setText("Reset Game");
        resetButton.addActionListener(e -> {
            endScreenPanel.setVisible(false);
            try {
                translationGame();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        endScreenPanel = new MenuGUI.Panel();
        endScreenPanel.setLayout(null);
        endScreenPanel.add(title);
        endScreenPanel.add(menuButton);
        endScreenPanel.add(resetButton);

        traslationGamePanel.setVisible(false);
        LoginGUI.mainFrame.add(endScreenPanel);
    }
}
