package ua.lviv.iot.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Entity
@Table(name = "application")
@NoArgsConstructor
@Getter
@Setter
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "priority", nullable = false)
    private String priority;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "signature", nullable = false)
    private Boolean signature;

    @OneToMany(mappedBy = "application", fetch = FetchType.EAGER)
    private Set<ResponsibleWorker> responsibleWorker;

    @ManyToOne
    @JoinColumn(name = "problem_id", nullable = false)
    private Problem problem;

    @OneToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

//    @OneToOne
//    @JoinColumn(name = "solution_id", nullable = false)
//    private Solution solution;
}
