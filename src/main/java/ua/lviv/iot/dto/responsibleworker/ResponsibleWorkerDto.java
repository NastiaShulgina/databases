package ua.lviv.iot.dto.responsibleworker;

import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponsibleWorkerDto {

    private String login;

    private String name;

    private String middleName;

    private String surname;

    private Integer age;

    private String post;

    private Integer workingExperience;

    private Integer applicationId;

}
