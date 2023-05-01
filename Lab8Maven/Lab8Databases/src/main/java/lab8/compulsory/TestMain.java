package lab8.compulsory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Statement;

public class TestMain {
    public static void main(String[] args) throws SQLException {
        String filename = "create_tables.sql";
        Path pathToFile = Paths.get(filename);
        System.out.println(pathToFile.toAbsolutePath());
        try {
            // creating singleton instance
            Database.getInstance();

            Statement stmt = Database.getConnection().createStatement();

            // reading and executing the sql script
            String script = new String(Files.readAllBytes(pathToFile.toAbsolutePath()));

//            stmt.execute(script);

            String[] statements = script.split(";");
            for (String statement : statements) {
                if (statement.trim().length() > 0) {
                    stmt.execute(statement);
                }
            }

            stmt.close();

            // adding entries in artists table
            var artists = new ArtistDAO();
            artists.create("Pink Floyd");
            artists.create("Michael Jackson");


            Database.closeConnection();
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
