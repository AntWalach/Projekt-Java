package pl.quizmemory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class AddContentToFileGUI extends CreateFile {

    public static JPanel filenamePanel;
    public static JPanel addContentToFilePanel;
    public static String fileName;


    AddContentToFileGUI() {
        filenameGUI();
    }

    public void filenameGUI() { //moze da sie to zrobic tak zeby tworzyc znowu takiej funkcji tylko uzyc jej z innej klasy

        JLabel title = new JLabel();
        title.setText("Add content to a file");
        //title.setHorizontalTextPosition(JLabel.CENTER);
        //title.setVerticalTextPosition(JLabel.TOP);
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("Arial", Font.PLAIN, 40));
        //title.setVerticalAlignment(JLabel.CENTER);
        //title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(450, 50, 400, 100);

        JLabel text1 = new JLabel();
        text1.setText("Enter file name:");
        text1.setHorizontalTextPosition(JLabel.CENTER);
        //text1.setVerticalTextPosition(JLabel.TOP);
        text1.setForeground(new Color(255, 255, 255));
        text1.setFont(new Font("Arial", Font.PLAIN, 25));
        text1.setBounds(500, 300, 200, 100);

        JButton buttonFile = MenuGUI.setButton(550, 500, 100, 50);
        buttonFile.setText("Submit");

        JTextField textField = new JTextField();
        //textField.setPreferredSize(new Dimension(250,40));
        textField.setBounds(500, 400, 200, 50);
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        buttonFile.addActionListener(e -> {
            try {
                openFile(e, textField, buttonFile);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        filenamePanel = new MenuGUI.Panel();
        filenamePanel.setLayout(null);
        filenamePanel.add(title);
        filenamePanel.add(text1);
        filenamePanel.add(textField);
        filenamePanel.add(buttonFile);

        MenuGUI.menuPanel.setVisible(false);
        LoginGUI.mainFrame.add(filenamePanel);
    }

    public void addContentToFileGUI() {
        JLabel title = new JLabel();
        title.setText("Add words");
        //title.setHorizontalTextPosition(JLabel.CENTER);
        //title.setVerticalTextPosition(JLabel.TOP);
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("Arial", Font.PLAIN, 40));
        //title.setVerticalAlignment(JLabel.CENTER);
        //title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(500, 50, 300, 100);

        JButton buttonSubmit = MenuGUI.setButton(550, 500, 100, 50);
        buttonSubmit.setText("Submit");

        JTextField textField1 = new JTextField();
        textField1.setBounds(500, 300, 200, 50);
        textField1.setFont(new Font("Arial", Font.PLAIN, 20));
        JTextField textField2 = new JTextField();
        textField2.setBounds(500, 400, 200, 50);
        textField2.setFont(new Font("Arial", Font.PLAIN, 20));

        buttonSubmit.addActionListener(e -> {
            try {
                addContentToFile(e, textField1, textField2, buttonSubmit);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                try {
                    addContentToFileKey(e, textField1, textField2);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        textField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                try {
                    addContentToFileKey(e, textField1, textField2);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        JButton buttonExit = MenuGUI.setButton(50, 50, 100, 50);
        buttonExit.setText("Return");
        buttonExit.addActionListener(e -> returnMenu());

        addContentToFilePanel = new MenuGUI.Panel();
        addContentToFilePanel.setLayout(null);
        addContentToFilePanel.add(title);
        addContentToFilePanel.add(textField1);
        addContentToFilePanel.add(textField2);
        addContentToFilePanel.add(buttonSubmit);
        addContentToFilePanel.add(buttonExit);

        LoginGUI.mainFrame.add(addContentToFilePanel);
    }


    public void openFile(ActionEvent e, JTextField textField, JButton buttonFile) throws IOException {
        if (e.getSource() == buttonFile) {
            fileName = textField.getText();
            filenamePanel.setVisible(false);
            addContentToFileGUI();
        }
    }

    public void addContentToFile(ActionEvent e, JTextField textField1, JTextField textField2, JButton button) throws IOException {
        if (e.getSource() == button) {
            if (!Objects.equals(textField1.getText(), "") && !Objects.equals(textField2.getText(), "")) {
                String plWord = textField1.getText();
                String enWord = textField2.getText();
                this.addContentToFile(fileName, plWord, enWord);
            }
            textField1.setText(null);
            textField2.setText(null);
            textField1.repaint();
            textField2.repaint();
            textField1.requestFocus();
            addContentToFileGUI();
        }
    }

    public void addContentToFileKey(KeyEvent e, JTextField textField1, JTextField textField2) throws IOException {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!Objects.equals(textField1.getText(), "") && !Objects.equals(textField2.getText(), "")) {
                String plWord = textField1.getText();
                String enWord = textField2.getText();
                this.addContentToFile(fileName, plWord, enWord);
            }
            textField1.setText(null);
            textField2.setText(null);
            textField1.repaint();
            textField2.repaint();
            textField1.requestFocus();
            addContentToFileGUI();
        }
    }

    public static void returnMenu() {
        addContentToFilePanel.setVisible(false);
        MenuGUI.menuPanel.setVisible(true);
    }
}