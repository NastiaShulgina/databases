package ua.lviv.iot.dto.problem;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProblemDto {

    private Integer id;

    private String nonWorkingEquipment;

    private String damagedEquipment;

    private String obsoleteSoftware;

    private String damagedSoftware;

}
