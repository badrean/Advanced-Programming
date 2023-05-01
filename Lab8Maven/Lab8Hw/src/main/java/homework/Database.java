package homework;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;


public class Database {
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl( "jdbc:mysql://0.0.0.0:6968/mydb" );
        config.setUsername( "root" );
        config.setPassword( "root" );
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource( config );
    }
    private Database() { }
    private static Connection connection = null;
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    public static void closeConnection() {
        ds.close();
        System.out.println("Connection closed successfully");
    }
    public static void createTables() throws SQLException {
            Connection conn = ds.getConnection();
            Statement stmt = conn.createStatement();
            String sqlQuery = "CREATE TABLE artists (id SERIAL PRIMARY KEY, name TEXT NOT NULL);" +
                    "CREATE TABLE genres (id SERIAL PRIMARY KEY, name TEXT NOT NULL);" +
                    "CREATE TABLE albums (id SERIAL PRIMARY KEY, name TEXT NOT NULL, release_year INTEGER NOT NULL);" +
                    "CREATE TABLE album_genres (album_id INTEGER NOT NULL REFERENCES albums(id), genre_id INTEGER NOT NULL REFERENCES genres(id), PRIMARY KEY (album_id, genre_id));";

        String[] splitSql = sqlQuery.split(";");

        for (String sql : splitSql) {
            stmt.executeUpdate(sql);
        }
        System.out.println("Tables created successfully!");
    }
    public static void displayTables(String tableName) throws SQLException {
        Connection conn = ds.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName + ";");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            if (tableName.equalsIgnoreCase("albums")) {
                int releaseYear = rs.getInt("release_year");
                System.out.println("Release Year: " + releaseYear);
            }
        }
        System.out.println("Table " + tableName + " displayed successfully!\n");
    }
    public static void dropTables() throws SQLException {
        Connection conn = ds.getConnection();
        Statement stmt = conn.createStatement();
        String sqlQuery = "DROP TABLE album_genres CASCADE; " +
                    "DROP TABLE albums CASCADE; " +
                    "DROP TABLE genres CASCADE; " +
                    " DROP TABLE artists CASCADE ";
        String[] splitSql = sqlQuery.split(";");

        for (String sql : splitSql) {
            stmt.executeUpdate(sql);
        }
        System.out.println("Tables dropped successfully");
    }
}