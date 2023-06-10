package pl.quizmemory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Graficzna implementacja dodwania zawartości do pliku .txt
 */
public class EditFileGUI extends CreateFile {
    private MenuGUI.Panel editFileContentPanel;
    private String fileName;
    private JTextArea changeFileTextArea;

    /**
     * Kontruktor wywołujący odziedziczoną funkcje, która wyświetla okno wyboru pliku .txt
     */
    EditFileGUI() {
        filenameGUI();
    }

    /**
     * Dodanie graficznych elementów do wyświetlanego panelu
     */
    public void editContentFileGUI() {
        JLabel title = new JLabel();
        title.setText("Edit input file");
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("Arial", Font.PLAIN, 40));
        title.setBounds(500, 50, 300, 100);

        changeFileTextArea = new JTextArea();
        changeFileTextArea.setBackground(new Color(255, 255, 255));
        changeFileTextArea.setForeground(new Color(0, 0, 0));
        changeFileTextArea.setFont(new Font("Arial", Font.PLAIN, 20));
        changeFileTextArea.setLineWrap(true);
        String fileContent = readFileContent();
        changeFileTextArea.setText(fileContent);
        changeFileTextArea.setCaretPosition(0);

        JScrollPane scrollPane = new JScrollPane(changeFileTextArea, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(250, 200, 700, 500);

        JButton buttonSubmit = MenuGUI.setButton(550, 750, 100, 50);
        buttonSubmit.setText("Submit");

        buttonSubmit.addActionListener(e -> {
            try {
                changeText(e, changeFileTextArea, buttonSubmit);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        JButton buttonExit = MenuGUI.setButton(50, 50, 100, 50);
        buttonExit.setText("Return");
        buttonExit.addActionListener(e -> returnMenu(editFileContentPanel));

        editFileContentPanel = new MenuGUI.Panel();
        editFileContentPanel.setLayout(null);
        editFileContentPanel.add(title);
        editFileContentPanel.add(scrollPane);
        editFileContentPanel.add(buttonSubmit);
        editFileContentPanel.add(buttonExit);

        LoginGUI.mainFrame.add(editFileContentPanel);
    }

    /**
     * Funkcja wywołująca akcje pobrania nazwy pliku po jej wpisaniu i naciśnięciu przycisku
     * @param e - action event
     * @param textField - pole tekstowe
     * @param buttonFile - przycisk
     */
    public void action(ActionEvent e, JTextField textField, JButton buttonFile) {
        if (e.getSource() == buttonFile) {
            fileName = textField.getText();
            filenamePanel.setVisible(false);
            editContentFileGUI();
        }
    }

    /**
     * Funkcja zczytująca zawartość pliku .txt
     * @return zwraca string zaweirający całą zawartośc pliku .txt
     */
    public String readFileContent() {
        try {
            File file = new File(this.checkFileName(fileName));
            String filePath = file.getAbsolutePath();
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Funkcja zapisująca zmiany w pliku .txt
     * @param e - action
     * @param textArea - pole tekstowe
     * @param button - przycisk
     * @throws IOException - wyjątek
     */
    public void changeText(ActionEvent e, JTextArea textArea, JButton button) throws IOException {
        if (e.getSource() == button) {
            File file = new File(this.checkFileName(fileName));
            String filePath = file.getAbsolutePath();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(textArea.getText());
            }
        }
    }
}
