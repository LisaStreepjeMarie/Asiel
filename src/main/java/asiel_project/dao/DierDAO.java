package asiel_project.dao;

import asiel_project.entity.Dier;


import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless
public class DierDAO {

//    @PersistenceContext(unitName = "cursus", type = PersistenceContextType.EXTENDED)
//    private EntityManager entityManager;

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("cursus");

    public List<Dier> getAll() {
        EntityManager em = factory.createEntityManager();
        List<Dier> lijst = em.createNamedQuery("Dier.findAll", Dier.class).getResultList();
        em.close();
        return lijst;
    }

    public Dier findById(Integer id) {
        EntityManager em = factory.createEntityManager();
        return em.find(Dier.class, id);
    }

    public void update(Dier todo) {
        EntityManager em = factory.createEntityManager();
        em.merge(todo);
    }
//
//    public void create(Dier todo) {
//        em.persist(todo);
//    }
//
//    public void delete(Dier todo) {
//        if (!em.contains(todo)) {
//            todo = em.merge(todo);
//        }
//
//        em.remove(todo);
//    }
}

