package ua.lviv.iot.mappers;

import ua.lviv.iot.dto.responsibleworker.ResponsibleWorkerDto;
import ua.lviv.iot.model.ResponsibleWorker;

import java.util.Collections;
import java.util.stream.Collectors;

public class ResponsibleWorkerMapper {

    private ResponsibleWorkerMapper() {
    }

    public static ResponsibleWorkerDto mapResponsibleWorkerToResponsibleWorkerDto(ResponsibleWorker responsibleWorker) {
        return new ResponsibleWorkerDto(
                responsibleWorker.getLogin(),
                responsibleWorker.getName(),
                responsibleWorker.getMiddleName(),
                responsibleWorker.getSurname(),
                responsibleWorker.getAge(),
                responsibleWorker.getPost(),
                responsibleWorker.getWorkingExperience(),
                responsibleWorker.getApplication().getId()
        );
    }
}
