package ua.lviv.iot.model;

import lombok.*;
import ua.lviv.iot.annotations.Column;
import ua.lviv.iot.annotations.PrimaryKey;
import ua.lviv.iot.annotations.Table;

@Table(name = "solution")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class Solution {

    @PrimaryKey
    @Column(name = "id")
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

    @Column(name = "application_id")
    private Integer applicationId;
}
