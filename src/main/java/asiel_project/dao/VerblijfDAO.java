package asiel_project.dao;

import asiel_project.entity.Verblijf;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Stateless
public class VerblijfDAO {

//    @PersistenceContext(unitName = "cursus", type = PersistenceContextType.EXTENDED)
//    private EntityManager entityManager;

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("cursus");

    public List<Verblijf> getAll() {
        EntityManager em = factory.createEntityManager();
        List<Verblijf> lijst = em.createNamedQuery("Verblijf.findAll", Verblijf.class).getResultList();
        em.close();
        return lijst;
    }

    public Verblijf findById(Integer id) {
        EntityManager em = factory.createEntityManager();
        Verblijf verblijf = em.find(Verblijf.class, id);
        em.close();
        return verblijf;
    }

    public void update(Verblijf verblijf) {
        EntityManager em = factory.createEntityManager();
        em.merge(verblijf);
        em.close();
    }

    public void create(Verblijf verblijf) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(verblijf);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Verblijf verblijf) {
        EntityManager em = factory.createEntityManager();
        if (!em.contains(verblijf)) {
            verblijf = em.merge(verblijf);
        }
        em.remove(verblijf);
        em.close();
    }
}
