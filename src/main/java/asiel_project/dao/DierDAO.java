package asiel_project.dao;

import asiel_project.entity.Dier;


import javax.ejb.Stateless;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class DierDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Dier> getAll() {
        return entityManager.createNamedQuery("Dier.findAll", Dier.class).getResultList();
    }

    public Dier findById(Integer id) {
        return entityManager.find(Dier.class, id);
    }

    public void update(Dier todo) {
        entityManager.merge(todo);
    }

    public void create(Dier nieuwdier) {
        nieuwdier.setDatumErin(LocalDate.now().toString());
        entityManager.persist(nieuwdier);
    }

    public void delete(Dier todo) {
        if (!entityManager.contains(todo)) {
            todo = entityManager.merge(todo);
        }

        entityManager.remove(todo);
    }
}

