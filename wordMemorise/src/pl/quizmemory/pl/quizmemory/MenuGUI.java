package pl.quizmemory;

import javax.swing.*;
import java.awt.*;

public class MenuGUI {

    static Frame mainFrame;
    static Panel menuPanel;
    static JButton buttonCreateDeleteFile;
    static JButton buttonCheckInputFile;
    static JButton button3;
    static JButton button4;
    static JButton buttonGames;

    public static void menuGUI(){

        JLabel title=new JLabel();
        title.setText("Word Game");
        //title.setHorizontalTextPosition(JLabel.CENTER);
        //title.setVerticalTextPosition(JLabel.TOP);
        title.setForeground(new Color(255,255,255));
        title.setFont(new Font("Arial",Font.PLAIN,40));
        //title.setVerticalAlignment(JLabel.CENTER);
        //title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(500,50,400,100);

        buttonCreateDeleteFile =setButton(300,250,200,100);
        buttonCheckInputFile =setButton(700,250,200,100);
        button3=setButton(300,400,200,100);
        button4=setButton(700,400,200,100);
        buttonGames=setButton(300,550,600,150);

        buttonCreateDeleteFile.setText("Create/delete file");
        buttonCheckInputFile.setText("Check input file");
        button3.setText("Add content to a file");
        button4.setText("View content of en/pl arrays");
        buttonGames.setText("GAMES!");

        buttonCreateDeleteFile.addActionListener(e-> CreateDeleteFileGUI.choicePanelGUI());
        buttonCheckInputFile.addActionListener(e-> CheckInputFileGUI.filenameGUI());
        button3.addActionListener(e-> AddContentToFileGUI.filenameGUI());
        button4.addActionListener(e-> System.out.println("4"));
        buttonGames.addActionListener(e-> FlashcardsGUI.filenameGUI());

        menuPanel = new Panel();

        mainFrame = new Frame();
        mainFrame.setLayout(null);

        menuPanel.add(title);
        menuPanel.add(buttonCreateDeleteFile);
        menuPanel.add(buttonCheckInputFile);
        menuPanel.add(button3);
        menuPanel.add(button4);
        menuPanel.add(buttonGames);

        mainFrame.add(menuPanel);
    }

    public static JButton setButton(int x, int y, int width, int height){
        JButton newButton = new JButton();
        newButton.setBounds(x,y,width,height);
        newButton.setFocusable(false);

        return  newButton;
    }

    public static class Panel extends JPanel{
        Panel() {
            //background color
            this.setBackground(new Color(0, 0, 51));
            this.setBounds(0,0,1200,900);
        }
    }

    public static class Frame extends JFrame {
        Frame() {

            //frame basics
            this.setTitle("Word Game");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false); //optional
            this.setSize(1200, 900);
            this.setVisible(true);

            //icon
            ImageIcon windowIcon = new ImageIcon("w.png");
            this.setIconImage(windowIcon.getImage());

            //background color
            this.getContentPane().setBackground(new Color(0, 0, 51));
        }
    }
}
