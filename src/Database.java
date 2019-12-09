import java.sql.*;

/**
 * Database class for interfacing with an SQLite database file.
 *
 * @author Benjamin Williams
 * @version 11.21.19
 */

public class Database {

    public static void main(String[] args) {
        Database db = new Database();
        System.out.println(db.printAllStudents());

        MathGenerator mg = new MathGenerator();
        MathObject[] mo = mg.generatePlacesQuestions();

        for(int i = 0; i < mo.length; i++)
        {
            System.out.println("The number is: " + mo[i].getOne() + "" + mo[i].getTwo());

            if(mo[i].getSum() == 0)
            {
                System.out.println("Enter the number in the ONES place!");
                System.out.println(mo[i].getTwo());
            }
            else
            {
                System.out.println("Enter the number in the TENS place!");
                System.out.println(mo[i].getOne());
            }

            System.out.println();
        }

    }

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

    /**
     * Method to log into the user account via either Student or Teacher table of the database.
     *
     * @param name               user's entered username
     * @param password           user's entered password
     * @param isStudentorTeacher whether we're logging into Student or Teacher. 0 = student, 1 = teacher
     * @return the account file if found in database, or null if does not exist
     */
    public Object login(String name, String password, int isStudentorTeacher) {
        name = name.trim();
        password = password.trim();
        String sql;

        if (isStudentorTeacher == 0) sql = ("SELECT * FROM Students WHERE name = ? AND password = ?;");
        else sql = ("SELECT * FROM Teachers WHERE name = ? AND password = ?;");

        try (Connection con = this.connect(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                if (isStudentorTeacher == 0) {
                    Student result = new Student(rs.getString("name"), rs.getString("password"));
                    result.setAnsAttempt(rs.getInt("attempt"));
                    result.setAnsCorrect(rs.getInt("correct"));
                    return result;
                } else {
                    Teacher result = new Teacher(rs.getString("name"), rs.getString("password"));
                    return result;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        //if nothing found
        return null;
    }

    /**
     * Method to create a new student. Defaults the values for attempted and correct answers to 0.
     *
     * @param name               Name of the user
     * @param pass               Password of user
     * @param isStudentorTeacher 0 = Student, 1  = Teacher
     * @return true if succeed, false if fail
     */
    public boolean newUser(String name, String pass, int isStudentorTeacher) {
        String sql;

        if (isStudentorTeacher == 0) {
            sql = ("INSERT INTO Students(name, password, correct, attempt) VALUES(\'"
                    + name.trim() + "\',\'" + pass.trim() + "\', 0, 0);");
        } else {
            sql = "INSERT INTO Teachers(name, password) VALUES(\'"
                    + name.trim() + "\',\'" + pass.trim() + "\';";
        }

        //bugtesting, print to console the entered input
        System.out.println(sql);

        Connection c = this.connect();
        Statement s = null;

        try {
            s = c.createStatement();
            s.executeUpdate(sql);
            s.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * Bugtesting function to print out the users currently stored in database. Will probably later be edited
     * to display student stats for the teacher.
     */
    public String printAllStudents() {
        String sql = "SELECT * FROM Students";
        String result = "";

        try (Connection con = this.connect(); PreparedStatement ptsmt = con.prepareStatement(sql)) {
            ResultSet rs = ptsmt.executeQuery();

            while (rs.next()) {
                result += (rs.getInt("ID") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getInt("correct") + "\t" +
                        rs.getInt("attempt"));

                result = result + "\n";
            }

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Unused method for removing a student from the database.
     *
     * @param name name of the user we want to delete
     */
    public boolean deleteStudent(String name) {
        String sql = ("DELETE FROM Students WHERE name = \'" + name + "\';");
        System.out.println(sql);

        Connection c = this.connect();
        Statement s = null;

        if (logicCheck(name)) {

            try {
                s = c.createStatement();
                s.executeUpdate(sql);
                s.close();
                c.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return logicCheck(name);
    }

    public boolean updateStudent(Student s) {
        int cor = s.getAnsCorrect(), atmpt = s.getAnsAttempt();
        String n = s.getName();

        String sql = "UPDATE Students SET correct = " + cor + ", attempt = " + atmpt + " WHERE name = \'" + n + "\';";
        System.out.println(sql);

        Connection c = this.connect();
        Statement st = null;

        try {
            st = c.createStatement();
            st.executeUpdate(sql);
            st.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private boolean logicCheck(String name) {
        String sql = "SELECT * FROM Students WHERE name = \'" + name + "\';";

        try (Connection con = this.connect(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
