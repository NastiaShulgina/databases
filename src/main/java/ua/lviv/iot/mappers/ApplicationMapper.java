package ua.lviv.iot.mappers;

import ua.lviv.iot.dto.application.ApplicationDto;
import ua.lviv.iot.model.Location;
import ua.lviv.iot.model.Application;

import java.util.Collections;
import java.util.stream.Collectors;

public class ApplicationMapper {

    private ApplicationMapper() {
    }

    public static ApplicationDto mapApplicationToApplicationDto(Application application) {
        return new ApplicationDto(
                application.getId(),
                application.getDate(),
                application.getTime(),
                application.getStatus(),
                application.getPriority(),
                application.getName(),
                application.getMiddleName(),
                application.getSurname(),
                application.getSignature(),
                application.getLocation().getId(),
                application.getProblem().getId()
        );
    }
}
