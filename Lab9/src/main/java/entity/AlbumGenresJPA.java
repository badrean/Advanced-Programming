package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "album_genres", schema = "mydb")
public class AlbumGenresJPA {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "album_id")
    private int albumId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "genre_id")
    private int genreId;
    @ManyToOne
    @JoinColumn(name = "album_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private AlbumsJPA albumsByAlbumId;
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private GenresJPA genresByGenreId;

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

        AlbumGenresJPA that = (AlbumGenresJPA) o;

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

    public AlbumsJPA getAlbumsByAlbumId() {
        return albumsByAlbumId;
    }

    public void setAlbumsByAlbumId(AlbumsJPA albumsByAlbumId) {
        this.albumsByAlbumId = albumsByAlbumId;
    }

    public GenresJPA getGenresByGenreId() {
        return genresByGenreId;
    }

    public void setGenresByGenreId(GenresJPA genresByGenreId) {
        this.genresByGenreId = genresByGenreId;
    }
}
