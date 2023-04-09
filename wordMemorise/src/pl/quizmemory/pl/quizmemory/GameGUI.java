package pl.quizmemory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;

public class GameGUI{

    static JButton button1;
    static JButton button2;
    static JButton button3;
    static JButton button4;
    static JButton buttonCard;

    public static void GUI(){

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
        button1.setBounds(150,400,100,50);
        button2.setBounds(950,400,100,50);
        button3.setBounds(450,700,100,50);
        button4.setBounds(650,700,100,50);
        buttonCard.setBounds(350,200,500,450);
        buttonCard.setText(" - word - ");

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
        button1.addActionListener(e-> System.out.println("previous"));
        button2.addActionListener(e-> System.out.println("next"));
        button3.addActionListener(e-> System.out.println("wrong"));
        button4.addActionListener(e-> System.out.println("correct"));
        buttonCard.addActionListener(e-> System.out.println("flip"));

        Frame mainFrame = new Frame();
        mainFrame.setLayout(null);
        mainFrame.add(title);
        mainFrame.add(button1);
        mainFrame.add(button2);
        mainFrame.add(button3);
        mainFrame.add(button4);
        mainFrame.add(buttonCard);
        //mainFrame.pack(); //adjusts size
    }

    /*@Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            System.out.println("test");
        }
    }*/

    public static class Frame extends JFrame{
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
