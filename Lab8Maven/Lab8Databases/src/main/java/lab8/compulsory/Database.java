package lab8.compulsory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database database;
    private static final String URL =
            "jdbc:mysql://0.0.0.0:6968/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection connection = null;

    private Database() {
        createConnection();
    }

    public static Database getInstance() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }
    public static Connection getConnection() {
        return connection;
    }

    private static void createConnection() {
        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }
}
