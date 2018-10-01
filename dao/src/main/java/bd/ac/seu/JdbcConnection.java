package bd.ac.seu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    private static JdbcConnection instance = new JdbcConnection();
    private static Connection connection;

    private JdbcConnection() {
        connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            final String USERNAME = "root";
            final String PASSWORD = "1614";
            final String DBURL = "jdbc:mysql://127.0.0.1/predictdb";

            connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

}
