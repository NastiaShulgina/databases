package ua.lviv.iot.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "problem")
@NoArgsConstructor
@Getter
@Setter
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "non_working_equipment")
    private String nonWorkingEquipment;

    @Column(name = "damaged_equipment")
    private String damagedEquipment;

    @Column(name = "obsolete_software")
    private String obsoleteSoftware;

    @Column(name = "damaged_software")
    private String damagedSoftware;

    @OneToMany(mappedBy = "problem", fetch = FetchType.EAGER)
    private Set<Application> application;
}
