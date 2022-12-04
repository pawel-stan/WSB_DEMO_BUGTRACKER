package wsb.bugtrackerexercise.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wsb.bugtrackerexercise.filters.ProjectFilter;
import wsb.bugtrackerexercise.models.Person;
import wsb.bugtrackerexercise.models.Project;
import wsb.bugtrackerexercise.repositories.ProjectRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public List<Project> findAll(ProjectFilter filter) {
        return projectRepository.findAll(filter.buildQuery());
    }

    public List<Project> findAllEnabled() {
        return projectRepository.findAllByEnabled(true);
    }

    public Set<Person> findAllCreators() {
        return findAllEnabled()
                .stream()
                .map(Project::getCreator)
                .collect(Collectors.toSet());
    }


}
