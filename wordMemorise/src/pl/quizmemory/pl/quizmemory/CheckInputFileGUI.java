package pl.quizmemory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class CheckInputFileGUI {

    public static JPanel filenamePanel;
    public static JPanel checkInputFilePanel;
    public static JTextArea textArea;

    public static void filenameGUI(){ //moze da sie to zrobic tak zeby tworzyc znowu takiej funkcji tylko uzyc jej z innej klasy

        JLabel title=new JLabel();
        title.setText("Check input file");
        //title.setHorizontalTextPosition(JLabel.CENTER);
        //title.setVerticalTextPosition(JLabel.TOP);
        title.setForeground(new Color(255,255,255));
        title.setFont(new Font("Arial",Font.PLAIN,40));
        //title.setVerticalAlignment(JLabel.CENTER);
        //title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(450,50,300,100);

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
                addContentToFile(e,textField,buttonFile);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        filenamePanel=new FlashcardsGUI.Panel();
        filenamePanel.setLayout(null);
        filenamePanel.add(title);
        filenamePanel.add(text1);
        filenamePanel.add(textField);
        filenamePanel.add(buttonFile);

        MenuGUI.menuPanel.setVisible(false);
        MenuGUI.mainFrame.add(filenamePanel);
    }

    public static void checkInputFileGUI(){

        JLabel title=new JLabel();
        title.setText("Delete file");
        //title.setHorizontalTextPosition(JLabel.CENTER);
        //title.setVerticalTextPosition(JLabel.TOP);
        title.setForeground(new Color(255,255,255));
        title.setFont(new Font("Arial",Font.PLAIN,40));
        //title.setVerticalAlignment(JLabel.CENTER);
        //title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(500,50,200,100);

        textArea=new JTextArea();
        textArea.setBackground(new Color(0,0,51));
        textArea.setForeground(new Color(255,255,255));
        textArea.setFont(new Font("Arial",Font.PLAIN,20));
        textArea.setBounds(250,200,800,500);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        addWordsToTextField();

        JScrollPane scrollPane=new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        checkInputFilePanel=new Panel();
        checkInputFilePanel.setLayout(null);
        checkInputFilePanel.add(title);
        checkInputFilePanel.add(textArea);
        checkInputFilePanel.add(scrollPane);

        MenuGUI.mainFrame.add(checkInputFilePanel);
    }

    public static void addWordsToTextField(){
        for(int i=0; i<WordList.plWords.size(); i++) {
            textArea.append(WordList.plWords.get(i) + " - " + WordList.enWords.get(i) + "\n");
        }

    }
    public static void addContentToFile(ActionEvent e, JTextField textField, JButton buttonFile) throws IOException {
        if(e.getSource()==buttonFile){
            String fileName=textField.getText();
            WordList.addWordsToListTest(CreateFile.checkFileName(fileName));
            filenamePanel.setVisible(false);
            checkInputFileGUI();
        }
    }

    public static class Panel extends JPanel {
        Panel() {
            //background color
            this.setBackground(new Color(0, 0, 51));
            this.setBounds(0,0,1200,900);
        }
    }
}
