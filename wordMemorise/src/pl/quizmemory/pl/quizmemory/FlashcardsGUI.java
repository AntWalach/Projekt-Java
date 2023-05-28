package pl.quizmemory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class FlashcardsGUI extends CreateFile {

    static MenuGUI.Panel flashcardPanel;
    static JButton button1;
    static JButton button2;
    static JButton button3;
    static JButton buttonCard;

    FlashcardsGUI() {
        filenameGUI();
    }

    public void action(ActionEvent e, JTextField textField, JButton buttonFile) throws IOException {
        if (e.getSource() == buttonFile) {
            String fileName = textField.getText();
            WordList.addWordsToList(this.checkFileName(fileName));
            flashcardsGUI();
        }
    }

    public void flashcardsGUI() {

        JLabel title = new JLabel();
        title.setText("Flashcards");
        //title.setHorizontalTextPosition(JLabel.CENTER);
        //title.setVerticalTextPosition(JLabel.TOP);
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("Arial", Font.PLAIN, 40));
        //title.setVerticalAlignment(JLabel.CENTER);
        //title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(500, 50, 200, 100);

        button1 = MenuGUI.setButton(150, 400, 100, 50);
        button2 = MenuGUI.setButton(950, 400, 100, 50);
        //button3 = MenuGUI.setButton(450, 700, 100, 50);
        button3 = MenuGUI.setButton(475, 700, 250, 50);
        JButton buttonExit = MenuGUI.setButton(50, 50, 100, 50);


        buttonCard = MenuGUI.setButton(350, 200, 500, 450);
        buttonCard.setText("Click to flip card");
        buttonCard.setFont(new Font("Arial", Font.BOLD, 30));

        buttonExit.setText("Return");

        ImageIcon arrowLeft = new ImageIcon("arrowLeft.png");
        ImageIcon arrowRight = new ImageIcon("arrowRight.png");
        ImageIcon correctIcon = new ImageIcon("correctIcon.png");
        //resizing icons
        Image image1 = arrowLeft.getImage();
        Image newimage1 = image1.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        arrowLeft = new ImageIcon(newimage1);
        Image image2 = arrowRight.getImage();
        Image newimage2 = image2.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        arrowRight = new ImageIcon(newimage2);
        Image image4 = correctIcon.getImage();
        Image newimage4 = image4.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        correctIcon = new ImageIcon(newimage4);
        button1.setIcon(arrowLeft);
        button2.setIcon(arrowRight);
        button3.setIcon(correctIcon);
        button3.setText("Learned");
        button3.setFont(new Font("Arial",Font.PLAIN,20));

        FlashcardsGame flashcardsGame = new FlashcardsGame();

        button1.addActionListener(e -> flashcardsGame.previousCard());
        button2.addActionListener(e -> flashcardsGame.nextCard());
        button3.addActionListener(e -> flashcardsGame.learned());
        buttonCard.addActionListener(e -> flashcardsGame.flipCard());
        buttonExit.addActionListener(e -> returnMenu(flashcardPanel));

        flashcardPanel = new MenuGUI.Panel();
        flashcardPanel.setLayout(null);
        flashcardPanel.add(title);
        flashcardPanel.add(button1);
        flashcardPanel.add(button2);
        flashcardPanel.add(button3);
        flashcardPanel.add(buttonCard);
        flashcardPanel.add(buttonExit);

        filenamePanel.setVisible(false);
        LoginGUI.mainFrame.add(flashcardPanel);
    }
}
