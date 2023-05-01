package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "artists", schema = "mydb")
@NamedQuery(name = "ArtistsJPA.findByName", query = "SELECT a FROM ArtistsJPA a WHERE a.name LIKE :name")
public class ArtistsJPA {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "artistsByArtistId")
    private Collection<AlbumsJPA> albumsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtistsJPA that = (ArtistsJPA) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ArtistsJPA{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", albumsById=").append(albumsById);
        sb.append('}');
        return sb.toString();
    }

    public Collection<AlbumsJPA> getAlbumsById() {
        return albumsById;
    }

    public void setAlbumsById(Collection<AlbumsJPA> albumsById) {
        this.albumsById = albumsById;
    }
}
