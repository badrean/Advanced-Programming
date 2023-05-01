import DAO.AlbumDAO;
import DAO.ArtistDAO;
import DAO.GenreDAO;
import homework.Database;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Path pathToFile = Paths.get("archive/albumlist.csv");
        ArtistDAO artists = new ArtistDAO();
        AlbumDAO albums = new AlbumDAO();
        GenreDAO genres = new GenreDAO();
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.ISO_8859_1)) {
            DatabaseMetaData dbm = Database.getConnection().getMetaData();
            ResultSet aristTable = dbm.getTables(null, null, "artists", null);
            ResultSet albumTable = dbm.getTables(null, null, "albums", null);
            ResultSet genreTable = dbm.getTables(null, null, "genres", null);
            // check if the tables exist
            if (aristTable.next() && albumTable.next() && genreTable.next()) {
                Database.dropTables();
            }
            Database.createTables();

            String line = br.readLine();
            line = br.readLine(); // start from the second line
            while (line != null) {
                String[] attributes = line.split(",");
                int id = Integer.parseInt(attributes[0]);
                int year = Integer.parseInt(attributes[1]);
                String albumName = attributes[2];
                String artistName = attributes[3];
                String genreName = attributes[4];

                artists.create(id, artistName);
                albums.create(id, albumName, year);
                genres.create(id, genreName);

                line = br.readLine();
            }
            System.out.println("Tables populated successfully!\n");

            Database.displayTables("artists");
//
            System.out.println("The Beatles ID: " + artists.findByName("The Beatles"));
            System.out.println("Name: " + artists.findById(320));
            Database.getConnection().close();
        } catch(IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}