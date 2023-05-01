import entity.ArtistsJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import repository.ArtistsRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Lab9");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ArtistsRepository artistsRepository = new ArtistsRepository(entityManager);

        ArtistsJPA artist = new ArtistsJPA();
        artist.setName("Snoop Dog");

        List<ArtistsJPA> matchingPersons = artistsRepository.findByName("Snoop Dog");

        if(matchingPersons.isEmpty())
            artistsRepository.create(artist);

        ArtistsJPA newArtist = artistsRepository.findById(1);
        System.out.println(newArtist);


        entityManager.close();
        entityManagerFactory.close();
    }
}
