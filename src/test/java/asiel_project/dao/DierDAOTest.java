package asiel_project.dao;

import asiel_project.entity.Dier;
import asiel_project.entity.Verblijf;
import asiel_project.exception.VerblijfVolException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;

@RunWith(MockitoJUnitRunner.class)
public class DierDAOTest {

    @Mock
    EntityManager entityManager;

    @InjectMocks
    private DierDAO cut;

    @Test
    public void shouldSaveDier() throws VerblijfVolException {
        Dier dier = getDierWithVerblijf();

        cut.create(dier);

        Mockito.verify(entityManager, Mockito.times(1)).persist(eq(dier));
    }

    @Test(expected = VerblijfVolException.class)
    public void shouldThrowVerblijfVolException() throws VerblijfVolException {
        Dier nieuwDier = getDierWithVerblijfVol();

        cut.create(nieuwDier);
    }

    private Dier getDierWithVerblijf() {
        Dier dier = new Dier();
        Verblijf verblijf = new Verblijf();
        dier.setVerblijf(verblijf);
        return dier;
    }

    private Dier getDierWithVerblijfVol() {
        Dier dier = new Dier();
        List<Dier> dieren = new ArrayList<>();
        dieren.add(dier);
        Verblijf verblijf = new Verblijf();
        verblijf.setDieren(dieren);
        verblijf.setPlekkenTotaal(1);
        Dier dier2 = new Dier();
        dier2.setVerblijf(verblijf);
        return dier2;
    }
}
