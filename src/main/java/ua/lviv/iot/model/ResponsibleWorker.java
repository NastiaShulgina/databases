package ua.lviv.iot.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "responsible_worker")
@NoArgsConstructor
@Getter
@Setter
@ToString()
@EqualsAndHashCode()
public class ResponsibleWorker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "age")
    private Integer age;

    @Column(name = "post")
    private String post;

    @Column(name = "working_experience")
    private Integer workingExperience;

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;
}
