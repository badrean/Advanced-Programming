package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "genres", schema = "mydb")
public class GenresJPA {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "genresByGenreId")
    private Collection<AlbumGenresJPA> albumGenresById;

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

        GenresJPA genresJPA = (GenresJPA) o;

        if (id != genresJPA.id) return false;
        if (name != null ? !name.equals(genresJPA.name) : genresJPA.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<AlbumGenresJPA> getAlbumGenresById() {
        return albumGenresById;
    }

    public void setAlbumGenresById(Collection<AlbumGenresJPA> albumGenresById) {
        this.albumGenresById = albumGenresById;
    }
}
