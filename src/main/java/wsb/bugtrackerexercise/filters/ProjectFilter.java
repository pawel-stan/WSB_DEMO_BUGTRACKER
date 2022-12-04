package wsb.bugtrackerexercise.filters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import wsb.bugtrackerexercise.models.Project;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectFilter {

    private String name;


    public Specification<Project> buildQuery() {
        return Specification.allOf(
                ilike("name", name),
                equalTo("enabled", true)
        );
    }

    private Specification<Project> equalTo(String property, Object value) {
        if (value == null) {
            return Specification.where(null);
        }

        return (root, query, builder) -> builder.equal(root.get(property), value);
    }

    private Specification<Project> ilike(String property, String value) {
        if (value == null) {
            return Specification.where(null);
        }

        return (root, query, builder) -> builder.like(builder.lower(root.get(property)), "%" + value.toLowerCase() + "%");
    }
}
