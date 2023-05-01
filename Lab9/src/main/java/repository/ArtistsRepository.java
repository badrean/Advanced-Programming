package repository;

import entity.ArtistsJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ArtistsRepository {
    private EntityManager entityManager;
    public ArtistsRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(ArtistsJPA artist) {
        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
    }

    public ArtistsJPA findById(int id) {
        return entityManager.find(ArtistsJPA.class, id);
    }

    public List<ArtistsJPA> findByName(String namePattern) {
        TypedQuery<ArtistsJPA> query = entityManager.createNamedQuery("ArtistsJPA.findByName", ArtistsJPA.class);
        query.setParameter("name", "%" + namePattern + "%");
        return query.getResultList();
    }
}
