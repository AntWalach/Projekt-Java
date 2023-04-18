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

public class AddContentToFileGUI {

    public static JPanel filenamePanel;
    public static JPanel addContentToFilePanel;
    public static JPanel editFileContentPanel;
    public static String fileName;
    public static JTextArea changeFileTextArea;

    public static void filenameGUI(){ //moze da sie to zrobic tak zeby tworzyc znowu takiej funkcji tylko uzyc jej z innej klasy

        JLabel title=new JLabel();
        title.setText("Add content to a file");
        //title.setHorizontalTextPosition(JLabel.CENTER);
        //title.setVerticalTextPosition(JLabel.TOP);
        title.setForeground(new Color(255,255,255));
        title.setFont(new Font("Arial",Font.PLAIN,40));
        //title.setVerticalAlignment(JLabel.CENTER);
        //title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(450,50,400,100);

        JLabel text1=new JLabel();
        text1.setText("Enter file name:");
        text1.setHorizontalTextPosition(JLabel.CENTER);
        //text1.setVerticalTextPosition(JLabel.TOP);
        text1.setForeground(new Color(255,255,255));
        text1.setFont(new Font("Arial",Font.PLAIN,25));
        text1.setBounds(500,300,200,100);

        JButton buttonFile=MenuGUI.setButton(550,500,100,50);
        buttonFile.setText("Submit");

        JTextField textField = new JTextField();
        //textField.setPreferredSize(new Dimension(250,40));
        textField.setBounds(500,400,200,50);
        textField.setFont(new Font("Arial",Font.PLAIN,20));
        buttonFile.addActionListener(e-> {
            try {
                openFile(e,textField,buttonFile);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        filenamePanel=new MenuGUI.Panel();
        filenamePanel.setLayout(null);
        filenamePanel.add(title);
        filenamePanel.add(text1);
        filenamePanel.add(textField);
        filenamePanel.add(buttonFile);

        MenuGUI.menuPanel.setVisible(false);
        MenuGUI.mainFrame.add(filenamePanel);
    }
    public static void addContentToFileGUI(){
        JLabel title=new JLabel();
        title.setText("Add words");
        //title.setHorizontalTextPosition(JLabel.CENTER);
        //title.setVerticalTextPosition(JLabel.TOP);
        title.setForeground(new Color(255,255,255));
        title.setFont(new Font("Arial",Font.PLAIN,40));
        //title.setVerticalAlignment(JLabel.CENTER);
        //title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(500,50,300,100);

        JButton buttonSubmit=MenuGUI.setButton(550,500,100,50);
        buttonSubmit.setText("Submit");

        JTextField textField1 = new JTextField();
        textField1.setBounds(500,300,200,50);
        textField1.setFont(new Font("Arial",Font.PLAIN,20));
        JTextField textField2 = new JTextField();
        textField2.setBounds(500,400,200,50);
        textField2.setFont(new Font("Arial",Font.PLAIN,20));

        buttonSubmit.addActionListener(e-> {
            try {
                addContentToFile(e,textField1,textField2,buttonSubmit);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                try {
                    addContentToFileKey(e, textField1,textField2);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        textField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                try {
                    addContentToFileKey(e, textField1,textField2);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        addContentToFilePanel=new MenuGUI.Panel();
        addContentToFilePanel.setLayout(null);
        addContentToFilePanel.add(title);
        addContentToFilePanel.add(textField1);
        addContentToFilePanel.add(textField2);
        addContentToFilePanel.add(buttonSubmit);

        MenuGUI.mainFrame.add(addContentToFilePanel);
    }

    public static void editContentFileGUI(){
        JLabel title=new JLabel();
        title.setText("Edit input file");
        //title.setHorizontalTextPosition(JLabel.CENTER);
        //title.setVerticalTextPosition(JLabel.TOP);
        title.setForeground(new Color(255,255,255));
        title.setFont(new Font("Arial",Font.PLAIN,40));
        //title.setVerticalAlignment(JLabel.CENTER);
        //title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(500,50,300,100);

        changeFileTextArea=new JTextArea();
        changeFileTextArea.setBackground(new Color(255,255,255));
        changeFileTextArea.setForeground(new Color(0,0,0));
        changeFileTextArea.setFont(new Font("Arial",Font.PLAIN,20));
        changeFileTextArea.setLineWrap(true);
        addWordsToTextField();
        changeFileTextArea.setCaretPosition(0);

        JScrollPane scrollPane=new JScrollPane(changeFileTextArea, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(250,200,700,500);
        //scrollPane.setBorder(BorderFactory.createEmptyBorder());

        JButton buttonSubmit=MenuGUI.setButton(550,750,100,50);
        buttonSubmit.setText("Submit");

        buttonSubmit.addActionListener(e->{
            try {
                changeText(e,changeFileTextArea,buttonSubmit);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        editFileContentPanel=new MenuGUI.Panel();
        editFileContentPanel.setLayout(null);
        editFileContentPanel.add(title);
        editFileContentPanel.add(scrollPane);
        editFileContentPanel.add(buttonSubmit);

        MenuGUI.mainFrame.add(editFileContentPanel);
    }

    public static void openFile(ActionEvent e, JTextField textField, JButton buttonFile) throws IOException {
        if(e.getSource()==buttonFile){
            fileName=textField.getText();
            filenamePanel.setVisible(false);
            addContentToFileGUI();
            //editContentFileGUI();
        }
    }

    public static void addContentToFile(ActionEvent e, JTextField textField1, JTextField textField2, JButton button) throws IOException {
        if(e.getSource()==button){
            if(!Objects.equals(textField1.getText(), "") && !Objects.equals(textField2.getText(), "")) {
                String plWord = textField1.getText();
                String enWord = textField2.getText();
                CreateFile.addContentToFile(fileName, plWord, enWord);
            }
            textField1.setText(null);
            textField2.setText(null);
            textField1.repaint();
            textField2.repaint();
            textField1.requestFocus();
            addContentToFileGUI();
        }
    }

    public static void addContentToFileKey(KeyEvent e, JTextField textField1, JTextField textField2) throws IOException {
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            if(!Objects.equals(textField1.getText(), "") && !Objects.equals(textField2.getText(), "")) {
                String plWord = textField1.getText();
                String enWord = textField2.getText();
                CreateFile.addContentToFile(fileName, plWord, enWord);
            }
            textField1.setText(null);
            textField2.setText(null);
            textField1.repaint();
            textField2.repaint();
            textField1.requestFocus();
            addContentToFileGUI();
        }
    }

    public static void addWordsToTextField(){
        for(int i=0; i<WordList.plWords.size()-1; i++) {
            changeFileTextArea.append(WordList.plWords.get(i).trim() + "," + WordList.enWords.get(i).trim() + "\n");
        }
    }

    public static void changeText(ActionEvent e, JTextArea textArea, JButton button) throws IOException {
        if(e.getSource()==button){
            File file= new File(CreateFile.checkFileName(fileName));
            String filePath = file.getAbsolutePath();

            BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath));
            writer.write(textArea.getText());

        }
    }
}
