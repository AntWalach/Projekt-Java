package pl.quizmemory;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends MenuGUI implements ActionListener {

    protected static MenuGUI.Frame mainFrame;
    protected static MenuGUI.Panel panelLogin;
    protected static JTextField userText;
    protected static JLabel passwordLabel;
    protected static JPasswordField userPassword;
    protected static JButton loginButton;
    protected static JButton registerButton;
    protected static JLabel success;

    public static JTextField getUserText() {
        return userText;
    }

    public static void setUserText(JTextField userText) {
        LoginGUI.userText = userText;
    }

    public static JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public static void setPasswordLabel(JLabel passwordLabel) {
        LoginGUI.passwordLabel = passwordLabel;
    }

    public static JPasswordField getUserPassword() {
        return userPassword;
    }

    public static void setUserPassword(JPasswordField userPassword) {
        LoginGUI.userPassword = userPassword;
    }

    public static JButton getLoginButton() {
        return loginButton;
    }

    public static JLabel getSuccess() {
        return success;
    }

    public static void setSuccess(JLabel success) {
        LoginGUI.success = success;
    }

    public static void setLoginButton(JButton loginButton) {
        LoginGUI.loginButton = loginButton;
    }

    public static JButton getRegisterButton() {
        return registerButton;
    }

    public static void setRegisterButton(JButton registerButton) {
        LoginGUI.registerButton = registerButton;
    }

    public void ILogin() {

        panelLogin = new MenuGUI.Panel();
        //JFrame frame = new MenuGUI.Frame();
        mainFrame = new MenuGUI.Frame();
        //mainFrame.setLayout(null);
        //frame.setSize(1200, 900);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(panelLogin);

        panelLogin.setLayout(null);

        JLabel label = new JLabel("User");
        label.setBounds(450, 330, 80, 25);
        label.setForeground(new Color(255, 255, 255));
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        panelLogin.add(label);

        userText = new JTextField();
        userText.setBounds(580, 320, 180, 40);
        userText.setFont(new Font("Arial", Font.PLAIN, 20));
        panelLogin.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(450, 380, 150, 25);
        passwordLabel.setForeground(new Color(255, 255, 255));
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        panelLogin.add(passwordLabel);

        userPassword = new JPasswordField();
        userPassword.setBounds(580, 370, 180, 40);
        userPassword.setFont(new Font("Arial", Font.PLAIN, 20));
        panelLogin.add(userPassword);

        loginButton = new JButton("Login");
        loginButton.setBounds(580, 440, 80, 25);
        loginButton.addActionListener(new LoginGUI());
        panelLogin.add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(670, 440, 90, 25);
        registerButton.addActionListener(new LoginGUI());
        panelLogin.add(registerButton);

        success = new JLabel("");
        success.setBounds(500, 470, 300, 25);
        panelLogin.add(success);

        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        LoginGUI.mainFrame.add(panelLogin);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        UserManagement userManagement = new UserManagement();
        String user = userText.getText();
        String password = userPassword.getText();
        if (e.getSource() == loginButton) {

            userManagement.loginUser(user, password);

        } else if (e.getSource() == registerButton) {

            userManagement.registerUser(user, password, false);

        }

    }
}
