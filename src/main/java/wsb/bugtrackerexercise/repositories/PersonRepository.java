package wsb.bugtrackerexercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wsb.bugtrackerexercise.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
