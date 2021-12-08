package ua.lviv.iot.dto.application;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ApplicationDto {

    private Integer id;

    private LocalDate date;

    private LocalTime time;

    private String status;

    private String priority;

    private String name;

    private String middleName;

    private String surname;

    private Boolean signature;

    private Integer locationId;

    private Integer problemId;

    public ApplicationDto(Integer id, LocalDate date, LocalTime time, String status, String priority, String name, String middleName, String surname, Boolean signature, Integer locationId, Integer problemId) {
    }
}
