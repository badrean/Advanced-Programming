package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "albums", schema = "mydb")
public class AlbumsJPA {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "release_year")
    private int releaseYear;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "artist_id", insertable = false, updatable = false)
    private int artistId;
    @OneToMany(mappedBy = "albumsByAlbumId")
    private Collection<AlbumGenresJPA> albumGenresById;
    @ManyToOne
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    private ArtistsJPA artistsByArtistId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlbumsJPA albumsJPA = (AlbumsJPA) o;

        if (id != albumsJPA.id) return false;
        if (releaseYear != albumsJPA.releaseYear) return false;
        if (artistId != albumsJPA.artistId) return false;
        if (title != null ? !title.equals(albumsJPA.title) : albumsJPA.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + releaseYear;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + artistId;
        return result;
    }

    public Collection<AlbumGenresJPA> getAlbumGenresById() {
        return albumGenresById;
    }

    public void setAlbumGenresById(Collection<AlbumGenresJPA> albumGenresById) {
        this.albumGenresById = albumGenresById;
    }

    public ArtistsJPA getArtistsByArtistId() {
        return artistsByArtistId;
    }

    public void setArtistsByArtistId(ArtistsJPA artistsByArtistId) {
        this.artistsByArtistId = artistsByArtistId;
    }
}
