package pl.quizmemory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class FlashcardsGUI{

    static Panel flashcardPanel;
    static Panel filenamePanel;
    static JButton button1;
    static JButton button2;
    static JButton button3;
    static JButton button4;
    static JButton buttonCard;

    public static void filenameGUI(){

        JLabel title=new JLabel();
        title.setText("Flashcards");
        //title.setHorizontalTextPosition(JLabel.CENTER);
        //title.setVerticalTextPosition(JLabel.TOP);
        title.setForeground(new Color(255,255,255));
        title.setFont(new Font("Arial",Font.PLAIN,40));
        //title.setVerticalAlignment(JLabel.CENTER);
        //title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(500,50,200,100);

        JLabel text1=new JLabel();
        text1.setText("Enter file name:");
        text1.setHorizontalTextPosition(JLabel.CENTER);
        //text1.setVerticalTextPosition(JLabel.TOP);
        text1.setForeground(new Color(255,255,255));
        text1.setFont(new Font("Arial",Font.PLAIN,25));
        text1.setBounds(500,300,200,100);

        JButton buttonFile=new JButton("Submit");
        buttonFile.setBounds(550,500,100,50);


        JTextField textField = new JTextField();
        //textField.setPreferredSize(new Dimension(250,40));
        textField.setBounds(500,400,200,50);
        textField.setFont(new Font("Arial",Font.PLAIN,20));
        buttonFile.addActionListener(e-> {
            try {
                saveFile(e,textField,buttonFile);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        filenamePanel=new Panel();
        filenamePanel.setLayout(null);
        filenamePanel.add(title);
        filenamePanel.add(text1);
        filenamePanel.add(textField);
        filenamePanel.add(buttonFile);

        MenuGUI.menuPanel.setVisible(false);
        MenuGUI.mainFrame.add(filenamePanel);
    }

    public static void saveFile(ActionEvent e, JTextField textField, JButton buttonFile) throws IOException {
        if(e.getSource()==buttonFile){
            String fileName=textField.getText();
            WordList.addWordsToListTest(CreateFile.checkFileName(fileName));
            flashcardsGUI();
        }
    }

    public static void flashcardsGUI(){

        JLabel title=new JLabel();
        title.setText("Flashcards");
        //title.setHorizontalTextPosition(JLabel.CENTER);
        //title.setVerticalTextPosition(JLabel.TOP);
        title.setForeground(new Color(255,255,255));
        title.setFont(new Font("Arial",Font.PLAIN,40));
        //title.setVerticalAlignment(JLabel.CENTER);
        //title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(500,50,200,100);

        button1=new JButton();
        button2=new JButton();
        button3=new JButton();
        button4=new JButton();
        buttonCard=new JButton();
        JButton buttonExit=new JButton("Return");
        button1.setBounds(150,400,100,50);
        button2.setBounds(950,400,100,50);
        button3.setBounds(450,700,100,50);
        button4.setBounds(650,700,100,50);
        buttonExit.setBounds(50,50,100,50);

        buttonCard.setBounds(350,200,500,450);
        buttonCard.setText("Click to start");
        buttonCard.setFont(new Font("Arial",Font.BOLD,30));

        ImageIcon arrowLeft=new ImageIcon("arrowLeft.png");
        ImageIcon arrowRight=new ImageIcon("arrowRight.png");
        ImageIcon correctIcon=new ImageIcon("correctIcon.png");
        ImageIcon wrongIcon=new ImageIcon("wrongIcon.png");
        //resizing icons
        Image image1 = arrowLeft.getImage();
        Image newimage1 = image1.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
        arrowLeft = new ImageIcon(newimage1);
        Image image2 = arrowRight.getImage();
        Image newimage2 = image2.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
        arrowRight = new ImageIcon(newimage2);
        Image image3 = wrongIcon.getImage();
        Image newimage3 = image3.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
        wrongIcon = new ImageIcon(newimage3);
        Image image4 = correctIcon.getImage();
        Image newimage4 = image4.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
        correctIcon = new ImageIcon(newimage4);

        button1.setIcon(arrowLeft);
        button2.setIcon(arrowRight);
        button3.setIcon(wrongIcon);
        button4.setIcon(correctIcon);
        button1.setFocusable(false);
        button2.setFocusable(false);
        button3.setFocusable(false);
        button4.setFocusable(false);
        buttonCard.setFocusable(false);
        buttonExit.setFocusable(false);
        button1.addActionListener(e-> FlashcardsGame.previousCard());
        button2.addActionListener(e-> FlashcardsGame.nextCard());
        button3.addActionListener(e-> System.out.println("wrong"));
        button4.addActionListener(e-> System.out.println("correct"));
        buttonCard.addActionListener(e-> FlashcardsGame.flipCard());
        buttonExit.addActionListener(e-> returnMenu());

        flashcardPanel = new Panel();
        flashcardPanel.setLayout(null);
        flashcardPanel.add(title);
        flashcardPanel.add(button1);
        flashcardPanel.add(button2);
        flashcardPanel.add(button3);
        flashcardPanel.add(button4);
        flashcardPanel.add(buttonCard);
        flashcardPanel.add(buttonExit);

        filenamePanel.setVisible(false);
        MenuGUI.mainFrame.add(flashcardPanel);
    }

    public static void returnMenu()
    {
        flashcardPanel.setVisible(false);
        MenuGUI.menuPanel.setVisible(true);
    }

    public static class Panel extends JPanel{
        Panel() {
            //background color
            this.setBackground(new Color(0, 0, 51));
            this.setBounds(0,0,1200,900);
        }
    }
}
