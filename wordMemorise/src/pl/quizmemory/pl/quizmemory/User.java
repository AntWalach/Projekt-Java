package pl.quizmemory;

import java.io.Serializable;

/**
 * Klasa użytkownika
 */
public class User implements Serializable {
    private String login;
    private String password;

    public User(String login, String password) {

        this.login = login;
        this.password = password;
    }

    //getters and setters
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
