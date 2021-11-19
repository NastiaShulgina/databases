package ua.lviv.iot.model;

import lombok.*;
import ua.lviv.iot.annotations.Column;
import ua.lviv.iot.annotations.PrimaryKey;
import ua.lviv.iot.annotations.Table;

@Table(name = "responsible_worker")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "login")
public class ResponsibleWorker {

    @PrimaryKey
    @Column(name = "login")
    private String login;

    @Column(name = "name")
    private String name;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private Integer age;

    @Column(name = "post")
    private String post;

    @Column(name = "working_experience")
    private Integer workingExperience;

    @Column(name = "application_id")
    private Integer applicationId;
}
