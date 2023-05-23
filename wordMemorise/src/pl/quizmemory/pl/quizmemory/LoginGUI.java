package pl.quizmemory;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI implements ActionListener {

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


        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(1200, 900);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        JLabel label = new JLabel("User");
        label.setBounds(500, 370, 80, 25);
        panel.add(label);

        userText = new JTextField();
        userText.setBounds(580, 370, 140, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(500, 400, 80, 25);
        panel.add(passwordLabel);

        userPassword = new JPasswordField();
        userPassword.setBounds(580, 400, 140, 25);
        panel.add(userPassword);

        loginButton = new JButton("Login");
        loginButton.setBounds(560, 440, 80, 25);
        loginButton.addActionListener(new LoginGUI());
        panel.add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(660, 440, 80, 25);
        registerButton.addActionListener(new LoginGUI());
        panel.add(registerButton);

        success = new JLabel("");
        success.setBounds(500, 470, 300, 25);
        panel.add(success);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        UserManagement userManagement = new UserManagement();
        String user = userText.getText();
        String password = userPassword.getText();
        if (e.getSource() == loginButton) {


            userManagement.loginUser(user, password);
//        if (user.equals("antek") && password.equals("123")) {
//            success.setText("Login successful!");
//            MenuGUI.menuGUI();
//        } else {
//            success.setText("Invalid username or password");
//        }
        } else if (e.getSource() == registerButton) {

            userManagement.registerUser(user, password, false);


        }

    }
}
