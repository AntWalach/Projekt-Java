package pl.quizmemory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TranslationGUI extends CreateFile {

    static MenuGUI.Panel filenamePanel;
    static MenuGUI.Panel traslationGamePanel;
    static MenuGUI.Panel endScreenPanel;
    static JRadioButton PLtoEN;
    static JRadioButton ENtoPL;
    static JLabel wordToTranslate;
    static JLabel Score;
    static JLabel answerResult;
    static JTextField answerField;
    static java.util.List<String> LearnWords;
    static java.util.List<String> AnswerWords;

    static int answersPointer = 0;
    static int deletedWords = 0;

    static int maxScore = 0;
    static String word;


    TranslationGUI() {
        filenameGUI_COPY();
    }

    public void filenameGUI_COPY() {
        //to jest kopia funckji znajdującej się w flashcardsGUI
        //(POTRZEBNA OPTYMALIZACJA!)
        JLabel title = new JLabel();
        title.setText("Transition Game");
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

        JTextField textField = new JTextField();
        textField.setBounds(500, 400, 200, 50);
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        buttonFile.addActionListener(e -> {
            try {
                saveFile_COPY(e, textField, buttonFile);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        /*Ta część jest unikalna tylko dla translation game*/
        PLtoEN = new JRadioButton("Polish - English");
        PLtoEN.setBounds(490, 180, 300, 50);
        PLtoEN.setBackground(new Color(0, 0, 51));
        PLtoEN.setForeground(new Color(255, 255, 255));
        PLtoEN.setFont(new Font("Arial", Font.PLAIN, 25));
        PLtoEN.setRequestFocusEnabled(false);
        PLtoEN.setSelected(true);
        ENtoPL = new JRadioButton("English - Polish");
        ENtoPL.setBounds(490, 230, 300, 50);
        ENtoPL.setBackground(new Color(0, 0, 51));
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

        GameChoiceGUI.choiceMenu.setVisible(false);
        LoginGUI.mainFrame.add(filenamePanel);
    }

    public void saveFile_COPY(ActionEvent e, JTextField textField, JButton buttonFile) throws IOException {
        //to jest kopia funckji znajdującej się w flashcardsGUI
        //(POTRZEBNA OPTYMALIZACJA!)
        if (e.getSource() == buttonFile) {
            String fileName = textField.getText();
            WordList.addWordsToListTest(this.checkFileName(fileName));
            translationGame();
        }
    }

    public void languageChoice() throws IOException {

        //naprawa złego zapisywania do pliku(w tablicy z polskimi słowami przed każdym słowem są białe znaki "\r\n")
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
        } else {
            LearnWords.addAll(WordList.enWords);
            AnswerWords.addAll(WordList.plWords);
        }
    }

    public boolean compareTwoWords(String word1, String word2) {
        if (word1.equals(word2))
            return true;
        else
            return false;
    }

    public void translationEngine() {
        if (compareTwoWords(word, AnswerWords.get(answersPointer))) {
            LearnWords.remove(answersPointer);
            AnswerWords.remove(answersPointer);
            deletedWords++;

            Score.setText("Your Score: " + deletedWords + "/" + maxScore);
            answerResult.setText("Correct");
            answerResult.setForeground(new Color(47, 250, 2));
        } else {
            answerResult.setText("Wrong");
            answerResult.setForeground(new Color(250, 9, 9));
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


    public void translationGame() throws IOException {
        answersPointer = 0;
        deletedWords = 0;
        languageChoice();
        maxScore = LearnWords.size();

        JLabel title = new JLabel();
        title.setText("Transition Game");
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("Arial", Font.PLAIN, 40));
        title.setBounds(470, 50, 500, 100);


        wordToTranslate = new JLabel();
        wordToTranslate.setText(LearnWords.get(0));
        wordToTranslate.setHorizontalTextPosition(JLabel.CENTER);
        wordToTranslate.setForeground(new Color(255, 255, 255));
        wordToTranslate.setFont(new Font("Arial", Font.PLAIN, 35));
        wordToTranslate.setBounds(520, 300, 200, 50);


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

        traslationGamePanel = new MenuGUI.Panel();
        traslationGamePanel.setLayout(null);
        traslationGamePanel.add(title);
        traslationGamePanel.add(wordToTranslate);
        traslationGamePanel.add(answerField);
        traslationGamePanel.add(Score);
        traslationGamePanel.add(answerResult);

        filenamePanel.setVisible(false);
        LoginGUI.mainFrame.add(traslationGamePanel);

    }

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
            LoginGUI.mainFrame.add(MenuGUI.menuPanel);
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
