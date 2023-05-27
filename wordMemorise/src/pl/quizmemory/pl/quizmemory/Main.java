package pl.quizmemory;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        LoginGUI loginGUI = new LoginGUI();
        MenuGUI menuGUI = new MenuGUI(); //dla testow

        loginGUI.ILogin();
       // menuGUI.menuGUI(); //dla testow zeby omijac logowanie
    }
}
