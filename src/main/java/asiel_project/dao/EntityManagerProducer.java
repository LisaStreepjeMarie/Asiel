package asiel_project.dao;

import org.springframework.data.repository.cdi.Eager;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Eager
public class EntityManagerProducer {

    @PersistenceContext(name = "cursus")
    private EntityManager entityManager;

    @Produces
    @Dependent
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
