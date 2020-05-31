package asiel_project.dao;

import asiel_project.entity.Dier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.cdi.Eager;

@Eager
public interface DierRepository extends JpaRepository<Dier, Integer> {

}
