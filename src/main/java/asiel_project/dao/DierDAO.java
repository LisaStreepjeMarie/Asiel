package asiel_project.dao;

import asiel_project.model.Dier;
import jakarta.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DierDAO {

//    @PersistenceContext(unitName = "cursus")
    EntityManager em;

    public List getAll() {
        return em.createNamedQuery("Dier.findAll", Dier.class).getResultList();
    }

    public Dier findById(Long id) {
        return em.find(Dier.class, id);
    }

    public void update(Dier todo) {
        em.merge(todo);
    }

    public void create(Dier todo) {
        em.persist(todo);
    }

    public void delete(Dier todo) {
        if (!em.contains(todo)) {
            todo = em.merge(todo);
        }

        em.remove(todo);
    }
}

