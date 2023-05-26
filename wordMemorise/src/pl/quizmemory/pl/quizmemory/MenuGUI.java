package pl.quizmemory;

import javax.swing.*;
import java.awt.*;

import static pl.quizmemory.LoginGUI.mainFrame;

public class MenuGUI {

    //protected static Frame mainFrame;
    protected static Panel menuPanel;
    protected static JButton buttonCreateDeleteFile;
    protected static JButton buttonCheckInputFile;
    protected static JButton buttonAddContentToFile;
    protected static JButton buttonEditFile;
    protected static JButton buttonGames;

    public void menuGUI() {

        JLabel title = new JLabel();
        title.setText("Word Game");
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("Arial", Font.PLAIN, 40));
        title.setBounds(500, 50, 400, 100);

        buttonCreateDeleteFile = setButton(300, 250, 200, 100);
        buttonCheckInputFile = setButton(700, 250, 200, 100);
        buttonAddContentToFile = setButton(300, 400, 200, 100);
        buttonEditFile = setButton(700, 400, 200, 100);
        buttonGames = setButton(300, 550, 600, 150);

        buttonCreateDeleteFile.setText("Create/delete file");
        buttonCheckInputFile.setText("Check input file");
        buttonAddContentToFile.setText("Add content to a file");
        buttonEditFile.setText("Edit file");
        buttonGames.setText("GAMES!");


        buttonCreateDeleteFile.addActionListener(e -> {
            CreateDeleteFileGUI createDeleteFileGUI = new CreateDeleteFileGUI();
        });
        buttonCheckInputFile.addActionListener(e -> {
            CheckInputFileGUI checkInputFileGUI = new CheckInputFileGUI();
        });
        buttonAddContentToFile.addActionListener(e -> {
            AddContentToFileGUI addContentToFileGUI = new AddContentToFileGUI();
        });
        buttonEditFile.addActionListener(e -> {
            EditFileGUI editFileGUI = new EditFileGUI();
        });
        buttonGames.addActionListener(e -> {
            GameChoiceGUI gameChoiceGUI = new GameChoiceGUI();
        });

        menuPanel = new Panel();

        //mainFrame = new Frame(); //tu mozliwe ze przez to sie rozjezdza po wcisnieciu return, trzeba sprobowac w mainie to wywolac
        mainFrame.setLayout(null);

        menuPanel.add(title);
        menuPanel.add(buttonCreateDeleteFile);
        menuPanel.add(buttonCheckInputFile);
        menuPanel.add(buttonAddContentToFile);
        menuPanel.add(buttonEditFile);
        menuPanel.add(buttonGames);
        mainFrame.add(menuPanel);
        mainFrame.setVisible(true);
        LoginGUI.panelLogin.setVisible(false);
    }

    public static JButton setButton(int x, int y, int width, int height) {
        JButton newButton = new JButton();
        newButton.setBounds(x, y, width, height);
        newButton.setFocusable(false);

        return newButton;
    }

    public static class Panel extends JPanel {
        Panel() {
            //background color
            this.setBackground(new Color(0, 0, 51));
            this.setBounds(0, 0, 1200, 900);
        }
    }

    public static class Frame extends JFrame {
        Frame() {

            //frame basics
            this.setTitle("Word Game");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false); //optional
            this.setSize(1200, 900);
            //this.setVisible(true);

            //icon
            ImageIcon windowIcon = new ImageIcon("w.png");
            this.setIconImage(windowIcon.getImage());

            //background color
            this.getContentPane().setBackground(new Color(0, 0, 51));
        }
    }
}
