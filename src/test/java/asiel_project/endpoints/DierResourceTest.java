package asiel_project.endpoints;

import asiel_project.dao.DierDAO;
import asiel_project.dao.VerblijfDAO;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DierResourceTest {

    @Mock
    DierDAO dierDAO;

    @Mock
    VerblijfDAO verblijfDAO;

    @InjectMocks
    private DierResource cut;


}
