import java.sql.*;

/**
 * Database class for interfacing with an SQLite database file.
 *
 * @author Benjamin Williams
 * @version 11.02.19
 */

public class Database {

    /**
     * Connect to a sample database
     */
    private Connection connect() {
        // db parameters
        String url = "jdbc:sqlite:db.sqlite";
        Connection con = null;

        try {
            con = DriverManager.getConnection(url);
            System.out.println("Database connected.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;

    }

    public void login(String username, String password) {
        String sql = ("SELECT * FROM Students WHERE username = " + username + " AND password = " + password + ";");

        try (Connection con = this.connect(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                //user found in database
                if (!rs.wasNull()) {
                    Student result = new Student(rs.getString("name"), rs.getString("username"), rs.getString("password"));
                    result.setAnsAttempt(rs.getInt("attempt"));
                    result.setAnsCorrect(rs.getInt("correct"));

                    System.out.println(result);
                }

                //user not found in database
                else {
                    System.out.println("User not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void newUser(String name, String user, String pass) {
        String sql = ("INSERT INTO Students(name, username, password, correct, attempt) VALUES("
                + name + "," + user + "," + pass + ", 0, 0);");

        try (Connection con = this.connect(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Database db = new Database();

        db.login("tester","pass");

    }

}
