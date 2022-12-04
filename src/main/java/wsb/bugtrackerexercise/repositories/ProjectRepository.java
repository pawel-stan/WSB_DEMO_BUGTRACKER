package wsb.bugtrackerexercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wsb.bugtrackerexercise.models.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
