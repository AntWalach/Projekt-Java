package pl.quizmemory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TranslationGUI {

    static MenuGUI.Panel filenamePanel;
    static MenuGUI.Panel traslationGamePanel;
    static JRadioButton PLtoEN;
    static JRadioButton ENtoPL;
    static JLabel wordToTranslate;
    static JTextField answerField;
    static JButton checkButton;

    public static void filenameGUI_COPY(){
        //to jest kopia funckji znajdującej się w flashcardsGUI
        //(POTRZEBNA OPTYMALIZACJA!)
        JLabel title=new JLabel();
        title.setText("Transition Game");
        title.setForeground(new Color(255,255,255));
        title.setFont(new Font("Arial",Font.PLAIN,40));
        title.setBounds(470,50,500,100);

        JLabel text1=new JLabel();
        text1.setText("Enter file name:");
        text1.setHorizontalTextPosition(JLabel.CENTER);
        text1.setForeground(new Color(255,255,255));
        text1.setFont(new Font("Arial",Font.PLAIN,25));
        text1.setBounds(500,300,200,100);

        JButton buttonFile=MenuGUI.setButton(550,500,100,50);
        buttonFile.setText("Submit");

        JTextField textField = new JTextField();
        textField.setBounds(500,400,200,50);
        textField.setFont(new Font("Arial",Font.PLAIN,20));
        buttonFile.addActionListener(e-> {
            try {
                saveFile_COPY(e,textField,buttonFile);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        /*Ta część jest unikalna tylko dla translation game*/
        PLtoEN = new JRadioButton("Polish - English");
        PLtoEN.setBounds(490,180,300,50);
        PLtoEN.setBackground(new Color(0,0,51));
        PLtoEN.setForeground(new Color(255,255,255));
        PLtoEN.setFont(new Font("Arial",Font.PLAIN,25));
        PLtoEN.setRequestFocusEnabled(false);
        PLtoEN.setSelected(true);
        ENtoPL = new JRadioButton("English - Polish");
        ENtoPL.setBounds(490,230,300,50);
        ENtoPL.setBackground(new Color(0,0,51));
        ENtoPL.setForeground(new Color(255,255,255));
        ENtoPL.setFont(new Font("Arial",Font.PLAIN,25));
        ENtoPL.setRequestFocusEnabled(false);

        ButtonGroup group = new ButtonGroup();
        group.add(PLtoEN);
        group.add(ENtoPL);


        filenamePanel=new MenuGUI.Panel();
        filenamePanel.setLayout(null);
        filenamePanel.add(title);
        filenamePanel.add(text1);
        filenamePanel.add(PLtoEN);
        filenamePanel.add(ENtoPL);
        filenamePanel.add(textField);
        filenamePanel.add(buttonFile);

        GameChoiceGUI.choiceMenu.setVisible(false);
        MenuGUI.mainFrame.add(filenamePanel);
    }

    public static void saveFile_COPY(ActionEvent e, JTextField textField, JButton buttonFile) throws IOException {
        //to jest kopia funckji znajdującej się w flashcardsGUI
        //(POTRZEBNA OPTYMALIZACJA!)
        if(e.getSource()==buttonFile){
            String fileName=textField.getText();
            WordList.addWordsToListTest(CreateFile.checkFileName(fileName));
            translationGame();
        }
    }

    public static void languageChoice() throws IOException {

        if(PLtoEN.isSelected())
            translation(WordList.plWords, WordList.enWords);
        else
            translation(WordList.enWords, WordList.plWords);
    }

    public static boolean compareTwoWords(String word1, String word2) {
        if (word1.equals(word2))
            return true;
        else
            return false;
    }

    public static void translation(java.util.List<String> words, java.util.List<String> words2) {
        wordToTranslate.setText(words.get(0));
        /*
        Scanner scanner = new Scanner(System.in);

        int learnedWordsCounter = 0;
        int primaryWordsNumber = words.size();
        int numberOfDeletedWords = 0;
        java.util.List<String> unlearnedWords = new ArrayList<String>();
        List<String> answerWords = new ArrayList<String>();
        unlearnedWords.addAll(words);
        answerWords.addAll(words2);

        while(unlearnedWords.size() != 0) {
            for(int i=0; i<words.size(); i++) {
                System.out.print(words.get(i));
                //System.out.print(" - translation: ");

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

         */

    }



    public static void translationGame() throws IOException {
        JLabel title=new JLabel();
        title.setText("Transition Game");
        title.setForeground(new Color(255,255,255));
        title.setFont(new Font("Arial",Font.PLAIN,40));
        title.setBounds(470,50,500,100);

        wordToTranslate=new JLabel();
        wordToTranslate.setText("");
        wordToTranslate.setHorizontalTextPosition(JLabel.CENTER);
        wordToTranslate.setForeground(new Color(255,255,255));
        wordToTranslate.setFont(new Font("Arial",Font.PLAIN,35));
        wordToTranslate.setBounds(475,330,200,100);

        JLabel dash=new JLabel();
        dash.setText("-");
        dash.setHorizontalTextPosition(JLabel.CENTER);
        dash.setForeground(new Color(255,255,255));
        dash.setFont(new Font("Arial",Font.PLAIN,35));
        dash.setBounds(585,330,200,100);

        answerField = new JTextField();
        answerField.setBounds(620,358,150,50);
        answerField.setFont(new Font("Arial",Font.PLAIN,20));

        checkButton = MenuGUI.setButton(550,450,100,50);
        checkButton.setText("Check");

        traslationGamePanel=new MenuGUI.Panel();
        traslationGamePanel.setLayout(null);
        traslationGamePanel.add(title);
        traslationGamePanel.add(wordToTranslate);
        traslationGamePanel.add(dash);
        traslationGamePanel.add(answerField);
        traslationGamePanel.add(checkButton);

        filenamePanel.setVisible(false);
        MenuGUI.mainFrame.add(traslationGamePanel);


        languageChoice();
    }
}
