package pl.quizmemory;

/**
 * Klasa tworząca zwykłego użytkownika
 */
public class RegularUser extends User{
    /**
     * Konstruktor wywołujący kontruktor klasy bazowej User
     * @param login -  login użytkownika
     * @param password - hasło użytkownika
     */
    public RegularUser(String login, String password) {
        super(login, password);
    }
}
