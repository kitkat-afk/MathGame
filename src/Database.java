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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;

    }

    public Student login(String username, String password) {
        String sql = ("SELECT * FROM Students WHERE username = ? AND password = ?;");

        try (Connection con = this.connect(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1,username);
            pstmt.setString(2,password);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Student result = new Student(rs.getString("name"), rs.getString("username"), rs.getString("password"));
                result.setAnsAttempt(rs.getInt("attempt"));
                result.setAnsCorrect(rs.getInt("correct"));
                return result;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //if nothing found
        return null;
    }

    public void newUser(String name, String user, String pass) {
        String sql = ("INSERT INTO Students(name, username, password, correct, attempt) VALUES(\'"
                + name + "\', \'" + user + "\', \'" + pass + "\', 0, 0);");

        System.out.println(sql);

        Connection c = this.connect();
        Statement s = null;

        try {
            s = c.createStatement();
            s.executeUpdate(sql);
            s.close();
            c.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void printAllStudents() {
        String sql = "SELECT * FROM Students";

        try(Connection con = this.connect(); PreparedStatement ptsmt = con.prepareStatement(sql)) {
            ResultSet rs = ptsmt.executeQuery();

            while(rs.next()) {
                System.out.println(rs.getInt("ID") + "\t" +
                        rs.getString("name")  + "\t" +
                        rs.getString("username") + "\t" +
                        rs.getString("password") + "\t" +
                        rs.getInt("correct") + "\t" +
                        rs.getInt("attempt"));
            }

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(String user)
    {
        String sql = ("DELETE FROM Students WHERE username = \'" +  user + "\';");
        System.out.println(sql);

        Connection c = this.connect();
        Statement s = null;

        try {
            s = c.createStatement();
            s.executeUpdate(sql);
            s.close();
            c.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        Database db = new Database();
        db.printAllStudents();
        db.login("jdoe","me");
        db.printAllStudents();
    }

}
