package asiel_project.dao;

import asiel_project.entity.Dier;
import asiel_project.entity.Verblijf;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless
public class VerblijfDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Verblijf> getAll() {
        return entityManager.createNamedQuery("Verblijf.findAll", Verblijf.class).getResultList();
    }

    public Verblijf findById(Integer id) {
        return entityManager.find(Verblijf.class, id);
    }

    public void update(Verblijf verblijf) {
        entityManager.merge(verblijf);

    }

    public void create(Verblijf verblijf) {
        entityManager.persist(verblijf);
    }

    public void delete(Verblijf verblijf) {
        if (!entityManager.contains(verblijf)) {
            verblijf = entityManager.merge(verblijf);
        }
        entityManager.remove(verblijf);
        entityManager.close();
    }
}
