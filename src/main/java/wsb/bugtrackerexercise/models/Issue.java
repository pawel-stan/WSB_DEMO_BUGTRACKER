package wsb.bugtrackerexercise.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Issue {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.TODO;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Priority priority = Priority.NORMAL;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type = Type.TASK;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, unique = true)
    private String code;

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private Person creator;

    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private Person assignee;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Column(nullable = false)
    private Date dateCreated;

    @Column(nullable = false)
    private Date lastUpdated;

    @Column(nullable = false)
    private Boolean enabled = true;
}
