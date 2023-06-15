package pl.quizmemory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 * Graficzna implementacja tworzenia/usuwania plików .txt
 */
public class CreateDeleteFileGUI extends CreateFile {
    private MenuGUI.Panel choicePanel;
    private MenuGUI.Panel createPanel;
    private MenuGUI.Panel deletePanel;

    /**
     * Konstruktor wywołujący funkcje choicePanelGUI
     */
    CreateDeleteFileGUI() {
        choicePanelGUI();
    }

    /**
     * Dodanie graficznych elementów do wyświetlanego panelu
     */
    public void choicePanelGUI() {
        JLabel title = new JLabel();
        title.setText("Choose option");
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("Arial", Font.PLAIN, 40));
        title.setBounds(500, 50, 300, 100);

        JButton buttonCreate = MenuGUI.setButton(500, 300, 200, 100);
        JButton buttonDelete = MenuGUI.setButton(500, 500, 200, 100);
        buttonCreate.setText("Create file");
        buttonDelete.setText("Delete file");

        buttonCreate.addActionListener(e -> createFileGUI());
        buttonDelete.addActionListener(e -> deleteFileGUI());

        JButton buttonExit = MenuGUI.setButton(50, 50, 100, 50);
        buttonExit.setText("Return");
        buttonExit.addActionListener(e -> returnMenu(choicePanel));

        choicePanel = new MenuGUI.Panel();
        choicePanel.setLayout(null);
        choicePanel.add(title);
        choicePanel.add(buttonCreate);
        choicePanel.add(buttonDelete);
        choicePanel.add(buttonExit);

        MenuGUI.menuPanel.setVisible(false);
        LoginGUI.mainFrame.add(choicePanel);
    }

    /**
     * Tworzenie nowego pliku .txt
     */
    public void createFileGUI() {
        JLabel title = new JLabel();
        title.setText("Create file");
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("Arial", Font.PLAIN, 40));
        title.setBounds(500, 50, 200, 100);

        JLabel text1 = new JLabel();
        text1.setText("Enter file name:");
        text1.setHorizontalTextPosition(JLabel.CENTER);
        text1.setForeground(new Color(255, 255, 255));
        text1.setFont(new Font("Arial", Font.PLAIN, 25));
        text1.setBounds(500, 300, 200, 100);

        JButton buttonFile = MenuGUI.setButton(550, 500, 100, 50);
        buttonFile.setText("Submit");

        JButton buttonExit = MenuGUI.setButton(50, 50, 100, 50);
        buttonExit.setText("Return");
        buttonExit.addActionListener(e -> returnMenu(createPanel));

        JTextField textField = new JTextField();
        textField.setBounds(500, 400, 200, 50);
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        buttonFile.addActionListener(e -> {
            try {
                createFile(e, textField, buttonFile);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        createPanel = new MenuGUI.Panel();
        createPanel.setLayout(null);
        createPanel.add(title);
        createPanel.add(text1);
        createPanel.add(textField);
        createPanel.add(buttonFile);
        createPanel.add(buttonExit);

        choicePanel.setVisible(false);
        LoginGUI.mainFrame.add(createPanel);
    }

    /**
     * usuwanie istniejącego pliku .txt
     */
    public void deleteFileGUI() {
        JLabel title = new JLabel();
        title.setText("Delete file");
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("Arial", Font.PLAIN, 40));
        title.setBounds(500, 50, 200, 100);

        JLabel text1 = new JLabel();
        text1.setText("Enter file name:");
        text1.setHorizontalTextPosition(JLabel.CENTER);
        text1.setForeground(new Color(255, 255, 255));
        text1.setFont(new Font("Arial", Font.PLAIN, 25));
        text1.setBounds(500, 300, 200, 100);

        JButton buttonFile = MenuGUI.setButton(550, 500, 100, 50);
        buttonFile.setText("Submit");

        JButton buttonExit = MenuGUI.setButton(50, 50, 100, 50);
        buttonExit.setText("Return");
        buttonExit.addActionListener(e -> returnMenu(deletePanel));

        JTextField textField = new JTextField();
        textField.setBounds(500, 400, 200, 50);
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        buttonFile.addActionListener(e -> {
            try {
                deleteFile(e, textField, buttonFile);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        deletePanel = new MenuGUI.Panel();
        deletePanel.setLayout(null);
        deletePanel.add(title);
        deletePanel.add(text1);
        deletePanel.add(textField);
        deletePanel.add(buttonFile);
        deletePanel.add(buttonExit);

        choicePanel.setVisible(false);
        LoginGUI.mainFrame.add(deletePanel);
    }

    /**
     * Funkcja wywołująca akcje utworzenia pliku po wpisaniu nazwy pliku i naciśnięciu przycisku
     * @param e - action event
     * @param textField - pole tekstowe
     * @param buttonFile - przycisk
     * @throws IOException - wyjątek
     */
    public void createFile(ActionEvent e, JTextField textField, JButton buttonFile) throws IOException {
        if (e.getSource() == buttonFile) {
            String fileName = textField.getText();
            this.createFile(fileName);
            createPanel.setVisible(false);
            MenuGUI.menuPanel.setVisible(true);
        }
    }

    /**
     * Funkcja wywołująca akcje usunięcia pliku po wpisaniu nazwy pliku i naciśnięciu przycisku
     * @param e - action event
     * @param textField - pole tekstowe
     * @param buttonFile - przycisk
     * @throws IOException - wyjątek
     */
    public void deleteFile(ActionEvent e, JTextField textField, JButton buttonFile) throws IOException {
        if (e.getSource() == buttonFile) {
            String fileName = textField.getText();
            this.deleteFile(fileName);
            deletePanel.setVisible(false);
            MenuGUI.menuPanel.setVisible(true);
        }
    }
}
