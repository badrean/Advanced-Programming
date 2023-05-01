package entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class AlbumGenresJPAPK implements Serializable {
    @Column(name = "album_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int albumId;
    @Column(name = "genre_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genreId;

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlbumGenresJPAPK that = (AlbumGenresJPAPK) o;

        if (albumId != that.albumId) return false;
        if (genreId != that.genreId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = albumId;
        result = 31 * result + genreId;
        return result;
    }
}
