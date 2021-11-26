package ua.lviv.iot.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "solution")
@NoArgsConstructor
@Getter
@Setter
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "equipment_to_replace")
    private String equipmentToReplace;

    @Column(name = "equipment_to_fix")
    private String equipmentToFix;

    @Column(name = "software_to_update")
    private String softwareToUpdate;

    @Column(name = "software_to_fix")
    private String softwareToFix;

    @Column(name = "amount_of_new_items_needed")
    private Integer amountOfNewItemsNeeded;

    @Column(name = "amount_of_items_to_fix")
    private Integer amountOfItemsToFix;

    @OneToOne(mappedBy = "solution", fetch = FetchType.EAGER)
    private Application application;

}
