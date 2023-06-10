package pl.quizmemory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 * Graficzna implementacja sprawdzania zawartości pliku
 */
public class CheckInputFileGUI extends CreateFile {
    private MenuGUI.Panel checkInputFilePanel;

    /**
     * Kontruktor wywołujący odziedziczoną funkcje, która wyświetla okno wyboru pliku .txt
     */
    CheckInputFileGUI() {
        filenameGUI();
    }

    /**
     * Dodanie graficznych elementów do wyświetlanego panelu
     */
    public void checkInputFileGUI() {
        JLabel title = new JLabel();
        title.setText("Check input file");
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("Arial", Font.PLAIN, 40));
        title.setBounds(500, 50, 300, 100);

        JTextArea textArea = new JTextArea();
        textArea.setOpaque(false);
        textArea.setForeground(new Color(255, 255, 255));
        textArea.setFont(new Font("Arial", Font.PLAIN, 20));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        addWordsToTextField(textArea);
        textArea.setCaretPosition(0);

        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(250, 200, 700, 500);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(false);

        JButton buttonExit = MenuGUI.setButton(50, 50, 100, 50);
        buttonExit.setText("Return");
        buttonExit.addActionListener(e -> returnMenu(checkInputFilePanel));

        checkInputFilePanel = new MenuGUI.Panel();
        checkInputFilePanel.setLayout(null);
        checkInputFilePanel.add(title);
        checkInputFilePanel.add(scrollPane);
        checkInputFilePanel.add(buttonExit);

        LoginGUI.mainFrame.add(checkInputFilePanel);
    }

    /**
     * Funkcja wyświetlająca zawartość pliku .txt
     * @param textArea - pole tekstowe
     */
    public void addWordsToTextField(JTextArea textArea) {
        textArea.setText("");

        for (int i = 0; i < WordList.plWords.size(); i++) {
            textArea.append((i + 1) + ". " + WordList.plWords.get(i).trim() + " - " + WordList.enWords.get(i).trim() + "\n \n");
        }
    }

    /**
     * Nadpisanie funkcji wywołującej akcje po wpisaniu nazwy pliku i naciśnięciu przycisku
     * @param e - action event
     * @param textField - pole tekstowe
     * @param button - przycisk
     * @throws IOException - wyjątek
     */
    @Override
    public void action(ActionEvent e, JTextField textField, JButton button) throws IOException {
        if (e.getSource() == button) {
            String fileName = textField.getText();
            WordList.addWordsToList(this.checkFileName(fileName));
            filenamePanel.setVisible(false);
            checkInputFileGUI();
        }
    }
}
