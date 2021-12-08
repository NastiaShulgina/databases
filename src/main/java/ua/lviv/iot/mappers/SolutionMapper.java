package ua.lviv.iot.mappers;

import ua.lviv.iot.dto.solution.SolutionDto;
import ua.lviv.iot.model.Location;
import ua.lviv.iot.model.Solution;

import java.util.Collections;
import java.util.stream.Collectors;

public class SolutionMapper {

    private SolutionMapper() {
    }

    public static SolutionDto mapSolutionToSolutionDto(Solution solution) {
        return new SolutionDto(
                solution.getEquipmentToReplace(),
                solution.getEquipmentToFix(),
                solution.getSoftwareToUpdate(),
                solution.getSoftwareToFix(),
                solution.getAmountOfNewItemsNeeded(),
                solution.getAmountOfItemsToFix(),
                solution.getApplication().getId()
        );
    }
}
