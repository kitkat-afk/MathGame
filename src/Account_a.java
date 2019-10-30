/**
 * Generic class for all users of the game. Currently in testing stages. All it requires is name, username, and password.
 *
 * @version 25.10.2019
 * @author Benjamin Williams
 */

public abstract class Account_a {
    public String name, username, password;

    public Account_a(String n, String u, String p)
    {
        name = n;
        username = u;
        password = p;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return (getName() + "\n" + getUsername() + "\n" + getPassword() + "\n");
    }
}
