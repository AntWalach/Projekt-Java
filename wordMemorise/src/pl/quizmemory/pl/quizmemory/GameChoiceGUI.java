package pl.quizmemory;

import javax.swing.*;
import java.awt.*;

public class GameChoiceGUI {

    static MenuGUI.Panel choiceMenu;
    static JButton transGameButton;
    static JButton flashcardsGameButton;


    public static void gamesMenu(){
        JLabel title=new JLabel();
        title.setText("Games");
        title.setForeground(new Color(255,255,255));
        title.setFont(new Font("Arial",Font.PLAIN,40));
        title.setBounds(520,50,200,100);

        JLabel text1=new JLabel();
        text1.setText("Choose game:");
        text1.setHorizontalTextPosition(JLabel.CENTER);
        text1.setForeground(new Color(255,255,255));
        text1.setFont(new Font("Arial",Font.PLAIN,25));
        text1.setBounds(500,250,200,100);

        transGameButton = MenuGUI.setButton(350,370,200,100);
        transGameButton.setText("Translation game");
        transGameButton.setFont(new Font("Arial",Font.BOLD,15));

        flashcardsGameButton = MenuGUI.setButton(630,370,200,100);
        flashcardsGameButton.setText("Flashcards game");
        flashcardsGameButton.setFont(new Font("Arial",Font.BOLD,15));

        transGameButton.addActionListener(e-> TranslationGUI.translationGame());
        flashcardsGameButton.addActionListener(e-> FlashcardsGUI.filenameGUI());


        choiceMenu = new MenuGUI.Panel();
        choiceMenu.setLayout(null);
        choiceMenu.setBackground(new Color(0, 0, 51));
        choiceMenu.add(title);
        choiceMenu.add(text1);
        choiceMenu.add(transGameButton);
        choiceMenu.add(flashcardsGameButton);

        MenuGUI.menuPanel.setVisible(false);

        MenuGUI.mainFrame.add(choiceMenu);
    }

}
