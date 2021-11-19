package ua.lviv.iot.model;

import lombok.*;
import ua.lviv.iot.annotations.Column;
import ua.lviv.iot.annotations.PrimaryKey;
import ua.lviv.iot.annotations.Table;

import java.time.LocalDateTime;

@Table(name = "problem")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class Problem {

    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "non_working_equipment")
    private String nonWorkingEquipment;

    @Column(name = "damaged_equipment")
    private String damagedEquipment;

    @Column(name = "obsolete_software")
    private String obsoleteSoftware;

    @Column(name = "damaged_software")
    private String damagedSoftware;


}
