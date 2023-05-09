package Users;

public class RegularUser extends User {
    public RegularUser(String username, String password) {
        super(username, password, false);
    }

    public boolean validate(String username, String password) {
        return ("1").equals(username) && ("1").equals(password);
    }
}