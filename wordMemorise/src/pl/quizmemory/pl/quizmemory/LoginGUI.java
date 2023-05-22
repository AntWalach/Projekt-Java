package pl.quizmemory;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI implements ActionListener {

    private static JTextField userText;

    private static JLabel passwordLabel;
    private static JPasswordField userPassword;
    private static JButton loginButton;
    private static JButton registerButton;
    private static JLabel success;

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
        loginButton.setBounds(640, 430, 80, 25);
        loginButton.addActionListener(new LoginGUI());
        panel.add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(730, 430, 80, 25);
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
