package pl.quizmemory;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {

        LoginGUI loginGUI = new LoginGUI();
        MenuGUI menuGUI = new MenuGUI(); //dla testow

        loginGUI.ILogin();
        // menuGUI.menuGUI(); //dla testow zeby omijac logowanie
    }
}
