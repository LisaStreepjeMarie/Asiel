package asiel_project;

import asiel_project.endpoints.DierResource;
import asiel_project.endpoints.VerblijfResource;
import asiel_project.exception.VerblijfVolMapper;
import asiel_project.mapper.VerblijfMapper;
import asiel_project.service.AccessControlResponseFilter;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class APIApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<>();
        set.add( DierResource.class );
        set.add( VerblijfResource.class );
        set.add( VerblijfVolMapper.class );

        return set;
    }
}
