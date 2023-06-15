package pl.quizmemory;

/**
 * Klasa tworząca konto admin
 */
public class AdminUser extends User {
    /**
     * Konstruktor wywołujący kontruktor klasy bazowej User
     * @param login - login użytkownika
     * @param password - hasło użytkownika
     */
    public AdminUser(String login, String password) {
        super(login, password);
    }
}
