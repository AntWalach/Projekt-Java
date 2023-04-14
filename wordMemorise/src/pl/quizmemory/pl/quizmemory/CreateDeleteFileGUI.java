package pl.quizmemory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class CreateDeleteFileGUI {

    public static Panel choicePanel;
    public static Panel createPanel;
    public static Panel deletePanel;


    public static void choicePanelGUI(){
        JLabel title=new JLabel();
        title.setText("Choose option");
        //title.setHorizontalTextPosition(JLabel.CENTER);
        //title.setVerticalTextPosition(JLabel.TOP);
        title.setForeground(new Color(255,255,255));
        title.setFont(new Font("Arial",Font.PLAIN,40));
        //title.setVerticalAlignment(SwingConstants.CENTER);
        //title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(500,50,300,100);


        JButton buttonCreate=MenuGUI.setButton(500,300,200,100);
        JButton buttonDelete=MenuGUI.setButton(500,500,200,100);
        buttonCreate.setText("Create file");
        buttonDelete.setText("Delete file");

        buttonCreate.addActionListener(e -> createFileGUI());
        buttonDelete.addActionListener(e -> deleteFileGUI());

        choicePanel=new Panel();
        choicePanel.setLayout(null);
        choicePanel.add(title);
        choicePanel.add(buttonCreate);
        choicePanel.add(buttonDelete);

        MenuGUI.menuPanel.setVisible(false);
        MenuGUI.mainFrame.add(choicePanel);
    }

    public static void createFileGUI(){
        JLabel title=new JLabel();
        title.setText("Create file");
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

        JButton buttonFile=MenuGUI.setButton(550,500,100,50);
        buttonFile.setText("Submit");

        JTextField textField = new JTextField();
        //textField.setPreferredSize(new Dimension(250,40));
        textField.setBounds(500,400,200,50);
        textField.setFont(new Font("Arial",Font.PLAIN,20));
        buttonFile.addActionListener(e-> {
            try {
                createFile(e,textField,buttonFile);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        createPanel=new Panel();
        createPanel.setLayout(null);
        createPanel.add(title);
        createPanel.add(text1);
        createPanel.add(textField);
        createPanel.add(buttonFile);

        choicePanel.setVisible(false);
        MenuGUI.mainFrame.add(createPanel);
    }

    public static void deleteFileGUI(){
        JLabel title=new JLabel();
        title.setText("Delete file");
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

        JButton buttonFile=MenuGUI.setButton(550,500,100,50);
        buttonFile.setText("Submit");

        JTextField textField = new JTextField();
        //textField.setPreferredSize(new Dimension(250,40));
        textField.setBounds(500,400,200,50);
        textField.setFont(new Font("Arial",Font.PLAIN,20));
        buttonFile.addActionListener(e-> {
            try {
                deleteFile(e,textField,buttonFile);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        deletePanel=new Panel();
        deletePanel.setLayout(null);
        deletePanel.add(title);
        deletePanel.add(text1);
        deletePanel.add(textField);
        deletePanel.add(buttonFile);

        choicePanel.setVisible(false);
        MenuGUI.mainFrame.add(deletePanel);
    }

    public static void createFile(ActionEvent e, JTextField textField, JButton buttonFile) throws IOException {
        if(e.getSource()==buttonFile){
            String fileName=textField.getText();
            CreateFile.createFile(fileName);
            createPanel.setVisible(false);
            MenuGUI.menuPanel.setVisible(true);
        }
    }

    public static void deleteFile(ActionEvent e, JTextField textField, JButton buttonFile) throws IOException {
        if(e.getSource()==buttonFile){
            String fileName=textField.getText();
            CreateFile.deleteFile(fileName);
            deletePanel.setVisible(false);
            MenuGUI.menuPanel.setVisible(true);
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
