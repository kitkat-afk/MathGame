
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
        public static void connect() {
            Connection conn = null;
            try {
                // db parameters
                String url = "jdbc:sqlite:db.sqlite";
                // create a connection to the database
                conn = DriverManager.getConnection(url);

                System.out.println("Connection to SQLite has been established.");

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

    public static void main(String[] args) {
        connect();
    }
}
