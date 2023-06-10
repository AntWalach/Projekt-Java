package pl.quizmemory;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa zarządzająca użytkownikami
 */
public class UserManagement extends LoginGUI {

    private List<User> users;
    private final String dataFilePath = "users.dat";

    /**
     * Konstruktor pobierający dane o użytkownikach z pliku .dat
     */
    UserManagement() {
        users = new ArrayList<>();
        loadData();
    }

    /**
     * Fukcja nadzorująca proces rejestracji użytkownika
     * @param username - nazwa użytkownika
     * @param password - hasło użytkownika
     * @param isAdmin - czy użytkownik jest administratorem(true or false)
     */
    public void registerUser(String username, String password, boolean isAdmin) {
        User user;
        
        if (isAdmin) {
            user = new AdminUser(username, password);
        } else {
            user = new RegularUser(username, password);
        }
        users.add(user);
        saveData();
    }

    /**
     * Fukcja nadzorująca proces logowania użytkownika
     * @param username - nazwa użytkownika
     * @param password - hasło użytkownika
     */
    public void loginUser(String username, String password) {
        for (User user : users) {
            if (user.getLogin().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login successful!");
                success.setText("Login successful!");

                MenuGUI menuGUI = new MenuGUI();
                menuGUI.menuGUI();
            }
        }
        System.out.println("Invalid username or password!");
        success.setText("Invalid username or password!");
        success.setForeground(new Color(255, 255, 255));
    }

    /**
     * Funkcja zapisująca użytkowników do pliku .dat
     */
    private void saveData() {
        try {
            FileOutputStream fos = new FileOutputStream(dataFilePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Funkcja pobierąca użytkowników z pliku .dat
     */
    private void loadData() {
        try {
            File file = new File(dataFilePath);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(dataFilePath);
                ObjectInputStream ois = new ObjectInputStream(fis);
                users = (List<User>) ois.readObject();
                ois.close();
                fis.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
