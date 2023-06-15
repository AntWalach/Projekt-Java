package pl.quizmemory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static pl.quizmemory.LoginGUI.mainFrame;

/**
 * Graficzna implementacja menu głównego
 */
public class MenuGUI {
    protected static Panel menuPanel;

    /**
     * Dodanie graficznych elementów do wyświetlanego panelu
     */
    public void menuGUI() {
        JLabel title = new JLabel();
        title.setText("Word Game");
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("Arial", Font.PLAIN, 40));
        title.setBounds(500, 50, 400, 100);

        JButton buttonCreateDeleteFile = setButton(300, 250, 200, 100);
        JButton buttonCheckInputFile = setButton(700, 250, 200, 100);
        JButton buttonAddContentToFile = setButton(300, 400, 200, 100);
        JButton buttonEditFile = setButton(700, 400, 200, 100);
        JButton buttonGames = setButton(300, 550, 600, 150);

        buttonCreateDeleteFile.setText("Create/delete file");
        buttonCheckInputFile.setText("Check input file");
        buttonAddContentToFile.setText("Add content to a file");
        buttonEditFile.setText("Edit file");
        buttonGames.setText("GAMES!");

        buttonCreateDeleteFile.addActionListener(e -> {
            CreateDeleteFileGUI createDeleteFileGUI = new CreateDeleteFileGUI();
        });
        buttonCheckInputFile.addActionListener(e -> {
            CheckInputFileGUI checkInputFileGUI = new CheckInputFileGUI();
        });
        buttonAddContentToFile.addActionListener(e -> {
            AddContentToFileGUI addContentToFileGUI = new AddContentToFileGUI();
        });
        buttonEditFile.addActionListener(e -> {
            EditFileGUI editFileGUI = new EditFileGUI();
        });
        buttonGames.addActionListener(e -> {
            GameChoiceGUI gameChoiceGUI = new GameChoiceGUI();
        });

        menuPanel = new Panel();

        mainFrame.setLayout(null);

        menuPanel.add(title);
        menuPanel.add(buttonCreateDeleteFile);
        menuPanel.add(buttonCheckInputFile);
        menuPanel.add(buttonAddContentToFile);
        menuPanel.add(buttonEditFile);
        menuPanel.add(buttonGames);

        menuPanel.setLayout(null);

        mainFrame.add(menuPanel);
        mainFrame.setVisible(true);
        LoginGUI.panelLogin.setVisible(false);
    }

    /**
     * Funkcja ustawiająca podstawowe włściwości przycisków
     * @param x - współrzędna x przycisku
     * @param y - współrzędna y przycisku
     * @param width - szerokość przycisku
     * @param height - wysokość przycisku
     * @return przycisk
     */
    public static JButton setButton(int x, int y, int width, int height) {
        JButton newButton = new JButton();
        newButton.setBounds(x, y, width, height);
        newButton.setFocusable(false);

        return newButton;
    }

    /**
     * Klasa wewnętrzna reprezentująca panel GUI
     */
    public static class Panel extends JPanel {
        Panel() {
            //background color
            this.setOpaque(false);
            this.setBounds(0, 0, 1200, 900);
        }
    }

    /**
     * Klasa wewnętrzna reprezetnujące okno główne GUI
     */
    public static class Frame extends JFrame {
        Frame() {
            try {
                //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            //frame basics
            this.setTitle("Word Game");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false); //optional
            this.setSize(1200, 900);

            //icon
            ImageIcon windowIcon = new ImageIcon("w.png");
            this.setIconImage(windowIcon.getImage());

            //background color
            try {
                this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("gradient.png")))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
