/**z
 * Generic class for all users of the game. Currently in testing stages. All it requires is name, username, and password.
 *
 * @version 11.21.2019
 * @author Benjamin Williams
 */

public class Account_a {
    public String name, password;

    public Account_a(String n, String p)
    {
        name = n;
        password = p;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public String toString() {
        return (getName()  + "\n");
    }
}
