package pl.quizmemory;

import javax.swing.*;
import java.awt.*;

public class GameChoiceGUI {

    static Panel choiceMenu;


    public static void gamesMenu(){
        JLabel title=new JLabel();
        title.setText("Games");
        title.setForeground(new Color(255,255,255));
        title.setFont(new Font("Arial",Font.PLAIN,40));
        title.setBounds(500,50,200,100);

        JLabel text1=new JLabel();
        text1.setText("Choose game:");
        text1.setHorizontalTextPosition(JLabel.CENTER);
        text1.setForeground(new Color(255,255,255));
        text1.setFont(new Font("Arial",Font.PLAIN,25));
        text1.setBounds(500,300,200,100);

        choiceMenu = new Panel();
        choiceMenu.setLayout(null);
        choiceMenu.add(title);
        choiceMenu.add(text1);
        MenuGUI.menuPanel.setVisible(false);
        MenuGUI.mainFrame.add(choiceMenu);
    }

}
