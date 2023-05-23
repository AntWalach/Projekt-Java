package pl.quizmemory;

import javax.swing.*;
import java.awt.*;

public class MenuGUI {

    static Frame mainFrame;
    static Panel menuPanel;
    static JButton buttonCreateDeleteFile;
    static JButton buttonCheckInputFile;
    static JButton buttonAddContentToFile;
    static JButton buttonEditFile;
    static JButton buttonGames;

    public static void menuGUI(){

        JLabel title=new JLabel();
        title.setText("Word Game");
        title.setForeground(new Color(255,255,255));
        title.setFont(new Font("Arial",Font.PLAIN,40));
        title.setBounds(500,50,400,100);

        buttonCreateDeleteFile =setButton(300,250,200,100);
        buttonCheckInputFile =setButton(700,250,200,100);
        buttonAddContentToFile =setButton(300,400,200,100);
        buttonEditFile =setButton(700,400,200,100);
        buttonGames=setButton(300,550,600,150);

        buttonCreateDeleteFile.setText("Create/delete file");
        buttonCheckInputFile.setText("Check input file");
        buttonAddContentToFile.setText("Add content to a file");
        buttonEditFile.setText("Edit file");
        buttonGames.setText("GAMES!");

        /*
        button1.addActionListener(e-> System.out.println("1"));
        button2.addActionListener(e-> System.out.println("2"));
        button3.addActionListener(e-> System.out.println("3"));
        button4.addActionListener(e-> System.out.println("4"));
        buttonGames.addActionListener(e-> GameChoiceGUI.gamesMenu());
        */
        buttonCreateDeleteFile.addActionListener(e-> CreateDeleteFileGUI.choicePanelGUI());
        buttonCheckInputFile.addActionListener(e-> CheckInputFileGUI.filenameGUI());
        buttonAddContentToFile.addActionListener(e-> AddContentToFileGUI.filenameGUI());
        buttonEditFile.addActionListener(e-> EditFileGUI.filenameGUI());
        buttonGames.addActionListener(e-> GameChoiceGUI.gamesMenu());

        menuPanel = new Panel();

        mainFrame = new Frame(); //tu mozliwe ze przez to sie rozjezdza po wcisnieciu return, trzeba sprobowac w mainie to wywolac
        mainFrame.setLayout(null);

        menuPanel.add(title);
        menuPanel.add(buttonCreateDeleteFile);
        menuPanel.add(buttonCheckInputFile);
        menuPanel.add(buttonAddContentToFile);
        menuPanel.add(buttonEditFile);
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
