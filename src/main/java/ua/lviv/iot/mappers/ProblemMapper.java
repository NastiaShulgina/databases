package ua.lviv.iot.mappers;

import ua.lviv.iot.dto.problem.ProblemDto;
import ua.lviv.iot.model.Problem;

public class ProblemMapper {

    private ProblemMapper() {
    }

    public static ProblemDto mapProblemToProblemDto(Problem problem) {
        return new ProblemDto(
                problem.getId(),
                problem.getNonWorkingEquipment(),
                problem.getDamagedEquipment(),
                problem.getObsoleteSoftware(),
                problem.getDamagedSoftware()
        );
    }
}
