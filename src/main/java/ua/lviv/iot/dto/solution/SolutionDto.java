package ua.lviv.iot.dto.solution;

import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SolutionDto {

    private Integer id;

    private String equipmentToReplace;

    private String equipmentToFix;

    private String softwareToUpdate;

    private String softwareToFix;

    private Integer amountOfNewItemsNeeded;

    private Integer amountOfItemsToFix;

    private Integer applicationId;

    public SolutionDto(String equipmentToReplace, String equipmentToFix, String softwareToUpdate, String softwareToFix, Integer amountOfNewItemsNeeded, Integer amountOfItemsToFix, Integer id) {
    }
}
