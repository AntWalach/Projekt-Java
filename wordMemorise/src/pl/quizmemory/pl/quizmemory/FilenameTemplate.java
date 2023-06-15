package pl.quizmemory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 * Graficzna implementacja wybierania pliku .txt
 */
public class FilenameTemplate  {
    protected MenuGUI.Panel filenamePanel;

    /**
     * Dodanie graficznych elementów do wyświetlanego panelu
     */
    public void filenameGUI() {
        JLabel title = new JLabel();
        title.setText("Choose file");
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("Arial", Font.PLAIN, 40));
        title.setBounds(500, 50, 300, 100);

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
        buttonExit.addActionListener(e -> returnMenu(filenamePanel));

        JTextField textField = new JTextField();
        textField.setBounds(500, 400, 200, 50);
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        buttonFile.addActionListener(e -> {
            try {
                action(e, textField, buttonFile);
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
        filenamePanel.add(buttonExit);

        MenuGUI.menuPanel.setVisible(false);
        LoginGUI.mainFrame.add(filenamePanel);
    }

    /**
     * Wzorzec funkcji odpowiadającej za przekazanie informacji wpisanych do pola tekstowego po naciśnięciu przycisku
     * @param e - action event
     * @param textField - pole tekstowe
     * @param button - przcisk
     * @throws IOException - wyjątek
     */
    public void action(ActionEvent e, JTextField textField, JButton button) throws IOException{ }

    /**
     * Powrót do menu głównego
     * @param panel - panel
     */
    public void returnMenu(JPanel panel){
        panel.setVisible(false);
        MenuGUI.menuPanel.setVisible(true);
    }
}
